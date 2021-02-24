package com.epam.brest.dao.jdbc;

import com.epam.brest.dao.DepartmentDao;
import com.epam.brest.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:test-db.xml", "classpath*:test-dao.xml"})
public class DepartmentDaoJdbcTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void findAllTest() {
        List<Department> departments = departmentDao.findAll();
        assertNotNull(departments);
        assertTrue(departments.size() > 0);
    }

    @Test
    public void save() {
        Department department = departmentDao.save(new Department("Test"));

        assertNotNull(department);
        assertEquals(departmentDao.findByTitle("Test").getDepartmentName(),department.getDepartmentName());
    }

    @Test
    public void delete() {
        Department department = departmentDao.save(new Department("Test Delete"));
        assertNotNull(department);
        assertTrue(departmentDao.delete(department.getDepartmentId()));
    }

    @Test
    public void findByTitle() {
        assertNotNull(departmentDao.findByTitle("IT"));
    }
}
