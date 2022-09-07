package dev.ranieri.repos;

import dev.ranieri.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {

    @Query("{'username':'?0'}")
    Employee findByUsername(String username);
}
