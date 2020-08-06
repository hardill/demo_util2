package com.demo.mail;

import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

@Component
@Slf4j
public class EmailUtils {

    private static String auth = "true";
    private static String host = "smtp.qq.com";
    private static String protocol = "smtp";
    private static int port = 465;
    private static String authName = "2622991031@qq.com";
    private static String password = "mnaxyrhlliyrebjg";
    private static boolean isSSL = true;
    private static String charset = "UTF-8";
    private static String timeout = "5000";

    /**
     * 发送邮件
     *
     * @param subject     主题
     * @param toUsers     收件人
     * @param ccUsers     抄送
     * @param content     邮件内容
     * @param attachfiles 附件列表  List<Map<String, String>> key: name && file
     */
    public static boolean sendEmail(String subject, String[] toUsers, String[] ccUsers, String content, List<Map<String, String>> attachfiles) {
        boolean flag = true;
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setHost(host);
            javaMailSender.setUsername(authName);
            javaMailSender.setPassword(password);
            javaMailSender.setDefaultEncoding(charset);
            javaMailSender.setProtocol(protocol);
            javaMailSender.setPort(port);

            Properties properties = new Properties();
            properties.setProperty("mail.smtp.auth", auth);
            properties.setProperty("mail.smtp.timeout", timeout);
            if (isSSL) {
                MailSSLSocketFactory sf = null;
                try {
                    sf = new MailSSLSocketFactory();
                    sf.setTrustAllHosts(true);
                    properties.put("mail.smtp.ssl.enable", "true");
                    properties.put("mail.smtp.ssl.socketFactory", sf);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
            javaMailSender.setJavaMailProperties(properties);

            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true);
            messageHelper.setTo(toUsers);
            if (ccUsers != null && ccUsers.length > 0) {
                messageHelper.setCc(ccUsers);
            }
            messageHelper.setFrom(authName);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            if (attachfiles != null && attachfiles.size() > 0) {
                for (Map<String, String> attachfile : attachfiles) {
                    String attachfileName = attachfile.get("name");
                    File file = new File(attachfile.get("file"));
                    messageHelper.addAttachment(attachfileName, file);
                }
            }
            javaMailSender.send(mailMessage);

        } catch (Exception e) {
            log.error("发送邮件失败!", e);
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        /*boolean isSend = EmailUtils.sendEmail("这是一封测试邮件",
                new String[]{"hardill0906@163.com"}, null,
                "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);*/

        //System.out.println(validEmail("hardill0906@163.com"));

        BigDecimal q = new BigDecimal("24");
        BigDecimal p = new BigDecimal("39.88");
        BigDecimal a = q.multiply(p);
        System.out.println(a);
    }

    private static boolean validEmail(String email) {
        String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
        return Pattern.compile(regex).matcher(email).find();
    }

}