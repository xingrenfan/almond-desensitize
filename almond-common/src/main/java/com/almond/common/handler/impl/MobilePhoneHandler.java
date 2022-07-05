package com.almond.common.handler.impl;

import com.almond.common.handler.DesensitizationHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-25 23:46
 */
public class MobilePhoneHandler implements DesensitizationHandler {

    @Override
    public boolean closeHandler(boolean enableExeclude) {
        // 默认处理程序，不排除任何方法
        return false;
    }

    @Override
    public String handler(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 2).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 2), StringUtils.length(num), "*"), "***"));
    }
}
