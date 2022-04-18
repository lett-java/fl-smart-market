package com.flettieri.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flettieri.api.model.Announcer;
import com.flettieri.api.repository.AnnouncerRepository;

@Service
public class AnnouncerService {

	@Autowired
	private AnnouncerRepository announcerRepository;
	
	public Announcer save(Announcer announcer) {
		return announcerRepository.save(announcer);
	}
	
}
