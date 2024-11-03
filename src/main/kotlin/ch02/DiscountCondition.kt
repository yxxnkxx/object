package main.kotlin.ch02

interface DiscountCondition {
    fun isSatisfiedBy(screening: Screening): Boolean
}