package com.perfiecent.bcproj.appointment.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String apptName;
    private String apptType;
    private String description;
    private String startTime;
    private String endTime;
    private String metaData;

}
