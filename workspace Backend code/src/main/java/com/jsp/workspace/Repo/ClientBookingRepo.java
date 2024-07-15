package com.jsp.workspace.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.workspace.dto.ClientBooking;

public interface ClientBookingRepo extends JpaRepository<ClientBooking, Integer> {

}
