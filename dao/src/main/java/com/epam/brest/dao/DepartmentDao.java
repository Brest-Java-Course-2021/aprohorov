package com.epam.brest.dao;

import com.epam.brest.model.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> findAll();

    Department save(Department department);

    boolean delete(Integer id);

    Department findByTitle(String title);
}
