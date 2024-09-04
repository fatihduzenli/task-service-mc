package com.cydeo.repository;

import com.cydeo.entity.Task;
import com.cydeo.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTaskCode(String taskCode);

    List<Task> findAllByProjectCode(String projectCode);

    List<Task> findAllByTaskStatusIsNotAndAssignedEmployee(Status status, String assignedEmployee);

    List<Task> findAllByTaskStatusAndAssignedEmployee(Status status, String assignedEmployee);

    @Query(value = "SELECT COUNT(*) FROM tasks WHERE assigned_employee = :assignedEmployee " +
            "AND task_status <> 'COMPLETED' AND is_deleted = false", nativeQuery = true)
    int countNonCompletedByAssignedEmployee(@Param("assignedEmployee") String assignedEmployee);

    @Query(value = "SELECT COUNT(*)" +
            "FROM tasks " +
            "WHERE project_code = ?1 AND task_status = 'COMPLETED'", nativeQuery = true)
    long totalCompletedTasksByProject(@Param("projectCode") String projectCode);

    @Query("SELECT COUNT(t) FROM Task t WHERE t.projectCode = ?1 AND t.taskStatus <> 'COMPLETED'")
    long totalNonCompletedTasksByProject(@Param("projectCode") String projectCode);

}
