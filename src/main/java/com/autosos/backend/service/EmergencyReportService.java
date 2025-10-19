package com.autosos.backend.service;

import com.autosos.backend.dto.EmergencyReportRequest;
import com.autosos.backend.dto.EmergencyReportResponse;
import java.util.List;

public interface EmergencyReportService {
    EmergencyReportResponse createReport(String username, EmergencyReportRequest request);
    List<EmergencyReportResponse> getReportsForUser(String username);
    List<EmergencyReportResponse> getAllReports();
    EmergencyReportResponse updateReport(Long id, EmergencyReportRequest request);
}
