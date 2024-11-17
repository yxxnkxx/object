package main.kotlin.ch06

import java.time.Duration
import java.time.LocalDateTime


data class Event(
    val subject: String,
    val from: LocalDateTime,
    val duration: Duration
) {
    fun isSatisfied(schedule: RecurringSchedule): Boolean {
        if (from.dayOfWeek != schedule.getDayOfWeek() ||
            from.toLocalTime() != schedule.getFrom()||
            duration != schedule.getDuration()
        ) {
            reschedule(schedule)
            return false
        } else {
            return true
        }
    }

    fun reschedule(schedule: RecurringSchedule) {
        // reschedule logic
    }
}


fun main() {
    val meeting = Event(
        subject = "Board Meeting",
        from = LocalDateTime.of(2021, 7, 1, 10, 0),
        duration = Duration.ofHours(2)
    )
}