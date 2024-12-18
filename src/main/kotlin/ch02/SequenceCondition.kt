package main.kotlin.ch02

class SequenceCondition(private val sequence: Int): DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}