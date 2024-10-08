package in.pscube.flightreserve.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.pscube.flightreserve.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("FROM Flight where departureCity=:departureCity AND arrivalCity=:arrivalCity AND dateOfDeparture=:dateOfDeparture")
	List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to,
			@Param("dateOfDeparture") Date departureDate);

}
