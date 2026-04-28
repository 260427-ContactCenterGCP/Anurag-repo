package com.example.crud.service;

import com.example.crud.model.Item;
import com.example.crud.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item getItem(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return repository.save(item);
    }

    public Item updateItem(Long id, Item item) {
        if (repository.findById(id).isEmpty()) return null;
        item.setId(id);
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.delete(id);
    }
}
