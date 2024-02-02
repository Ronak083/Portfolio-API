package com.ronak.portfolio.repository;


import com.ronak.portfolio.Entity.Role;
import com.ronak.portfolio.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    User findByRole(Role role);
}