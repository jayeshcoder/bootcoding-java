package com.bootcoding.java.dao;

import com.bootcoding.java.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                Order order = new Order();
                order.setTotalPrice(resultSet.getDouble("totalprice"));
                System.out.println(resultSet.getString("totalprice"));
                orders.add(order);
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        return orders;
    }
}
