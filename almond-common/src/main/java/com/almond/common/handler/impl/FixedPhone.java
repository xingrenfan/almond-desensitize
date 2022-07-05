package com.almond.common.handler.impl;

import com.almond.common.handler.DesensitizationHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： 固定电话过滤器
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-28 23:14
 */
public class FixedPhone implements DesensitizationHandler {

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
        return StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*");
    }
}
