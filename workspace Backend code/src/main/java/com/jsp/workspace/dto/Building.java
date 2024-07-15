package com.jsp.workspace.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Building {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String building_Name;
	private int ratings;

	@OneToOne
	@JoinColumn(unique = true)
	private Manager manager;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@ManyToOne
	private Admin admin;
	
	@OneToMany
	private List<Floor> floors;
	
}
