package com.autosos.backend.repository;

import com.autosos.backend.entity.EmergencyReport;
import com.autosos.backend.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergencyReportRepository extends JpaRepository<EmergencyReport, Long> {
    List<EmergencyReport> findByUser(User user);
}
