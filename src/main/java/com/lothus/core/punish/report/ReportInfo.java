package com.lothus.core.punish.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class ReportInfo {

    private UUID reporter;
    private UUID reported;

    private String reason;

    private long created;
}
