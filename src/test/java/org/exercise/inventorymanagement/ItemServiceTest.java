package org.exercise.inventorymanagement;

import org.exercise.inventorymanagement.dao.ItemRepository;
import org.exercise.inventorymanagement.entity.InventoryItem;
import org.exercise.inventorymanagement.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

    // Mock Repository
    @Mock
    private ItemRepository itemRepository;

    // Inject Service
    @InjectMocks
    private ItemService itemService;

    // Set up the test environment
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Test the findAll method
    @Test
    public void testFindAll() {

        // Mock the data
        List<InventoryItem> items = Arrays.asList(
                new InventoryItem("Item1", "description1","department1", 10, 100),
                new InventoryItem("Item2","description2", "department2", 20, 200)
        );

        // Mock the behavior
        when(itemRepository.findAll()).thenReturn(items);

        // Call the method to be tested
        List<InventoryItem> result = itemService.findAll();

        // Verify with assert method
        assertEquals(2, result.size());
    }

    // Test the findById method
    @Test
    public void testFindById() {
        // Mock the data
        InventoryItem item = new InventoryItem("Item1", "description1","department1", 10, 100);
        item.setId(1L);
        // Mock the behavior
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

        // Call the method to be tested
        InventoryItem result = itemService.findById(1L);

        // Verify with assert method
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Item1", result.getName());
        assertEquals("description1", result.getDescription());
        assertEquals("department1", result.getDepartment());
        assertEquals(10, result.getQuantity());
        assertEquals(100, result.getPrice());

    }

    // Test the findById method when the item is not found
    @Test
    public void testFindByIdNotFound() {
        // We don't mock the data because we want to test the scenario where the item with the given id is not found

        // Mock the behavior
        when(itemRepository.findById(1L)).thenReturn(Optional.empty());

        // Call the method to be tested and assert that it throws a RuntimeException
        assertThrows(RuntimeException.class, () -> itemService.findById(1L));

    }

    // Test the save method
    @Test
    public void testSave() {
        // Mock the data
        InventoryItem item = new InventoryItem("Item1", "description1","department1", 10, 100);

        // Mock the behavior
        when(itemRepository.save(item)).thenReturn(item);

        // Call the method to be tested
        InventoryItem result = itemService.save(item);

        // Verify with assert method
        assertNotNull(result);
        assertEquals("Item1", result.getName());
        assertEquals("description1", result.getDescription());
        assertEquals("department1", result.getDepartment());
        assertEquals(10, result.getQuantity());
        assertEquals(100, result.getPrice());
    }

    // Test the deleteByID method
    @Test
    public void testDeleteByID() {
        // No need to mock the data because we are testing the deleteByID() method
        // No need to mock the behavior of the deleteByID()

        // Call the method to be tested
        itemService.deleteByID(1L);

        // Verify the behavior
        verify(itemRepository).deleteById(1L);
    }

    // Test the updateInventoryItem method
    @Test
    public void testUpdateInventoryItem() {
        // Mock the data
        InventoryItem item = new InventoryItem("Item1", "description1","department1", 10, 100);
        item.setId(1L);
        InventoryItem itemUpdated = new InventoryItem("Item1", "description1","department1", 20, 200);
        itemUpdated.setId(1L);
        // Mock the behavior
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));
        when(itemRepository.save(item)).thenReturn(itemUpdated);

        // Call the method to be tested
        InventoryItem result = itemService.updateInventoryItem(1L, itemUpdated);

        // Verify with assert method
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Item1", result.getName());
        assertEquals("description1", result.getDescription());
        assertEquals("department1", result.getDepartment());
        assertEquals(20, result.getQuantity());
        assertEquals(200, result.getPrice());
    }

}
