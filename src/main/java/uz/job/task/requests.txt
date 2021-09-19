-------------------------------
// Get request for Category
// localhost:1111/order/list
// localhost:1111/order/{id}
-------------------------------

-------------------------------
// Get request for Product
// localhost:1111/product/list
// localhost:1111/product/{id}
-------------------------------

-------------------------------
// Post request for Order
// localhost:1111/order/add/1
-------------------------------
{
  "customer":
  {
    "customer": 1,
    "name": "Sam",
    "country": "Tashkent",
    "address": "Uzbekistan",
    "phone": 1234567
  },
  "product":
  {
    "product": 1,
    "name": "Apple",
    "category":
    {
      "category": 1,
      "name": "Apple"
    },
    "description": "Very delicious",
    "price": 20.00
  },
  "quantity": 25
}

-------------------------------
// Get request for Order
// localhost:1111/order/{id}
-------------------------------

-------------------------------
// Post Request for Payment
// localhost:1111/payment/add/1
-------------------------------

{
  "invoice":
  {
    "order":
    {
      "date": "2021-09-19T17:53:02.5081762+05:00",
      "customer":
      {
        "name": "Sam",
        "country": "Tashkent",
        "address": "Uzbekistan",
        "phone": 1234567
      }
    }
  }
}

-------------------------------
// Get request for Payment
// localhost:1111/payment/{id}
-------------------------------