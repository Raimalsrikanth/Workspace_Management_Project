package com.jsp.workspace.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.workspace.dto.Client;
import com.jsp.workspace.Repo.ClientRepo;

@Repository
public class ClientDao {
	
	@Autowired
	private ClientRepo clientRepo;

	public Client saveClient(Client client) {
		System.out.println(client);
		return clientRepo.save(client);
	}
}
