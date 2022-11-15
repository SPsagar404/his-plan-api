package com.nt.planapi.restcontroller;

import com.nt.planapi.entity.Plan;
import com.nt.planapi.entity.PlanCategory;
import com.nt.planapi.service.IPlanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlanRestController {

    @Autowired
    private IPlanService planService;

    Logger logger= LoggerFactory.getLogger(PlanRestController.class);

    @GetMapping("/categories")
    public ResponseEntity<Map<Integer,String>> planCategories(){
        logger.info("PlanRestController.planCategory() method execution started ");
        Map<Integer,String> catgories =planService.getPlanCategories();
        logger.info("PlanRestController.planCategory() method execution ended ");
        return new ResponseEntity<>(catgories, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<String> saveCategory(@RequestBody PlanCategory category){
        logger.info("SaveCategory() method execution started");
        String saveCategoryMsg = "";

        boolean isSaved = planService.saveCategory(category);

        if (isSaved)
            saveCategoryMsg="Category saved successfully";
        else
            saveCategoryMsg="Category not saved";
        logger.info("SaveCategory() method execution ended");
        return new ResponseEntity<>(saveCategoryMsg,HttpStatus.CREATED);
    }

    @PostMapping("/plan")
    public ResponseEntity<String> savePlan(@RequestBody Plan plan){
        logger.info("savePlan() method execution started");
        String responseMsg ="";
        boolean isSaved = planService.savePlan(plan);
        if(isSaved)
            responseMsg="Plan Saved Successfully";
        else
            responseMsg="Plan not saved";
        logger.info("savePlan() method execution ended");
        return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
    }

    @GetMapping("/plans")
    public ResponseEntity<List<Plan>> plans(){
        logger.info("plans() method execution started");
        List<Plan> allPlans = planService.getAllPlans();
        logger.info("plans() method execution ended");
        return new ResponseEntity<>(allPlans,HttpStatus.OK);
    }

    @GetMapping("/plan/{planId}")
    public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
        logger.info("editPlan() method execution started");
        Plan planById = planService.getPlanById(planId);
        logger.info("editPlan() method execution ended");
        return  new ResponseEntity<>(planById,HttpStatus.OK);
    }

    @DeleteMapping("/plan/{planId}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
        logger.info("deletePlan() method execution started");
        String deleteStatus ="";
        boolean isDeleted = planService.deleteByPlanId(planId);
        if(isDeleted)
            deleteStatus="Plan deleted successfully";
        else
            deleteStatus="Plan not deleted";
        logger.info("deletePlan() method execution ended");
        return  new ResponseEntity<>(deleteStatus,HttpStatus.OK);
    }

    @PutMapping("/plan")
    public ResponseEntity<String> updatePlan(@RequestBody Plan plan){
        logger.info("updatePlan() method execution started");
        String updateMsg="";
        boolean isUpdated = planService.updatePlan(plan);
        if(isUpdated)
            updateMsg="Plan updated successfully";
        else
            updateMsg="Plan not updated";
        logger.info("updatePlan() method execution ended");
        return  new ResponseEntity<>(updateMsg,HttpStatus.OK);
    }

    @PutMapping("/status-change/{planId}/{status}")
    public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
        logger.info("statusChange() method execution started");
        String statusChangeMsg="";
        boolean isStatusChange = planService.planStatusChange(planId, status);
        if(isStatusChange)
            statusChangeMsg="Status changed";
        else
            statusChangeMsg="Status not changed";
        logger.info("statusChange() method execution ended");
        return new ResponseEntity<>(statusChangeMsg,HttpStatus.OK);
    }
}
