package com.mj.dao.annotate;

import java.lang.annotation.*;

//切换数据注解,可以用于类或者方法级别,方法级别优先级>类级别
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    String value() default "";//该值即key的值
}
