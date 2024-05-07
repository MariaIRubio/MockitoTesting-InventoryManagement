package org.exercise.inventorymanagement.service;

import jakarta.transaction.Transactional;
import org.exercise.inventorymanagement.dao.ItemRepository;
import org.exercise.inventorymanagement.entity.InventoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements ItemServiceInterface{

    private final ItemRepository itemRepo;

    @Autowired
    public ItemService(ItemRepository iDAO) {
        this.itemRepo = iDAO;
    }

    @Override
    public List<InventoryItem> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public InventoryItem findById(Long id) {
        Optional<InventoryItem> result = itemRepo.findById(id);
        InventoryItem item = null;
        if(result.isPresent()) {
            item = result.get();
        }else{throw  new RuntimeException("Inventory Item id not found - " + id);}
        return item;
    }

    @Override
    @Transactional
    public InventoryItem save(InventoryItem item) {
        return itemRepo.save(item);
    }

    @Override
    @Transactional
    public void deleteByID(Long id) {
        itemRepo.deleteById(id);
    }

    public InventoryItem updateInventoryItem(Long id, InventoryItem newItem) {
       InventoryItem item = findById(id);
       item.setName(newItem.getName());
       item.setDescription(newItem.getDescription());
       item.setDepartment(newItem.getDepartment());
       item.setQuantity(newItem.getQuantity());
       item.setPrice(newItem.getPrice());
       InventoryItem itemUpdated = itemRepo.save(item);
       return itemUpdated;
    }
}
