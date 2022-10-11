package com.bootcoding.java.dao;

import com.bootcoding.java.model.Customer;
import com.bootcoding.java.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO
{
    private Connection conn;
    public CustomerDAO()
    {
        DAOService daoService = new DAOService();
        conn = daoService.getDataConnection();
    }
    public List<Customer> getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from bootcoding.customer ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long
            }
        }catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}
