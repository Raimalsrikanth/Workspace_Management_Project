package com.jsp.workspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.jsp.workspace.dao.ManagerDao;
import com.jsp.workspace.dto.Manager;
import com.jsp.workspace.exception.ManagerNotFoundBasedOnId;
import com.jsp.workspace.util.ResponseStructure;

@Service
public class ManagerService {

	@Autowired
	private ManagerDao managerDao;

	/*
	 * Saving Manager Object if Building is present
	 */
	public ResponseEntity<ResponseStructure<Manager>> saveManager(Manager manager) {
		Manager dbmanager = managerDao.saveManager(manager);
		ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
		structure.setData(dbmanager);
		structure.setMessage("manager save successfully...");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.CREATED);
	}

	// ******************* Fetching The Manager By Id *************//
	public ResponseEntity<ResponseStructure<Manager>> fetchManagerById(int id) {
		Manager mgr = managerDao.fetchManagerById(id);
		if (mgr != null) {
			ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
			structure.setData(mgr);
			structure.setMessage("Manager Fetched Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotFoundBasedOnId("Manager Not Found Based On Id " + id);
		}
	}

	// ******************* Fetching All The Manager In List *************//
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchManager() {
		List<Manager> mgr = managerDao.fetchAllManager();
		if (mgr != null) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<List<Manager>>();
			structure.setData(mgr);
			structure.setMessage("List Of Managers Fetched Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotFoundBasedOnId("Managers Not Found");
		}
	}

	// ******************* Fetching All The Manager In List By Experience
	// *************//
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchManagerByExp(int exp) {
		List<Manager> mgr = managerDao.fetchAllManagerByExp(exp);
		if (mgr != null) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<List<Manager>>();
			structure.setData(mgr);
			structure.setMessage("List Of Managers Fetched Successfully Based On Experience");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotFoundBasedOnId("Managers Not Found Based On Experience" + exp);
		}
	}

	// ******************* Fetching All The Manager In List By Name *************//
	public ResponseEntity<ResponseStructure<List<Manager>>> fetchManagerByName(String name) {
		List<Manager> mgr = managerDao.fetchAllManagerByName(name);
		if (mgr != null) {
			ResponseStructure<List<Manager>> structure = new ResponseStructure<List<Manager>>();
			structure.setData(mgr);
			structure.setMessage("List Of Managers Fetched Successfully Based On Name " + name);
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Manager>>>(structure, HttpStatus.FOUND);
		} else {
			throw new ManagerNotFoundBasedOnId("Managers Not Found Based On Name " + name);
		}
	}

	// ******************* Updating The Manager Details *************//
	public ResponseEntity<ResponseStructure<Manager>> updateManager(Manager manager) {
		Manager mgr = managerDao.updateManager(manager);
		if (mgr != null) {
			ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
			structure.setData(mgr);
			structure.setMessage("Manager Details Updated Successfully");
			structure.setStatus(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.ACCEPTED);
		} else {
			throw new ManagerNotFoundBasedOnId("Manager Not Found Based On Id " + manager.getId());
		}
	}

	// ******************* Deleting The Manager Details *************//
	public ResponseEntity<ResponseStructure<Manager>> deleteManager(int id) {
		Manager mgr = managerDao.fetchManagerById(id);
		if (mgr != null) {
			Manager mgr1 = managerDao.deleteManager(mgr);
			ResponseStructure<Manager> structure = new ResponseStructure<Manager>();
			structure.setData(mgr1);
			structure.setMessage("Manager Deleted Successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Manager>>(structure, HttpStatus.OK);
		} else {
			throw new ManagerNotFoundBasedOnId("Manager Not Found Based On Id " + id);
		}
	}

	public ResponseEntity<ResponseStructure<Manager>> fetchBasedOnId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
