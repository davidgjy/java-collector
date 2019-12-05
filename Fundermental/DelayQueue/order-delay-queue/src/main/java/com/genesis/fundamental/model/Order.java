package com.genesis.fundamental.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author : KG
 * description: 延时订单
 * create date: 1:44 PM 2019/12/5
 * modified by:
 */

@Data
public class Order implements Delayed {

    /**
     * 订单过期时间(单位: 毫秒)
     */
    private static final long EXPIRE_TIME = 10000;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    @Override
    public long getDelay(TimeUnit unit) {
        // 消息是否到期(是否可以被读取出来)的判断依据, 当返回负数时说明已经到期
        return unit.convert(this.createTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()
                + EXPIRE_TIME - System.currentTimeMillis(),
                TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        // 比较取消时间, 小的会优先被队列提出来
        return this.getCreateTime().compareTo(((Order) o).getCreateTime());
    }
}






