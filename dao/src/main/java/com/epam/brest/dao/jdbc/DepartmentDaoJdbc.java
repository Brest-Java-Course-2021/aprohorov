package com.epam.brest.dao.jdbc;

import com.epam.brest.dao.DepartmentDao;
import com.epam.brest.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DepartmentDaoJdbc implements DepartmentDao {


    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public DepartmentDaoJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void init() {
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("DEPARTMENT")
                .usingGeneratedKeyColumns("DEPARTMENT_ID");
    }

    @Override
    public List<Department> findAll() {
        String request = "SELECT D.DEPARTMENT_ID, D.DEPARTMENT_NAME FROM DEPARTMENT AS D ORDER BY D.DEPARTMENT_NAME";
        return jdbcTemplate.query(request, new DepartmentRowMapper());
    }

    @Override
    public Department save(Department department) {
        Map<String, Object> mapDepartment = new HashMap<>();
        mapDepartment.put("DEPARTMENT_NAME", department.getDepartmentName());
        Number number = simpleJdbcInsert.executeAndReturnKey(mapDepartment);
        department.setDepartmentId(number.intValue());

        return department;
    }

    @Override
    public boolean delete(Integer id) {
        int delete = jdbcTemplate.update("DELETE FROM DEPARTMENT WHERE DEPARTMENT_ID = ?", id);
        return delete > 0;
    }

    @Override
    public Department findByTitle(String title) {
        return jdbcTemplate.queryForObject("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = ?", new DepartmentRowMapper(), title);
    }

    private static class DepartmentRowMapper implements RowMapper<Department> {

        @Override
        public Department mapRow(ResultSet resultSet, int i) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt("DEPARTMENT_ID"));
            department.setDepartmentName(resultSet.getString("DEPARTMENT_NAME"));
            return department;
        }
    }
}
