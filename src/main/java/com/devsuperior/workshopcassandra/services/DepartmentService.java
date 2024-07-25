package com.devsuperior.workshopcassandra.services;

import com.devsuperior.workshopcassandra.model.dto.DepartmentDTO;
import com.devsuperior.workshopcassandra.model.entities.Department;
import com.devsuperior.workshopcassandra.repositories.DepartmentRepository;
import com.devsuperior.workshopcassandra.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(DepartmentDTO::new).toList();
    }

    public DepartmentDTO findById(UUID id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new DepartmentDTO(department);
    }

    public DepartmentDTO insert(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(UUID.randomUUID());
        department.setName(departmentDTO.getName());
        department = departmentRepository.save(department);
        return new DepartmentDTO(department);
    }

    public DepartmentDTO update(UUID id, DepartmentDTO departmentDTO) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        department.setName(departmentDTO.getName());
        department = departmentRepository.save(department);
        return new DepartmentDTO(department);
    }
}
