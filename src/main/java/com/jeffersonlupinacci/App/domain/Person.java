package com.jeffersonlupinacci.App.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * The Person Class
 * @author jeffersonlupinacci
 */
@Document(value = "PERSON_COLLECTION")
public class Person {

  @Id
  private Long id;

  @Field
  private String name;

  @Field
  private String email;

  /**
   * @return The Id to Get
   */
  public Long getId() {
    return id;
  }

  /**
   * @return the Name to Get
   */
  public String getName() {
    return name;
  }

  /**
   * @return The Email to Get
   */
  public String getEmail() {
    return email;
  }

  /**
   * Default Constructor
   */
  public Person() {
  }

  /**
   * Builder Constructor
   *
   * @param builder the builder to Construct
   */
  private Person(Builder builder) {
    id = builder.id;
    name = builder.name;
    email = builder.email;
  }

  /**
   * The Builder
   *
   * @return the Builder Instance
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * The Builder Inner Class
   */
  public static final class Builder {

    private Long id;
    private String name;
    private String email;

    /**
     * Default Constructor
     */
    private Builder() {
    }

    /**
     * @param val the Id
     * @return this
     */
    public Builder withId(Long val) {
      id = val;
      return this;
    }

    /**
     * @param val the Name
     * @return this
     */
    public Builder withName(String val) {
      name = val;
      return this;
    }

    /**
     * @param val the Email
     * @return this
     */
    public Builder withEmail(String val) {
      email = val;
      return this;
    }

    /**
     * Create a new Person
     *
     * @return the Person Instance
     */
    public Person build() {
      return new Person(this);
    }
  }

}
