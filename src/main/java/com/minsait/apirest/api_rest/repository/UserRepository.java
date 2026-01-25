package com.minsait.apirest.api_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.minsait.apirest.api_rest.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}