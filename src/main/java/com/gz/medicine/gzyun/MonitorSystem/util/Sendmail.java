package com.gz.medicine.gzyun.MonitorSystem.util;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Created by Administrator on 2017/10/16 0016.
 */
public class Sendmail {

    // 主机地址
    private static String host = "smtp.163.com";
    // 发件人，填写你的邮箱账号
    private static String from = "15779102820@163.com";
    // 发件人密码，填写你自己的邮箱密码
    private static String password = "qq16899199";
    /***发件正文***/
    private static String link = "http://192.168.0.119:8080/";

    private static String getContent(String link){
        String content = "<h3>这是一封转到Tomcat服务器主页的测试邮件，点击此链接进行测试！</h3>"
                + "<a href='"+ link +"'>点此激活</a>";
        return content ;
    }

    public static void sendEmail(String to, String sub,String content) {

        /*** 1、创建Session ***/
        Properties props = new Properties();
        // 开启调试模式
        props.setProperty("mail.debug", "true");
        // 发送主机需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置主机名称
        props.setProperty("mail.host", host);
        // 设置主机端口
        props.setProperty("mail.port", "25");
        // 发送协议名称
        props.setProperty("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(props);
        /*** 2、创建邮件对象 ***/
        Message msg = new MimeMessage(session);
        try {
            // 设置发件人
            msg.setFrom(new InternetAddress(from));
            // 设置标题
            msg.setSubject(sub);
            // 设置内容
            msg.setContent(content, "text/html;charset=UTF-8");
            /*** 3、发送邮件 ***/
            Transport transport = session.getTransport();
            transport.connect(from, password);
            transport.sendMessage(msg, new Address[] { new InternetAddress(to) });
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        sendEmail("1429264916@qq.com","测试", getContent(link + "index.action"));
    }
}
