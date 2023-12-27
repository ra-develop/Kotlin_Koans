// Return all products the given customer has ordered
fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap {
                it.products
        }

// Return all products that were ordered by at least one customer
fun Shop.getOrderedProducts(): Set<Product> =
        this.customers.filter {
                it.orders.isNotEmpty()
        }.map {
                it.getOrderedProducts()
        }.flatten().toSet()
