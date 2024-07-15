package com.jsp.workspace.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workspace.dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}