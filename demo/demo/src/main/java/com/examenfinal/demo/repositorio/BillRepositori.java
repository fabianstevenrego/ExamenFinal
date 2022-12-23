package com.examenfinal.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examenfinal.demo.modelo.Bill;

public interface BillRepositori  extends JpaRepository<Bill, Integer> {
}
