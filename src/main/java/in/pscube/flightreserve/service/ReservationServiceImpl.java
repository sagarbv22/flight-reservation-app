package in.pscube.flightreserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pscube.flightreserve.dto.ReservationRequest;
import in.pscube.flightreserve.entities.Flight;
import in.pscube.flightreserve.entities.Passenger;
import in.pscube.flightreserve.entities.Reservation;
import in.pscube.flightreserve.repos.FlightRepository;
import in.pscube.flightreserve.repos.PassengerRepository;
import in.pscube.flightreserve.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Flight flight = flightRepository.findById(request.getFlightId()).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());

		Passenger savedPassenger = passengerRepository.save(passenger);

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);

		Reservation savedReservation = reservationRepository.save(reservation);
		return savedReservation;
	}

}
