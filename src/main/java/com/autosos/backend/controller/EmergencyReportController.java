package com.autosos.backend.controller;

import com.autosos.backend.dto.EmergencyReportRequest;
import com.autosos.backend.dto.EmergencyReportResponse;
import com.autosos.backend.service.EmergencyReportService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
public class EmergencyReportController {

    private final EmergencyReportService reportService;

    public EmergencyReportController(EmergencyReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping
    public ResponseEntity<EmergencyReportResponse> createReport(Authentication authentication,
                                                                @Valid @RequestBody EmergencyReportRequest request) {
        String username = authentication.getName();
        EmergencyReportResponse response = reportService.createReport(username, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/me")
    public ResponseEntity<List<EmergencyReportResponse>> getMyReports(Authentication authentication) {
        String username = authentication.getName();
        return ResponseEntity.ok(reportService.getReportsForUser(username));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EmergencyReportResponse>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<EmergencyReportResponse> updateReport(@PathVariable Long id,
                                                                @Valid @RequestBody EmergencyReportRequest request) {
        EmergencyReportResponse response = reportService.updateReport(id, request);
        return ResponseEntity.ok(response);
    }
}
