//package com.gz.medicine.gzyun.heaman.controller;
//import com.gz.medicine.common.util.ValidateWithException;
//import com.gz.medicine.gzyun.heaman.service.EcgService;
//
//import javax.validation.Valid;
//import javax.validation.Validator;
//
//import org.apache.log4j.Logger;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.gz.medicine.common.util.SimpleCode;
//import com.gz.medicine.common.util.SimpleResult;
//import com.gz.medicine.yun.user.request.SelUserRequest;
//
//@Controller
//@RequestMapping("/gzyunEcg")
//public class EcgController extends ValidateWithException {
//    
//    public static final Logger LOGGER = Logger.getLogger(EcgController.class);
//    
//    @Autowired
//    private EcgService ecgService;
//    @Autowired
//    Validator validator; 
//    
//    /**
//     * 对外暴露的心电测量数据新增接口
//     * @param data
//     * @return
//     */
//    @RequestMapping(value = "/gzyunAddEcg", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
//    @ResponseBody
//    public SimpleResult addEcg(@Valid SelUserRequest data ) {
//    	  SimpleResult sr=null;
//    	  String code = null;
//          try {
//        	  if(validates(validator, data)!=null){
//        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
//        	  }
//        	  code= ecgService.addEcg(data);
//		} catch (Exception e) {
//			LOGGER.error(e);
//		}
//            sr = SimpleResult.success(); 
//            sr.putData("code", code); 
//        return  sr;
//    }
//
//    
//    
//    /**
//     * 对外暴露的心电查询接口
//     * @param data
//     * @return
//     */
////    @RequestMapping(value = "/gzyunSelEcg", method = RequestMethod.POST,produces="text/html;charset=UTF-8")  
////    @ResponseBody
////    public SimpleResult user(@Valid SelUserRequest data ) {
////    	  SimpleResult sr=null;
////    	  String pwd = null;
////          try {
////        	  if(validates(validator, data)!=null){
////        		  return SimpleResult.error(SimpleCode.ERROR.getCode(), validates(validator, data)); 
////        	  }
////        	  pwd= userService.queryUser(data);
////		} catch (Exception e) {
////			LOGGER.error(e);
////		}
////            sr = SimpleResult.success(); 
////            sr.putData("pwd", pwd); 
////        return  sr;
////    }
//
//	
//}
