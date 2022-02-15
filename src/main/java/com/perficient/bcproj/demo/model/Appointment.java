package com.perficient.bcproj.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {

    private String apptName;
    private String apptType;
    private String description;
    private String startTime;
    private String endTime;
    private String metaData;
}
