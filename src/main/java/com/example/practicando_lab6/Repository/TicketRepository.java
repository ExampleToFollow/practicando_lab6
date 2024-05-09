package com.example.practicando_lab6.Repository;

import com.example.practicando_lab6.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer>  {
}
