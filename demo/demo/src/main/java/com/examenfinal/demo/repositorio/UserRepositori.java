package com.examenfinal.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.demo.modelo.User;



public interface UserRepositori extends JpaRepository<User, Integer> {
   
}