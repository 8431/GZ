package com.gz.medicine.gzyun.health.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.common.util.ValidateWithException;
import com.gz.medicine.gzyun.health.service.HealthOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Validator;
import java.util.List;
import java.util.Map;

/**
 * @version V1.0
 * @Author fendo
 * @ClassName HealthOrderController
 * @PackageName com.gz.medicine.gzyun.health.controller
 * @Description 订单 Controller
 * @Data 2017-09-21 10:47
 **/
@Controller
@RequestMapping("/order")
public class HealthOrderController extends ValidateWithException {

    public static final Logger LOGGER = Logger.getLogger(HealthOrderController.class);

    @Autowired
    Validator validator;


    @Autowired
    private HealthOrderService healthOrderService;

    /**
     *
     *@Title GetEetails
     *@Description: 订单退款详情
     *@Author fendo
     *@Date 2017年9月21日 上午10:52
     *@param orderid 订单ID
     *@return SimpleResult
     *@throws
     *@测试地址: http://localhost:8080/GZ/order/getdetails?orderid=1510530884953109591000000568
     */
    @RequestMapping(value="getdetails",method = RequestMethod.GET,produces="text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult GetEetails(String orderid){
        SimpleResult simpleResult;
        List<Map<String, Object>> mapList;
        LOGGER.info("[/order/getdetails]");
        if(StringUtils.isEmpty(orderid)){
            return SimpleResult.error("000","订单ID不能为空!");
        }
        try {
            mapList = healthOrderService.GetOrderEetails(orderid);
        }catch (CommonException e){
            LOGGER.error(e);
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        simpleResult = SimpleResult.success();
        simpleResult.put("data",mapList);
        return  simpleResult;
    }


}
