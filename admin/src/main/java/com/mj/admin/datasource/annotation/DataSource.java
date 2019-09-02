/**
 * Copyright (c) 2018 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.mj.admin.datasource.annotation;

import java.lang.annotation.*;

/**
 * @Author Simon
 * @Method
 * @Version 1.0
 * @Return
 * @Exception 多文件注解
 * @Date 2019-08-23 0023 09:49:53
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";
}
