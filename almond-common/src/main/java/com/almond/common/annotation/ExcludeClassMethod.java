package com.almond.common.annotation;

import java.lang.annotation.*;

/**
 * 说明： 方法排除注解
 *
 * @version V 1.0.0
 * @Author: Glendon.Li
 * @Create: 2021-10-30 22:14
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcludeClassMethod {
    /**
     * 排除的方法名称
     *
     * @return
     */
    public String[] methodName() default {};
}
