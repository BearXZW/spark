package com.sana.sparkdemo.model;

public class FreqItemSets {
    private Integer id;

    private String items;

    private Integer itemsfreq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items == null ? null : items.trim();
    }

    public Integer getItemsfreq() {
        return itemsfreq;
    }

    public void setItemsfreq(Integer itemsfreq) {
        this.itemsfreq = itemsfreq;
    }
}