package com.examenfinal.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenfinal.demo.modelo.Bill;
import com.examenfinal.demo.repositorio.BillRepositori;

@RestController
@RequestMapping("/bills")

public class BillController {


    @Autowired
	BillRepositori billRepositori;


    @GetMapping
	public List<Bill> getProductoAll() {

		return billRepositori.findAll();
	}
	
	@GetMapping("/{id}")
	public Bill getProductosbyId(@PathVariable Integer id) {
		
		Optional<Bill> producto = billRepositori.findById(id);
		
		if (producto.isPresent()) {
			return producto.get();
		}
		
		return null;

	}
	
	@PostMapping
	public Bill postBill(@RequestBody Bill bill) {
		
		billRepositori.save(bill);
		
		return bill;
		

	}
	
	
	
	@DeleteMapping("/{id}")
	public Bill deleteBillsId(@PathVariable Integer id) {
		
		Optional<Bill> bill = billRepositori.findById(id);
		
		if (bill.isPresent()) {
			
			Bill billReturn = bill.get();
			
			billRepositori.deleteById(id);
			
			return billReturn;
		}
		
		return null;

	}

    
}

