package com.nt.planapi.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan_category")
@Data
public class PlanCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer categoryId;

    private String categoryName;

    private String activeSw;

    private LocalDate createDate;

    private LocalDate updatedDate;

    private String createdBy;

    private String updatedBy;


}