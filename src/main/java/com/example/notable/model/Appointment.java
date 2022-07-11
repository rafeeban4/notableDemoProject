package com.example.notable.model;

import java.security.PrivateKey;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Appointment {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String date;
  private String time;
  private Long doctorId;
  private boolean newPatient;

  protected Appointment(){}

  public Appointment(String firstName, String lastName, String date, String time, long doctorId, boolean newPatient) {
    this.firstName=firstName;
    this.lastName=lastName;
    this.date = date;
    this.time=time;
    this.doctorId = doctorId;
    this.newPatient =newPatient;
  }
}
