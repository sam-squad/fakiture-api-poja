package com.samsquad.fakitureapi.repository;

import com.samsquad.fakitureapi.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);
}