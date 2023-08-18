package com.joshuajacobs.sudentfoodapp.repository.impl;
import com.joshuajacobs.sudentfoodapp.repository.OrderRepository;
import com.joshuajacobs.sudentfoodapp.domain.Order;
import java.util.HashSet;
import java.util.Set;

public class OrderRepositoryImpl implements OrderRepository {
    private static OrderRepositoryImpl repository = null; //nothing in user repo yet
    private Set<Order> orderDB = null;

    private OrderRepositoryImpl() {
        orderDB = new HashSet<Order>();
    }

    public static OrderRepositoryImpl getRepository() {
        if (repository == null) { //will return null if empty
            repository = new OrderRepositoryImpl(); //will return an object if not
        }
        return repository;
    }
    @Override
    public Order create(Order order) {
        boolean success = orderDB.add(order);
        if (!success)
            return null;
        return order;
    }

    @Override
    public Order read(String orderId) {
        for (Order c : orderDB) {
            if (c.getOrderId().equals(orderId)) //getting the object from the primary key,if thr primary key doe not match the order id then it will return null
                return c;
        }
        return null;
    }
    @Override
    public Order update(Order order) {
        Order oldOrder = read(order.getOrderId());
        if (oldOrder != null) {
            orderDB.remove(oldOrder); //getting the existing order details, and comparing it , if theres changes needed then changes get added and return it to be a new one
            orderDB.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean delete(String orderId) { //read id , if theres something to delete in DB it will return true if ther is nothing to delete then it will return false
        Order orderToDelete = read(orderId);
        if (orderToDelete == null) {
            return false;
        }
       orderDB.remove(orderToDelete);
        return true;
    }

    @Override
    public Set<Order> getAll () {

        return orderDB;
    }
}




