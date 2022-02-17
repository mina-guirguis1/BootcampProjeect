package com.perfiecent.bcproj.appointment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {


    @Id
    private UUID id;
    private String apptName;
    private String apptType;
    private String description;
    private String startTime;
    private String endTime;
    private String metaData;

}
