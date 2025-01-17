package com.nhl.tools.tool.service;

import com.nhl.tools.tool.payloads.request.ExecutionDateRequest;
import com.nhl.tools.tool.payloads.response.ExecutionDateResponse;
import com.nhl.tools.tool.payloads.response.Executions;
import com.nhl.tools.tool.repository.ExecutionDateRepository;
import com.nhl.tools.tool.repository.entity.ProjectSchedule;
import com.nhl.tools.tool.util.WrapperTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExecutionDateService {

    @Autowired
    private ExecutionDateRepository repository;

    public ExecutionDateService(ExecutionDateRepository repository) {
        this.repository = repository;
    }

    public ExecutionDateResponse newExecution(ExecutionDateRequest request) {
        if(!repository.existsByProjectId(request.getExecution().getProjectId())){
            ProjectSchedule projectSchedule = repository.save(WrapperTool.executionFrom(request.getExecution()));
            return new ExecutionDateResponse("DeadLine has associated to project successfully",
                    HttpStatus.CREATED.toString(),
                    List.of(new Executions(
                            projectSchedule.getId(),
                            projectSchedule.getProject().getName(),
                            Date.from(Instant.now()))));
        }
        return new ExecutionDateResponse("This DeadLine have not been associated",HttpStatus.CONFLICT.toString());
    }

    public ExecutionDateResponse list(){
        List<ProjectSchedule> projectSchedules = repository.findAll();
        if(!projectSchedules.isEmpty()) {
            return new ExecutionDateResponse("DeadLine associated",
                    HttpStatus.ACCEPTED.toString(),
                    WrapperTool.convertExecutionTo(projectSchedules));
        }
        return new ExecutionDateResponse("Does not exist DeadLine associated",HttpStatus.NOT_FOUND.toString());
    }

    public ExecutionDateResponse updateExecution(ExecutionDateRequest executionDateRequest, int executionId) {
        ExecutionDateResponse response =new ExecutionDateResponse();
        try {
            Optional<ProjectSchedule> projectScheduleCreated = repository.findById((long) executionId);
            if (projectScheduleCreated.isPresent()) {
                ProjectSchedule projectScheduleUpgrade = WrapperTool.executionFrom(executionDateRequest.getExecution());
                ProjectSchedule projectScheduleUpdate = repository.save(WrapperTool.executionUpdateFrom(projectScheduleCreated.get(), projectScheduleUpgrade));
                response.setMessage("The DeadLine has been updated successfully");
                response.setCode(HttpStatus.OK.toString());
                response.setExecutions(List.of(new Executions(
                        projectScheduleUpdate.getId(),
                        projectScheduleUpdate.getProject().getName(),
                        new Date())));
            }
        } catch (Exception exception) {
            return new ExecutionDateResponse("Error::Updating DeadLine::" + exception.getMessage(), HttpStatus.CONFLICT.toString());
        }
        return response;
    }

    public ExecutionDateResponse removeExecution(Long executionId) {
        ExecutionDateResponse response =new ExecutionDateResponse();
        try {
            Optional<ProjectSchedule> projectSchedule = repository.findById(executionId);
            if (projectSchedule.isPresent()) {
                repository.delete(projectSchedule.get());
                response.setMessage("The projectDeadline has been removed successfully");
                response.setCode(HttpStatus.OK.toString());
                response.setExecutions(List.of(new Executions(
                        projectSchedule.get().getId(),
                        projectSchedule.get().getProject().getName(),
                        new Date())));
            } else {
                response.setMessage("Don't found DeadLine with id "+ executionId);
                response.setCode(HttpStatus.NOT_FOUND.toString());
                response.setExecutions(null);
            }
        } catch (Exception exception) {
            return new ExecutionDateResponse("Error::Removing DeadLine::" + exception.getMessage(), HttpStatus.CONFLICT.toString());
        }
        return response;
    }
}
