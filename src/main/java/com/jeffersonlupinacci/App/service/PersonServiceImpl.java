package com.jeffersonlupinacci.App.service;

import com.jeffersonlupinacci.App.domain.Person;
import com.jeffersonlupinacci.App.repository.PersonMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The Person Service Implementation
 *
 * @author jeffersonlupinacci
 */
@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonMongoRepository personRepository;

  /**
   * Save a Person
   *
   * @param person the Person
   * @return the Saved Person
   */
  public Mono<Person> savePerson(Person person) {
    return personRepository.save(person).map(entity -> personTopicNotification(person));
  }

  /**
   * Find a Person by Id
   *
   * @param id the Id of The Person
   * @return the Saved Person
   */
  public Mono<Person> findPersonById(Long id) {
    return personRepository.findById(id);
  }

  /**
   * Find All Persons
   *
   * @return the Person List
   */
  public Flux<Person> findAllPersons() {
    return personRepository.findAll();
  }


  /**
   * Notify the Person
   *
   * @param person the Person to Send
   * @return the Person to Send
   */
  @SendTo("/topic/persons")
  private Person personTopicNotification(Person person) {
    return person;
  }

}
