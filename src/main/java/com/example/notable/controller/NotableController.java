package com.example.notable.controller;

import com.example.notable.db.AppointmentRepository;
import com.example.notable.db.DoctorRepository;
import com.example.notable.model.Appointment;
import com.example.notable.model.Doctor;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class NotableController {
  @Autowired
  DoctorRepository doctorRepository;
  @Autowired
  AppointmentRepository appointmentRepository;

  @GetMapping("/doctors")
  public List<Doctor> getAllDoctors(){
    return (List<Doctor>) doctorRepository.findAll();
  }
  @GetMapping("/appointments")
  public List<Appointment> getAllAppointments(){
    return (List<Appointment>) appointmentRepository.findAll();
  }

  @GetMapping("/doctors/{doctorId}")
  public ResponseEntity<Object> getAppointments(@PathVariable long doctorId, @RequestBody String date){
    try{
      return new ResponseEntity<>(appointmentRepository.findByDoctorIdAndDate(doctorId,date),HttpStatus.OK);
    }catch (Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/appointments/{appointmentID}")
  public ResponseEntity<Object> deleteAppointments(@PathVariable long appointmentID){
    try{
      appointmentRepository.deleteById(appointmentID);
    }catch (Exception e){
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/appointments/create")
  public ResponseEntity<Object> addAppointment(@RequestBody Appointment appointment){
    int minutes = Integer.parseInt(appointment.getTime().split(":")[1]);
    if(minutes%15!=0 || tooManyAppointments(appointment.getDoctorId(),appointment.getDate(),appointment.getTime())){
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    appointmentRepository.save(appointment);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  private boolean tooManyAppointments(long doctorID, String date, String time){
    return appointmentRepository.findByDoctorIdAndDateAndTime(doctorID,date,time).size() >=3;
  }



}

