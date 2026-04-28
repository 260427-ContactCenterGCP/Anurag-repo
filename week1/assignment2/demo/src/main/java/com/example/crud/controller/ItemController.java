package com.example.crud.controller;

import com.example.crud.model.Item;
import com.example.crud.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Item> getAll() {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) {
        return service.getItem(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item) {
        return service.createItem(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteItem(id);
    }
}
