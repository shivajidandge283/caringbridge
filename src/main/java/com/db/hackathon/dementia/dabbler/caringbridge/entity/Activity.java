package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;



import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "ACTIVITY")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Activity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String activityName;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="PATIENT_ID")
    private User patient;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private Date activityTime;

    @Column
    private String frequency;
}
