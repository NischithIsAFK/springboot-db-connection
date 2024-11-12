package com.example.springJdbcExample;

import com.example.springJdbcExample.Service.StudentService;
import com.example.springJdbcExample.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJdbcExampleApplication.class, args);
		Student st= context.getBean(Student.class);
		st.setRollno(104);
		st.setName("mario");
		st.setMarks(92);

		StudentService service=context.getBean(StudentService.class);
		service.addStudent(st);

		List<Student> students=service.getStudents();
		System.out.println(students);
	}

}
