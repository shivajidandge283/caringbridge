package com.db.hackathon.dementia.dabbler.caringbridge.repository;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends JpaRepository<User, Long>{

boolean existsByEmail(String email);

    User findByMobileNumber(String phoneNumber);

    User findByEmail(String email);
}
