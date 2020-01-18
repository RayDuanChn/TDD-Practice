package com.leiduanchn.unittesting.springbootunittesting.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author leiduanchn
 * @create 2019-12-25 8:38 p.m.
 */
@Entity
public class Item {

    @Id
    private int id;
    private String name;
    private int price;
    private int quality;

    //Don't store the field in db
    @Transient
    private int value;

    protected Item() {
    }

    public Item(int id, String name, int price, int quality) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quality = quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
