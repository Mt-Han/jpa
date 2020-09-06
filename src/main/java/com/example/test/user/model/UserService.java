package com.example.test.user.model;

import com.example.test.exception.ApiResponseException;
import com.example.test.user.model.predicate.UserPredicate;
import com.example.test.user.model.req.UserRequest;
import com.example.test.user.model.res.UserResponse;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user,UserResponse.class)).collect(Collectors.toList());
    }

    public UserResponse findByUserId(String userId){
        User user = userRepository.findByUserId(userId);
        return modelMapper.map(user,UserResponse.class);
    }

    public List<UserResponse> findByAge(UserRequest request) {
        Predicate predicate = UserPredicate.search(request);
        List<User> users = Lists.newArrayList(userRepository.findAll(predicate));
        return users.stream().map(user -> modelMapper.map(user,UserResponse.class)).collect(Collectors.toList());
    }

    public UserResponse insertUser(UserRequest request) {
        User duplicateUser = userRepository.findByUserIdAndName(request.getUserId(),request.getName());
        if (!ObjectUtils.isEmpty(duplicateUser))
            throw  new ApiResponseException("아이디 또는 이름이 중복입니다.",HttpStatus.BAD_REQUEST);

        User user = User.builder()
                .age(request.getAge())
                .gender(request.getGender())
                .password(request.getPassword())
                .name(request.getName())
                .userId(request.getUserId())
                .build();
        return modelMapper.map(userRepository.save(user),UserResponse.class);
    }

    @Transactional
    public UserResponse updateUser(UserRequest request) {
        User user = userRepository.findByUserId(request.getUserId());
        if (ObjectUtils.isEmpty(user))
            throw  new ApiResponseException("아이디가 없습니다.",HttpStatus.BAD_REQUEST);
        user.setAge(request.getAge());
//        userRepository.save(user);
        return modelMapper.map(user,UserResponse.class);
    }

    public String deleteUser(UserRequest request) {
        User user = userRepository.findByUserId(request.getUserId());
        if (ObjectUtils.isEmpty(user))
            throw  new ApiResponseException("아이디가 없습니다.",HttpStatus.BAD_REQUEST);
        userRepository.delete(user);
        return "Success";
    }

}
