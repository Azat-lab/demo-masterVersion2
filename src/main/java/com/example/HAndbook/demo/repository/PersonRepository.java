package com.example.HAndbook.demo.repository;



import com.example.HAndbook.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


}
