package main.kotlin.ch02

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalTime


class MovieTest {
}


fun main() {
    val avatar = Movie(
        title = "아바타",
        runningTime = Duration.ofMinutes(120),
        fee = Money.wons(10000),
        discountPolicy = AmountDiscountPolicy(
            Money.wons(800),
            listOf(
                SequenceCondition(1),
                SequenceCondition(10),
                PeriodCondition(
                    DayOfWeek.MONDAY,
                    LocalTime.of(10, 0),
                    LocalTime.of(11, 59)
                )
            )
        )
    )
}