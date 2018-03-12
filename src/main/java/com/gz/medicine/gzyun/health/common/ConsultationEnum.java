package com.gz.medicine.gzyun.health.common;

public enum ConsultationEnum {
	ALL_TYPE(1, "所有"),
	IMAGW_TEXT_TYPE(2, "图文咨询"), 
	VOICE_CONSULTING(3, "语音咨询"),
    VIDEO_CONSULTATION(4, "视频咨询") ;  
    
    int value;  
    String name;  
      
    ConsultationEnum(int value, String name) {  
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
