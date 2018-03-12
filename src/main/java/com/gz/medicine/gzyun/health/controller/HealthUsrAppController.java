package com.gz.medicine.gzyun.health.controller;

import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.mybatisPageVo.Page;
import com.gz.medicine.common.mybatisPageVo.PageModel;
import com.gz.medicine.common.util.JuheUtil;
import com.gz.medicine.common.util.SimpleCode;
import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.bean.HealthInvoiceInfo;
import com.gz.medicine.gzyun.health.bean.HealthInvoiceRecord;
import com.gz.medicine.gzyun.health.request.*;
import com.gz.medicine.gzyun.health.service.HealthUsrAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Validator;

import java.util.List;
import java.util.Map;

import static com.gz.medicine.common.util.ValidateWithException.validates;

/**
 * Created by Administrator on 2017/9/21 0021.
 */
@RestController
@RequestMapping("/v1/usrApp/")
public class HealthUsrAppController {
    @Autowired
    HealthUsrAppService healthusrappservice;
    @Autowired
    Validator validator;

    //我的订单
    @RequestMapping(value = "/queryMyOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryMyOrder(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = healthusrappservice.queryMyOrder(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }

    //我的订单详情
    @RequestMapping(value = "/queryMyOrdeDetail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryMyOrdeDetailr(@RequestParam(value = "orderid", required = false) String orderid) {
        SimpleResult sr = null;
        Map<String, Object> mp = null;
        try {
            mp = healthusrappservice.queryMyOrderDetail(orderid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", mp);
        return sr;
    }

    //我的咨询列表
    @RequestMapping(value = "/queryMyConsultation", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryMyConsultation(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = healthusrappservice.queryMyConsultation(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }

    //我的咨询查看详情
    @RequestMapping(value = "/queryMyConsultationDetail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryMyConsultationDetail(@RequestParam(value = "consultationid", required = false) String consultationid,
                                                  @RequestParam(value = "docid", required = true) String docid) {
        SimpleResult sr = null;
        Map<String, Object> mp = null;
        try {
            mp = healthusrappservice.queryMyConsultationDetail(consultationid, docid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", mp);
        return sr;
    }

    //评价提交接口
    @RequestMapping(value = "/insertEvaluateMessage", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult insertEvaluateMessage(HealthevaluateRequest result) {
        SimpleResult sr = null;
        if (validates(validator, result) != null) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, result));
        }
        try {
            healthusrappservice.insertEvaluateMessageAndLog(result);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());

        }
        sr = SimpleResult.success();
        return sr;
    }

    //医生排版时间
    @RequestMapping(value = "/getDocTime", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult getDocTime(@RequestParam(value = "docid", required = true) String docid) {
        SimpleResult sr = null;

        List<Map<String, Object>> mp = null;
        try {
            mp = healthusrappservice.queryDocTime(docid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", mp);
        return sr;
    }

    //身份证校验
    @RequestMapping(value = "/checkIdcard", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult checkIdcard(@RequestParam(value = "idcard", required = true) String idcard)  {
        SimpleResult sr = null;
        try {
            sr = JuheUtil.getIdcardMsg(idcard);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        return sr;
    }

//    //修改订单状态
//    @RequestMapping(value = "/updateOrderState", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//    public SimpleResult updateOrderState( HealtheOrderForUpdateRequest result) throws Exception {
//        SimpleResult sr = null;
//        if (validates(validator, result) != null) {
//            return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, result));
//        }
//        healthusrappservice.updateOrderAndLog(result);
//        sr = SimpleResult.success();
//        return sr;
//    }

    //------------------------------------------------新增开发票 by dlf 2017/10/16----------------------------------------------//
    //新增发票
    @RequestMapping(value = "/insertHealthInvoiceInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult insertHealthInvoiceInfo(HealthInvoiceInfoRequest result) {
        SimpleResult sr = null;
        if (validates(validator, result) != null) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, result));
        }
        try {
            healthusrappservice.insertHealthInvoiceInfo(result);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //查询发票
    @RequestMapping(value = "/queryHealthInvoiceInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryHealthInvoiceInfoForUsrid(@RequestParam(value = "usrid", required = true) String usrid) {
        SimpleResult sr = null;
        List<HealthInvoiceInfo> li = null;
        try {
            li = healthusrappservice.queryHealthInvoiceInfoForUsrid(usrid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", li);
        return sr;
    }

    //修改或删除
    @RequestMapping(value = "/updateHealthInvoiceInfo", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public SimpleResult updateHealthInvoiceInfoForUsrid(HealthInvoiceInfo hf)  {
        SimpleResult sr = null;
        try {
            healthusrappservice.updateHealthInvoiceInfoForUsrid(hf);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //发票记录新增
    @RequestMapping(value = "/insertHealthInvoiceRecord", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult insertHealthInvoiceRecord(HealthInvoiceRecordRequest hf)  {
        if (validates(validator, hf) != null) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, hf));
        }
        SimpleResult sr = null;
        try {
            healthusrappservice.insertHealthInvoiceRecordAndLog(hf);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //发票记录查询通过订单ID
    @RequestMapping(value = "/queryHealthInvoiceRecord", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryHealthInvoiceRecordForOrderId(@RequestParam(value = "orderid", required = true) String orderid)  {
        SimpleResult sr = null;
        HealthInvoiceRecord hd = null;
        try {
            hd = healthusrappservice.queryHealthInvoiceRecordForOrderId(orderid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", hd);
        return sr;
    }

    //更新物流信息
    @RequestMapping(value = "/updateHealthInvoiceRecord", method = {RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST}, produces = "text/html;charset=UTF-8")
    public SimpleResult updateHealthInvoiceRecordForOrderId(HealthInvoiceRecord hd)  {
        SimpleResult sr = null;
        try {
            healthusrappservice.updateHealthInvoiceRecordForOrderIdAndLog(hd);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //订单管理
    @RequestMapping(value = "/queryPageOrderForMoHo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult queryPageOrderForMoHo(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = healthusrappservice.queryPageOrderForMoHo(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }

    //聊天记录查询
    @RequestMapping(value = "/queryPageChatMsg", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public SimpleResult queryPageChatMsg(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = healthusrappservice.queryPageChatMsg(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }

    /*-----------------------------------------------------------完美的分割线by2017-10-30---------------------------------------------------------------------*/
    //咨询服务
    @RequestMapping(value = "/queryPageMyOrderForV2", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryPageMyOrderForV2(PageModel page) {
        SimpleResult sr = null;
        Page p = null;
        try {
            p = healthusrappservice.queryPageMyOrderForV2(page);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", p);
        return sr;
    }

    //取消订单
    @RequestMapping(value = "/cancelOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult cancelOrder(@RequestParam(value = "orderid", required = true) String orderid,
                                    @RequestParam(value = "loginid", required = true) String loginid) {
        SimpleResult sr = null;
        try {
            healthusrappservice.cancelOrderAndLog(orderid, loginid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getDesc());
        }
        sr = SimpleResult.success();
        return sr;
    }

    //订单详情
    @RequestMapping(value = "/queryOrderDetail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryOrderDetail(@RequestParam(value = "orderid", required = true) String orderid) {
        SimpleResult sr = null;
        Map<String, Object> resultMp = null;
        try {
            resultMp = healthusrappservice.queryOrderDetail(orderid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", resultMp);
        return sr;
    }

    //查看详情
    @RequestMapping(value = "/queryOrderFinshMsg", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult queryOrderFinshMsg(@RequestParam(value = "orderid", required = true) String orderid) {
        SimpleResult sr = null;
        Map<String, Object> resultMp = null;
        try {
            resultMp = healthusrappservice.queryOrderFinshMsg(orderid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        sr.put("data", resultMp);
        return sr;
    }

    //更新咨询时长
    @RequestMapping(value = "/updateHours", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult updateHours(@RequestParam(value = "id", required = true) String id,
                                    @RequestParam(value = "consultinghours", required = true) String consultinghours,
                                    @RequestParam(value = "usrid", required = true) String usrid)  {
        SimpleResult sr = null;
        try {
            healthusrappservice.updateHoursAndLog(id, consultinghours, usrid);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }
    //更新咨询开始时间
    @RequestMapping(value = "/updatetime", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public SimpleResult updatetime(@RequestParam(value = "id", required = true) String id)  {
        SimpleResult sr = null;
        try {
            healthusrappservice.updateConsultationstarttime(id);
        } catch (CommonException e) {
            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
        }
        sr = SimpleResult.success();
        return sr;
    }











//    //根据日期查询医生排版
//    @RequestMapping(value = "/queryDoctorFormByDate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
//    public SimpleResult queryDoctorFormByDate(@RequestParam(value = "docid", required = true) String docid,
//                                              @RequestParam(value = "date", required = true) String date)  {
//        SimpleResult sr = null;
//        try {
//            healthusrappservice.queryDoctorFormByDate(docid,date);
//        } catch (CommonException e) {
//            return SimpleResult.error(SimpleCode.ERROR.getCode(), e.getMessage());
//        }
//        sr = SimpleResult.success();
//        return sr;
//    }
//public static void main(String[] args) throws IOException {
//            String[] a=new String []{"0","1","2","3","4","5","6","7","8","9"};
//
////    /**
////     * 图片中心400*400的区域
////     */
////    Thumbnails.of("1111.jpeg").sourceRegion(Positions.CENTER, 2000, 2000).size(2000, 2000).keepAspectRatio(false)
////            .toFile("image_region_center.jpg");
//
//
//
//}


}

