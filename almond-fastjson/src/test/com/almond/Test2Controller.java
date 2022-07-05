package com.almond;

import com.alibaba.fastjson.JSONObject;
import com.almond.dto.User;
import com.almond.fastjson.DesensitizationSerialize;

/**
 * 说明： 测试类
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-11-01 22:11
 */
public class Test2Controller {
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
}
