package main.kotlin.ch04

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
     val type: DiscountConditionType,
     val sequence: Int,
     val dayOfWeek: DayOfWeek,
     val startTime: LocalTime,
     val endTime: LocalTime
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != DiscountConditionType.PERIOD) {
            throw IllegalArgumentException()
        }
        return this.dayOfWeek == dayOfWeek &&
                this.startTime <= time &&
                this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != DiscountConditionType.SEQUENCE) {
            throw IllegalArgumentException()
        }
        return this.sequence == sequence
    }
}

enum class DiscountConditionType {
    SEQUENCE,
    PERIOD
}