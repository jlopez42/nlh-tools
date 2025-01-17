package com.nhl.tools.tool.payloads.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Executions {

    private Long id;
    private String title;
    private Date createdAt;

    public Executions(Long id, String title, Date createdAt) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
    }

}
