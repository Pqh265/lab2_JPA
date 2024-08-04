package com.t2208e.T2208E_Java_JPA.Specifications;

import org.springframework.data.jpa.domain.Specification;package org.example.lab1_t2208e.specification;
public class UserSpecifications {

    public static Specification<User> hasUsername(String username) {
        return (root, query, criteriaBuilder) -> {
            if (username == null || username.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("username"), "%" + username + "%");
        };
    }

    public static Specification<User> hasAddress(String address) {
        return (root, query, criteriaBuilder) -> {
            if (address == null || address.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.get("address"), "%" + address + "%");
        };
    }

    public static Specification<User> hasDepartmentName(String departmentName) {
        return (root, query, criteriaBuilder) -> {
            if (departmentName == null || departmentName.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.join("department").get("name"), "%" + departmentName + "%");
        };
    }

    public static Specification<User> hasCompanyName(String companyName) {
        return (root, query, criteriaBuilder) -> {
            if (companyName == null || companyName.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.join("department").join("company").get("name"), "%" + companyName + "%");
        };
    }

    public static Specification<User> hasCorporationName(String corporationName) {
        return (root, query, criteriaBuilder) -> {
            if (corporationName == null || corporationName.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.like(root.join("department").join("company").join("corporation").get
