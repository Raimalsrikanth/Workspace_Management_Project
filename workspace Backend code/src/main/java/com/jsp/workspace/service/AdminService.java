package com.jsp.workspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.workspace.Clone.AdminClone;
import com.jsp.workspace.dao.AdminDao;
import com.jsp.workspace.dao.BuildingDao;
import com.jsp.workspace.dto.Admin;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.exception.AdminIdNotFound;
import com.jsp.workspace.exception.AdminNameNotFound;
import com.jsp.workspace.exception.BuildingNotFoundBasedOnName;
import com.jsp.workspace.util.ResponseStructure;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private BuildingDao buildingDao;

	/*
	 *  Saving The Admin
	 */
	public ResponseEntity<ResponseStructure<AdminClone>> saveAdmin(Admin admin) {
		
		Admin dbadmin = adminDao.saveAdmin(admin);
		AdminClone clone = new AdminClone();
		clone.setEmail(dbadmin.getEmail());
		clone.setName(dbadmin.getName());
		clone.setId(dbadmin.getId());
		clone.setPhone(dbadmin.getPhone());
		
		ResponseStructure<AdminClone> structure = new ResponseStructure<AdminClone>();
		structure.setMessage("admin save successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(clone);
		
		return new ResponseEntity<ResponseStructure<AdminClone>>(structure, HttpStatus.CREATED);
	}
	
	

	/*
	 *  Fetching Admin Details Based On Id
	 */
	public ResponseEntity<ResponseStructure<Admin>> fetchAdminById(int admin_id) {
		Admin dbadmin = adminDao.fetchAdminById(admin_id);
		if(dbadmin!=null) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setData(dbadmin);
		structure.setMessage("fetch the admin details Successfull....!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
		}else {
			throw new AdminIdNotFound ("admin not found with id");
		}
	}
	
	
	/*
	 *  Fetching Admin Details Based On Admin Name
	 */
	public ResponseEntity<ResponseStructure<List<Admin>>> fetchAdminByName(String admin_name) {
		List<Admin> dbadmin = adminDao.fetchAdminByName(admin_name);
		if(dbadmin!=null) {
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();
		structure.setData(dbadmin);
		structure.setMessage("Admin details fetched Successfull....!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.CREATED);
		}else {
			throw new AdminNameNotFound ("Admin not present with this name");
		}
	}
	
	
	/*
	 *  Updating The Admin Details
	 */
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		Admin dbadmin = adminDao.updateAdmin(admin);
		if(dbadmin!=null) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setData(dbadmin);
		structure.setMessage("Admin updated Successfull....!");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.CREATED);
		}else {
			throw new AdminIdNotFound ("admin not with id");
		}
	
	}
	
	
	public ResponseEntity<ResponseStructure<Admin>>deleteAdmin(int id){
		Admin db=adminDao.fetchAdminById(id);
		if(db!=null) {
			List<Building> bul=buildingDao.fetchBuildingsByAdminId(id);
			if(bul!=null) {
				buildingDao.deleteListOfBuildings(bul);
			}
			Admin ad=adminDao.deleteAdmin(id);
			ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
			structure.setData(ad);
			structure.setMessage("Admin Deleted Sucessfully And Buildings Related To Admin Also Deleted Scuessfully ");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
		}
		
		else {
			throw new AdminIdNotFound("Admin Not found With The Id "+id+" Deletion Of Admin is Not possible");
		}
	}
	
}
