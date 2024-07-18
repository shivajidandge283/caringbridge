package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userType;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String mobileNumber;
    private String hobby;
    private String gender;
    private String profilePhoto;
    private String emergencyContactNumber;
    private String patientMobileNumber;

}
