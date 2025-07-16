package uz.personal.gymtracker

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate

import jakarta.persistence.*

@Entity
@Table(name = "exercises")
data class Exercise(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false)
    var date: LocalDate = LocalDate.now(),

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var sets: Int = 0,

    @Column(nullable = false)
    var reps: Int = 0,

    @Column(nullable = false)
    var weight: Double = 0.0,

    var notes: String? = null
)


@Entity
@Table(name = "workout_day")
open class WorkoutDay(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @Column(nullable = false, unique = true)
    open var name: String = ""
)


@Entity
@Table(name = "exercise_template")
data class ExerciseTemplate(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String = "",

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_day_id")
    val workoutDay: WorkoutDay = WorkoutDay()
) {
    constructor() : this(null, "", WorkoutDay())
}