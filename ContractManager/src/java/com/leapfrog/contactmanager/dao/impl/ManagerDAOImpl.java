/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.contactmanager.dao.impl;

import com.leapfrog.contactmanager.constant.SQLConstant;
import com.leapfrog.contactmanager.dao.ManagerDAO;
import com.leapfrog.contactmanager.dbconnection.DBConnection;
import com.leapfrog.contactmanager.entity.Manager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anonymous
 */
public class ManagerDAOImpl implements ManagerDAO {

    private DBConnection db = new DBConnection();

    @Override
    public int insert(Manager m) throws ClassNotFoundException, SQLException {
        db.open();
        PreparedStatement stmt = db.initStatement(SQLConstant.INSERT_COURSE);
        stmt.setString(1, m.getName());
        stmt.setString(2, m.getEmail());
        stmt.setString(3, m.getPhone());
        stmt.setString(4, m.getAddress());
        int result = db.executeUpdate();
        db.close();
        return result;

    }

    @Override
    public Manager getByID(int id) throws ClassNotFoundException, SQLException {
        Manager manager = null;
        String sql = "SELECT * FROM tbl_contactmanager WHERE id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            manager = new Manager();
            manager.setId(rs.getInt("id"));
            manager.setName(rs.getString("name"));
            manager.setEmail(rs.getString("email"));
            manager.setPhone(rs.getString("phone"));
            manager.setAddress(rs.getString("address"));
            manager.setDOB(rs.getDate("dob"));

        }
        db.close();
        return manager;
    }

    @Override
    public List<Manager> getAll() throws ClassNotFoundException, SQLException {
        List<Manager> managerList = new ArrayList<>();
        String sql = "SELECT * FROM tbl_contactmanager";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Manager manager = new Manager();
            manager.setId(rs.getInt("id"));
            manager.setName(rs.getString("name"));
            manager.setEmail(rs.getString("email"));
            manager.setPhone(rs.getString("phone"));
            manager.setAddress(rs.getString("address"));
            manager.setDOB(rs.getDate("dob"));
            managerList.add(manager);
        }
        db.close();
        return managerList;

    }

    public int update(Manager m) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE  tbl_contactmanager SET name=?,email=?,phone=?,address=?,dob=? WHERE id=?";
        db.open();
        PreparedStatement stmt = db.initStatement(sql);
        stmt.setInt(1, m.getId());
        stmt.setString(2, m.getName());
        stmt.setString(3, m.getEmail());
        stmt.setString(4,m.getPhone());
        stmt.setString(5, m.getName());
        int result = db.executeUpdate();
        db.close();
        return result;

    }

}
