package main.kotlin.ch04

import java.time.LocalDateTime

class Screening(
    val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                return if (movie.isDiscountable(whenScreened, sequence)) {
                    movie.calculateAmountDiscountedFee()
                } else {
                    movie.fee
                }
            }
            MovieType.PERCENT_DISCOUNT -> {
                return if (movie.isDiscountable(whenScreened, sequence)) {
                    movie.calculatePercentDiscountedFee()
                } else {
                    movie.fee
                }
            }
            MovieType.NONE_DISCOUNT -> {
                return if (movie.isDiscountable(whenScreened, sequence)) {
                    movie.calculateNoneDiscountedFee()
                } else {
                    movie.fee
                }

            }
        }
    }
}