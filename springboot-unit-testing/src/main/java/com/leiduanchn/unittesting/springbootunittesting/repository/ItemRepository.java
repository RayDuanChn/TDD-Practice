package com.leiduanchn.unittesting.springbootunittesting.repository;

import com.leiduanchn.unittesting.springbootunittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leiduanchn
 * @create 2020-01-16 10:05 p.m.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

}
