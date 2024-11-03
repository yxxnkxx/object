package main.kotlin.ch02

class InterfaceDiscountPolicy {
    interface DiscountPolicy {
        fun calculateDiscountAmount(screening: Screening): Money
    }

    abstract class DefaultDiscountPolicy(
        private val conditions: List<DiscountCondition>
    ) : DiscountPolicy {
        override fun calculateDiscountAmount(screening: Screening): Money {
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
    ) : DefaultDiscountPolicy(conditions) {

        override fun getDiscountAmount(screening: Screening): Money {
            return discountAmount
        }
    }

    class PercentDiscountPolicy(
        private val percent: Double,
        conditions: List<DiscountCondition>
    ) : DefaultDiscountPolicy(conditions) {

        override fun getDiscountAmount(screening: Screening): Money {
            return screening.getMovieFee().times(percent)
        }
    }

    class NoneDiscountPolicy : DiscountPolicy {
        override fun calculateDiscountAmount(screening: Screening): Money {
            return Money.ZERO
        }
    }
}