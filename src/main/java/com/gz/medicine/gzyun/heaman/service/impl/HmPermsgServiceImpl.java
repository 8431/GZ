package com.gz.medicine.gzyun.heaman.service.impl;





import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gz.medicine.common.exception.CommonException;
import com.gz.medicine.common.util.DateUtils;
import com.gz.medicine.gzyun.heaman.bean.HmPermsgRecord;
import com.gz.medicine.gzyun.heaman.mapper.HmPermsgRecordMapper;
import com.gz.medicine.gzyun.heaman.reponse.HmPermsgReponse;
import com.gz.medicine.gzyun.heaman.request.HmPermsgRequest;
import com.gz.medicine.gzyun.heaman.service.HmPermsgService;


/**
 * 健康指数
 * jin
 * **/

@Service
public class HmPermsgServiceImpl implements HmPermsgService {
    
    @Autowired
   private HmPermsgRecordMapper permsgMapper;

    /**
     * 查询
     */


	public HmPermsgReponse select(HmPermsgRequest data) throws CommonException {
		HmPermsgReponse permsg = new HmPermsgReponse();
		
		try {
				int healindex = 0;		//健康指数（总分）
				String healState = null;//健康评判（健康、亚健康）
				int integrity = 0;		//完整度
				int a = 0;//身高体重比评分
				int b = 0;//病史评分
				int c = 0;//既往史评分
				int d = 0;//手术外伤评分
				int e = 0;//药物过敏评分
				int f = 0;//食物过敏评分
				int g = 0;//吸烟
				int h = 0;//饮酒
				int i = 0;//其他生活状态评分
				int j = 0;//完整度评分
				
				HmPermsgRecord permsgrec = permsgMapper.select(data);
				if(permsgrec!=null){
					
						BeanUtils.copyProperties(permsgrec,permsg);
						Double heightDouble = Double.valueOf(permsgrec.getHeight());
						Double weightDouble = Double.valueOf(permsgrec.getWeight());
						int xbnum = permsgrec.getXbs().split("、").length;
						int jwsnum = permsgrec.getJws().split("、").length;
						int surnum = permsgrec.getSurgery().split("、").length;
						int drunum = permsgrec.getDrugallergy().split("、").length;
						int foonum = permsgrec.getFoodallergy().split("、").length;
						int livnum = permsgrec.getLivinghabits().split("、").length;
						
				 if(permsgrec.getHeight()!=""&&permsgrec.getWeight()!=""&&heightDouble!=0){
					 Double hei = heightDouble/100;
					 Double bmi = weightDouble/(hei*hei);
					 if(bmi<18.5){
							a = 10;
						}if(bmi>=18.5&&bmi<24){
							a = 15;
						}if(bmi>=24&&bmi<28){
							a = 5;
						}if(bmi>=28){
							a = 0;
						}
					}else{
						a = 0;
						integrity++;
					}
				 
				 if(permsgrec.getXbs()!=""){
					 if(xbnum==1){
							b = 10;
						}
						if(xbnum==2){
							b = 5;
						}
						if(xbnum>=3){
							b = 0;
						}
						if(permsgrec.getXbs()=="暂无"){
							b = 15;
						}
						
					}else{
						b = 0;
						integrity++;
					}
					
				if(permsgrec.getJws()!=""){
						if(jwsnum==1){
							c = 10;
						}if(jwsnum==2){
							c = 5;
						}
						if(jwsnum>=3){
							c = 0;
						}
						if(permsgrec.getJws()=="暂无"){
							c = 15;
						}
						
					}else{
							c = 0;
							integrity++;
						}
				
				if(permsgrec.getSurgery()!=""){
						if(surnum==1){
							d = 5;
						}if(surnum >=2){
							d = 0;
						}
						if(permsgrec.getSurgery()=="暂无"){
							d = 10;
						}
					
					}else{
						d = 0;
						integrity++;
					}
					
				if(permsgrec.getDrugallergy()!=""){
						if(drunum==1){
							e = 3;
						}if(drunum>=2){
							e = 0;
						}
						if(permsgrec.getDrugallergy()=="暂无"){
							e = 5;
						}
					
					}else{
						e = 0;
						integrity++;
					}
				
				if(permsgrec.getFoodallergy()!=""){
						if(foonum==1){
							f = 3;
						}if(foonum>=2){
							f = 0;
						}
						if(permsgrec.getFoodallergy()=="暂无"){
							f = 5;
						}
					
					}else{
						f = 0;
						integrity++;
					}
				
				if(permsgrec.getSmoke()!=""){
						if(permsgrec.getSmoke()=="从不吸烟"){
							g = 10;
						}if(permsgrec.getSmoke()=="已戒烟"){
							g = 5;
						}if(permsgrec.getSmoke()=="吸烟"){
							g = 0;
						} 
					}else{
						g = 0;
						integrity++;
					}
				
				if(permsgrec.getDrink()!=""){
						if(permsgrec.getDrink()=="从不饮酒"){
							h = 10;
						}if(permsgrec.getDrink()=="已戒酒"){
							h = 5;
						}if(permsgrec.getDrink()=="饮酒"){
							h = 0;
						}
					}else{
						h = 0;
						integrity++;
					}
				
				if(permsgrec.getLivinghabits()!=""){
						if(livnum<6){
							i = 10 - 2*livnum;
						}if(livnum==6){
							i = 0;
						}
					}
					else{
						i = 0;
						integrity++;
					}
					if(permsgrec.getLivinghabits()=="暂无"){
						i = 10;
					}
					
					if(integrity<=1){
						j = 5;	
					}if(integrity==2){
						j = 3;
					}else if(integrity>=3){
						j = 0;
					}
					
						healindex = a+b+c+d+e+f+g+h+i+j;
					if(healindex>=80){
						
						permsg.setHealindex(healindex);
						permsg.setHealState("您的身体处于健康状态");	
						permsg.setHealState1("请保持当前生活状态");
					}else{
						
						permsg.setHealindex(healindex);
						permsg.setHealState("您的身体处于亚健康状态");
						permsg.setHealState1("需要改善当前的生活方式");
					}
				}else{
					permsg.setHealindex(0);
					permsg.setHealState("您暂无健康指数");
					permsg.setHealState1("请完善健康档案信息");
					
				}
		} catch (Exception e) {
			throw new CommonException("COM001","在整合方法中，出现异常",e);
		}
		return permsg;
	}


	
}
