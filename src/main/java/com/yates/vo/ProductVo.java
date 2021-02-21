package com.yates.vo;

import com.yates.entity.Product;

import java.util.Date;

public class ProductVo extends Product {
    private int startSecKillPrice;
    private int endSecKillPrice;

    private int startOriginPrice;
    private int endOriginPrice;

    private Date startApplyDate;
    private Date endApplyDate;

    private Date startEndTime;
    private Date endEndTime;

    private Date startProductCount;
    private Date endProductCount;

    private int startStockCount;
    private int endStockCount;

    public int getStartSecKillPrice() {
        return startSecKillPrice;
    }

    public void setStartSecKillPrice(int startSecKillPrice) {
        this.startSecKillPrice = startSecKillPrice;
    }

    public int getEndSecKillPrice() {
        return endSecKillPrice;
    }

    public void setEndSecKillPrice(int endSecKillPrice) {
        this.endSecKillPrice = endSecKillPrice;
    }

    public int getStartOriginPrice() {
        return startOriginPrice;
    }

    public void setStartOriginPrice(int startOriginPrice) {
        this.startOriginPrice = startOriginPrice;
    }

    public int getEndOriginPrice() {
        return endOriginPrice;
    }

    public void setEndOriginPrice(int endOriginPrice) {
        this.endOriginPrice = endOriginPrice;
    }

    public Date getStartApplyDate() {
        return startApplyDate;
    }

    public void setStartApplyDate(Date startApplyDate) {
        this.startApplyDate = startApplyDate;
    }

    public Date getEndApplyDate() {
        return endApplyDate;
    }

    public void setEndApplyDate(Date endApplyDate) {
        this.endApplyDate = endApplyDate;
    }

    public Date getStartEndTime() {
        return startEndTime;
    }

    public void setStartEndTime(Date startEndTime) {
        this.startEndTime = startEndTime;
    }

    public Date getEndEndTime() {
        return endEndTime;
    }

    public void setEndEndTime(Date endEndTime) {
        this.endEndTime = endEndTime;
    }

    public Date getStartProductCount() {
        return startProductCount;
    }

    public void setStartProductCount(Date startProductCount) {
        this.startProductCount = startProductCount;
    }

    public Date getEndProductCount() {
        return endProductCount;
    }

    public void setEndProductCount(Date endProductCount) {
        this.endProductCount = endProductCount;
    }

    public int getStartStockCount() {
        return startStockCount;
    }

    public void setStartStockCount(int startStockCount) {
        this.startStockCount = startStockCount;
    }

    public int getEndStockCount() {
        return endStockCount;
    }

    public void setEndStockCount(int endStockCount) {
        this.endStockCount = endStockCount;
    }
}
