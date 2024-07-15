package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@Table(name = "USER_DTL")
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String password;
}
