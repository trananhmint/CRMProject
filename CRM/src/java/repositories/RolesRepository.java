/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Roles;

/**
 *
 * @author Pc
 */
public class RolesRepository {

    public List<Roles> select() throws SQLException {
        List<Roles> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from roles");
        list = new ArrayList<>();
        while (rs.next()) {
            Roles roles = new Roles();
            roles.setId(rs.getInt("id"));
            roles.setName(rs.getString("name"));
            roles.setDescription(rs.getString("description"));
            list.add(roles);
        }

        con.close();
        return list;
    }

      public Roles read(int id) throws SQLException {
        Roles roles = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from roles where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            roles = new Roles();
            roles.setId(rs.getInt("id"));
            roles.setName(rs.getString("name"));
            roles.setDescription(rs.getString("description"));
        }
        con.close();
        return roles;
    }

    public void create(Roles roles) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into roles values(?, ?)");
        stm.setString(1, roles.getName());
        stm.setString(2, roles.getDescription());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Roles roles) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update roles set name =?, description= ? where id = ?");
        stm.setString(1, roles.getName());
        stm.setString(2, roles.getDescription());
        stm.setInt(3, roles.getId());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from roles where id = ?");
        stm.setInt(1, id);
        int count = stm.executeUpdate();
        con.close();
    }
}
