package com.fcc.core.shiro;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ShiroUser implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String password;
    private Timestamp lastLogin;
    private byte isSuperuser;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private byte isStaff;
    private byte isActive;
    private Timestamp dateJoined;

    public ShiroUser() {
    }

    public ShiroUser(int id, String password, Timestamp lastLogin, byte isSuperuser, String username, String firstName, String lastName, String email, byte isStaff, byte isActive, Timestamp dateJoined) {

        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperuser = isSuperuser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    }

    public static long getSerialVersionUID() {

        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public byte getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsSuperuser(byte isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(byte isStaff) {
        this.isStaff = isStaff;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "ShiroUser{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", isSuperuser=" + isSuperuser +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isStaff=" + isStaff +
                ", isActive=" + isActive +
                ", dateJoined=" + dateJoined +
                '}';
    }
}
