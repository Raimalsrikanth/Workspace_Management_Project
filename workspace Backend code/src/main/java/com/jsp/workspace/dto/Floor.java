package com.jsp.workspace.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Floor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int floor_Number;
	@OneToMany
	private List<Workspace>spaces;
}
