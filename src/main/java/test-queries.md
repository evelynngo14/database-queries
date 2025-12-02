SELECT FlowerID, Name, Price, StockQuantity FROM Flowers;

SELECT Name, Price FROM Flowers WHERE Color = 'White';

UPDATE Flowers SET Price = 15.00 WHERE Name = 'Red Rose';

UPDATE Flowers SET StockQuantity = 10 WHERE FlowerID = 3;

DELETE FROM Customers WHERE FirstName = 'Robert';

DELETE FROM Flowers WHERE Name = 'Tulip Yellow';