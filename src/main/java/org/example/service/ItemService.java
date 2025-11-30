package org.example.service;

import org.example.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAll();

    void addItem(ItemDto itemDto);

    void deleteItemById(Integer id);

    ItemDto searchItemById(Integer id);

    void updateItemById(ItemDto itemDto);
}
