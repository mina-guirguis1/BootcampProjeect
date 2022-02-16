package com.perficient.bcproj.demo.model;

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

    //TODO figure out UUID for appointment 
    @Id
    private String apptName;
    private String apptType;
    private String description;
    private String startTime;
    private String endTime;
    private String metaData;
}
