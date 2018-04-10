package org.shane.service;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.shane.domain.Paramotor;
import org.shane.domain.ParamotorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ParamotorRestController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/paramotor")
	public Collection<Paramotor> paramotors() {
		return paramotorRepo.findAll();
	}
	
	@GetMapping("/paramotor/{id}")
	public ResponseEntity<Paramotor> getById(@PathVariable Long id) {
		Optional<Paramotor> para = paramotorRepo.findById(id);
		
		if (para.isPresent())
			return new ResponseEntity<Paramotor>(para.get(), HttpStatus.OK);
		else
			return new ResponseEntity<Paramotor>(HttpStatus.NOT_FOUND);
	
	}
	
	@PostMapping("/paramotor")
	public ResponseEntity<Object> createStudent(@RequestBody Paramotor paramotor) {
		

		Paramotor newParamotor = new Paramotor();
		newParamotor.copyDetailsFrom(paramotor);
		newParamotor = paramotorRepo.save(newParamotor);

		log.debug("Created new paramotor: {}", newParamotor);		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newParamotor.getId()).toUri();

		return ResponseEntity.created(location).build();

	}	
	
	@DeleteMapping("/paramotor/{id}")
	public void deleteStudent(@PathVariable long id) {		
		log.info("Deleting paramotor with id = [{}] ", id);
		paramotorRepo.deleteById(id);
	}	
	
	@PutMapping("/paramotor/{id}")
	public ResponseEntity<Paramotor> updateParamotor(@RequestBody Paramotor paramotor, @PathVariable Long id) {	
		
		Optional<Paramotor> paramotorOptional = paramotorRepo.findById(id);
		
		Paramotor repoParamotor;
		if (!paramotorOptional.isPresent())
			return ResponseEntity.notFound().build();
		else {
			repoParamotor = paramotorOptional.get();
			log.debug("Updating paramotor with id = [{}] from [{}] to [{}]", id, repoParamotor, paramotor);
			repoParamotor.copyDetailsFrom(paramotor);
		}
		
		paramotorRepo.save(repoParamotor);

		return ResponseEntity.noContent().build();
		
	}
	
	@Autowired
	ParamotorRepository paramotorRepo;
}
