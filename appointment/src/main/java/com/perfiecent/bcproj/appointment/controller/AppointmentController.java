package com.perfiecent.bcproj.appointment.controller;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perfiecent.bcproj.appointment.model.Appointment;
import com.perfiecent.bcproj.appointment.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:8080")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        super();
        this.appointmentService = appointmentService;
    }

    @PostMapping()
    public ResponseEntity<Appointment> createAppointment(@RequestBody Appointment appointment) {
        return new ResponseEntity<Appointment>(appointmentService.createAppointment(appointment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long id) {
        return new ResponseEntity<Appointment>(appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @GetMapping("/findAllByMetaData/{metadata}")
    public ResponseEntity<List<Appointment>> getAppointmentByMetadata(@PathVariable("metadata") long metadata) {
        return new ResponseEntity<List<Appointment>>(appointmentService.findAllByMetaData(metadata), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
        return new ResponseEntity<Appointment>(appointmentService.updateAppointment(appointment,id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/appointments/{id}")
    public ResponseEntity<Appointment> getAllApointments(@PathVariable("id") long id) {
        return new ResponseEntity<Appointment>(appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") long id) {
        appointmentService.deleteAppointment(id);
        return new ResponseEntity<String>("Appointment deleted successfully", HttpStatus.OK);
    }


}
