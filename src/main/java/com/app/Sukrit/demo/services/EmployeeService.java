package com.app.Sukrit.demo.services;

import com.app.Sukrit.demo.dto.EmployeeDTO;
import com.app.Sukrit.demo.entities.EmployeeEntity;
import com.app.Sukrit.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//This is our service layer of API

@Service
public class EmployeeService {

    @Autowired
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDTO getEmployeeById(Long id)
    {
      EmployeeEntity employeeEntity = employeeRepository.getById(id);
      return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO)
    {
      EmployeeEntity employeeEntity = modelMapper.map(employeeDTO,EmployeeEntity.class);
      return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }

}
