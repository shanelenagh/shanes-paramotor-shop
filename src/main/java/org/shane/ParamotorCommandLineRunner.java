package org.shane;

import org.shane.domain.Paramotor;
import org.shane.domain.ParamotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@Component
public class ParamotorCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		//for (Paramotor p : paramotorRep)
	}
	
	//@Autowired 
	//private ParamotorRepository paramotorRepo;
	
}
