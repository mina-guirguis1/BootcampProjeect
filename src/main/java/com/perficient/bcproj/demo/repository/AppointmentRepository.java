package com.perficient.bcproj.demo.repository;

import com.perficient.bcproj.demo.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
