package com.hms.guest.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hms.guest.entity.Guest;
import com.hms.guest.exception.GuestNotFoundException;
import com.hms.guest.repository.GuestRepository;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class GuestController {
	
	private Logger logger = 
			LoggerFactory.getLogger(GuestController.class);
	
	@Autowired
	private GuestRepository repo;
	
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@Retry(name = "guest", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="guest")
	@GetMapping("/guest")
	public List<Guest> getAllGuest() {
		logger.info("Api call received");
		return repo.findAll();
		
		
	}

//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
//	@Retry(name = "guest", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name="default")
	@Bulkhead(name="guest")
	@GetMapping("/guest/{id}")
	public Optional<Guest> getGuestById(@PathVariable Long id) {
		Optional<Guest> guest = repo.findById(id);
		if(guest.isEmpty())
		{
			throw new GuestNotFoundException("Guest Not Present :" +id);
		}
		return guest;
	}
	
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@PostMapping("/guest")
	public Guest createGuest(@RequestBody Guest guest) {
		return repo.save(guest);
	}
	
//	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@DeleteMapping("/guest/{id}")
	public void deleteGuestById(@PathVariable Long id) 
	{
		Optional<Guest> guest = repo.findById(id);
		if(guest.isEmpty())
		{
			throw new GuestNotFoundException("Guest Not Present :" +id);
		}
		repo.deleteById(id);
	}
	
	//if service doesn't responds then this will get called
//	public String hardcodedResponse(Exception ex) {
//		return "fallback-response";
//	}
}
