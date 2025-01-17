package com.nhl.tools.tool.payloads.request;

import com.nhl.tools.tool.model.DeadLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeadLineRequest {
    private DeadLine deadLine;
}
