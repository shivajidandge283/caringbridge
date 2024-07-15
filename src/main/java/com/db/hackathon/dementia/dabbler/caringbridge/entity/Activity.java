package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ACTIVITY_DTL")
@NoArgsConstructor
@AllArgsConstructor
public class Activity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String activityName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="PATIENT_ID")
    private User patient;

    @Column
    private String frequency;
}
