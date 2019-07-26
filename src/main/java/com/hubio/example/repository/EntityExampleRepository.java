package com.hubio.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hubio.example.entity.EntityExample;

@Repository
@Transactional
public interface EntityExampleRepository extends JpaRepository<EntityExample, Long> {
	
	@Query("SELECT ee FROM EntityExample ee  WHERE ee.id = (:id) AND ee.name = (:name)")
    List<EntityExample> findByIdAndName(@Param("id") Long id, @Param("name") String name);

}
