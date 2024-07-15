package com.jsp.workspace.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.workspace.dto.Address;
import com.jsp.workspace.dto.Admin;
import com.jsp.workspace.Repo.AdminRepo;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private AddressDao addressdao;

	// To Save the Admin Object
	public Admin saveAdmin(Admin admin) {
		System.out.println(admin);
		return adminRepo.save(admin);
	}

	// Fetching Admin Details Based on Id
	public Admin fetchAdminById(int id) {
		Optional<Admin> optional = adminRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	//Fetching Admin Details Based On Name
		public List<Admin> fetchAdminByName(String name){
			List<Admin> opt=adminRepo.findByAdminName(name);
			if(opt.isEmpty()) {
				return null;
			}
			else {
				return opt;
			}
		} 
		
		
		// Updating The Admin Details 
		public Admin updateAdmin(Admin admin) {
			Optional<Admin> opt=adminRepo.findById(admin.getId());
			if(opt.isPresent()) {
				Admin a=opt.get();
					if(a.getName()!=admin.getName() && admin.getName()!=null) {
						a.setName(admin.getName());
					}
					else {
						a.setName(a.getName());
					}
					if(a.getPhone()!=admin.getPhone() && admin.getPhone()!=0) {
						a.setPhone(admin.getPhone());
					}
					else {
						a.setPhone(a.getPhone());
					}
					if(a.getEmail()!=admin.getEmail() && admin.getEmail()!=null) {
						a.setEmail(admin.getEmail());
					}
					else {
						a.setEmail(a.getEmail());
					}
					if(a.getGender()!=admin.getGender() && admin.getGender()!=null) {
						a.setGender(admin.getGender());
					}
					else {
						a.setGender(a.getGender());
					}
					if(a.getPwd()!=admin.getPwd() && admin.getPwd()!=null) {
						a.setPwd(admin.getPwd());
					}
					else {
						a.setPwd(a.getPwd());
					}
					if(admin.getAddress()!=null) {
						Address adrs=addressdao.updateAddress(a.getAddress(),admin.getAddress());
						a.setAddress(adrs);
					}
					else {
						a.setAddress(a.getAddress());
					}
					
					return adminRepo.save(a);
				}
			else {
				return null;
			}
		}
		
		//Deleting the Admin Details
		public Admin deleteAdmin(int id){
			Optional<Admin> ad=adminRepo.findById(id);
				Admin adm=ad.get();
				adminRepo.delete(adm);
				return adm;
		}

}
