package in.pscube.flightreserve.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pscube.flightreserve.entities.Flight;
import in.pscube.flightreserve.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
