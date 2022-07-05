package com.almond.common.handler.impl;

import com.almond.common.handler.DesensitizationHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： [中文姓名] 只显示第一个汉字，其他隐藏为2个星号<例子：李**>
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-25 23:38
 */
public class ChineseNameHandler implements DesensitizationHandler {

    @Override
    public boolean closeHandler(boolean enableExeclude) {
        // 默认处理程序，不排除任何方法
        return false;
    }

    @Override
    public String handler(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(name, 1), StringUtils.length(name), "*");
    }

}
