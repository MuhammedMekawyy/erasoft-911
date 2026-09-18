package com.task2.task57.service.impl;


import com.task2.task57.model.Item;
import com.task2.task57.repo.ItemRepo;
import com.task2.task57.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public void saveItem(Item item) {
        itemRepo.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @Override
    public Item getItemById(int id) {
        return itemRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteItem(int id) {
        itemRepo.deleteById(id);
    }
}
