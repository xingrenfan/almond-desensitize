package com.almond.common.handler.impl;

import com.almond.common.handler.DesensitizationHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： 地址脱敏
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-27 23:51
 */
public class AddressHandler implements DesensitizationHandler {

    @Override
    public boolean closeHandler(boolean enableExeclude) {
        // 默认处理程序，不排除任何方法
        return false;
    }

    @Override
    public String handler(String address) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        final int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, length - 4), length, "*");
    }
}
