package com.autosos.backend.service.impl;

import com.autosos.backend.dto.EmergencyReportRequest;
import com.autosos.backend.dto.EmergencyReportResponse;
import com.autosos.backend.entity.EmergencyReport;
import com.autosos.backend.entity.User;
import com.autosos.backend.exception.ResourceNotFoundException;
import com.autosos.backend.repository.EmergencyReportRepository;
import com.autosos.backend.repository.UserRepository;
import com.autosos.backend.service.EmergencyReportService;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmergencyReportServiceImpl implements EmergencyReportService {

    private final EmergencyReportRepository reportRepository;
    private final UserRepository userRepository;

    public EmergencyReportServiceImpl(EmergencyReportRepository reportRepository, UserRepository userRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
    }

    @Override
    public EmergencyReportResponse createReport(String username, EmergencyReportRequest request) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        EmergencyReport report = new EmergencyReport();
        report.setUser(user);
        report.setType(request.getType());
        report.setDescription(request.getDescription());
        report.setLocation(request.getLocation());
        report.setTimestamp(OffsetDateTime.now());
        EmergencyReport saved = reportRepository.save(report);
        return toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmergencyReportResponse> getReportsForUser(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return reportRepository.findByUser(user).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmergencyReportResponse> getAllReports() {
        return reportRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmergencyReportResponse updateReport(Long id, EmergencyReportRequest request) {
        EmergencyReport report = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found"));
        report.setType(request.getType());
        report.setDescription(request.getDescription());
        report.setLocation(request.getLocation());
        EmergencyReport updated = reportRepository.save(report);
        return toResponse(updated);
    }

    private EmergencyReportResponse toResponse(EmergencyReport report) {
        return new EmergencyReportResponse(
                report.getId(),
                report.getUser().getUsername(),
                report.getType(),
                report.getDescription(),
                report.getLocation(),
                report.getTimestamp()
        );
    }
}
