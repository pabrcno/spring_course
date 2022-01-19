
    DROP TABLE IF EXISTS ecommerce;
    
    CREATE table ecommerce (
        id int not null auto_increment,
        name varchar(255) not null,
        stock int not null,
        code varchar(255) not null,
        categoty varchar(255) not null,
        description varchar(255) not null,
        price float not null,
        primary key (id)
    );


    INSERT INTO ecommerce ( name, stock,code, categoty, description, price) VALUES
    ('milk', 20,'1', 'dairy', 'mmmmmu', 1),
    ('flour', 30, '2','bakery', 'corn flour', 1.2),
    ('cream', 15,'3', 'dairy', 'cruchy', 1.5),
    ('jellybeans','4', 20, 'candy', 'sweet', 1),
    ('cereal', 30,'5', 'breakfast', 'delicious', 1.2);
    

    