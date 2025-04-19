package com.timposulabs.jobportal.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users_type")
public class UsersType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    @NotEmpty
    private String userTypeName;

    @OneToMany(targetEntity = Users.class, mappedBy = "userTypeId", cascade = CascadeType.ALL)
    private List<Users> users;

    public UsersType() {
    }

    public UsersType(int userTypeId, String userTypeName, List<Users> users) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
        this.users = users;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsersType usersType = (UsersType) o;
        return Objects.equals(userTypeId, usersType.userTypeId) && Objects.equals(userTypeName, usersType.userTypeName) && Objects.equals(users, usersType.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userTypeId, userTypeName, users);
    }

    @Override
    public String toString() {
        return "UsersType{" +
                "id=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
