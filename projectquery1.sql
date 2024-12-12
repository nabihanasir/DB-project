CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    product_quantity INT NOT NULL,
    product_price DECIMAL(10, 2) NOT NULL,
    product_category VARCHAR(50),
    product_quality VARCHAR(50)
);
CREATE TABLE Accounts (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    address TEXT,
    contact VARCHAR(15),
    role ENUM('admin', 'user') NOT NULL
);
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_name VARCHAR(100) NOT NULL,
    order_number VARCHAR(50) NOT NULL UNIQUE,
    order_price DECIMAL(10, 2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Accounts(user_id)
);
INSERT INTO Accounts (username, password, address, contact, role)
   VALUES ('admin', 'securepassword', '123 Admin St', '1234567890', 'admin');

Alter table Accounts CHANGE COLUMN role role ENUM('admin', 'customer');

-- Create admin table
CREATE TABLE admin (
    admin_id INT AUTO_INCREMENT PRIMARY KEY,   
    username VARCHAR(50) NOT NULL,              
    password VARCHAR(255) NOT NULL,             
    email VARCHAR(100) NOT NULL,             
    CONSTRAINT unique_email UNIQUE (email),    
    CONSTRAINT unique_username UNIQUE (username)  
);


CREATE TABLE customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,   
    username VARCHAR(50) NOT NULL,                
    password VARCHAR(255) NOT NULL,                
    email VARCHAR(100) NOT NULL,                   
    first_name VARCHAR(50),                        
    last_name VARCHAR(50),                         
    address VARCHAR(255),                           
    city VARCHAR(50),                              
    contact_number VARCHAR(15),                    
    CONSTRAINT unique_email UNIQUE (email),       
    CONSTRAINT unique_username UNIQUE (username)  
);
drop table accounts;
ALTER TABLE Orders
CHANGE COLUMN user_id customer_id INT;
SHOW CREATE TABLE Orders;
ALTER TABLE Orders
DROP FOREIGN KEY Orders_ibfk_1;  

ALTER TABLE Orders
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customer(customer_id);
