package local.leticia.airports.repositories;


import local.leticia.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ppjatb
 */
public interface AirportRepository  extends JpaRepository<Airport, Long> {
    
    
}
