package main.kotlin.ch02

class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
)
