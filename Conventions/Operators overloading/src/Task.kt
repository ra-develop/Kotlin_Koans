import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return addTimeIntervals(timeInterval, 1)
}

class RepeatedTimeInterval (val timeInterval: TimeInterval, val numTimes: Int)
operator fun TimeInterval.times(numTimes: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval (this, numTimes)
}

operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    return addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.numTimes)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
