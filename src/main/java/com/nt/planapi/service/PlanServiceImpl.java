package com.nt.planapi.service;

import com.nt.planapi.entity.Plan;
import com.nt.planapi.entity.PlanCategory;
import com.nt.planapi.repository.PlanCategoryRepository;
import com.nt.planapi.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanServiceImpl implements IPlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private PlanCategoryRepository planCategoryRepository;

    @Override
    public Map<Integer, String> getPlanCategories() {
        List<PlanCategory> categories = planCategoryRepository.findAll();

        Map<Integer,String> categoryMap =new HashMap<>();
        categories.forEach(category->{
            categoryMap.put(category.getCategoryId(),category.getCategoryName());
        });
        return categoryMap;
    }

    @Override
    public boolean savePlan(Plan plan) {
        Plan saved = planRepository.save(plan);
        /*if(saved.getPlanId()!=null)
            return true;
        else
            return false;*/

        return saved.getPlanId() != null;
    }

    @Override
    public List<Plan> getAllPlans() {
        List<Plan> all = planRepository.findAll();
        return all;
    }

    @Override
    public Plan getPlanById(Integer planId) {
        Optional<Plan> byId = planRepository.findById(planId);
        if(byId.isPresent())
            return byId.get();
        return null;
    }

    @Override
    public boolean updatePlan(Plan plan) {
        planRepository.save(plan);
        return plan.getPlanId()!=null;
    }

    @Override
    public boolean deleteByPlanId(Integer planId) {

        boolean status =false;
        try {
            planRepository.deleteById(planId);
            status=true;
        }
        catch (Exception e){
         e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean planStatusChange(Integer planId, String status) {
        Optional<Plan> byId = planRepository.findById(planId);
        if (byId.isPresent()){
            Plan plan = byId.get();
            plan.setActiveSw(status);
            planRepository.save(plan);
            return true;
        }
        return false;
    }

    @Override
    public boolean saveCategory(PlanCategory planCategory) {
        PlanCategory save = planCategoryRepository.save(planCategory);
        return save.getCategoryId() != null;
    }
}
