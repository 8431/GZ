package com.gz.medicine.gzyun.health.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gz.medicine.common.util.SimpleResult;
import com.gz.medicine.gzyun.health.service.HealthCommonService;

/**
 * 
 * @author zhao
 *
 */
@RestController
@RequestMapping("/common/")
public class HealthCommonController {
	
	@Autowired
	private HealthCommonService healthCommonService;
	
	@RequestMapping(value = "/querySystemParam", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public SimpleResult querySystemParam() throws Exception {
        SimpleResult sr = null;
        Map<String,Object> map=healthCommonService.querySystemTime();
        sr=SimpleResult.success();
        sr.put("data",map);
        return sr;
    }

}
