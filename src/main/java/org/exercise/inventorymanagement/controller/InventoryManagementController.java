package org.exercise.inventorymanagement.controller;

import org.exercise.inventorymanagement.entity.InventoryItem;
import org.exercise.inventorymanagement.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryManagementController {

    private ItemService itemService;

    public InventoryManagementController(ItemService iService){
        this.itemService = iService;
    }

    @GetMapping("/items")
    public List<InventoryItem> getInventoryItems(){
        return itemService.findAll();
    }

    @GetMapping("/item/{id}")
    public InventoryItem getInventoryItem(@PathVariable Long id){
        return itemService.findById(id);
    }

    @PostMapping("/item")
    public InventoryItem addInventoryItem(@RequestBody InventoryItem item){
        item.setId(0L);
        return itemService.save(item);
    }

    @PutMapping("/item/{id}")
    public InventoryItem updateInventoryItem(@PathVariable Long id, @RequestBody InventoryItem item){
        return itemService.updateInventoryItem(id, item);
    }

    @DeleteMapping("/item/{id}")
    public String deleteInventoryItem(@PathVariable Long id){
        itemService.findById(id);
        itemService.deleteByID(id);
        return "Deleted Inventory Item id - " + id;
    }
}
