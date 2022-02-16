package com.example.HAndbook.demo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "person_name")
    private String name;

    @Column(name = "person_surname")
    private String lastname;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    public Person(String name, String lastname) {
    }


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    public Person(Long personId, Integer phoneNumber) {
        this.personId = personId;
        this.phoneNumber = phoneNumber;
    }

    public Person(Long personId, String name, String lastname,
                  Integer phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(personId, person.personId)) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(lastname, person.lastname))
            return false;
        if (!Objects.equals(phoneNumber, person.phoneNumber))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "PersonId=" + personId +
                ", PersonName='" + name + '\'' +
                ", PersonLastname='" + lastname + '\'' +
                ", PhoneNumber=" + phoneNumber +
                '}';
    }
}
