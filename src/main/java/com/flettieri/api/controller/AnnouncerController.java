package com.flettieri.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flettieri.api.model.Announcer;
import com.flettieri.api.service.AnnouncerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Anunciador")
@RestController
@RequestMapping("/announcer")
public class AnnouncerController {

	@Autowired
	private AnnouncerService announcerService;
	
	@PostMapping("/save")
	@ApiOperation("Salvar Anunciador")
	public ResponseEntity<Announcer> save(@RequestBody Announcer announcer) {
		return ResponseEntity.ok().body(announcerService.save(announcer));
	}
	
}
