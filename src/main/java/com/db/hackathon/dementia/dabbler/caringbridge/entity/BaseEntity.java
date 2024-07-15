package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Generated;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Generated
@MappedSuperclass
public class BaseEntity {

    private static final int LENGTH_1 = 100;
    private static final int LENGTH_30 = 30;
    private static final int LENGTH_50 = 50;
    private static final int LENGTH_100 = 100;
    private static final int LENGTH_1000 = 1000;
    private static final int LENGTH_4000 = 4000;

    @Column(name = "CREATED_DATE", nullable = false)
    private Timestamp createdDate;

    @Column(name = "CREATED_BY", length = LENGTH_30, nullable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE", nullable = false)
    private Timestamp updatedDate;

    @Column(name = "UPDATED_BY", length = LENGTH_30, nullable = false)
    private String updatedBy;

    @PrePersist
    public void onPrePersist() {
        createdDate = new Timestamp(new Date().getTime());
        updatedDate = createdDate;
        createdBy = "System";
        updatedBy = "System";
    }

    @PreUpdate
    public void onPreUpdate() {
        updatedDate = new Timestamp(new Date().getTime());
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", updatedDate=" + updatedDate +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
