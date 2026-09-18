package com.task2.task57.controller;

//Implement the following operations:
//Add Item done
//Delete Item
//Show All Items
//Update Item
//Show Item By ID


import com.task2.task57.model.Item;
import com.task2.task57.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // Show empty form (Add Item)
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("item", new Item());
        return "item-form";
    }

    // Add / Update Item (same endpoint handles both)
    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    // Show All Items
    @GetMapping("/items")
    public String showAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "item-list";
    }

    // Show Item By ID
    @GetMapping("/items/{id}")
    public String showItemById(@PathVariable("id") int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-details";
    }

    // Load item into form for editing (Update Item — step 1)
    @GetMapping("/items/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Item item = itemService.getItemById(id);
        model.addAttribute("item", item);
        return "item-form";
    }

    // Delete Item
    @GetMapping("/items/delete/{id}")
    public String deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return "redirect:/items";
    }
}
