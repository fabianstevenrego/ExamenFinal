package com.examenfinal.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.demo.modelo.User;



public interface UserRepositori extends JpaRepository<User, Integer> {
}