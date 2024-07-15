package com.db.hackathon.dementia.dabbler.caringbridge.repository;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Long>, JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {

    boolean existsByEmail(String email);

    User findByPhoneNumber(String phoneNumber);

    User findByEmailAndPassword(String email, String password);
}
