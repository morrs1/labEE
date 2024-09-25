DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Maintainer;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Warehouses;
DROP TABLE IF EXISTS Inventory;

CREATE TABLE Categories
(
    category_ID          SERIAL PRIMARY KEY,
    category_name        VARCHAR(50) NOT NULL,
    category_description TEXT
);

CREATE TABLE Manufacturers
(
    manufacturer_ID      SERIAL PRIMARY KEY,
    manufacturer_name    VARCHAR(100) NOT NULL,
    manufacturer_country VARCHAR(50)  NOT NULL
);

CREATE TABLE Products
(
    product_ID          SERIAL PRIMARY KEY,
    product_name        VARCHAR(50)    NOT NULL,
    product_description TEXT,
    price               DECIMAL(10, 2) NOT NULL,
    category_ID         INT,
    manufacturer_ID     INT,
    CONSTRAINT fk_manufacturer
        FOREIGN KEY (manufacturer_ID)
            REFERENCES Manufacturers (manufacturer_ID)
            ON DELETE CASCADE
);

CREATE TABLE Warehouses
(
    warehouse_ID      SERIAL PRIMARY KEY,
    warehouse_name    VARCHAR(100),
    warehouseLocation VARCHAR(100)
);

CREATE TABLE INVENTORY
(
    inventory_ID SERIAL PRIMARY KEY,
    product_ID   INT,
    warehouse_ID INT,
    quantity     INT,
    CONSTRAINT fk_product
        FOREIGN KEY (product_ID)
            REFERENCES Products (product_ID)
            ON DELETE CASCADE,
    CONSTRAINT fk_warehouse
        FOREIGN KEY (warehouse_ID)
            REFERENCES Warehouses (warehouse_ID)
            ON DELETE CASCADE
);

ALTER TABLE Products
    ADD CONSTRAINT fk_category_id
        FOREIGN KEY (category_ID)
            REFERENCES Categories (category_ID);

ALTER TABLE warehouses RENAME COLUMN warehouseLocation TO warehouse_location;