package com.jeffersonlupinacci.App.repository;

import com.jeffersonlupinacci.App.domain.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The Person Repository
 *
 * @author jeffersonlupinacci
 */
@Repository
public interface PersonMongoRepository extends ReactiveCrudRepository<Person, Long> {

}
