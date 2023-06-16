/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import static Utils.Utils.sdf;
import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Tasks;

/**
 *
 * @author Dell
 */
public class TasksRepository {

    public List<Tasks> select() throws SQLException {
        List<Tasks> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select t.id, t.name as task_name, t.start_date, t.end_date, t.user_id, t.job_id, t.status_id, u.fullname as user_name, s.name as status_name, j.name as job_name \n"
                + "from tasks as t\n"
                + "join users as u on t.user_id = u.id\n"
                + "join status as s on t.status_id = s.id\n"
                + "join jobs as j on t.job_id = j.id");
        list = new ArrayList<>();
        while (rs.next()) {
            Tasks tasks = new Tasks();
            tasks.setId(rs.getInt("id"));
            tasks.setName(rs.getString("task_name"));
            tasks.setStart_date(rs.getDate("start_date"));
            tasks.setEnd_date(rs.getDate("end_date"));
            tasks.setUser_id(rs.getInt("user_id"));
            tasks.setJob_id(rs.getInt("job_id"));
            tasks.setStatus_id(rs.getInt("status_id"));
            tasks.setUser_name(rs.getString("user_name"));
            tasks.setStatus_name(rs.getString("status_name"));
            tasks.setJob_name(rs.getString("job_name"));
            list.add(tasks);
        }

        con.close();
        return list;
    }

    public Tasks read(int id) throws SQLException {
        Tasks tasks = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from tasks where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            tasks = new Tasks();
            tasks.setId(rs.getInt("id"));
            tasks.setName(rs.getString("name"));
            tasks.setStart_date(rs.getDate("start_date"));
            tasks.setEnd_date(rs.getDate("end_date"));
            tasks.setUser_id(rs.getInt("user_id"));
            tasks.setJob_id(rs.getInt("job_id"));
            tasks.setStatus_id(rs.getInt("status_id"));
        }
        con.close();
        return tasks;
    }

    public void create(Tasks tasks) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into tasks values(?, ?, ?, ?, ?, ?)");
        stm.setString(1, tasks.getName());
        stm.setString(2, sdf.format(tasks.getStart_date()));
        stm.setString(3, sdf.format(tasks.getEnd_date()));
        stm.setInt(4, tasks.getUser_id());
        stm.setInt(5, tasks.getJob_id());
        stm.setInt(6, tasks.getStatus_id());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Tasks tasks) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update tasks set name =?, start_date=?, end_date=?, user_id=?, job_id=?, status_id=? where id = ?");
        stm.setString(1, tasks.getName());
        stm.setString(2, sdf.format(tasks.getStart_date()));
        stm.setString(3, sdf.format(tasks.getEnd_date()));
        stm.setInt(4, tasks.getUser_id());
        stm.setInt(5, tasks.getJob_id());
        stm.setInt(6, tasks.getStatus_id());
        stm.setInt(7, tasks.getId());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from tasks where id = ?");
        stm.setInt(1, id);
        int count = stm.executeUpdate();
        con.close();
    }
}
