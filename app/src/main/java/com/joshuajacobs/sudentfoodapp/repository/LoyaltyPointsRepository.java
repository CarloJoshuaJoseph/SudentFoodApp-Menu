package com.joshuajacobs.sudentfoodapp.repository;

import com.joshuajacobs.sudentfoodapp.domain.LoyaltyPoints;

import java.util.Set;
/*
LoyaltyPointsRepository.java
Author: Joshua Jacobs 221144862
Date : 09 May 2023
*/

public interface LoyaltyPointsRepository extends IRepository <LoyaltyPoints,String>{
    public Set<LoyaltyPoints> getAll();
}