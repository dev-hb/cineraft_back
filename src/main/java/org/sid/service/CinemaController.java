package org.sid.service;

import java.util.List;

import javax.websocket.server.PathParam;

import org.sid.dao.CinemaRepository;
import org.sid.entities.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
	
	@Autowired
	private CinemaRepository cinemaRepository;
	@GetMapping("/cines")
	
	public List<Cinema> cinemas(){
		return cinemaRepository.findAll();
	}
	
	@GetMapping("/cinemas/{id}")
	public Cinema cinema(@PathVariable Long id) {
		return cinemaRepository.findById(id).get();
	}
	
	@PostMapping("/cines")
	public void save(@RequestBody Cinema cinema) {
		cinemaRepository.save(cinema);
		
	}
	
	@DeleteMapping("/cines/{id}")
	public void delete(@PathVariable Long id) {
		cinemaRepository.deleteById(id);
	}
	
	@PutMapping("/cines/{id}")
	public void update(@RequestBody Cinema cinema, @PathVariable Long id) {
		cinema.setId(id);
		cinemaRepository.save(cinema);
		
	}
	

}
