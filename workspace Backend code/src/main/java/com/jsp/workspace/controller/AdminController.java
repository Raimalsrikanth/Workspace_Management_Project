package com.jsp.workspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.workspace.Clone.AdminClone;
import com.jsp.workspace.dto.Admin;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.service.AdminService;
import com.jsp.workspace.util.ResponseStructure;

@RestController
public class AdminController {
	
	//Saving Admin
	@Autowired
	private AdminService adminService;

	@PostMapping("/admin")
	public ResponseEntity<ResponseStructure<AdminClone>> SaveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	//Fetching The Admin By ID
		@GetMapping("/fetchAdminBasedOnId")
		public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(@RequestParam int id){
			return adminService.fetchAdminById(id);
		}
		
		//Fetching The Admin By Name
		@GetMapping("/fetchAdminBasedOnName")
		public ResponseEntity<ResponseStructure<List<Admin>>> fetchAdminByName(@RequestParam String name){
			return adminService.fetchAdminByName(name);
		}
		
		//Updating The Admin Details
		@PutMapping("/updatingAdmin")
		public ResponseEntity<ResponseStructure<Admin>> UpdateAdmin(@RequestBody Admin admin){
			return adminService.updateAdmin(admin);
		}
		
		//Deleting the Admin Details
		@DeleteMapping("/adminDeleting")
		public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(@RequestParam int id){
			return adminService.deleteAdmin(id);
		}	
	
}
