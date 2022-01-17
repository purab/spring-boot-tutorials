Used following sofwares:

used winnmp for mongodb.
for mongodb browser used - mongodb compass

1. Created Book database.
2. created "Book" and "order_DB" collection
3. following are postman requests for testing

http://localhost:8080/order-service/placeOrderNow
{
"id":1222,
"name":"test03",
"gender":"male",
"products":[
{"name":"tooth","quantity":2,"price":343}, {"name":"tooth1","quantity":3,"price":3333}
],
"address": {"city":"pune","state":"MH","pincode":"411014"}
}

http://localhost:8080/addBook

{
"id":1222,
"bookName":"test03",
"authorName":"purab3"
}