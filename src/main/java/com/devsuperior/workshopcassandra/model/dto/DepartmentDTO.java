package com.devsuperior.workshopcassandra.model.dto;

import com.devsuperior.workshopcassandra.model.entities.Department;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.UUID;

public class DepartmentDTO {

    private UUID id;
    private String name;

    public DepartmentDTO() {}

    public DepartmentDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Department department) {
        id = department.getId();
        name = department.getName();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
