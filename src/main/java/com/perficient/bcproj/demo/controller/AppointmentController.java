package com.perficient.bcproj.demo.controller;

import com.perficient.bcproj.demo.services.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/appointments")
@Controller
public class AppointmentController {

    private AppointmentService appointmentService;


}
