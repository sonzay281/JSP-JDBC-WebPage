/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.contactmanager.dao;

import com.leapfrog.contactmanager.entity.Manager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anonymous
 */
public interface ManagerDAO {

    int insert(Manager m) throws ClassNotFoundException, SQLException;

    int update(Manager m) throws ClassNotFoundException, SQLException;

    Manager getByID(int id) throws ClassNotFoundException, SQLException;

    List<Manager> getAll() throws ClassNotFoundException, SQLException;
}
