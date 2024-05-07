package org.exercise.inventorymanagement.service;

import org.exercise.inventorymanagement.entity.InventoryItem;

import java.util.List;

public interface ItemServiceInterface {

    List<InventoryItem> findAll();
    InventoryItem findById(Long id);

    InventoryItem save(InventoryItem item);

    void deleteByID(Long id);

}
