package com.fcc.module.shop.model;

import javax.persistence.*;

/**
 * Created by acer on 2017/11/1.
 */
@Entity
@Table(name = "shop_shop_tag_relation", schema = "autosite", catalog = "")
public class ShopShopTagRelationEntity {
    private int id;
    private int shopId;
    private int tagId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shop_id")
    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "tag_id")
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopShopTagRelationEntity that = (ShopShopTagRelationEntity) o;

        if (id != that.id) return false;
        if (shopId != that.shopId) return false;
        if (tagId != that.tagId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + shopId;
        result = 31 * result + tagId;
        return result;
    }
}
