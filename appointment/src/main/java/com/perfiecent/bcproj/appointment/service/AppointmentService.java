package com.perfiecent.bcproj.appointment.service;


import com.perfiecent.bcproj.appointment.model.Appointment;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    List<Appointment> findAllById(UUID id);

    Appointment getAppointmentById(UUID id);

    Appointment updateAppointment(Appointment appointment, UUID id);

    void deleteAppointment(UUID id);


}
