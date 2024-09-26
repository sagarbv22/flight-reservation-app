package in.pscube.flightreserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import in.pscube.flightreserve.dto.ReservationRequest;
import in.pscube.flightreserve.entities.Flight;
import in.pscube.flightreserve.entities.Reservation;
import in.pscube.flightreserve.repos.FlightRepository;
import in.pscube.flightreserve.service.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationService reservationService;

	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}

	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg",
				"Reservation created successfully and the reservation id is " + reservation.getId());
		return "reservationConfirmation";
	}
}
