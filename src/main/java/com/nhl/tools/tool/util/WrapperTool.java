package com.nhl.tools.tool.util;

import com.nhl.tools.tool.model.Document;
import com.nhl.tools.tool.payloads.response.Documents;
import com.nhl.tools.tool.repository.entity.Project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WrapperTool {

    public static List<Documents> convertTo (List<com.nhl.tools.tool.repository.entity.Document> projectList){
        List<Documents> projects = new ArrayList<>();
        projectList.forEach(project -> projects.add(new Documents(project.getId(), project.getTitle(), Date.from(project.getCreatedAt()))));
        return projects;
    }

    public static com.nhl.tools.tool.repository.entity.Document documentFrom(Document document) {
        com.nhl.tools.tool.repository.entity.Document entity = new com.nhl.tools.tool.repository.entity.Document();
        entity.setTitle(document.getTitle());
        Project project = new Project();
        project.setId(document.getProjectId());
        entity.setProject(project);
        entity.setContent(document.getContent().getBytes());
        return entity;
    }

    public static com.nhl.tools.tool.repository.entity.Document documentUpdateFrom(com.nhl.tools.tool.repository.entity.Document document, com.nhl.tools.tool.repository.entity.Document documentUpgrade) {
        document.setProject(documentUpgrade.getProject());
        document.setTitle(documentUpgrade.getTitle());
        document.setContent(documentUpgrade.getContent());
        return document;
    }
}
