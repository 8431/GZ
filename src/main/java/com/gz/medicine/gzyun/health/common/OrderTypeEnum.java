package com.gz.medicine.gzyun.health.common;

public enum OrderTypeEnum {
	PENDING_ORDER(1, "待支付"),
	SUCCESSFUL_ORDER(2, "付款成功"), 
	CANCEL_ORDER(3, "取消订单"),
	 CLOSE_ORDER(4, "订单关闭"),
	 DELETE_ORDER(5, "删除订单"),
	 UNSUBSCRIBE_ORDER(6, "订单退订");  
    
    int value;  
    String name;  
      
    OrderTypeEnum(int value, String name) {  
        this.value = value;  
        this.name = name;  
    }  
      
    public int getValue() {  
        return value;  
    }  
      
    public String getName() {  
        return name;  
    }  
}
