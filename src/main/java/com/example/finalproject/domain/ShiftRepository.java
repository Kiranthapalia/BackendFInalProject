package com.example.finalproject.domain;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ShiftRepository extends CrudRepository<Shift, Long> {

	List<Shift> findByStatus(@Param("status") String status);
	List<Shift> findByAssigned(String assigned);
}
