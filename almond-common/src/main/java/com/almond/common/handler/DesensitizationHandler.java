package com.almond.common.handler;

/**
 * 说明： 脱敏程序
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-25 22:54
 */
public interface DesensitizationHandler {

    /**
     * 开启脱敏程序
     *
     * @return
     */
    public boolean closeHandler(boolean enableExeclude);

    /**
     * 脱敏处理器执行者
     *
     * @param arg
     * @return
     */
    public String handler(String arg);

}
