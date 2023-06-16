/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Dell
 */
public class Users {
    private int id;
    private String email;
    private String password;
    private String fullname;
    private String avatar;
    private int status;
    private int role_id;
    private String role_name;

    public Users() {
    }
    

    public Users(String email, String password, String fullname, String avatar, int status, int role_id) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
        this.status = status;
        this.role_id = role_id;
    }

    public Users(int id, String email, String password, String fullname, String avatar, int status, int role_id) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
        this.status = status;
        this.role_id = role_id;
    }

    public Users(int id, String email, String password, String fullname, String avatar, int status, int role_id, String role_name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatar = avatar;
        this.status = status;
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    
    

}
