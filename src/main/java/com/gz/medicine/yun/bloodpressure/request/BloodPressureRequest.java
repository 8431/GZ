package com.gz.medicine.yun.bloodpressure.request;

public class BloodPressureRequest {
	 private String guid;

	    private String doctorid;

	    private String doctorname;

	    private String machineid;

	    private String unitno;

	    private String unitname;

	    private String macaddr;

	    private String recordno;

	    private String measuretime;

	    private String devicetype;

	    private String logintype;

	    private String name;

	    private String mobile;

	    private String idcode;

	    private String age;

	    private String sex;

	    private String address;

	    private String birthday;

	    private String usericon;

	    private String nation;

	    private String startdate;

	    private String enddate;

	    private String department;

	    private String barcode;

	    private String iccode;

	    private String socialcode;

	    private String userid;

	    private String height;

	    private String weight;

	    private String bmi;

	    private String idealweight;

	    private String fatrate;

	    private String fat;

	    private String exceptfat;

	    private String waterrate;

	    private String water;

	    private String minerals;

	    private String protein;

	    private String fic;

	    private String foc;

	    private String muscle;

	    private String fatadjust;

	    private String weightadjust;

	    private String muscleadjust;

	    private String basicmetabolism;

	    private String viscera;

	    private String bmc;

	    private String musclerate;

	    private String quganmuscle;

	    private String quganfat;

	    private String zuotuimuscle;

	    private String zuobimuscle;

	    private String youbimuscle;

	    private String youtuimuscle;

	    private String zuobifat;

	    private String zuotuifat;

	    private String youbifat;

	    private String youtuifat;

	    private String highpressure;

	    private String lowpressure;

	    private String pulse;

	    private String oxygen;

	    private String bpm;

	    private String oxygenlist;

	    private String bpmlist;

	    private String starttime;

	    private String endtime;

	    private String secondcount;

	    private String bloodsugartype;

	    private String schoolname;

	    private String classname;

	    private String classno;

	    private String minfat;

	    private String bloodpressure;

	    private String bo;

	    private String ecg;

	    private String peecg;

	    private String temperature;

	    private String waistline;

	    private String hipline;

	    private String whr;

	    private String result;

	    private String bloodsugar;

	    private String ua;

	    private String chol;

	    private String bloodfat;

	    private String cardiovascular;

	    private String bmd;

	    private String alcohol;

	    private String hb;

	    private String lung;

	    private String micaetery;

	    private Object createdate;

	    //----以下是新增的


	    private String heartbeat; //心跳

	    private String uro;

	    private String bld;

	    private String bil;

	    private String ket;

	    private String glu;

	    private String pro;

	    private String ph;

	    private String nit;

	    private String leu;

	    private String sg;

	    private String vc;

		private String bodyImpedance; //人体阻抗

	    private String testTime;

	    public String getGuid() {
	        return guid;
	    }

	    public void setGuid(String guid) {
	        this.guid = guid == null ? null : guid.trim();
	    }

	    public String getDoctorid() {
	        return doctorid;
	    }

	    public void setDoctorid(String doctorid) {
	        this.doctorid = doctorid == null ? null : doctorid.trim();
	    }

	    public String getDoctorname() {
	        return doctorname;
	    }

	    public void setDoctorname(String doctorname) {
	        this.doctorname = doctorname == null ? null : doctorname.trim();
	    }

	    public String getMachineid() {
	        return machineid;
	    }

	    public void setMachineid(String machineid) {
	        this.machineid = machineid == null ? null : machineid.trim();
	    }

	    public String getUnitno() {
	        return unitno;
	    }

	    public void setUnitno(String unitno) {
	        this.unitno = unitno == null ? null : unitno.trim();
	    }

	    public String getUnitname() {
	        return unitname;
	    }

	    public void setUnitname(String unitname) {
	        this.unitname = unitname == null ? null : unitname.trim();
	    }

	    public String getMacaddr() {
	        return macaddr;
	    }

	    public void setMacaddr(String macaddr) {
	        this.macaddr = macaddr == null ? null : macaddr.trim();
	    }

	    public String getRecordno() {
	        return recordno;
	    }

	    public void setRecordno(String recordno) {
	        this.recordno = recordno == null ? null : recordno.trim();
	    }

	    public String getMeasuretime() {
	        return measuretime;
	    }

	    public void setMeasuretime(String measuretime) {
	        this.measuretime = measuretime == null ? null : measuretime.trim();
	    }

	    public String getDevicetype() {
	        return devicetype;
	    }

	    public void setDevicetype(String devicetype) {
	        this.devicetype = devicetype == null ? null : devicetype.trim();
	    }

	    public String getLogintype() {
	        return logintype;
	    }

	    public void setLogintype(String logintype) {
	        this.logintype = logintype == null ? null : logintype.trim();
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name == null ? null : name.trim();
	    }

	    public String getMobile() {
	        return mobile;
	    }

	    public void setMobile(String mobile) {
	        this.mobile = mobile == null ? null : mobile.trim();
	    }

	    public String getIdcode() {
	        return idcode;
	    }

	    public void setIdcode(String idcode) {
	        this.idcode = idcode == null ? null : idcode.trim();
	    }

	    public String getAge() {
	        return age;
	    }

	    public void setAge(String age) {
	        this.age = age == null ? null : age.trim();
	    }

	    public String getSex() {
	        return sex;
	    }

	    public void setSex(String sex) {
	        this.sex = sex == null ? null : sex.trim();
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address == null ? null : address.trim();
	    }

	    public String getBirthday() {
	        return birthday;
	    }

	    public void setBirthday(String birthday) {
	        this.birthday = birthday == null ? null : birthday.trim();
	    }

	    public String getUsericon() {
	        return usericon;
	    }

	    public void setUsericon(String usericon) {
	        this.usericon = usericon == null ? null : usericon.trim();
	    }

	    public String getNation() {
	        return nation;
	    }

	    public void setNation(String nation) {
	        this.nation = nation == null ? null : nation.trim();
	    }

	    public String getStartdate() {
	        return startdate;
	    }

	    public void setStartdate(String startdate) {
	        this.startdate = startdate == null ? null : startdate.trim();
	    }

	    public String getEnddate() {
	        return enddate;
	    }

	    public void setEnddate(String enddate) {
	        this.enddate = enddate == null ? null : enddate.trim();
	    }

	    public String getDepartment() {
	        return department;
	    }

	    public void setDepartment(String department) {
	        this.department = department == null ? null : department.trim();
	    }

	    public String getBarcode() {
	        return barcode;
	    }

	    public void setBarcode(String barcode) {
	        this.barcode = barcode == null ? null : barcode.trim();
	    }

	    public String getIccode() {
	        return iccode;
	    }

	    public void setIccode(String iccode) {
	        this.iccode = iccode == null ? null : iccode.trim();
	    }

	    public String getSocialcode() {
	        return socialcode;
	    }

	    public void setSocialcode(String socialcode) {
	        this.socialcode = socialcode == null ? null : socialcode.trim();
	    }

	    public String getUserid() {
	        return userid;
	    }

	    public void setUserid(String userid) {
	        this.userid = userid == null ? null : userid.trim();
	    }

	    public String getHeight() {
	        return height;
	    }

	    public void setHeight(String height) {
	        this.height = height == null ? null : height.trim();
	    }

	    public String getWeight() {
	        return weight;
	    }

	    public void setWeight(String weight) {
	        this.weight = weight == null ? null : weight.trim();
	    }

	    public String getBmi() {
	        return bmi;
	    }

	    public void setBmi(String bmi) {
	        this.bmi = bmi == null ? null : bmi.trim();
	    }

	    public String getIdealweight() {
	        return idealweight;
	    }

	    public void setIdealweight(String idealweight) {
	        this.idealweight = idealweight == null ? null : idealweight.trim();
	    }

	    public String getFatrate() {
	        return fatrate;
	    }

	    public void setFatrate(String fatrate) {
	        this.fatrate = fatrate == null ? null : fatrate.trim();
	    }

	    public String getFat() {
	        return fat;
	    }

	    public void setFat(String fat) {
	        this.fat = fat == null ? null : fat.trim();
	    }

	    public String getExceptfat() {
	        return exceptfat;
	    }

	    public void setExceptfat(String exceptfat) {
	        this.exceptfat = exceptfat == null ? null : exceptfat.trim();
	    }

	    public String getWaterrate() {
	        return waterrate;
	    }

	    public void setWaterrate(String waterrate) {
	        this.waterrate = waterrate == null ? null : waterrate.trim();
	    }

	    public String getWater() {
	        return water;
	    }

	    public void setWater(String water) {
	        this.water = water == null ? null : water.trim();
	    }

	    public String getMinerals() {
	        return minerals;
	    }

	    public void setMinerals(String minerals) {
	        this.minerals = minerals == null ? null : minerals.trim();
	    }

	    public String getProtein() {
	        return protein;
	    }

	    public void setProtein(String protein) {
	        this.protein = protein == null ? null : protein.trim();
	    }

	    public String getFic() {
	        return fic;
	    }

	    public void setFic(String fic) {
	        this.fic = fic == null ? null : fic.trim();
	    }

	    public String getFoc() {
	        return foc;
	    }

	    public void setFoc(String foc) {
	        this.foc = foc == null ? null : foc.trim();
	    }

	    public String getMuscle() {
	        return muscle;
	    }

	    public void setMuscle(String muscle) {
	        this.muscle = muscle == null ? null : muscle.trim();
	    }

	    public String getFatadjust() {
	        return fatadjust;
	    }

	    public void setFatadjust(String fatadjust) {
	        this.fatadjust = fatadjust == null ? null : fatadjust.trim();
	    }

	    public String getWeightadjust() {
	        return weightadjust;
	    }

	    public void setWeightadjust(String weightadjust) {
	        this.weightadjust = weightadjust == null ? null : weightadjust.trim();
	    }

	    public String getMuscleadjust() {
	        return muscleadjust;
	    }

	    public void setMuscleadjust(String muscleadjust) {
	        this.muscleadjust = muscleadjust == null ? null : muscleadjust.trim();
	    }

	    public String getBasicmetabolism() {
	        return basicmetabolism;
	    }

	    public void setBasicmetabolism(String basicmetabolism) {
	        this.basicmetabolism = basicmetabolism == null ? null : basicmetabolism.trim();
	    }

	    public String getViscera() {
	        return viscera;
	    }

	    public void setViscera(String viscera) {
	        this.viscera = viscera == null ? null : viscera.trim();
	    }

	    public String getBmc() {
	        return bmc;
	    }

	    public void setBmc(String bmc) {
	        this.bmc = bmc == null ? null : bmc.trim();
	    }

	    public String getMusclerate() {
	        return musclerate;
	    }

	    public void setMusclerate(String musclerate) {
	        this.musclerate = musclerate == null ? null : musclerate.trim();
	    }

	    public String getQuganmuscle() {
	        return quganmuscle;
	    }

	    public void setQuganmuscle(String quganmuscle) {
	        this.quganmuscle = quganmuscle == null ? null : quganmuscle.trim();
	    }

	    public String getQuganfat() {
	        return quganfat;
	    }

	    public void setQuganfat(String quganfat) {
	        this.quganfat = quganfat == null ? null : quganfat.trim();
	    }

	    public String getZuotuimuscle() {
	        return zuotuimuscle;
	    }

	    public void setZuotuimuscle(String zuotuimuscle) {
	        this.zuotuimuscle = zuotuimuscle == null ? null : zuotuimuscle.trim();
	    }

	    public String getZuobimuscle() {
	        return zuobimuscle;
	    }

	    public void setZuobimuscle(String zuobimuscle) {
	        this.zuobimuscle = zuobimuscle == null ? null : zuobimuscle.trim();
	    }

	    public String getYoubimuscle() {
	        return youbimuscle;
	    }

	    public void setYoubimuscle(String youbimuscle) {
	        this.youbimuscle = youbimuscle == null ? null : youbimuscle.trim();
	    }

	    public String getYoutuimuscle() {
	        return youtuimuscle;
	    }

	    public void setYoutuimuscle(String youtuimuscle) {
	        this.youtuimuscle = youtuimuscle == null ? null : youtuimuscle.trim();
	    }

	    public String getZuobifat() {
	        return zuobifat;
	    }

	    public void setZuobifat(String zuobifat) {
	        this.zuobifat = zuobifat == null ? null : zuobifat.trim();
	    }

	    public String getZuotuifat() {
	        return zuotuifat;
	    }

	    public void setZuotuifat(String zuotuifat) {
	        this.zuotuifat = zuotuifat == null ? null : zuotuifat.trim();
	    }

	    public String getYoubifat() {
	        return youbifat;
	    }

	    public void setYoubifat(String youbifat) {
	        this.youbifat = youbifat == null ? null : youbifat.trim();
	    }

	    public String getYoutuifat() {
	        return youtuifat;
	    }

	    public void setYoutuifat(String youtuifat) {
	        this.youtuifat = youtuifat == null ? null : youtuifat.trim();
	    }

	    public String getHighpressure() {
	        return highpressure;
	    }

	    public void setHighpressure(String highpressure) {
	        this.highpressure = highpressure == null ? null : highpressure.trim();
	    }

	    public String getLowpressure() {
	        return lowpressure;
	    }

	    public void setLowpressure(String lowpressure) {
	        this.lowpressure = lowpressure == null ? null : lowpressure.trim();
	    }

	    public String getPulse() {
	        return pulse;
	    }

	    public void setPulse(String pulse) {
	        this.pulse = pulse == null ? null : pulse.trim();
	    }

	    public String getOxygen() {
	        return oxygen;
	    }

	    public void setOxygen(String oxygen) {
	        this.oxygen = oxygen == null ? null : oxygen.trim();
	    }

	    public String getBpm() {
	        return bpm;
	    }

	    public void setBpm(String bpm) {
	        this.bpm = bpm == null ? null : bpm.trim();
	    }

	    public String getOxygenlist() {
	        return oxygenlist;
	    }

	    public void setOxygenlist(String oxygenlist) {
	        this.oxygenlist = oxygenlist == null ? null : oxygenlist.trim();
	    }

	    public String getBpmlist() {
	        return bpmlist;
	    }

	    public void setBpmlist(String bpmlist) {
	        this.bpmlist = bpmlist == null ? null : bpmlist.trim();
	    }

	    public String getStarttime() {
	        return starttime;
	    }

	    public void setStarttime(String starttime) {
	        this.starttime = starttime == null ? null : starttime.trim();
	    }

	    public String getEndtime() {
	        return endtime;
	    }

	    public void setEndtime(String endtime) {
	        this.endtime = endtime == null ? null : endtime.trim();
	    }

	    public String getSecondcount() {
	        return secondcount;
	    }

	    public void setSecondcount(String secondcount) {
	        this.secondcount = secondcount == null ? null : secondcount.trim();
	    }

	    public String getBloodsugartype() {
	        return bloodsugartype;
	    }

	    public void setBloodsugartype(String bloodsugartype) {
	        this.bloodsugartype = bloodsugartype == null ? null : bloodsugartype.trim();
	    }

	    public String getSchoolname() {
	        return schoolname;
	    }

	    public void setSchoolname(String schoolname) {
	        this.schoolname = schoolname == null ? null : schoolname.trim();
	    }

	    public String getClassname() {
	        return classname;
	    }

	    public void setClassname(String classname) {
	        this.classname = classname == null ? null : classname.trim();
	    }

	    public String getClassno() {
	        return classno;
	    }

	    public void setClassno(String classno) {
	        this.classno = classno == null ? null : classno.trim();
	    }

	    public String getMinfat() {
	        return minfat;
	    }

	    public void setMinfat(String minfat) {
	        this.minfat = minfat == null ? null : minfat.trim();
	    }

	    public String getBloodpressure() {
	        return bloodpressure;
	    }

	    public void setBloodpressure(String bloodpressure) {
	        this.bloodpressure = bloodpressure == null ? null : bloodpressure.trim();
	    }

	    public String getBo() {
	        return bo;
	    }

	    public void setBo(String bo) {
	        this.bo = bo == null ? null : bo.trim();
	    }

	    public String getEcg() {
	        return ecg;
	    }

	    public void setEcg(String ecg) {
	        this.ecg = ecg == null ? null : ecg.trim();
	    }

	    public String getPeecg() {
	        return peecg;
	    }

	    public void setPeecg(String peecg) {
	        this.peecg = peecg == null ? null : peecg.trim();
	    }

	    public String getTemperature() {
	        return temperature;
	    }

	    public void setTemperature(String temperature) {
	        this.temperature = temperature == null ? null : temperature.trim();
	    }

	    public String getWaistline() {
	        return waistline;
	    }

	    public void setWaistline(String waistline) {
	        this.waistline = waistline == null ? null : waistline.trim();
	    }

	    public String getHipline() {
	        return hipline;
	    }

	    public void setHipline(String hipline) {
	        this.hipline = hipline == null ? null : hipline.trim();
	    }

	    public String getWhr() {
	        return whr;
	    }

	    public void setWhr(String whr) {
	        this.whr = whr == null ? null : whr.trim();
	    }

	    public String getResult() {
	        return result;
	    }

	    public void setResult(String result) {
	        this.result = result == null ? null : result.trim();
	    }

	    public String getBloodsugar() {
	        return bloodsugar;
	    }

	    public void setBloodsugar(String bloodsugar) {
	        this.bloodsugar = bloodsugar == null ? null : bloodsugar.trim();
	    }

	    public String getUa() {
	        return ua;
	    }

	    public void setUa(String ua) {
	        this.ua = ua == null ? null : ua.trim();
	    }

	    public String getChol() {
	        return chol;
	    }

	    public void setChol(String chol) {
	        this.chol = chol == null ? null : chol.trim();
	    }

	    public String getBloodfat() {
	        return bloodfat;
	    }

	    public void setBloodfat(String bloodfat) {
	        this.bloodfat = bloodfat == null ? null : bloodfat.trim();
	    }

	    public String getCardiovascular() {
	        return cardiovascular;
	    }

	    public void setCardiovascular(String cardiovascular) {
	        this.cardiovascular = cardiovascular == null ? null : cardiovascular.trim();
	    }

	    public String getBmd() {
	        return bmd;
	    }

	    public void setBmd(String bmd) {
	        this.bmd = bmd == null ? null : bmd.trim();
	    }

	    public String getAlcohol() {
	        return alcohol;
	    }

	    public void setAlcohol(String alcohol) {
	        this.alcohol = alcohol == null ? null : alcohol.trim();
	    }

	    public String getHb() {
	        return hb;
	    }

	    public void setHb(String hb) {
	        this.hb = hb == null ? null : hb.trim();
	    }

	    public String getLung() {
	        return lung;
	    }

	    public void setLung(String lung) {
	        this.lung = lung == null ? null : lung.trim();
	    }

	    public String getMicaetery() {
	        return micaetery;
	    }

	    public void setMicaetery(String micaetery) {
	        this.micaetery = micaetery == null ? null : micaetery.trim();
	    }

	    public Object getCreatedate() {
	        return createdate;
	    }

	    public void setCreatedate(Object createdate) {
	        this.createdate = createdate;
	    }
		private String hr;
		public String getHr() {
	return hr;
}

		public void setHr(String hr) {
	this.hr = hr;
}


		public String getHeartbeat() {
			return heartbeat;
		}

		public void setHeartbeat(String heartbeat) {
			this.heartbeat = heartbeat;
		}

		public String getUro() {
			return uro;
		}

		public void setUro(String uro) {
			this.uro = uro;
		}

		public String getBld() {
			return bld;
		}

		public void setBld(String bld) {
			this.bld = bld;
		}

		public String getBil() {
			return bil;
		}

		public void setBil(String bil) {
			this.bil = bil;
		}

		public String getKet() {
			return ket;
		}

		public void setKet(String ket) {
			this.ket = ket;
		}

		public String getGlu() {
			return glu;
		}

		public void setGlu(String glu) {
			this.glu = glu;
		}

		public String getPro() {
			return pro;
		}

		public void setPro(String pro) {
			this.pro = pro;
		}

		public String getPh() {
			return ph;
		}

		public void setPh(String ph) {
			this.ph = ph;
		}

		public String getNit() {
			return nit;
		}

		public void setNit(String nit) {
			this.nit = nit;
		}

		public String getLeu() {
			return leu;
		}

		public void setLeu(String leu) {
			this.leu = leu;
		}

		public String getSg() {
			return sg;
		}

		public void setSg(String sg) {
			this.sg = sg;
		}

		public String getVc() {
			return vc;
		}

		public void setVc(String vc) {
			this.vc = vc;
		}

		public String getBodyImpedance() {
			return bodyImpedance;
		}

		public void setBodyImpedance(String bodyImpedance) {
			this.bodyImpedance = bodyImpedance;
		}

		public String getTestTime() {
			return testTime;
		}

		public void setTestTime(String testTime) {
			this.testTime = testTime;
		}


	@Override
	public String toString() {
		return "BloodPressureRequest{" +
				"guid='" + guid + '\'' +
				", doctorid='" + doctorid + '\'' +
				", doctorname='" + doctorname + '\'' +
				", machineid='" + machineid + '\'' +
				", unitno='" + unitno + '\'' +
				", unitname='" + unitname + '\'' +
				", macaddr='" + macaddr + '\'' +
				", recordno='" + recordno + '\'' +
				", measuretime='" + measuretime + '\'' +
				", devicetype='" + devicetype + '\'' +
				", logintype='" + logintype + '\'' +
				", name='" + name + '\'' +
				", mobile='" + mobile + '\'' +
				", idcode='" + idcode + '\'' +
				", age='" + age + '\'' +
				", sex='" + sex + '\'' +
				", address='" + address + '\'' +
				", birthday='" + birthday + '\'' +
				", usericon='" + usericon + '\'' +
				", nation='" + nation + '\'' +
				", startdate='" + startdate + '\'' +
				", enddate='" + enddate + '\'' +
				", department='" + department + '\'' +
				", barcode='" + barcode + '\'' +
				", iccode='" + iccode + '\'' +
				", socialcode='" + socialcode + '\'' +
				", userid='" + userid + '\'' +
				", height='" + height + '\'' +
				", weight='" + weight + '\'' +
				", bmi='" + bmi + '\'' +
				", idealweight='" + idealweight + '\'' +
				", fatrate='" + fatrate + '\'' +
				", fat='" + fat + '\'' +
				", exceptfat='" + exceptfat + '\'' +
				", waterrate='" + waterrate + '\'' +
				", water='" + water + '\'' +
				", minerals='" + minerals + '\'' +
				", protein='" + protein + '\'' +
				", fic='" + fic + '\'' +
				", foc='" + foc + '\'' +
				", muscle='" + muscle + '\'' +
				", fatadjust='" + fatadjust + '\'' +
				", weightadjust='" + weightadjust + '\'' +
				", muscleadjust='" + muscleadjust + '\'' +
				", basicmetabolism='" + basicmetabolism + '\'' +
				", viscera='" + viscera + '\'' +
				", bmc='" + bmc + '\'' +
				", musclerate='" + musclerate + '\'' +
				", quganmuscle='" + quganmuscle + '\'' +
				", quganfat='" + quganfat + '\'' +
				", zuotuimuscle='" + zuotuimuscle + '\'' +
				", zuobimuscle='" + zuobimuscle + '\'' +
				", youbimuscle='" + youbimuscle + '\'' +
				", youtuimuscle='" + youtuimuscle + '\'' +
				", zuobifat='" + zuobifat + '\'' +
				", zuotuifat='" + zuotuifat + '\'' +
				", youbifat='" + youbifat + '\'' +
				", youtuifat='" + youtuifat + '\'' +
				", highpressure='" + highpressure + '\'' +
				", lowpressure='" + lowpressure + '\'' +
				", pulse='" + pulse + '\'' +
				", oxygen='" + oxygen + '\'' +
				", bpm='" + bpm + '\'' +
				", oxygenlist='" + oxygenlist + '\'' +
				", bpmlist='" + bpmlist + '\'' +
				", starttime='" + starttime + '\'' +
				", endtime='" + endtime + '\'' +
				", secondcount='" + secondcount + '\'' +
				", bloodsugartype='" + bloodsugartype + '\'' +
				", schoolname='" + schoolname + '\'' +
				", classname='" + classname + '\'' +
				", classno='" + classno + '\'' +
				", minfat='" + minfat + '\'' +
				", bloodpressure='" + bloodpressure + '\'' +
				", bo='" + bo + '\'' +
				", ecg='" + ecg + '\'' +
				", peecg='" + peecg + '\'' +
				", temperature='" + temperature + '\'' +
				", waistline='" + waistline + '\'' +
				", hipline='" + hipline + '\'' +
				", whr='" + whr + '\'' +
				", result='" + result + '\'' +
				", bloodsugar='" + bloodsugar + '\'' +
				", ua='" + ua + '\'' +
				", chol='" + chol + '\'' +
				", bloodfat='" + bloodfat + '\'' +
				", cardiovascular='" + cardiovascular + '\'' +
				", bmd='" + bmd + '\'' +
				", alcohol='" + alcohol + '\'' +
				", hb='" + hb + '\'' +
				", lung='" + lung + '\'' +
				", micaetery='" + micaetery + '\'' +
				", createdate=" + createdate +
				", heartbeat='" + heartbeat + '\'' +
				", uro='" + uro + '\'' +
				", bld='" + bld + '\'' +
				", bil='" + bil + '\'' +
				", ket='" + ket + '\'' +
				", glu='" + glu + '\'' +
				", pro='" + pro + '\'' +
				", ph='" + ph + '\'' +
				", nit='" + nit + '\'' +
				", leu='" + leu + '\'' +
				", sg='" + sg + '\'' +
				", vc='" + vc + '\'' +
				", bodyImpedance='" + bodyImpedance + '\'' +
				", testTime='" + testTime + '\'' +
				", hr='" + hr + '\'' +
				'}';
	}
}
