package com.fcc.module.group.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/13.
 */
@Entity
@Table(name = "groups_group_and_user", schema = "autosite", catalog = "")
public class GroupsGroupAndUserEntity {
    private int id;
    private Timestamp dateJoined;
    private int inviteUserId;
    private String inviteReason;
    private int groupId;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_joined")
    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Basic
    @Column(name = "invite_user_id")
    public int getInviteUserId() {
        return inviteUserId;
    }

    public void setInviteUserId(int inviteUserId) {
        this.inviteUserId = inviteUserId;
    }

    @Basic
    @Column(name = "invite_reason")
    public String getInviteReason() {
        return inviteReason;
    }

    public void setInviteReason(String inviteReason) {
        this.inviteReason = inviteReason;
    }

    @Basic
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupsGroupAndUserEntity that = (GroupsGroupAndUserEntity) o;

        if (id != that.id) return false;
        if (inviteUserId != that.inviteUserId) return false;
        if (groupId != that.groupId) return false;
        if (userId != that.userId) return false;
        if (dateJoined != null ? !dateJoined.equals(that.dateJoined) : that.dateJoined != null) return false;
        if (inviteReason != null ? !inviteReason.equals(that.inviteReason) : that.inviteReason != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateJoined != null ? dateJoined.hashCode() : 0);
        result = 31 * result + inviteUserId;
        result = 31 * result + (inviteReason != null ? inviteReason.hashCode() : 0);
        result = 31 * result + groupId;
        result = 31 * result + userId;
        return result;
    }
}
