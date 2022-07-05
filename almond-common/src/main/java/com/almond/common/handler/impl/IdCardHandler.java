package com.almond.common.handler.impl;

import com.almond.common.handler.DesensitizationHandler;
import org.apache.commons.lang3.StringUtils;

/**
 * 说明： [身份证号] 显示最后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-25 23:41
 */
public class IdCardHandler implements DesensitizationHandler {

    @Override
    public boolean closeHandler(boolean enableExeclude) {
        // 默认处理程序，不排除任何方法
        return false;
    }

    @Override
    public String handler(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }

        return StringUtils.left(id, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(id, 3), StringUtils.length(id), "*"), "***"));
    }
}
