/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.security.NoSuchAlgorithmException;
import models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Pass=role
 *
 * @author PHT
 */
public class AccountRepository {

    public Account login(String email, String password) throws SQLException {
        Account Account = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select u.id, u.email, u.password, u.fullname, u.avatar, u.status, u.role_id, r.name \n"
                + "from users as u left join roles as r on u.role_id = r.id\n"
                + "where u.email= ? and u.password = ?");
        //Compare Strings with CASE SENSITIVE
        stm.setString(1, email);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            Account = new Account();
            Account.setId(rs.getInt("id"));
            Account.setEmail(rs.getString("email"));
            Account.setPassword(rs.getString("password"));
            Account.setFullname(rs.getString("fullname"));
            Account.setAvatar(rs.getString("avatar"));
            Account.setStatus(rs.getInt("status"));
            Account.setRole_id(rs.getInt("role_id"));
            Account.setRole_name(rs.getString("name"));
        }
        con.close();
        return Account;
    }

//    public Account read(int userID) throws SQLException {
//        Account Account = null;
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("select * from Users u join Roles r on (u.roleID = r. roleID) where userID= ?");
//        stm.setInt(1, userID);
//        ResultSet rs = stm.executeQuery();
//        if (rs.next()) {
//            Account = new Account();
//            Account.setUserID(rs.getInt("userID"));
//            Account.setUserName(rs.getString("userName"));
//            Account.setFullName(rs.getString("fullName"));
//            Account.setPassword(rs.getString("password"));
//            Account.setAvatar(rs.getString("avatar"));
//            Account.setAddress(rs.getString("address"));
//            Account.setPhone(rs.getString("phone"));
//            Account.setEmail(rs.getString("email"));
//            Account.setRoleName(rs.getString("roleName"));
//        }
//        con.close();
//        return Account;
//    }
//
//    public boolean comparePass(int userID, String oldPass) throws SQLException, NoSuchAlgorithmException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("select * from Users where userID = ? and password = ? COLLATE Latin1_General_CS_AS");
//        stm.setInt(1, userID);
//        stm.setString(2, Utilities.hash(oldPass));
//        ResultSet rs = stm.executeQuery();
//        if (rs.next()) {
//            return true;
//        }
//        con.close();
//        return false;
//    }
//
//    public void updatePass(int userID, String NewPass2) throws SQLException, NoSuchAlgorithmException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("update Users set password= ? where userID = ?");
//        stm.setString(1, Utilities.hash(NewPass2));
//        stm.setInt(2, userID);
//        int count = stm.executeUpdate();
//        con.close();
//    }
//
//    public void update(Account Account) throws SQLException {
//        Connection con = DBContext.getConnection();
//        PreparedStatement stm = con.prepareStatement("update Users set userName= ?, fullName = ?, avatar = ?, address = ?, phone = ?, email = ? where userID = ?");
//        stm.setString(1, Account.getUserName());
//        stm.setString(2, Account.getFullName());
//        stm.setString(3, Account.getAvatar());
//        stm.setString(4, Account.getAddress());
//        stm.setString(5, Account.getPhone());
//        stm.setString(6, Account.getEmail());
//        stm.setInt(7, Account.getUserID());
//        int count = stm.executeUpdate();
//        con.close();
//    }
//
    public boolean isActive(int status) {
        return status == 1;
    }
}
