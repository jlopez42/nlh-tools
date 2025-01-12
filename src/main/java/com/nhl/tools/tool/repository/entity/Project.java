package com.nhl.tools.tool.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @ColumnDefault("1")
    @Column(name = "enable")
    private Boolean enable;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "project")
    private Set<Budget> budgets = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<Document> documents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectAssignment> projectAssignments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectDeadline> projectDeadlines = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectDetail> projectDetails = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectExtra> projectExtras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectGeneral> projectGenerals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectOfficer> projectOfficers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "project")
    private Set<ProjectSchedule> projectSchedules = new LinkedHashSet<>();

}