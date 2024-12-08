package com.nhl.tools.tool.repository;

import com.nhl.tools.tool.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentationRepository extends JpaRepository<Document, Long> {

    Optional<Document> findById(Long budgetId);

    Boolean existsByProjectId(Long projectId);
}
