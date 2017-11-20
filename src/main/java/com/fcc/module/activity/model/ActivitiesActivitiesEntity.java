package com.fcc.module.activity.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by acer on 2017/11/13.
 */
@Entity
@Table(name = "activities_activities", schema = "autosite", catalog = "")
public class ActivitiesActivitiesEntity {
    private int id;
    private String name;
    private String address;
    private String city;
    private String stateProvince;
    private String description;
    private String tel;
    private String img;
    private Timestamp startTime;
    private Timestamp endTime;
    private int ticketPayCount;
    private double ticketPayPrice;
    private int ticketFreeCount;
    private int status;
    private Timestamp createAt;
    private Timestamp updateAt;
    private int ownerId;

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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state_province")
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "ticket_pay_count")
    public int getTicketPayCount() {
        return ticketPayCount;
    }

    public void setTicketPayCount(int ticketPayCount) {
        this.ticketPayCount = ticketPayCount;
    }

    @Basic
    @Column(name = "ticket_pay_price")
    public double getTicketPayPrice() {
        return ticketPayPrice;
    }

    public void setTicketPayPrice(double ticketPayPrice) {
        this.ticketPayPrice = ticketPayPrice;
    }

    @Basic
    @Column(name = "ticket_free_count")
    public int getTicketFreeCount() {
        return ticketFreeCount;
    }

    public void setTicketFreeCount(int ticketFreeCount) {
        this.ticketFreeCount = ticketFreeCount;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "create_at")
    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Basic
    @Column(name = "owner_id")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivitiesActivitiesEntity that = (ActivitiesActivitiesEntity) o;

        if (id != that.id) return false;
        if (ticketPayCount != that.ticketPayCount) return false;
        if (Double.compare(that.ticketPayPrice, ticketPayPrice) != 0) return false;
        if (ticketFreeCount != that.ticketFreeCount) return false;
        if (status != that.status) return false;
        if (ownerId != that.ownerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(that.stateProvince) : that.stateProvince != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (createAt != null ? !createAt.equals(that.createAt) : that.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + ticketPayCount;
        temp = Double.doubleToLongBits(ticketPayPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ticketFreeCount;
        result = 31 * result + status;
        result = 31 * result + (createAt != null ? createAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        result = 31 * result + ownerId;
        return result;
    }
}
