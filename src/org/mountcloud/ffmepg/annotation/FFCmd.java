package org.mountcloud.ffmepg.annotation;

import java.lang.annotation.*;

/**
 * 命令注解，用于注解类
 * com.ugirls.ffmepg.annotation
 * 2018/6/6.
 *
 * @author zhanghaishan
 * @version V1.0
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FFCmd {

    /**
     * 命令的key
     *
     * @return 命令Key
     */
    String key() default "";

}
