package com.example.notable.db;

import com.example.notable.model.Doctor;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

  List<Doctor> findByLastName(String lastName);

  Doctor findById(long id);
}