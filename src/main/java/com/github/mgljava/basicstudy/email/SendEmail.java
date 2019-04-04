package com.github.mgljava.basicstudy.email;

import java.util.Date;
import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

  // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
  public static String myEmailAccount = "xxx@qq.com";
  public static String myEmailPassword = "auth";
  public static String myEmailSMTPHost = "smtp.qq.com";

  // 收件人邮箱（替换为自己知道的有效邮箱）
  public static String receiveMailAccount = "xxx@qq.com";

  public static void main(String[] args) throws Exception {
    // 1. 创建参数配置, 用于连接邮件服务器的参数配置
    Properties properties = new Properties();                    // 参数配置
    properties.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
    properties.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
    properties.setProperty("mail.smtp.auth", "true");            // 需要请求认证

    // 2. 根据配置创建会话对象, 用于和邮件服务器交互
    Session session = Session.getInstance(properties);
    session.setDebug(true);

    // 3. 创建一封邮件
    MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount);

    Transport transport = session.getTransport();

    transport.connect(myEmailAccount, myEmailPassword);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }


  /**
   * 创建一封只包含文本的简单邮件
   *
   * @param session 和服务器交互的会话
   * @param sendMail 发件人邮箱
   * @param receiveMail 收件人邮箱
   */
  public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail)
      throws Exception {
    // 1. 创建一封邮件
    MimeMessage message = new MimeMessage(session);

    // 2. From: 发件人
    message.setFrom(new InternetAddress(sendMail, sendMail, "UTF-8"));

    // 3. To: 收件人
    message.setRecipient(MimeMessage.RecipientType.TO,
        new InternetAddress(receiveMail, receiveMail, "UTF-8"));

    // 4. Subject: 邮件主题
    message.setSubject("This is Subject", "UTF-8");

    // 5. Content: 邮件正文
    message.setContent("", "text/html;charset=UTF-8");

    // 6. 设置发件时间
    message.setSentDate(new Date());

    // 7. 保存设置
    message.saveChanges();

    return message;
  }
}
