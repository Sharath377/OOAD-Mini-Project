package com.example.fitnesstracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.fitnesstracker.model.Bookings;
import com.example.fitnesstracker.repository.BookingsRepository;

@Service
public class BookingsService {
	private BookingsRepository BookingsRepository;
	public BookingsService(BookingsRepository BookingsRepository) {
		this.BookingsRepository=BookingsRepository;
	}
	
	
	public Bookings saveBooking(Bookings Bookings) {
		return BookingsRepository.save(Bookings);
	}
	public List<Bookings> getBookings(String username){
		return BookingsRepository.findByUsername(username);
	}

	public Optional<Bookings> get(Long id) {
		return BookingsRepository.findById(id);
	}
	public void delete(Long id) {
		BookingsRepository.deleteById(id);
	}
	}

