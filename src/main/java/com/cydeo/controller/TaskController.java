package com.cydeo.controller;

import com.cydeo.dto.wrapper.ExceptionWrapper;
import com.cydeo.dto.wrapper.ResponseWrapper;
import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import com.cydeo.util.SwaggerExamples;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "TaskController", description = "Task controller endpoints")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RolesAllowed("Manager")
    @PostMapping("/create")
    @Operation(summary = "Create a task.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDTO.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_CREATE_REQUEST_EXAMPLE))))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Task is successfully created.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_CREATE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "409", description = "Task already exists.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ALREADY_EXISTS_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Project does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "409", description = "User is not an employee.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_EMPLOYEE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Employee does not an exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.EMPLOYEE_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "400", description = "Invalid Input(s)",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.VALIDATION_EXCEPTION_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "500", description = "Manager cannot be retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.MANAGER_NOT_RETRIEVED_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "500", description = "Employee check is failed.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.EMPLOYEE_CHECK_FAILED_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "500", description = "Project check is failed.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_CHECK_FAILED_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> createTask(@Valid @RequestBody TaskDTO taskDTO) {

        TaskDTO createdTask = taskService.create(taskDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.CREATED)
                        .message("Task is successfully created.")
                        .data(createdTask)
                        .build());

    }

    @RolesAllowed({"Manager", "Employee"})
    @GetMapping("/read/{taskCode}")
    @Operation(summary = "Read a task by task code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task is successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_GET_RESPONSE_SINGLE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Task does not an exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> getByTaskCode(@PathVariable("taskCode") String taskCode) {

        TaskDTO foundTask = taskService.readByTaskCode(taskCode);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Task is successfully retrieved.")
                        .data(foundTask)
                        .build());

    }

    @RolesAllowed("Manager")
    @GetMapping("/read/all/{projectCode}")
    @Operation(summary = "Read all tasks by project code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks are successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_GET_RESPONSE_LIST_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> getTasksByProject(@PathVariable("projectCode") String projectCode) {

        List<TaskDTO> foundTasks = taskService.readAllTasksByProject(projectCode);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Tasks are successfully retrieved.")
                        .data(foundTasks)
                        .build());

    }

    @RolesAllowed("Employee")
    @GetMapping("/read/employee/archive")
    @Operation(summary = "Read all archived tasks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks are successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ARCHIVED_GET_RESPONSE_LIST_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> employeeArchivedTasks() {

        List<TaskDTO> foundTasks = taskService.readAllByStatus(Status.COMPLETED);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Tasks are successfully retrieved.")
                        .data(foundTasks)
                        .build());

    }

    @RolesAllowed("Employee")
    @GetMapping("/read/employee/pending-tasks")
    @Operation(summary = "Read all archived tasks.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks are successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_GET_RESPONSE_LIST_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> employeePendingTasks() {

        List<TaskDTO> foundTasks = taskService.readAllByStatusIsNot(Status.COMPLETED);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Tasks are successfully retrieved.")
                        .data(foundTasks)
                        .build());

    }

    @RolesAllowed("Manager")
    @GetMapping("/count/project/{projectCode}")
    @Operation(summary = "Read all task counts of a project by project code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task counts are successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_COUNTS_BY_PROJECT_CODE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> getCountsByProject(@PathVariable("projectCode") String projectCode) {

        Map<String, Integer> taskCounts = taskService.getCountsByProject(projectCode);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Task counts are successfully retrieved.")
                        .data(taskCounts)
                        .build());

    }

    @RolesAllowed("Admin")
    @GetMapping("/count/employee/{assignedEmployee}")
    @Operation(summary = "Read all non completed task count of an employee by username.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task count is successfully retrieved.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_NON_COMPLETED_COUNT_BY_ASSIGNED_EMPLOYEE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> getNonCompletedCountByAssignedEmployeeByAssignedEmployee(@PathVariable("assignedEmployee") String assignedEmployee) {

        Integer taskCount = taskService.countNonCompletedByAssignedEmployee(assignedEmployee);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Task count is successfully retrieved.")
                        .data(taskCount)
                        .build());

    }

    @RolesAllowed("Manager")
    @PutMapping("/update/{taskCode}")
    @Operation(summary = "Update a task.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDTO.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_UPDATE_REQUEST_EXAMPLE))))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task is successfully updated.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_UPDATE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "409", description = "User is not an employee.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_EMPLOYEE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Project does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Task does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Employee does not an exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.EMPLOYEE_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "400", description = "Invalid Input(s)",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.VALIDATION_EXCEPTION_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "500", description = "Employee check is failed.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.EMPLOYEE_CHECK_FAILED_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "500", description = "Project check is failed.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_CHECK_FAILED_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> updateTask(@PathVariable("taskCode") String taskCode,
                                                      @Valid @RequestBody TaskDTO taskDTO) {

        TaskDTO updatedTask = taskService.update(taskCode, taskDTO);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Task is successfully updated.")
                        .data(updatedTask)
                        .build());

    }

    @RolesAllowed("Employee")
    @PutMapping("/update/employee/{taskCode}")
    @Operation(summary = "Update the status of a task by task code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task is successfully updated.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_UPDATE_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "Task does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<ResponseWrapper> employeeUpdateTasks(@PathVariable("taskCode") String taskCode,
                                                               @RequestParam Status status) {

        TaskDTO updatedTask = taskService.updateStatus(taskCode, status);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Task is successfully updated.")
                        .data(updatedTask)
                        .build());

    }

    @RolesAllowed("Manager")
    @PutMapping("/complete/project/{projectCode}")
    @Operation(summary = "Complete all tasks of a project by project code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks are successfully completed.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_COMPLETE_BY_PROJECT_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    ResponseEntity<ResponseWrapper> completeByProject(@PathVariable("projectCode") String projectCode) {

        taskService.completeByProject(projectCode);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Tasks are successfully completed.")
                        .build());

    }

    @RolesAllowed("Manager")
    @DeleteMapping("/delete/{taskCode}")
    @Operation(summary = "Delete a task by task code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Task is successfully deleted."),
            @ApiResponse(responseCode = "404", description = "Task does not an exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    public ResponseEntity<Void> deleteTask(@PathVariable("taskCode") String taskCode) {
        taskService.delete(taskCode);
        return ResponseEntity.noContent().build();
    }

    @RolesAllowed("Manager")
    @DeleteMapping("/delete/project/{projectCode}")
    @Operation(summary = "Delete all tasks of a project by project code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks are successfully deleted.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_DELETE_BY_PROJECT_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "404", description = "User does not exist.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.USER_NOT_FOUND_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own project.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.PROJECT_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access denied, make sure that you are working on your own task.",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.TASK_ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE))),
            @ApiResponse(responseCode = "403", description = "Access is denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionWrapper.class),
                            examples = @ExampleObject(value = SwaggerExamples.ACCESS_DENIED_FORBIDDEN_RESPONSE_EXAMPLE)))})
    ResponseEntity<ResponseWrapper> deleteByProject(@PathVariable("projectCode") String projectCode) {

        taskService.deleteByProject(projectCode);

        return ResponseEntity
                .ok(ResponseWrapper.builder()
                        .success(true)
                        .statusCode(HttpStatus.OK)
                        .message("Tasks are successfully deleted.")
                        .build());

    }

}
