package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.model.Item;
import com.leiduanchn.unittesting.springbootunittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leiduanchn
 * @create 2019-12-28 8:35 p.m.
 */
@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retrieveItem() {
        return new Item(1, "ball", 10, 100);
    }

    public List<Item> retrieveAllItems() {

        List<Item> items = repository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuality());
        }
        return items;
    }
}
