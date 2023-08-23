package ma.theatre.theatremanagementsystembackend.repositories;

import ma.theatre.theatremanagementsystembackend.entities.Category;
import ma.theatre.theatremanagementsystembackend.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
