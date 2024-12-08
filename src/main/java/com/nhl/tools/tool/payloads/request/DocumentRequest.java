package com.nhl.tools.tool.payloads.request;

import com.nhl.tools.tool.model.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentRequest {
    private Document document;
}
