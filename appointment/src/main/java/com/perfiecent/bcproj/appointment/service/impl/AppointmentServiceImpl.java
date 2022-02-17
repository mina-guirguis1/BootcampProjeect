package com.perfiecent.bcproj.appointment.service.impl;


import com.perfiecent.bcproj.appointment.model.Appointment;
import com.perfiecent.bcproj.appointment.repository.AppointmentRepository;
import com.perfiecent.bcproj.appointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;


    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public List<Appointment> findAllById(UUID id) {
        return appointmentRepository.findAllById(id);
    }


    @Override
    public Appointment getAppointmentById(UUID id) {
       return null;
    }

    @Override
    public Appointment updateAppointment(Appointment appointment, UUID id) {
        return null;
    }

    @Override
    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteApptById(id);
    }
}


