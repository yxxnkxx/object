package main.kotlin.ch06

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

data class RecurringSchedule(
    private val subject: String,
    private val dayOfWeek: DayOfWeek,
    private val from: LocalTime,
    private val duration: Duration
) {
    fun getDayOfWeek() = dayOfWeek
    fun getFrom() = from
    fun getDuration() = duration
}

fun main() {
    val recurringSchedule = RecurringSchedule(
        subject = "회의",
        dayOfWeek = DayOfWeek.WEDNESDAY,
        from = LocalTime.of(10, 0),
        duration = Duration.ofMinutes(30)
    )

    val meeting = Event(
        subject = "Board Meeting",
        from = LocalDateTime.of(2021, 7, 1, 10, 30),
        duration = Duration.ofMinutes(30)
    )

    assert(!meeting.isSatisfied(recurringSchedule))
    assert(meeting.isSatisfied(recurringSchedule))
    // isSatisfied를 2번 호출하면 두 번째에는 true를 반환한다

}