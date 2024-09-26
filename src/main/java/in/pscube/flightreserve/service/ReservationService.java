package in.pscube.flightreserve.service;

import in.pscube.flightreserve.dto.ReservationRequest;
import in.pscube.flightreserve.entities.Reservation;

public interface ReservationService {

	Reservation bookFlight(ReservationRequest request);
}
