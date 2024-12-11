package com.nhl.tools.tool.util;

import com.nhl.tools.tool.model.Document;
import com.nhl.tools.tool.payloads.response.Documents;

import java.util.ArrayList;
import java.util.List;

public class WrapperTool {

    public static List<Documents> convertTo (List<Document> projectList){
        List<Documents> projects = new ArrayList<>();
        projectList.forEach(project -> projects.add(new Documents(project.getId(), project.getTitle(), project.getCreatedAt())));
        return projects;
    }
}
