package com.examenfinal.demo.modelo;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Bill implements Serializable {
	
	@Id
	private Integer id;
	private Timestamp date;
	@ManyToOne
	private User user;
	private String numeric;
	private Integer type;
	private String observation;
	
	
	
	
}

