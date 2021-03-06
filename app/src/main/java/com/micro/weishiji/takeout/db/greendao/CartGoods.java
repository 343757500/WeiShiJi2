package com.micro.weishiji.takeout.db.greendao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "CART_GOODS".
 */
public class CartGoods {

    private Long id;
    private Integer goodsId;
    private Integer categoryId;
    private Integer shopId;
    private Integer count;

    public CartGoods() {
    }

    public CartGoods(Long id) {
        this.id = id;
    }

    public CartGoods(Long id, Integer goodsId, Integer categoryId, Integer shopId, Integer count) {
        this.id = id;
        this.goodsId = goodsId;
        this.categoryId = categoryId;
        this.shopId = shopId;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
