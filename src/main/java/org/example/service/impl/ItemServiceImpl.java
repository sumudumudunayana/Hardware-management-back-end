package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.ItemDto;
import org.example.entity.ItemEntity;
import org.example.repository.ItemRepository;
import org.example.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<ItemDto> getAll() {
        List<ItemDto> ItemArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            ItemArrayList.add(mapper.map(entity, ItemDto.class));
        });
        return ItemArrayList;
    }

    @Override
    public void addItem(ItemDto itemDto) {
        System.out.println(itemDto);
        repository.save(mapper.map(itemDto, ItemEntity.class));
    }

    @Override
    public void deleteItemById(Integer id){
        repository.deleteById(id);
    }

    @Override
    public ItemDto searchItemById(Integer id) {
        return mapper.map(repository.findById(id),ItemDto.class);


    }

    @Override
    public void updateItemById(ItemDto itemDto) {
        repository.save(mapper.map(itemDto, ItemEntity.class));
    }
}
