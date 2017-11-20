package com.fcc.module.activity.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/11/13.
 */
@Entity
@Table(name = "activitie_attendee", schema = "autosite", catalog = "")
public class ActivitieAttendeeEntity {
    private int id;
    private String name;
    private String email;
    private String tel;
    private int ticket;
    private int activitieId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "ticket")
    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    @Basic
    @Column(name = "activitie_id")
    public int getActivitieId() {
        return activitieId;
    }

    public void setActivitieId(int activitieId) {
        this.activitieId = activitieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivitieAttendeeEntity that = (ActivitieAttendeeEntity) o;

        if (id != that.id) return false;
        if (ticket != that.ticket) return false;
        if (activitieId != that.activitieId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + ticket;
        result = 31 * result + activitieId;
        return result;
    }
}
