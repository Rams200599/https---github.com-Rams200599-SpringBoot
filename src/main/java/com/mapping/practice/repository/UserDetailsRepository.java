package com.mapping.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.practice.Entities.UserDetails;
//Repository interface for UserDetails
@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
    
}
