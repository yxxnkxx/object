package main.kotlin.ch02

import java.time.LocalDateTime

class Screening(
   private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    fun getStartTime() = whenScreened

    fun getMovieFee(): Money {
        return movie.getFee()
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this).times(audienceCount.toDouble())
    }

}