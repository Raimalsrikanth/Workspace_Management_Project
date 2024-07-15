package com.jsp.workspace.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workspace.dto.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> 
{

}