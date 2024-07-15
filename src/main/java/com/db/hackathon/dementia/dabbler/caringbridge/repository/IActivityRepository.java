package com.db.hackathon.dementia.dabbler.caringbridge.repository;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface IActivityRepository extends CrudRepository<Activity, Long>, JpaRepository<Activity, Long>,
        JpaSpecificationExecutor<Activity> {

}
