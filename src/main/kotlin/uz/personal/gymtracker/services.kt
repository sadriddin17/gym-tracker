package uz.personal.gymtracker

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ExerciseService(private val repository: ExerciseRepository) {

    fun findAll(page: Int, size: Int): Page<Exercise> =
        repository.findAll(PageRequest.of(page, size, Sort.by("date").descending()))

    fun findById(id: Long): Exercise = repository.findById(id).orElseThrow()

    fun save(dto: ExerciseDto): Exercise {
        val entity = Exercise(
            id = dto.id,
            date = dto.date,
            name = dto.name,
            sets = dto.sets,
            reps = dto.reps,
            weight = dto.weight,
            notes = dto.notes
        )
        return repository.save(entity)
    }

    fun delete(id: Long) = repository.deleteById(id)
}
@Service
class WorkoutService(private val repository: WorkoutRepository) {

    fun findAll(): List<WorkoutDto> =
        repository
            .findAll()
            .stream()
            .map { it -> WorkoutDto.toDto(it) }
            .toList() as List<WorkoutDto>

}
@Service
class ExerciseTemplateService(private val repository: ExerciseTemplateRepository) {

    fun findByWorkoutDayId(workoutDayId: Long): List<ExerciseTemplateDto> =
        repository
            .findAllByWorkoutDayId(workoutDayId)
            .stream()
            .map { it -> ExerciseTemplateDto.toDto(it) }
            .toList() as List<ExerciseTemplateDto>

}
