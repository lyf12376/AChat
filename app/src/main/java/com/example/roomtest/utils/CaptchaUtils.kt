package com.example.roomtest.utils

import android.util.Log
import java.net.ConnectException
import java.net.InetAddress
import java.net.Socket
import java.security.SecureRandom
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


object CaptchaUtils{
    fun generateFourDigitRandomNumber(): Int {
        val random = SecureRandom()
        Log.d("TAG", "generateFourDigitRandomNumber: ")
        return random.nextInt(9000) + 1000
    }

    fun sendCaptcha(user: String?, code: String) {
        Log.d("TAG", "sendCaptcha: ")
        val props = Properties()
        props.setProperty("mail.smtp.host","smtp.163.com")
        props.setProperty("mail.transport.protocol", "smtp")
        props["mail.smtp.port"] = "25"
        props.setProperty("mail.smtp.address", "smtp.163.com") // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true")

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication("liuyifan031117@163.com", "XPNIYJIHZEAIYCFK")
            }
        })
        try {
            val message: Message = MimeMessage(session)
            // 3.1设置发件人
            message.setFrom(InternetAddress("liuyifan031117@163.com"))
            // 3.2设置收件人
            message.setRecipient(Message.RecipientType.TO, InternetAddress(user))
            // 3.3设置邮件的主题
            message.subject = "讨论A组"
            // 3.4设置邮件的正文
            message.setContent("您的验证码是：$code", "text/html;charset=UTF-8")
            // 4.发送邮件
            Transport.send(message)
        } catch (e: MessagingException) {
            e.printStackTrace()
        }
    }

    fun test()
    {
        try {
            val address = InetAddress.getByName("smtp.163.com")
            val socket = Socket(address, 587)
            Log.d("Connected to the server successfully.","")
        } catch (e: ConnectException) {
            Log.d("Connected to the server failed.","")
        } catch (e: Exception) {
            Log.d("Connected to the server failed.","")
        }
    }
}

