package com.qa.springvegetables.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.springvegetables.domain.Vegetables;

@Repository
public interface VegetablesRepo extends JpaRepository<Vegetables, Long> { // Vegetables is the domain and the data type
																			// id is Long

}
