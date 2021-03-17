package com.example.donutondemand.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.donutondemand.model.Role;

public interface RoleJPADao extends JpaRepository<Role, Integer> {

}
