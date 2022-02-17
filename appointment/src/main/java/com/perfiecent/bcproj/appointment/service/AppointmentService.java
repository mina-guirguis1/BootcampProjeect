package com.perfiecent.bcproj.appointment.service;


import com.perfiecent.bcproj.appointment.model.Appointment;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    List<Appointment> findAllById(long id);

    Appointment getAppointmentById(long id);

    Appointment updateAppointment(Appointment appointment, long id);

    void deleteAppointment(long id);


}
