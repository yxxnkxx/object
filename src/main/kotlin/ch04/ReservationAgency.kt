package main.kotlin.ch04

import java.lang.StringBuilder
import java.util.Stack

class ReservationAgency {

    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie
        val fee = screening.calculateFee(audienceCount)
        return Reservation(customer, screening, fee, audienceCount)
    }
}

fun main() {
    val s = "leet**cod*e"
    val stack = Stack<Char>()

    s.forEach { c ->
        if (c != '*') stack.push(c)
        else stack.pop()
    }
    var output = StringBuilder()
    while (stack.isNotEmpty()) {
        output.append(stack.pop())
    }
    print(output.reverse().toString())

}