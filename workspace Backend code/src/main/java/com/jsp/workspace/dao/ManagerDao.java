package com.jsp.workspace.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workspace.dto.Address;
import com.jsp.workspace.dto.Building;
import com.jsp.workspace.dto.Manager;
import com.jsp.workspace.Repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	private ManagerRepo managerRepo;

	@Autowired
	private AddressDao addressDao;

	/*
	 * Saving Manager
	 */
	public Manager saveManager(Manager manager) {
		System.out.println(manager);
		return managerRepo.save(manager);
	}

	/*
	 * Fetching Manager Details Based On Id
	 */
	public Manager fetchManagerById(int id) {
		Optional<Manager> optional = managerRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	// *********** Fetching All The Managers ************//
	public List<Manager> fetchAllManager() {
		List<Manager> list = managerRepo.findAll();
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	// *********** Fetching All The Managers By Experience ************//
	public List<Manager> fetchAllManagerByExp(int exp) {
		List<Manager> list = managerRepo.fetchByExp(exp);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	// *********** Fetching All The Managers By Name ************//
	public List<Manager> fetchAllManagerByName(String name) {
		List<Manager> list = managerRepo.fetchByName(name);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	// ************* Updating The Managers Details ***************//
	public Manager updateManager(Manager manager) {
		Optional<Manager> mng = managerRepo.findById(manager.getId());
		if (mng.isPresent()) {
			Manager mgr = mng.get();

			if (mgr.getName() != manager.getName() && manager.getName() != null) {
				mgr.setName(manager.getName());
			} 
			else {
				mgr.setName(mgr.getName());
			}
			if (mgr.getPhone() != manager.getPhone() && manager.getPhone() != 0) {
				mgr.setPhone(manager.getPhone());
			} 
			else {
				mgr.setPhone(mgr.getPhone());
			}
			if (mgr.getEmail() != manager.getEmail() && manager.getEmail() != null) {
				mgr.setEmail(manager.getEmail());
			} 
			else {
				mgr.setEmail(mgr.getEmail());
			}
			if (mgr.getExperience() != manager.getExperience() && manager.getExperience()>-1) {
				mgr.setExperience(manager.getExperience());
			}
			else {
				mgr.setExperience(mgr.getExperience());
			}
			if (mgr.getGender() != manager.getGender() && manager.getGender() != null) {
				mgr.setGender(manager.getGender());
			}
			else {
				mgr.setGender(mgr.getGender());
			}
			if (mgr.getPwd() != manager.getPwd() && manager.getPwd() != null) {
				mgr.setPwd(manager.getPwd());
			} 
			else {
				mgr.setPwd(mgr.getPwd());
			}
			if (manager.getAddress() != null) {
				Address adrs = addressDao.updateAddress(mgr.getAddress(), manager.getAddress());
				mgr.setAddress(adrs);
			}
			else {
				mgr.setAddress(mgr.getAddress());
			}

			return managerRepo.save(mgr);
		} 
		else {
			return null;
		}
	
	}
	
	
	//**************** Deleting Manager ********************//
	public Manager deleteManager(Manager mgr) {
		managerRepo.delete(mgr);
		return mgr;
	}

}
