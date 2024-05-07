package org.exercise.inventorymanagement.dao;

import org.exercise.inventorymanagement.entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<InventoryItem, Long> {
}
