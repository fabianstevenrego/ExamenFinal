package com.examenfinal.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examenfinal.demo.modelo.Bill;
import com.examenfinal.demo.modelo.User;
import com.examenfinal.demo.repositorio.UserRepositori;


@RestController
@RequestMapping("/users")

public class UserController {


	@Autowired
	UserRepositori userRepositori;
	
	@GetMapping
	public List<User> getUserAll() {

		return userRepositori.findAll();
	}
	
	@GetMapping("/{id}/bills")
	public List<Bill> user(@PathVariable Integer id){
		Optional<User> usuarios=userRepositori.findById(id);
		if(usuarios.isPresent()) {
			return usuarios.get().getBills();
		}
		
		return null;
	}
	
	@PostMapping("/{id}/bills")
	public Bill postBillPorUser(@RequestBody Bill bill, @PathVariable Integer id) {
		
		Optional<User> usuarios=userRepositori.findById(id);
		if(usuarios.isPresent()) {
		
			usuarios.get().setBills(null);
		}
		
		return bill;
		
	}
	
	
	
	
	
	@GetMapping("/{id}/bills/{idmov}") 
	public List<Bill> userBill(@PathVariable Integer id,@PathVariable Integer idmov){
		
		Optional<User>usuarios=userRepositori.findById(id);
		if(usuarios.isPresent()) {
			
			return usuarios.get().getBills();
		}
		
		return null;
	}
	

    /* 
	@GetMapping("/{user}/bill") 
    public List<Bill> getUsuariosbyUser(@PathVariable String user) {
        List<User> usuarios = userRepositori.findByUser(user); 
        if (!usuarios.isEmpty()) {
            return usuarios.get(0).getBills();
        } 
        return null;

    }
	
	 */
	
}
