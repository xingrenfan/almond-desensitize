package com.almond;

/**
 * 说明： 测试Jackson脱敏程序
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-25 23:44
 */
public class TestHandler {
    public static void main(String[] args) {
        TestController testController = new TestController();
        testController.test();
        testController.test1();
        Test2Controller test2Controller = new Test2Controller();
        test2Controller.test();
    }
}
