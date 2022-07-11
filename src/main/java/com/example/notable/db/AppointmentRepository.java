package com.example.notable.db;

import com.example.notable.model.Appointment;
import com.example.notable.model.Doctor;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

  List<Doctor> findByLastName(String lastName);

  Doctor findById(long id);

  List<Appointment> findByDoctorIdAndDate(long doctorId, String date);

  List<Appointment> findByDoctorIdAndDateAndTime(long doctorId, String date, String time);
}