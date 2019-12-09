package com.geekbrains.marketdemoa.entites;

import com.geekbrains.marketdemoa.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class Cart {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "allProductList=" + allProductList +
                '}';
    }

    public List<Item> getAllProductList() {
        return allProductList;
    }

    List<Item> allProductList;

    @PostConstruct()
    public void init() {
        allProductList = new ArrayList<>();
    }

    public void addProductById(Long id) {
        allProductList.add(itemService.findById(id));
    }
}
