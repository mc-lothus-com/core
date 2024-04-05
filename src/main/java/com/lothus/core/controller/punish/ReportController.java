package com.lothus.core.controller.punish;


import com.lothus.core.Core;
import com.lothus.core.punish.report.ReportInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReportController {

    private List<ReportInfo> reports = new ArrayList<>();

    public void loadAll() {
        for (ReportInfo reportInfo : Core.getDataReport().getReports()) {
            load(reportInfo);
        }
    }

    public void load(ReportInfo reportInfo) {
        reports.add(reportInfo);
    }

    public void unload(UUID uuid) {
        reports.removeIf(reportInfo -> reportInfo.getReported().equals(uuid));
    }

    public ReportInfo getReport(UUID uuid) {
        for (ReportInfo reportInfo : reports) {
            if (reportInfo.getReported().equals(uuid)) {
                return reportInfo;
            }
        }
        return null;
    }

    public List<ReportInfo> getReports() {
        return reports;
    }
}
