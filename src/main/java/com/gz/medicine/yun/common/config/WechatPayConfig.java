package com.gz.medicine.yun.common.config;

/** 微信配置公共参数
 * Created by fendo on 2017/9/18.
 */
public class WechatPayConfig {

    public static final String ORDER_PAY = "https://api.mch.weixin.qq.com/pay/unifiedorder"; // 统一下单

    public static final String ORDER_PAY_QUERY = "https://api.mch.weixin.qq.com/pay/orderquery"; // 支付订单查询

    public static final String ORDER_REFUND = "https://api.mch.weixin.qq.com/secapi/pay/refund"; // 申请退款

    public static final String ORDER_REFUND_QUERY = "https://api.mch.weixin.qq.com/pay/refundquery"; // 申请退款

    //微信支付成功后通知地址 必须要求80端口并且地址不能带参数
    //public static final String NOTIFY_URL="http://2312892206.tunnel.echomod.cn/GZ/wechatpay/pay/notify"; //异步通知地址
    //public static final String NOTIFY_URL="https://tsch.fromfuture.cn:7021/GZ/wechatpay/pay/notify"; //异步通知地址
    public static final String NOTIFY_URL="https://tsch.fromfuture.cn:7712/GZ/wechatpay/pay/notify";  //测试
    //public static final String NOTIFY_URL="https://xlzx.fromfuture.cn/GZ/wechatpay/pay/notify";  //正式

    public static final String APP_ID = "wxaa4d20511f1df045";//微信认证的自己应用ID

    public static final String MCH_ID = "1483590632";//商户id

    public static final String API_KEY=""; //API密钥

    public static final String API_SECRET ="UNBcVGKSWnXa411pkmfqq6whxv9IZ45G";//服务号的应用密码

    public final static String CERT_PATH = "D:/apiclient_cert.p12";//微信支付证书存放路径地址
}
