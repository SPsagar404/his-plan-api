package com.nt.planapi.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plan")
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer planId;

    private String planName	;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

    private Integer planCategoryId;

    private String activeSw;

    @CreatedDate
    private LocalDate createDate;

    @UpdateTimestamp
    private LocalDate updateDate;

    @CreatedBy
    private String createdBy;

    private String updatedBy;



}