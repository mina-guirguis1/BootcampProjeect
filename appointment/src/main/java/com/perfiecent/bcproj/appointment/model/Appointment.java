package com.perfiecent.bcproj.appointment.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="appointmentdb")
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "apptName", nullable = false)
    private String apptName;

    @Column(name = "apptType", nullable = false)
    private String apptType;

    @Column(name = "description")
    private String description;

    @Column(name = "startTime", nullable = false)
    private String startTime;

    @Column(name = "endTime", nullable = false)
    private String endTime;

    @Column(name = "metaData", nullable = false)
    private long metaData;

}
