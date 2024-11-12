package com.example.springJdbcExample.repository;

import com.example.springJdbcExample.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student s) {
        String query="insert into student (rollno, name, marks) values (?,?,?)";
       int rows=jdbcTemplate.update(query,s.getRollno(),s.getName(),s.getMarks());
        System.out.println(rows+" affected/updated");
    }

    public List<Student> findAll() {
       String query="Select * from student";
        RowMapper<Student> mapper=( rs,  rowNum) -> {
                Student s=new Student();
                s.setRollno(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
        };
       return jdbcTemplate.query(query,( rs,  rowNum) -> {
            Student s=new Student();
            s.setRollno(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
    }
}
