package com.nt.planapi.service;

import com.nt.planapi.entity.Plan;
import com.nt.planapi.entity.PlanCategory;

import java.util.List;
import java.util.Map;

public interface IPlanService {

    public Map<Integer,String> getPlanCategories();

    public boolean savePlan(Plan plan);

    public List<Plan> getAllPlans();

    public Plan getPlanById(Integer planId);

    public boolean updatePlan(Plan plan);

    public boolean deleteByPlanId(Integer planId);

    public boolean planStatusChange(Integer planId,String status);


    public boolean saveCategory(PlanCategory planCategory);
}
