package com.cydeo.client;

import com.cydeo.dto.wrapper.ProjectResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "project-service")
public interface ProjectClient {

    @GetMapping("/api/v1/project/check/{projectCode}")
    ResponseEntity<ProjectResponse> checkProjectByCode(@PathVariable("projectCode")String projectCode);


    @GetMapping("/api/v1/project/read/manager/{projectCode}")
    ResponseEntity<ProjectResponse> getManagerByProjectCode(@PathVariable("projectCode")String projectCode);


}
