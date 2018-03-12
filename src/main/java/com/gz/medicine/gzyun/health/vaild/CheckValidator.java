package com.gz.medicine.gzyun.health.vaild;

import com.gz.medicine.common.util.JuheUtil;
import com.gz.medicine.common.util.RegexUtils;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.TimeUtil;
import com.gz.medicine.gzyun.health.mapper.HealthyOrderMapper;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by dlf on 2017/10/24 0024.
 * Email 1429264916@qq.com
 */
public class CheckValidator implements ConstraintValidator<Annotation, Object> {
    @Autowired
    HealthyOrderMapper healthyordermapper;
    public static final Logger LOGGER = Logger.getLogger(CheckValidator.class);
    public static final String DATE_CHECK ="((^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(10|12|0?[13578])([-\\/\\._])(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(11|0?[469])([-\\/\\._])(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\\d{2})|([2-9]\\d{3}))([-\\/\\._])(0?2)([-\\/\\._])(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([3579][26]00)([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][0][48])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][2468][048])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([1][89][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$)|(^([2-9][0-9][13579][26])([-\\/\\._])(0?2)([-\\/\\._])(29)$))";
    public static final String TIME_CHECK="^([0-1]?[0-9]|2[0-3]):([0-5][0-9])";
    public static final String YYYYMMHHDDMI="^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01]) (0\\d{1}|1\\d{1}|2[0-3]):([0-5]\\d{1})$";
    private String value;
    private int annotationType;

    @Override
    public void initialize(Annotation annotation) {
        if (annotation instanceof InsertCheck) {
            annotationType = 0;
            InsertCheck ak = (InsertCheck) annotation;
            this.value = ak.sql();
        }
        if (annotation instanceof DateCheck) {
            annotationType = 1;
            DateCheck dk = (DateCheck) annotation;
            this.value = dk.type();
        }
        if (annotation instanceof IdCardCheck) {
            annotationType = 2;
            IdCardCheck ik = (IdCardCheck) annotation;
        }

        if (annotation instanceof MobileCheck) {
            annotationType = 3;
            MobileCheck ik = (MobileCheck) annotation;
        }

    }

    public static void main(String[] args) {

        System.out.println(Pattern.matches("","2017-12-32 09:54"));
    }

    @Override
    public boolean isValid(Object ot, ConstraintValidatorContext constraintValidatorContext) {
        boolean re = false;
        try {
            switch (annotationType) {

                case 0: {
                    try {
                        String key = this.value.substring(this.value.indexOf("{") + 1, this.value.indexOf("}"));
                        Map<String, Object> mp = new HashedMap();
                        mp.put("sql", this.value);
                        mp.put(key, ot);
                        List<Map<String, Object>> li = healthyordermapper.exuSql(mp);
                        System.out.println(li.size());
                        if (li != null && li.size() == 0) {
                            re = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ;
                    }
                    break;
                }
                case 1: {
                    try {
                        if("YYYY-MM-DD".equals(this.value)){
                            re =Pattern.matches(DATE_CHECK, (String) ot);
                        }
                        if("HH:MI".equals(this.value)){
                            re =Pattern.matches(TIME_CHECK, (String) ot);
                        }
                        if("YYYY-MM-DD HH:MI".equals(this.value)){
                            re =Pattern.matches(YYYYMMHHDDMI, (String) ot);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        ;
                    }
                    break;
                }
                case 2: {
                    try {
                        SimpleResult sr = JuheUtil.getIdcardMsg((String) ot);
                        String code = (String) sr.get("code");
                        if ("000".equals(code)) {
                            re = true;
                        }
                    } catch (Exception e) {
                    }
                    break;
                }
                case 3:{
                    re  = RegexUtils.isMobile((String) ot);
                    break;
                }

            }

        } catch (Exception e) {
            LOGGER.error("校验异常:" + e.getMessage(), e);
        }
        return re;

    }


}
