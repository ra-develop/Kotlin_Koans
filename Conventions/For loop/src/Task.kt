class DateRange(val start: MyDate, val end: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {

            var currentDate: MyDate = start

            override fun hasNext(): Boolean = currentDate <= end

            override fun next(): MyDate {
                val returnDate = currentDate
                if (returnDate <= end) {
                    currentDate = returnDate.followingDate()
                } else {
                    throw NoSuchElementException()
                }
                return returnDate
            }

        }
    }

}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}