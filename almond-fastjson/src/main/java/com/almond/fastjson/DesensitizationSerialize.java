package com.almond.fastjson;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.almond.common.handler.DesensitizationHandler;
import com.almond.common.util.RmHandlerUtil;
import com.almond.fastjson.annotation.ExcludeSensitive;

import java.util.Objects;

/**
 * 说明：脱敏
 *
 * @Author: Glendon.Li
 * @Create: 2021-10-22 23:09
 * @version: V 1.0.0
 */
public class DesensitizationSerialize implements ValueFilter {

    @Override
    public Object process(Object entity, String name, Object value) {
        try {
            if (Objects.nonNull(entity)) {
                ExcludeSensitive excludeSensitive = entity.getClass().getAnnotation(ExcludeSensitive.class);
                // 如果能得到注解
                if (Objects.nonNull(excludeSensitive) && excludeSensitive.enable() &&
                        Objects.nonNull(excludeSensitive.handler())) {
                    DesensitizationHandler handler = RmHandlerUtil.getHandler(excludeSensitive.handler());
                    if (Objects.nonNull(handler) && handler.closeHandler(excludeSensitive.enableExclude())) {
                        return handler.handler(Objects.toString(value, ""));
                    }
                }
            }
        } catch (Exception e) {

        }
        return value;
    }
}
