package com.example.notable.controller;

import com.example.notable.db.CustomerRepository;
import com.example.notable.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  @Autowired
  CustomerRepository x;
  @GetMapping("/sayhello")
  public Customer sayHelloWorld(){
    return x.findById(1L);
  }

}

