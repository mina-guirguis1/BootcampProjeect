package com.perfiecent.bcproj.appointment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="appointmentdb")
public class Appointment {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "appt_name", nullable = false)
    private String apptName;

    @Column(name = "appt_type", nullable = false)
    private String apptType;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "meta_data", nullable = false)
    private long metaData;

}
