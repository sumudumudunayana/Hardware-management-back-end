package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.ItemDto;
import org.example.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ItemController {
    final ItemService service;

    @GetMapping("/get-all")
    public List<ItemDto> getItem(){
        return service.getAll();
    }

    @PostMapping("/add-item")
    public void addItem(@RequestBody ItemDto itemDto){
        log.info("updated-> {}",itemDto);
        service.addItem(itemDto);
    }

    @GetMapping("/search-by-id/{id}")
    public ItemDto getItemById(@PathVariable Integer id){
        return service.searchItemById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteItemById(@PathVariable Integer id){
        service.deleteItemById(id);
    }

    @PutMapping("/update-item")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItemById(@RequestBody ItemDto itemDto){
        service.updateItemById(itemDto);
    }
}
