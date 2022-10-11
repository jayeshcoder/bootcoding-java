package com.bootcoding.java.dao;

import com.bootcoding.java.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO
{
    private Connection con;
    public  OrderDAO()
    {
        DAOService daoService = new DAOService();
        con = daoService.getDataConnection();
    }
    public List<Order> getAllOrders()
    {
        ArrayList<Order> orders = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = con.prepareStatement("select * from bootcoding.order ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                long customerid = resultSet.getLong("customerid");
                long vendorid = resultSet.getLong("vendorid");
                double totalprice = resultSet.getDouble("totalprice");
                String deliveryaddress = resultSet.getString("deliveryaddress");
                String status = resultSet.getString("status");
                Date order_date = new Date(resultSet.getLong("order_date"))
                Order order = new Order();
                order.setTotalPrice(resultSet.getDouble("totalprice"));
                System.out.println(resultSet.getString("deliveryaddress"));
                orders.add(order);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
