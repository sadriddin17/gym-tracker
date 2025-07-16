package uz.personal.gymtracker

import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/exercises")
class ExerciseController(private val service: ExerciseService) {

    @GetMapping
    fun getAll(
        @RequestParam(defaultValue = "0") page: Int,
        @RequestParam(defaultValue = "10") size: Int
    ): Page<Exercise> = service.findAll(page, size)

    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): Exercise = service.findById(id)

    @PostMapping
    fun create(@RequestBody dto: ExerciseDto): Exercise = service.save(dto)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: ExerciseDto): Exercise =
        service.save(dto.copy(id = id))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        service.delete(id)
}

@RestController
@RequestMapping("/api/workout-days")
class WorkoutController(private val service: WorkoutService) {

    @GetMapping
    fun getAll(
    ): List<WorkoutDto> = service.findAll()
}

@RestController
@RequestMapping("/api/workout-days")
class ExerciseTemplateController(private val service: ExerciseTemplateService) {

    @GetMapping("/{id}/exercises")
    fun getAll(@PathVariable(value = "id") workoutDayId: Long): List<ExerciseTemplateDto> = service.findByWorkoutDayId(workoutDayId)
}
