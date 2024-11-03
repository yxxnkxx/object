package ch01

class TicketOffice(
    var amount: Long,
    val tickets: MutableList<Ticket>
) {
    fun getTicket(): Ticket {
        if (tickets.isEmpty()) {
            throw IllegalStateException()
        }
        return tickets.removeAt(0)
    }

    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}