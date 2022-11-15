package com.nt.planapi.repository;

import com.nt.planapi.entity.PlanCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
