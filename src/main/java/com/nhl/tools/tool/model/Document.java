package com.nhl.tools.tool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Entity(name = "documentation")
public class Document {

    @Id
    @GeneratedValue
    private Long id;
    private Long projectId;
    private String title;
    private String content;
    private Date createdAt;
    private Date updatedAt;
}
