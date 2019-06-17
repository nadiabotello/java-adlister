package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ads where username = ?");
            preparedStatement.setString(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return extractAd(rs);

        }catch(SQLException e ){
            throw new RuntimeException("Error retrieving an ad.", e);
        }

    }


    @Override
    public Long insert(User user) {
        return null;
    }
}
