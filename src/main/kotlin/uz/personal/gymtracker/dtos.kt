package uz.personal.gymtracker

import java.time.LocalDate

data class ExerciseDto(
    val id: Long?,
    val date: LocalDate = LocalDate.now(),
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Double,
    val notes: String? = null
)


data class WorkoutDto(
    val id: Long?,
    val name: String
){
    companion object{
        @JvmStatic
        fun toDto(entity: WorkoutDay): WorkoutDto {
            return WorkoutDto(entity.id, entity.name)
        }
    }
}

data class ExerciseTemplateDto(
    val id: Long?,
    val name: String,
    val workoutDayId: Long? = null
){
    companion object{
        @JvmStatic
        fun toDto(entity: ExerciseTemplate): ExerciseTemplateDto {
            return ExerciseTemplateDto(entity.id, entity.name, entity.workoutDay?.id)
        }
    }
}