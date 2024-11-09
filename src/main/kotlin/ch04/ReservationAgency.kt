package main.kotlin.ch04

class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}