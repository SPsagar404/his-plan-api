package com.nt.planapi.repository;

import com.nt.planapi.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    Plan findByPlanId(Integer integer);

}