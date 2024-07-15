package com.jsp.workspace.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Workspace {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int capacity;
	private String type;
	private double pricePerDay;
	private String availability;
	private String squareFeet;
	
	@ManyToMany
	private List<Client>clients;
}
