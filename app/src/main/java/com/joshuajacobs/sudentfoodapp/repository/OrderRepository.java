package com.joshuajacobs.sudentfoodapp.repository;
import com.joshuajacobs.sudentfoodapp.domain.Order;

import java.util.Set;

    public interface OrderRepository extends IRepository <Order,String>{
        public Set<Order> getAll();
}
