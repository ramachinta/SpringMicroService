package com.springdata.demo.data;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="springDataSample")
public class DataController {
	
	  private static final Logger log = LoggerFactory.getLogger(DataController.class);
	
	public final PersonRepository personRepo;
	
	public DataController(PersonRepository personRepo) {
		this.personRepo=personRepo;
	}
	
	
	@RequestMapping(path="findAll")
	public List<PersonModel> findAllPersonDetails(){
		 personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));personRepo.save(new PersonModel("Jack", "Bauer","lastname"));
	      personRepo.save(new PersonModel("Chloe", "OBrain","lastname"));
	      personRepo.save(new PersonModel("Kim", "Bauer","lastname"));
	      personRepo.save(new PersonModel("David", "Palmer","lastname"));
	      personRepo.save(new PersonModel("Michelle", "Dessler","lastname"));

	      // fetch all PersonModels
	      log.info("PersonModels found with findAll():");
	      log.info("-------------------------------");
	      /*for (PersonModel PersonModel : personRepo.findAll()) {
	        log.info(PersonModel.toString());
	      }*/
	      log.info("");

	      // fetch an individual PersonModel by ID
	      //Optional<PersonModel> PersonModel = personRepo.findById(1L);
	      log.info("PersonModel found with findById(1L):");
	      log.info("--------------------------------");
	      //log.info(PersonModel.toString());
	      log.info("");

	      // fetch PersonModels by last name
	      log.info("PersonModel found with findByLastName('Bauer'):");
	      log.info("--------------------------------------------");
	      personRepo.findBylastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	      // for (PersonModel bauer : personRepo.findByLastName("Bauer")) {
	      //  log.info(bauer.toString());
	      // }
	      log.info("");
		return (personRepo.findAll());
	}

}
