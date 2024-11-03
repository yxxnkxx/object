package main.kotlin.ch02

abstract class DiscountPolicy(
    private val conditions: List<DiscountCondition>
) {
    fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }
        return Money.ZERO
    }

    abstract fun getDiscountAmount(screening: Screening): Money
}


class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}

class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee().times(percent)
    }
}

class NoneDiscountPolicy : DiscountPolicy(emptyList()) {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}