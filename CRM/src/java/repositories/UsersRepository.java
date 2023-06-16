/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
//import services.Utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Users;

/**
 *
 * @author Dell
 */
public class UsersRepository {

    public static List<Users> select() throws SQLException {
        List<Users> list = null;
        Connection con = DBContext.getConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("select u.id, u.email, u.password, u.fullname, u.avatar, u.status, u.role_id, r.name \n"
                + "from users as u left join roles as r on u.role_id = r.id");
        list = new ArrayList<>();
        while (rs.next()) {
            Users users = new Users();
            users.setId(rs.getInt("id"));
            users.setEmail(rs.getString("email"));
            users.setPassword(rs.getString("password"));
            users.setFullname(rs.getString("fullname"));
            users.setAvatar(rs.getString("avatar"));
            users.setStatus(rs.getInt("status"));
            users.setRole_id(rs.getInt("role_id"));
            users.setRole_name(rs.getString("name"));
            list.add(users);
        }
        con.close();
        return list;
    }

    public void create(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into users values(?, ?, ?, ?, ?, ?)");
        stm.setString(1, users.getEmail());
        stm.setString(2, users.getPassword());
        stm.setString(3, users.getFullname());
        stm.setString(4, users.getAvatar());
        stm.setInt(5, users.getStatus());
        stm.setInt(6, users.getRole_id());
        stm.executeUpdate();
        con.close();
    }

    public Users read(int id) throws SQLException {
        Users users = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from users where id = ?");
        stm.setInt(1, id);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            users = new Users();
            users.setId(rs.getInt("id"));
            users.setEmail(rs.getString("email"));
            users.setPassword(rs.getString("password"));
            users.setFullname(rs.getString("fullname"));
            users.setAvatar(rs.getString("avatar"));
            users.setStatus(rs.getInt("status"));
            users.setRole_id(rs.getInt("role_id"));
        }
        con.close();
        return users;
    }

    public void update(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update users set email= ?, password= ?, fullname= ?, avatar= ?, status= ?, role_id= ? where id = ?");
        stm.setString(1, users.getEmail());
        stm.setString(2, users.getPassword());
        stm.setString(3, users.getFullname());
        stm.setString(4, users.getAvatar());
        stm.setInt(5, users.getStatus());
        stm.setInt(6, users.getRole_id());
        stm.setInt(7, users.getId());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int id) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from users where id = ?");
        stm.setInt(1, id);
        int count = stm.executeUpdate();
        con.close();
    }
//    public List<Object> myProfile(int userId) throws SQLException {
//        List list = null;
//        Connection con = DBContext.getConnection();
//        String sql = "select Users.userID, Users.userName, Users.password, Users.fullName, Users.avatar, Users.address, Users.phone, Users.email, Roles.roleName\n"
//                + "from Users \n"
//                + "left join Roles on Users.roleID= Roles.roleID \n"
//                + "where userID = ?";
//        PreparedStatement stm = con.prepareStatement(sql);
//        stm.setInt(1, userId);
//        ResultSet rs = stm.executeQuery();
//        while (rs.next()) {
//            Users users = new Users();
//            int userID = rs.getInt("userID");
//            list.add(userID);
//            String userName = rs.getString("userName");
//            list.add(userName);
//            String password = rs.getString("password");
//            list.add(password);
//            String fullName = rs.getString("fullName");
//            list.add(fullName);
//            String avatar = rs.getString("avatar");
//            list.add(avatar);
//            String address = rs.getString("address");
//            list.add(address);
//            String phone = rs.getString("phone");
//            list.add(phone);
//            String email = rs.getString("email");
//            list.add(email);
//            String roleName = rs.getString("roleName");
//            list.add(roleName);
//
////            users.setUserID(rs.getInt("userID"));
////            users.setUsername(rs.getString("username"));
////            users.setPassword(rs.getString("password"));
////            users.setFullName(rs.getString("fullName"));
////            users.setAvatar(rs.getString("avatar"));
////            users.setAddress(rs.getString("address"));
////            users.setPhone(rs.getString("phone"));
////            users.setEmail(rs.getString("email"));
////            users.setRoleName(rs.getString("roleName"));
//        }
//        con.close();
//        return list;
//    }
}
