package com.gz.medicine.gzyun.health.vaild;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName MobileCheck
 * @PackageName com.gz.medicine.gzyun.health.vaild
 * @Description 手机号校验
 * @Data 2017-09-21 10:47
 **/
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
//指定验证器
@Constraint(validatedBy = CheckValidator.class)
@Documented
public @interface MobileCheck {
    String message() default "手机号格式错误";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
