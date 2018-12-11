package com.jeffersonlupinacci.App.controller;


import com.jeffersonlupinacci.App.domain.Person;
import com.jeffersonlupinacci.App.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Person Rest Controller
 * @author jeffersonlupinacci
 */
@RestController()
@RequestMapping("/persons")
public class PersonRestController {

  @Autowired
  PersonService personService;

  /**
   * Save a Person
   * @param person the Person
   * @return the Saved Person
   */
  @RequestMapping(value = "/", method = RequestMethod.POST)
  private Mono<Person> savePerson(@RequestBody Person person) {
    return personService.savePerson(person);
  }

  /**
   * Find a Person by Id
   * @param id the Id of The Person
   * @return the Saved Person
   */
  @GetMapping("/{id}")
  private Mono<Person> findPersonById(@PathVariable Long id) {
    return personService.findPersonById(id);
  }

  /**
   * Find All Persons
   * @return the Person List
   */
  @GetMapping("/")
  private Flux<Person> findAllPersons() {
    return personService.findAllPersons();
  }

}
