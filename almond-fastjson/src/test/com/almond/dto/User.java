package com.almond.dto;

import com.almond.common.handler.impl.AddressHandler;
import com.almond.common.handler.impl.ChineseNameHandler;
import com.almond.common.handler.impl.IdCardHandler;
import com.almond.common.handler.impl.MobilePhoneHandler;
import com.almond.fastjson.annotation.ExcludeSensitive;
import com.almond.test.NativePlaceHandler;

/**
 * 说明：
 *
 * @Author: Glendon.Li
 * @Create: 2021-10-22 23:03
 * @version: V 1.0.0
 */
public class User {

    @ExcludeSensitive(handler = ChineseNameHandler.class)
    private String name;

    // 手机号
    @ExcludeSensitive(handler = MobilePhoneHandler.class)
    private String mobile;

    // 年龄
    private int age;

    // 性别
    private String sex;

    // 籍贯
    @ExcludeSensitive(handler = AddressHandler.class, enable = false)
    private String address;

    @ExcludeSensitive(handler = NativePlaceHandler.class, enableExclude = true)
    private String nativePlace;

    // 身份证号
    @ExcludeSensitive(handler = IdCardHandler.class, enable = false)
    private String idCard;

    public User() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
