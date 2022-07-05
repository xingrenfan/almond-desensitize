package com.almond.jackson.annotation;

import com.almond.common.handler.DesensitizationHandler;
import com.almond.jackson.DesensitizationSerialize;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

/**
 * 说明：脱敏注解
 *
 * @Author: Glendon.Li
 * @Create: 2021-10-22 23:07
 * @version: V 1.0.0
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerialize.class)
public @interface ExcludeSensitive {
    /**
     * 脱敏程序名
     *
     * @return
     */
    public Class<? extends DesensitizationHandler> handler();

    /**
     * 开启脱敏 - 有些程序可能暂时不需要脱敏，以后需要先加上注解以后方便查找和修改
     *
     * @return
     */
    public boolean enable() default true;

    /**
     * 开启接口排除 - 会影响部分性能
     *
     * @return
     */
    public boolean enableExclude() default false;

}
