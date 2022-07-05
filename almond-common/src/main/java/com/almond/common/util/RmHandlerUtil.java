package com.almond.common.util;

import com.almond.common.annotation.ExcludeClassMethod;
import com.almond.common.handler.DesensitizationHandler;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 说明： 脱敏程序辅助工具
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-30 15:09
 */
public class RmHandlerUtil {
    private RmHandlerUtil() {
    }

    public static DesensitizationHandler getHandler(Class<? extends DesensitizationHandler> handler) throws IllegalAccessException, InstantiationException {
        return handler.newInstance();
    }

    public static boolean isExclude() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        return Stream.of(stackTrace).anyMatch(dto -> {
            try {
                ExcludeClassMethod methods = Class.forName(dto.getClassName()).getAnnotation(ExcludeClassMethod.class);
                if (Objects.nonNull(methods)) {
                    return Arrays.asList(methods.methodName()).contains(dto.getMethodName());
                }
            } catch (ClassNotFoundException e) {
                return false;
            }
            return false;
        });
    }
}
