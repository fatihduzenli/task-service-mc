package com.cydeo.dto;

import com.cydeo.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"}, ignoreUnknown = true)
public class TaskDTO {

    @JsonIgnore
    private Long id;

    @NotBlank(message = "Task code is required.")
    @Size(min = 5, max = 5, message = "Project code should include 5 characters.")
    private String taskCode;

    @NotBlank(message = "Task subject is required.")
    @Size(min = 3, max = 16, message = "Task subject length should be min 3, max 16.")
    private String taskSubject;

    private String taskDetail;
    private Status taskStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate assignedDate;

    @NotBlank(message = "Project code is required.")
    private String projectCode;

    @NotBlank(message = "Assigned employee is required.")
    private String assignedEmployee;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String assignedManager;

}
