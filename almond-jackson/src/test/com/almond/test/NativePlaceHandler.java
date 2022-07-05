package com.almond.test;

import com.almond.common.handler.DesensitizationHandler;
import com.almond.common.util.RmHandlerUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： 籍贯脱敏程序
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-30 21:41
 */
public class NativePlaceHandler implements DesensitizationHandler {
    @Override
    public boolean closeHandler(boolean enableExeclude) {
        return RmHandlerUtil.isExclude();
    }

    @Override
    public String handler(String address) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        final int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, length - 6), length, "*");
    }
}
