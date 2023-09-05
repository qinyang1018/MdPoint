package com.qy.mdpoint.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "point_table")
data class PointEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    //订单号
    @ColumnInfo(name = "orderNo")
    val orderNo:String,
    //平台
    @ColumnInfo(name = "platform")
    val platform:String,
    //金额
    @ColumnInfo(name = "money")
    val money: Float,
    //积分
    @ColumnInfo(name = "point")
    val point:Float,
    //积分倍数
    @ColumnInfo(name = "factor")
    val factor:Float,
    //剩余积分倍数
    @ColumnInfo(name = "surplusFactor")
    val surplusFactor:Float,
)
