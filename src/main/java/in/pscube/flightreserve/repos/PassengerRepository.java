package in.pscube.flightreserve.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pscube.flightreserve.entities.Flight;
import in.pscube.flightreserve.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
