/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import static Utils.Utils.sdf;
import config.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Jobs;

/**
 *
 * @author Dell
 */
public class JobsRepository {
     public List<Jobs> select() throws SQLException {
        List<Jobs> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select * from jobs");
        list = new ArrayList<>();
        while (rs.next()) {
            Jobs j = new Jobs();
            j.setId(rs.getInt("id"));
            j.setName(rs.getString("name"));
            j.setStart_date(rs.getDate("start_date"));
            j.setEnd_date(rs.getDate("end_date"));
            list.add(j);
        }

        con.close();
        return list;
    }

    public Jobs read(int id) throws SQLException {
        Jobs j = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from jobs where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            j = new Jobs();
            j.setId(rs.getInt("id"));
            j.setName(rs.getString("name"));
            j.setStart_date(rs.getDate("start_date"));
            j.setEnd_date(rs.getDate("end_date"));
        }
        con.close();
        return j;
    }

    public void create(Jobs jobs) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into jobs values(?, ?, ?)");
        stm.setString(1, jobs.getName());
        stm.setString(2, sdf.format(jobs.getStart_date()));
        stm.setString(3, sdf.format(jobs.getEnd_date()));

        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Jobs jobs) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update jobs set name =?, start_date= ?, end_date=? where id = ?");
        stm.setString(1, jobs.getName());
        stm.setString(2, sdf.format(jobs.getStart_date()));
        stm.setString(3, sdf.format(jobs.getEnd_date()));
        stm.setInt(4, jobs.getId());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from jobs where id = ?");
        stm.setInt(1, id);
        int count = stm.executeUpdate();
        con.close();
    }
}
