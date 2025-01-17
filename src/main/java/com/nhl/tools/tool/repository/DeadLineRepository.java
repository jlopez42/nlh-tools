package com.nhl.tools.tool.repository;

import com.nhl.tools.tool.repository.entity.ProjectDeadline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeadLineRepository extends JpaRepository<ProjectDeadline, Long> {
    Optional<ProjectDeadline> findById(Long projectDeadLineId);

    Boolean existsByProjectId(Long projectId);
}
