package uz.personal.gymtracker

import org.springframework.data.jpa.repository.JpaRepository

interface ExerciseRepository : JpaRepository<Exercise, Long>
interface WorkoutRepository : JpaRepository<WorkoutDay, Long>
interface ExerciseTemplateRepository : JpaRepository<ExerciseTemplate, Long>{
    fun findAllByWorkoutDayId(workoutDayId: Long): List<ExerciseTemplate>
}
