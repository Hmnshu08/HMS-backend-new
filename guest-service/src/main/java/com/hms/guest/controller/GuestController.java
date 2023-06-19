package com.hms.guest.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
public class GuestController {
	@Autowired
	private GuestRepository repo;
	
	@GetMapping("/guest")
	public List<Guest> getAllGuest() {
		return repo.findAll();
		
	}

	@GetMapping("/guest/{id}")
	public Optional<Guest> getGuestById(@PathVariable Long id) {
		Optional<Guest> guest = repo.findById(id);
		if(guest.isEmpty())
		{
			throw new GuestNotFoundException("Guest Not Present :" +id);
		}
		return guest;
	}
	
	@PostMapping("/guest")
	public Guest createGuest(@RequestBody Guest guest) {
		return repo.save(guest);
	}
	
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
}
