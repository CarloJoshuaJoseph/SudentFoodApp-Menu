package com.joshuajacobs.sudentfoodapp.domain;

import java.util.ArrayList;

public class Order {
    private String orderId;
    private String customerId;
    private String orderDate;
    private double totalAmount;
    private String vendorName;
    private ArrayList<String> items;
    // check this ArrayList for correctness

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customerId = builder.customerId;
        this.orderDate = builder.orderDate;
        this.totalAmount = builder.totalAmount;
        this.vendorName = builder.vendorName;
        this.items = builder.items;

    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getVendorName() {
        return vendorName;
    }

    public ArrayList<String> getItems() {
        return items;
        //check this for correctness
    }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId='" + orderId + '\'' +
                    ", customerId='" + customerId + '\'' +
                    ", orderDate='" + orderDate + '\'' +
                    ", totalAmount=" + totalAmount +
                    ", vendorName='" + vendorName + '\'' +
                    ", items=" + (items) +
                    '}';
        }
        public static class Builder {
            private String orderId;
            private String customerId;
            private String orderDate;
            private double totalAmount;
            private String vendorName;
            private ArrayList<String> items;
            //check this for correctness


            public Builder setOrderId(String orderId) {
                this.orderId = orderId;
                return this;

            }
            public Builder setCustomerId(String customerId) {
                this.customerId = customerId;
                return this;
            }
            public Builder setOrderDate(String orderDate) {
                this.orderDate = orderDate;
                return this;
            }
            public Builder setTotalAmount(double totalAmount) {
                this.totalAmount = totalAmount;
                return this;
            }
            public Builder setVendorName(String vendorName) {
                this.vendorName = vendorName;
                return this;
            }
            public Builder setItems(ArrayList<String> items) {
                this.items = items;
                return this;
                //check this for correctness
            }

            public Builder copy(Order order) {
                this.orderId = order.orderId;
                this.customerId = order.customerId;
                this.orderDate = order.orderDate;
                this.totalAmount = order.totalAmount;
                this.vendorName = order.vendorName;
                this.items = order.items;
                return this;
            }
            public Order build() {
                return new Order(this); //"this" calls the constructor
                //this is a builder object and it is going to return a order object
            }
        }
    }

