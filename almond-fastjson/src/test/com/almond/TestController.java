package com.almond;

import com.alibaba.fastjson.JSONObject;
import com.almond.common.annotation.MethodExclude;
import com.almond.dto.User;
import com.almond.fastjson.DesensitizationSerialize;

/**
 * 说明： 测试
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-30 22:42
 */
@MethodExclude(methodName = "test1")
public class TestController {
    public void test() {
        User user = new User();
        user.setName("张小明");
        user.setMobile("17602159257");
        user.setAge(30);
        user.setSex("男");
        user.setAddress("上海市闵行区浦江镇浦涛路505弄48号801室");
        user.setNativePlace("上海市闵行区浦江镇浦涛路505弄48号801室");
        user.setIdCard("372378202109265638");

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++){
//            objectMapper.writeValueAsString(user);
//        }
        System.out.println("test: " + JSONObject.toJSONString(user, new DesensitizationSerialize()));
        System.out.println("test time: " + (System.currentTimeMillis() - start));
    }

    public void test1() {
        User user = new User();
        user.setName("张小明");
        user.setMobile("17602159257");
        user.setAge(30);
        user.setSex("男");
        user.setAddress("上海市闵行区浦江镇浦涛路505弄48号801室");
        user.setNativePlace("上海市闵行区浦江镇浦涛路505弄48号801室");
        user.setIdCard("372378202109265638");

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++){
//            objectMapper.writeValueAsString(user);
//        }
        System.out.println("test1: " + JSONObject.toJSONString(user, new DesensitizationSerialize()));
        System.out.println("test1 time: " + (System.currentTimeMillis() - start));
    }
}
