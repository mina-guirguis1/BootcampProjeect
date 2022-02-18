package com.perficient.bcproj.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="gender", nullable = false)
    private String gender;

    @Column(name="age", nullable = false)
    private Integer age;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="phone_number", nullable = false)
    private String phoneNumber;

}
