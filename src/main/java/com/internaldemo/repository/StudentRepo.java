package com.internaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.internaldemo.entities.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

}
