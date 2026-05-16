package com.example.myportfolio.entity;

import com.example.myportfolio.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill extends BaseEntity {

    private String name;

    private Integer percentage;

    private String icon;

    private String category;
}