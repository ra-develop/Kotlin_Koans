// Find the most expensive product among all the delivered products
// ordered by the customer. Use `Order.isDelivered` flag.
fun findMostExpensiveProductBy(customer: Customer): Product? {
    val deliveredProductsSequences = customer.orders.asSequence()
    return deliveredProductsSequences.filter {
        it.isDelivered
    }
    .flatMap(Order::products).maxByOrNull {
        it.price
    }
}

// Count the amount of times a product was ordered.
// Note that a customer may order the same product several times.
fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    val customersSequences = customers.asSequence()
    return customersSequences.flatMap(Customer::getOrderedProducts)
    .count {
        it == product
    }
}

fun Customer.getOrderedProducts(): Sequence<Product> =
    orders.flatMap(Order::products).asSequence()
