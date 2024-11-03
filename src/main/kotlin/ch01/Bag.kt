package ch01

class Bag {
    var amount: Long
    var invitation: Invitation? = null
    var ticket: Ticket? = null

    constructor(amount: Long) {
        this.amount = amount
    }

    constructor(amount: Long, invitation: Invitation) {
        this.amount = amount
        this.invitation = invitation
    }

    fun hold(ticket: Ticket) : Long{
        return if (hasInvitation()){
            this.ticket = ticket
            0L
        } else {
            this.ticket = ticket
            minusAmount(ticket.fee)
            ticket.fee
        }

    }

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

   private fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}