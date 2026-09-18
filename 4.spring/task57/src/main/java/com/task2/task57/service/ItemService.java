package com.task2.task57.service;


import com.task2.task57.model.Item;

import java.util.List;

public interface ItemService {
    void saveItem(Item item);
    List<Item> getAllItems();
    Item getItemById(int id);
    void deleteItem(int id);
}
