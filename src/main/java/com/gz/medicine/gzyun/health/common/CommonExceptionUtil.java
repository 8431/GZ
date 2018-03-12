package com.gz.medicine.gzyun.health.common;

import com.gz.medicine.common.exception.CommonException;

/**
 * Created by dlf on 2017/11/24 0024.
 * Email 1429264916@qq.com
 */
public class CommonExceptionUtil {
    public static CommonException setCommonException(GzHealthyCodeEnum g, Exception e) {
        CommonException cn=new CommonException( g.getName(),g.getValue(),e);
        return cn;
    }
    public static CommonException setCommonException(GzHealthyCodeEnum g,String msg, Exception e) {
        CommonException cn=new CommonException( g.getName(),msg,e);
        return cn;
    }

}
