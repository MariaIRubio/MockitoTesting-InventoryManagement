### Exercise: Inventory Management System with Unit Testing

#### Objective:

Develop an inventory management system using Spring Boot, enabling efficient management of inventory items. The focus will be on implementing CRUD (Create, Read, Update, Delete) operations to facilitate seamless handling of inventory items. Additionally, ensure the reliability and accuracy of the application by writing comprehensive unit tests for the service layer.

#### Instructions:

#### Application Development:
-	Create an InventoryItem entity.
-	Implement InventoryItemRepository extending JpaRepository for CRUD operations.
-	Create a service interface (InventoryItemServiceInterface) and its implementation (InventoryItemService) for business logic.
-	Develop a controller class (InventoryController) with endpoints for CRUD operations.
#### Unit Testing:
-	Write unit tests for InventoryItemService methods using Mockito and JUnit.
-	Mock InventoryItemRepository and test service methods (e.g., findAll, findById, save, deleteById).
-	Ensure all unit tests pass to verify service layer accuracy.
