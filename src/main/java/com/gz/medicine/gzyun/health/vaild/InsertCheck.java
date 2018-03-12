package com.gz.medicine.gzyun.health.vaild;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
/**
 * Created by dlf on 2017/10/24 0024.
 * Email 1429264916@qq.com
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
//指定验证器
@Constraint(validatedBy = CheckValidator.class)
@Documented
public @interface InsertCheck {

    //默认错误消息
    String message() default "{forbidden.word}";
    //查询的表名
    String tableName() default "";
    String cloumn() default "";
    String sql() default "";
    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };

    //指定多个时使用
    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        InsertCheck[] value();
    }

}
