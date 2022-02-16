package com.perficient.bcproj.demo.services.impl;

import com.perficient.bcproj.demo.repository.AppointmentRepository;
import com.perficient.bcproj.demo.services.AppointmentService;
import org.springframework.stereotype.Service;

public class AppointmentServiceImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        super();
        this.appointmentRepository = appointmentRepository;
    }
}


