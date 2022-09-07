package dev.ranieri.employeeapp;

import dev.ranieri.entities.Employee;
import dev.ranieri.repos.EmployeeRepo;
import dev.ranieri.services.JwtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeappApplicationTests {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	JwtService jwtService;

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void create_employee(){
		Employee sam = new Employee(null, "sam54","pa$$word","librarian");
		employeeRepo.save(sam);
		System.out.println(sam);
		Assertions.assertNotNull(sam.getId());
	}

	@Test
	@Disabled
	void get_employees(){
		List<Employee> employees = employeeRepo.findAll();
		System.out.println(employees);
	}

	@Test
	@Disabled
	void find_by_username(){
		Employee employee = employeeRepo.findByUsername("adamGatorr19");
		System.out.println(employee);
		Assertions.assertEquals("admin",employee.getRole());
	}

	@Test
	void create_jwt(){

		String jwt = jwtService.createJwtWithUsernameAndRole("Terry","Wizzard");
		System.out.println(jwt);

	}

}
