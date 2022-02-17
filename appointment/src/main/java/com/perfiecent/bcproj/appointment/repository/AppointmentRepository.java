package com.perfiecent.bcproj.appointment.repository;


import com.perfiecent.bcproj.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    List<Appointment> findAllById(long id);

    void deleteApptById(long id);

}