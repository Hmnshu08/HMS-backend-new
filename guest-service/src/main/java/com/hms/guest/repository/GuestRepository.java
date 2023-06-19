package com.hms.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.guest.entity.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
