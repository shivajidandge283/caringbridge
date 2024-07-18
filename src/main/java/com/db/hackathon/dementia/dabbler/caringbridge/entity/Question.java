package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "QUESTION")
@NoArgsConstructor
@AllArgsConstructor
public class Question implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String question;
    @Column
    private String queCategory;
    @Column
    private Integer answer;

    @Column
    private String options;

    @Column
    private String imageUrl;

}
