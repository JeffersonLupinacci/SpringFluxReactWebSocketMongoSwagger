package com.jeffersonlupinacci.App.service;

import com.jeffersonlupinacci.App.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Person Service
 *
 * @author jeffersonlupinacci
 */
public interface PersonService {

  /**
   * Save a Person
   *
   * @param person the Person
   * @return the Saved Person
   */
  Mono<Person> savePerson(Person person);

  /**
   * Find a Person by Id
   *
   * @param id the Id of The Person
   * @return the Saved Person
   */
  Mono<Person> findPersonById(Long id);

  /**
   * Find All Persons
   *
   * @return the Person List
   */
  Flux<Person> findAllPersons();

}
