package com.example.test.item.controller;

import com.example.test.item.model.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;


}
