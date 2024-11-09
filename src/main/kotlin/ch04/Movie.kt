package main.kotlin.ch04

import java.time.Duration
import java.time.LocalDateTime

class Movie(
    val title: String,
    val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,

    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double

) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        for (condition in discountConditions) {
            return if (condition.type == DiscountConditionType.PERIOD) {
                condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())

            } else {
                condition.isDiscountable(sequence)

            }
        }
        return false
    }


}


enum class MovieType {
    AMOUNT_DISCOUNT,
    PERCENT_DISCOUNT,
    NONE_DISCOUNT
}

