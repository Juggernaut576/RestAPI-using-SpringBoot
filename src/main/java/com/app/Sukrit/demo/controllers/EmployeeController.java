package com.app.Sukrit.demo.controllers;

//Operations
//GET /employees
//POST /employees
//DELETE /employees/{id}

import com.app.Sukrit.demo.dto.EmployeeDTO;
import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees/{id}")
    public EmployeeDTO getEmployees(@PathVariable("id") Long employeeId)
    {
        return new EmployeeDTO(employeeId,"Anuj",LocalDate.of(2024,1,2),true);
    }

    @GetMapping(path ="/employees")
    public String getData(@PathParam("sortBy") String sortBy)
    {
      return "Hello" + sortBy;
    }
}
