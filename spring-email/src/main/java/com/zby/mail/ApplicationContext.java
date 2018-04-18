package com.zby.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * 发不起
 * 
 * @author zhoubaiyun
 *
 */
public class ApplicationContext {

	public static void main(String[] args) {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");// 指定用来发送Email的邮件服务器主机名
		mailSender.setPort(587);// 默认端口，标准的SMTP端口
		mailSender.setUsername("1181905571@qq.com");// 用户名
		mailSender.setPassword("irjgxjrhcdhrjijj");// 密码
		SimpleMailMessage message = new SimpleMailMessage();// 消息构造器
		message.setFrom("1181905571@qq.com");// 发件人
		message.setTo("1181905571@qq.com");// 收件人
		message.setSubject("Spring Email Test");// 主题
		message.setText("hello world!!");// 正文
		mailSender.send(message);
		System.out.println("邮件发送完毕");

	}

}
