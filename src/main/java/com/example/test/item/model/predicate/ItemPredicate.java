package com.example.test.item.model.predicate;

import com.example.test.item.model.ItemRepository;
import com.example.test.item.model.QItem;
import com.example.test.item.model.req.ItemRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.util.ObjectUtils;

public class ItemPredicate {
    public static Predicate search(ItemRequest request){
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(nameSearch(request.getName()));
        return builder;
    }
    public static Predicate nameSearch(String name){
        BooleanBuilder builder = new BooleanBuilder();
        QItem item = QItem.item;
        if (!ObjectUtils.isEmpty(name))
            builder.and(item.name.like("%"+name+"%"));
        return builder;
    }
}
