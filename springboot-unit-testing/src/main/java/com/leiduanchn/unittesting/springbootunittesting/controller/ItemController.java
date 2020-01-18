package com.leiduanchn.unittesting.springbootunittesting.controller;

import com.leiduanchn.unittesting.springbootunittesting.business.ItemBusinessService;
import com.leiduanchn.unittesting.springbootunittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leiduanchn
 * @create 2019-12-24 10:34 p.m.
 */
@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1, "ball", 10, 100);
    }

    @GetMapping("/item/from-service")
    public Item itemFromService(){
        return itemBusinessService.retrieveItem();
    }

    @GetMapping("/all-item-from-database")
    public List<Item> retrieveAllItems(){
        return itemBusinessService.retrieveAllItems();
    }
}
