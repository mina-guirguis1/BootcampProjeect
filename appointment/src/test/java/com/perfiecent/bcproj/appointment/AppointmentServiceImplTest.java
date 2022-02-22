package com.perfiecent.bcproj.appointment;

import com.perfiecent.bcproj.appointment.controller.AppointmentController;
import com.perfiecent.bcproj.appointment.model.Appointment;
import com.perfiecent.bcproj.appointment.repository.AppointmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@SpringBootTest
public class AppointmentServiceImplTest {

    private static long id = 1L;
    private static String apptName = "Dentist Appointment";
    private static String apptType = "Dental";
    private static String description = "Teeth cleaning";
    private static String startTime = "3:00pm";
    private static String endTime = "4:00pm";
    private static long metaData = 2L;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentController appointmentController;

    Appointment appointmentTest;
    Appointment otherAppointmentTest;

    @BeforeEach
    void setUp() {
        appointmentTest = Appointment.builder()
                .id(1L)
                .apptName("Dentist Appointment")
                .apptType("Dental")
                .description("Teeth cleaning")
                .startTime("3:00pm")
                .endTime("4:00pm")
                .metaData(2L)
                .build();
        appointmentRepository.save(appointmentTest);

        otherAppointmentTest = Appointment.builder()
                .id(3L)
                .apptName("Check up")
                .apptType("Primary Care")
                .description("Yearly checkup")
                .startTime("10:00am")
                .endTime("11:00am")
                .metaData(4L)
                .build();
        appointmentRepository.save(otherAppointmentTest);
    }

    @Test
    void saveAppointmentTest() {

        Appointment  retrieveAppointment = appointmentRepository.findById(1L).orElse(null);

        assertNotNull(retrieveAppointment);
        assertEquals(id, retrieveAppointment.getId());
        assertEquals(apptName, retrieveAppointment.getApptName());
        assertEquals(apptType, retrieveAppointment.getApptType());
        assertEquals(description, retrieveAppointment.getDescription());
        assertEquals(startTime, retrieveAppointment.getStartTime());
        assertEquals(endTime, retrieveAppointment.getEndTime());
        assertEquals(metaData, retrieveAppointment.getMetaData());

    }

    @Test
    void getAppointmentTest() {assertThat(appointmentRepository.findAll().size() == 2);}

    @Test
    void updateUserTest() {

        Appointment gotAppointment = appointmentRepository.getById(otherAppointmentTest.getId());
        Appointment updatedAppointment = Appointment.builder()
                .id(gotAppointment.getId())
                .apptName(gotAppointment.getApptName())
                .apptType(gotAppointment.getApptType())
                .description(gotAppointment.getDescription())
                .startTime(gotAppointment.getStartTime())
                .endTime(gotAppointment.getEndTime())
                .metaData(gotAppointment.getMetaData())
                .build();

        appointmentRepository.save(updatedAppointment);
        updatedAppointment = appointmentRepository.getById(otherAppointmentTest.getId());

        assertThat(updatedAppointment.getApptName().equals("Check up"));
        assertThat(updatedAppointment.getApptType().equals("Primary care"));
    }

    @Test
    void deleteAppointment() {
        appointmentRepository.deleteById(otherAppointmentTest.getId());
        assertThat(appointmentRepository.findById(otherAppointmentTest.getId()).isEmpty());
    }
}
