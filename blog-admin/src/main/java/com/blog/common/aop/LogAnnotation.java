package com.blog.common.aop;

import java.lang.annotation.*;

/**
 * common
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    /**
     * common
     * @return
     */

    String module() default "";

    String operation() default "";

}
