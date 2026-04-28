package com.example.crud.repository;

import com.example.crud.model.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {

    private final Map<Long, Item> store = new HashMap<>();
    private Long idCounter = 1L;

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idCounter++);
        }
        store.put(item.getId(), item);
        return item;
    }

    public void delete(Long id) {
        store.remove(id);
    }
}
