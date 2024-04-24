package com.internaldemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.internaldemo.entities.Laptop;

@Repository
public interface LaptopRepo extends CrudRepository<Laptop, Integer> {

}
