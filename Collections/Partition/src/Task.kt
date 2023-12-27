// Return customers who have more undelivered orders than delivered
fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> {
    val result = customers.filter {customer: Customer ->
        val (delivered, undelivered) = customer.orders.partition { order: Order ->
            order.isDelivered
        }
        undelivered.size > delivered.size
    }
    return result.toSet()
}
