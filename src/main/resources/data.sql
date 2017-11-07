INSERT INTO address(id, street, zip_code)
	VALUES
		(1, 'Main St', '12345'),
		(2, '1st Street', '11111'),
		(3, '5th Street', '55555');
		
INSERT INTO customer(id, first_name, last_name, birthday, address_id)
	VALUES 
		(1, 'John', 'Doe', '1981-01-01', 1),
		(2, 'Mary', 'Doe', '1985-05-05', 1),
		(3, 'Andrew', 'Smith', '1988-08-08', 2),
		(4, 'William', 'Jones', '1990-09-09', 3);
