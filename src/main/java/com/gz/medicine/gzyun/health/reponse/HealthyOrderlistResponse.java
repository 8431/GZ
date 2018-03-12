package com.gz.medicine.gzyun.health.reponse;

import java.util.Date;

/**
 *  fendo on 2017/12/5.
 *  订单响应数据
 */
public class HealthyOrderlistResponse {

        /**
         * @Fields id 主键
         */
        private String id;
        /**
         * @Fields usrid 患者id
         */
        private String usrid;
        /**
         * @Fields docid 医生id
         */
        private String docid;
        /**
         * @Fields ordercode 系统订单编号
         */
        private String ordercode;
        /**
         * @Fields thirdordercode 第三方订单编号
         */
        private String thirdordercode;
        /**
         * @Fields paymentmethod 支付方式(微信、支付宝)1,2
         */
        private String paymentmethod;
        /**
         * @Fields consultationmethod  咨询方式（图文、语音、视频）2,3,4
         */
        private String consultationmethod;
        /**
         * @Fields orderamount 订单金额
         */
        private String orderamount;
        /**
         * @Fields orderstate 订单状态：待支付(1)、付款成功(2)、订单取消(3)、订单关闭(4)、订单完成(5)
         */
        private String orderstate;
        /**
         * @Fields consultingdescription 咨询问题描述
         */
        private String consultingdescription;
        /**
         * @Fields createdate 创建时间
         */
        private Date createdate;
        /**
         * @Fields createname 创建人
         */
        private String createname;
        /**
         * @Fields updatename 更新人
         */
        private String updatename;
        /**
         * @Fields updatedate 更新时间
         */
        private Date updatedate;
        /**
         * @Fields state 删除标记位
         */
        private String state;
        /**
         * @Fields reservationphotoid 预约图片id
         */
        private String reservationphotoid;
        /**
         * @Fields reservationdate 预约日期//2017-09-21
         */
        private String reservationdate;
        /**
         * @Fields reservationperiod 预约时段//上午，下午，晚上 ---------------废弃 by 2017-10-29
         */
        private String reservationperiod;
        /**
         * @Fields reservationtime 预约时间//10：00-11：00 ---------------废弃 by 2017-10-29
         */
        private String reservationtime;

        /**
         *  患者联系方式
         */
        private String usrphone;

        /**
         * 订单图片FTP路径ID
         */
        private String pathcode;

        /**
         * 订单表中的发票状态字段 0未开票 1已开票
         */
        private String invoicestate;


        /**
         * 患者姓名
         */
        private String username;

        /**
         * 患者性别
         */
        private  String usrsex;

        /**
         * 出生日期
         */
        private String usrbirth;

        /**
         * 预约开始时间
         */
        private String reserstarttime;

        /**
         * 预约结束时间
         */
        private String reserendtime;

        /**
         * 支付成功短信提示标志(0 未发送 1 已发送)
         */
        private String sendflag;


        private String ftpurl;

        private String docname;

        private String conid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id == null ? null : id.trim();
        }

        public String getUsrid() {
            return usrid;
        }

        public void setUsrid(String usrid) {
            this.usrid = usrid == null ? null : usrid.trim();
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid == null ? null : docid.trim();
        }

        public String getOrdercode() {
            return ordercode;
        }

        public void setOrdercode(String ordercode) {
            this.ordercode = ordercode == null ? null : ordercode.trim();
        }

        public String getThirdordercode() {
            return thirdordercode;
        }

        public void setThirdordercode(String thirdordercode) {
            this.thirdordercode = thirdordercode == null ? null : thirdordercode.trim();
        }

        public String getPaymentmethod() {
            return paymentmethod;
        }

        public void setPaymentmethod(String paymentmethod) {
            this.paymentmethod = paymentmethod == null ? null : paymentmethod.trim();
        }

        public String getConsultationmethod() {
            return consultationmethod;
        }

        public void setConsultationmethod(String consultationmethod) {
            this.consultationmethod = consultationmethod == null ? null : consultationmethod.trim();
        }

        public String getOrderamount() {
            return orderamount;
        }

        public void setOrderamount(String orderamount) {
            this.orderamount = orderamount == null ? null : orderamount.trim();
        }

        public String getOrderstate() {
            return orderstate;
        }

        public void setOrderstate(String orderstate) {
            this.orderstate = orderstate == null ? null : orderstate.trim();
        }

        public String getConsultingdescription() {
            return consultingdescription;
        }

        public void setConsultingdescription(String consultingdescription) {
            this.consultingdescription = consultingdescription == null ? null : consultingdescription.trim();
        }

        public Date getCreatedate() {
            return createdate;
        }

        public void setCreatedate(Date createdate) {
            this.createdate = createdate;
        }

        public String getCreatename() {
            return createname;
        }

        public void setCreatename(String createname) {
            this.createname = createname == null ? null : createname.trim();
        }

        public String getUpdatename() {
            return updatename;
        }

        public void setUpdatename(String updatename) {
            this.updatename = updatename == null ? null : updatename.trim();
        }

        public Date getUpdatedate() {
            return updatedate;
        }

        public void setUpdatedate(Date updatedate) {
            this.updatedate = updatedate;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state == null ? null : state.trim();
        }

        public String getReservationphotoid() {
            return reservationphotoid;
        }

        public void setReservationphotoid(String reservationphotoid) {
            this.reservationphotoid = reservationphotoid == null ? null : reservationphotoid.trim();
        }

        public String getReservationdate() {
            return reservationdate;
        }

        public void setReservationdate(String reservationdate) {
            this.reservationdate = reservationdate == null ? null : reservationdate.trim();
        }

        public String getReservationperiod() {
            return reservationperiod;
        }

        public void setReservationperiod(String reservationperiod) {
            this.reservationperiod = reservationperiod == null ? null : reservationperiod.trim();
        }

        public String getReservationtime() {
            return reservationtime;
        }

        public void setReservationtime(String reservationtime) {
            this.reservationtime = reservationtime == null ? null : reservationtime.trim();
        }

        public String getUsrphone() {
            return usrphone;
        }

        public void setUsrphone(String usrphone) {
            this.usrphone = usrphone;
        }

        public String getPathcode() {
            return pathcode;
        }

        public void setPathcode(String pathcode) {
            this.pathcode = pathcode;
        }

        public String getInvoicestate() {
            return invoicestate;
        }

        public void setInvoicestate(String invoicestate) {
            this.invoicestate = invoicestate;
        }

        public String getUsrname() {
            return username;
        }

        public void setUsrname(String username) {
            this.username = username;
        }

        public String getUsrsex() {
            return usrsex;
        }

        public void setUsrsex(String usersex) {
            this.usrsex = usersex;
        }

        public String getUsrbirth() {
            return usrbirth;
        }

        public void setUsrbirth(String usrbirth) {
            this.usrbirth = usrbirth;
        }

        public String getReserstarttime() {
            return reserstarttime;
        }

        public void setReserstarttime(String reserstarttime) {
            this.reserstarttime = reserstarttime;
        }

        public String getReserendtime() {
            return reserendtime;
        }

        public void setReserendtime(String reserendtime) {
            this.reserendtime = reserendtime;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getSendflag() {
            return sendflag;
        }

        public void setSendflag(String sendflag) {
            this.sendflag = sendflag;
        }

        public String getFtpurl() {
            return ftpurl;
        }

        public void setFtpurl(String ftpurl) {
            this.ftpurl = ftpurl;
        }


        public String getDocname() {
            return docname;
        }

        public void setDocname(String docname) {
            this.docname = docname;
        }

        public String getConid() {
            return conid;
        }

        public void setConid(String conid) {
            this.conid = conid;
        }
}
