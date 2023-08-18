package com.joshuajacobs.sudentfoodapp.repository;

import com.joshuajacobs.sudentfoodapp.domain.Reward;

import java.util.Set;
/*
RewardRepository.java
Author: Joshua Jacobs 221144862
Date : 09 May 2023
*/

public interface RewardRepository extends IRepository <Reward,String>{
    public Set<Reward> getAll();
}