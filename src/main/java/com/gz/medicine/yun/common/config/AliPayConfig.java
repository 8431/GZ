package com.gz.medicine.yun.common.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;

/** 支付宝配置公共参数
 * Created by fendo on 2017/9/18.
 */
public class AliPayConfig {

        /**
         * 应用号
         */
        public static String APP_ID = "2017060807447469";

        /** 支付宝账户登录授权业务：入参pid值 */
        public static String PID="2088721233400752";
        /**
         * 商户的私钥 需要PKCS8格式，RSA公私钥生成：https://doc.open.alipay.com/doc2/detail.htm?spm=a219a.7629140.0.0.nBDxfy&treeId=58&articleId=103242&docType=1
         */
        public static String APP_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALy8FXk5LlI8OnuW6J4ZmCX0j9Ec2JzIgxng1Uex8xIaPaBI5Fnj8osuodDCthi76Y4vcvfiNOQmCbjn8h6tKASmwYOp4h3c0b1A3MJ0YrmQkBzuwwpEPx66KVNEgdb+QaQr9t9Fn5MKZRQdRskVfAhKX55ZBDk5auEEdyZXj2FxAgMBAAECgYEAhv6Q7XA07aUev5+lKtBrv1o6M/xKA3p4K15hrzJdBim2wprgmlss9NiZ7VQYI4DlAUp3FU67PiTm91cQG1kHMXEnUC9yZ1eryYxt4abVOgiyPlYVhYS/3M1MPODwtrBh5YoX3B6nSt5dimmlpr7ACVGjhntSUQmDdDMH919xxrECQQDtR+HZgctUdOH8V6J+OG1unAGneibryO4hJEhlCZYPmpCiN8RfYXNDlH7jZylmwUVIuDV3HdnNZBbFoz/vHqJ7AkEAy5/EEtBv1k9Zh6Fsp67IIqxDmi/P9O3NyXzfHHlISbh/ftaZGvUh0iv/2vUNKrSwQSFpoaZX7hwqsuN78HZOAwJAeyr8Bm7EgBOoFtfaplBeJbNffHMA7xW+3n86ARCHz5O5DiuKiMRKE8NqVlp/eDJM56GPR0S8gUw6Md862cH6LwJAbtrg5RlC+ZqjdDqGq9d0r6O2/hcvkPlyAlKQKLFCkJf4GTZ9jfaMXh6EIVEtxOUv25V0K4Qi9Mey20cLb4MIvwJAAKPRME5FLWXQtVZ79WuNUmNkK0Sd2NNn7gm4inPhQH9jOHeMXSeTlbHbgbmCvtyMkUCkPFxwyFNJ/zNmUQBzRQ==";

        public static final String RSA_PRIVATE = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8vBV5OS5SPDp7luieGZgl9I/RHNicyIMZ4NVHsfMSGj2gSORZ4/KLLqHQwrYYu+mOL3L34jTkJgm45/IerSgEpsGDqeId3NG9QNzCdGK5kJAc7sMKRD8euilTRIHW/kGkK/bfRZ+TCmUUHUbJFXwISl+eWQQ5OWrhBHcmV49hcQIDAQAB";


        /**
         * 编码
         */
        public static String CHARSET = "UTF-8";
        /**
         * 支付宝公钥
         */
        public static String ALIPAY_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";


        //网关地址
        //public static final String URL = "https://openapi.alipay.com/gateway.do"; //(正式环境)
        //public static final String URL = "https://openapi.alipaydev.com/gateway.do"; //沙箱(测试环境)
        /**
         * 支付宝网关地址
         */
        private static String GATEWAY = "https://openapi.alipay.com/gateway.do";
        /**
         * 成功付款回调
         */
        //public static String PAY_NOTIFY = "https://tsch.fromfuture.cn:7712/GZ/alipay/pay/notify";
        //public static String PAY_NOTIFY = "https://tsch.fromfuture.cn:7712/GZ/alipay/pay/notify";
        public static String PAY_NOTIFY = "http://xlzx.fromfuture.cn:7017/GZ/alipay/pay/notify";

        /**
         * 支付成功回调
         */
        //public static String REFUND_NOTIFY = "http://2312892206.tunnel.echomod.cn/GZ/alipay/pay/notify";
         //public static String REFUND_NOTIFY = "https://tsch.fromfuture.cn:7712/GZ/alipay/pay/notify";
        //public static String REFUND_NOTIFY = "http://tsch.fromfuture.cn:7012/GZ/alipay/pay/notify";
        public static String REFUND_NOTIFY = "http://xlzx.fromfuture.cn:7017/GZ/alipay/pay/notify";

        /**
         * 前台通知地址 同步跳转的页面，就是支付宝支付成功后页面跳转的url
         */
        //public static String RETURN_URL = "http://niuli.tunnel.qydev.com/notify/alipay_pay";
        //public static String RETURN_URL = "http://tsch.fromfuture.cn:7012/GZ/alipay/pay/notify";
        public static String RETURN_URL = "http://xlzx.fromfuture.cn:7017/GZ/alipay/pay/notify";

        /**
         * 参数类型
         */
        public static String PARAM_TYPE = "json";
        /**
         * 成功标识
         */
        public static final String SUCCESS_REQUEST = "TRADE_SUCCESS";
        /**
         * 交易关闭回调(当该笔订单全部退款完毕,则交易关闭)
         */
        public static final String TRADE_CLOSED = "TRADE_CLOSED";
        /**
         * 收款方账号 收款支付宝账号，以2088开头由16位纯数字组成的字符串，一般情况下收款账号就是签约账号 查看地址：https://openhome.alipay.com/platform/keyManage.htm?keyType=partner
         */
        public static final String SELLER_ID = "2088721233400752";
        /**
         * 支付宝请求客户端入口
         */
        private volatile static AlipayClient alipayClient = null;

        /**
         * 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
         */
        public static String log_path ="C://";
        /**
         * 不可实例化
         */
        private AliPayConfig(){};

        /**
         * 签名方式
         */
        public static String SIGN_TYPE = "RSA";

        /**
         * 销售产品码
         */
        public static final  String QUICK_MSECURITY_PAY="QUICK_MSECURITY_PAY";

        /**
         * 双重锁单例
         * @return 支付宝请求客户端实例
         */
        public static AlipayClient getInstance(){
            if (alipayClient == null){
                synchronized (com.gz.medicine.yun.common.config.AliPayConfig.class){
                    if (alipayClient == null){
                        //alipayClient = new DefaultAlipayClient(GATEWAY,APP_ID,APP_PRIVATE_KEY,PARAM_TYPE,CHARSET,ALIPAY_PUBLIC_KEY,sign_type);
                       alipayClient = new DefaultAlipayClient(GATEWAY,APP_ID,APP_PRIVATE_KEY,PARAM_TYPE,CHARSET,ALIPAY_PUBLIC_KEY,SIGN_TYPE);

                    }
                }
            }
            return alipayClient;
        }

    }
