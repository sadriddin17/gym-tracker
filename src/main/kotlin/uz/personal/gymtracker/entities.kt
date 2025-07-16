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
class WorkoutDay(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    var name: String = "",

    @OneToMany(
        mappedBy = "workoutDay",
        cascade = [CascadeType.ALL],
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    var exerciseTemplates: MutableList<ExerciseTemplate> = mutableListOf()
)

@Entity
@Table(name = "media")
class Media(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(nullable = false, length = 100)
    var url: String = "",

    @ManyToMany(mappedBy = "mediaList", fetch = FetchType.LAZY)
    var exerciseTemplates: MutableSet<ExerciseTemplate> = mutableSetOf()
)


@Entity
@Table(name = "exercise_template")
class ExerciseTemplate(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_day_id")
    var workoutDay: WorkoutDay? = null,

    @Column(nullable = false, length = 100)
    var name: String = "",

    @Column(name = "set_reps", nullable = false, length = 50)
    var setReps: String = "",

    @Column(length = 200)
    var description: String? = null,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "exercise_template_media",
        joinColumns = [JoinColumn(name = "exercise_template_id")],
        inverseJoinColumns = [JoinColumn(name = "media_id")]
    )
    var mediaList: MutableSet<Media> = mutableSetOf()
)