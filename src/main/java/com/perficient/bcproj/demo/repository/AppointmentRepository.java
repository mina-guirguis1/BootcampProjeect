package com.perficient.bcproj.demo.repository;

import com.perficient.bcproj.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllById(UUID id);

    void deleteApptById(UUID id);

}
