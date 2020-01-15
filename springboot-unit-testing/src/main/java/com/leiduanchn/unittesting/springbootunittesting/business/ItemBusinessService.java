package com.leiduanchn.unittesting.springbootunittesting.business;

import com.leiduanchn.unittesting.springbootunittesting.model.Item;
import org.springframework.stereotype.Service;

/**
 * @author leiduanchn
 * @create 2019-12-28 8:35 p.m.
 */
@Service
public class ItemBusinessService {

    public Item retrieveItem() {
        return new Item(1, "ball", 10, 100);
    }
}
