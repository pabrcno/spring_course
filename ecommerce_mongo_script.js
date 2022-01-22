// script fot mongodb

//create ecommerce database

let conn = new Mongo();
let db = conn.getDB("ecommerce");

// product = {name: string, price: num, description: string, stock: num}
db.products.insertMany([
  {
    name: "iPhone X",
    price: 4999.99,
    description: "A phone by Apple",
    stock: 100,
  },

  {
    name: "iPhone XS",
    price: 2200.2,
    description: "A phone by Apple",
    stock: 32,
  },

  {
    name: "iPhone XS Max",
    price: 1300.2,
    description: "A phone by Apple",
    stock: 80,
  },

  {
    name: "iPhone XR",
    price: 400.2,
    description: "A phone by Apple",
    stock: 55,
  },

  {
    name: "iPhone 11",
    price: 3590.0,
    description: "A phone by Apple",
    stock: 10,
  },

  {
    name: "iPhone 11 Pro",
    price: 4690.0,
    description: "A phone by Apple",
    stock: 10,
  },

  {
    name: "iPhone 11 Pro Max",
    price: 2790.0,
    description: "A phone by Apple",
    stock: 40,
  },

  {
    name: "iPhone SE",
    price: 1255.0,
    description: "A phone by Apple",
    stock: 20,
  },

  {
    name: "iPhone 8",
    price: 2200.0,
    description: "A phone by Apple",
    stock: 20,
  },

  {
    name: "iPhone 8 Plus",
    price: 950.0,
    description: "A phone by Apple",
    stock: 22,
  },

  {
    name: "iPhone 7",
    price: 550.0,
    description: "A phone by Apple",
    stock: 12,
  },
]);

// message = { description: string}
db.messages.insertMany([
  {
    description: "Hello, this is a message 1",
  },

  {
    description: "Hello, this is a message 2",
  },

  {
    description: "Hello, this is a message 3",
  },

  {
    description: "Hello, this is a message 4",
  },

  {
    description: "Hello, this is a message 5",
  },

  {
    description: "Hello, this is a message 6",
  },

  {
    description: "Hello, this is a message 7",
  },

  {
    description: "Hello, this is a message 8",
  },

  {
    description: "Hello, this is a message 9",
  },

  {
    description: "Hello, this is a message 10",
  },
]);

//list documents on products collection
db.products.find().pretty();

//list documents on messages collection
db.messages.find().pretty();

//add a new product
db.products.insertOne({
  name: "iPhone XS Max",
  price: 1300.2,
  description: "A phone by Apple",
  stock: 80,
});

//list all products where price < 1000
db.products.find({ price: { $lt: 1000 } }).pretty();

//list all products where  1000 < price < 3000
db.products.find({ price: { $gt: 1000, $lt: 3000 } }).pretty();

//list all products where price > 3000
db.products.find({ price: { $gt: 3000 } }).pretty();

//update all products stock to 100
db.products.updateMany({}, { $set: { stock: 100 } });

//update all products where price >4000 to stock = 0
db.products.updateMany({ price: { $gt: 4000 } }, { $set: { stock: 0 } });

//delete all products where price < 1000
db.products.deleteMany({ price: { $lt: 1000 } });

//create user pepe password = usd456 only read permissions
db.createUser({
  user: "pepe",
  pwd: "usd456",
  roles: [{ role: "read", db: "ecommerce" }],
});

//pepe login
db.auth("pepe", "usd456");

// pepe change product name to iPhone XS Max
db.products.updateOne(
  { name: "iPhone XS Max" },
  { $set: { name: "iPhone XS XD" } }
);
