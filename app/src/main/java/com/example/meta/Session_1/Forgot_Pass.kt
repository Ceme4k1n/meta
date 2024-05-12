package com.example.meta.Session_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.meta.R
import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

private const val SMTP_HOST = "smtp.gmail.com"
private const val SMTP_PORT = "587"
private const val SENDER_EMAIL = "gigahrush75@gmail.com"
private const val SENDER_PASSWORD = "Gigahrush75#!"

class Forgot_Pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        val email: EditText = findViewById(R.id.email)
        val subject = "Код на подтверждение"
        val emailText = "123456"
        val ent: Button = findViewById(R.id.enterButton)
        val fckGoBack: Button = findViewById(R.id.createButton)

        ent.setOnClickListener {
            if (email.text.isNotEmpty()) {
                sendEmail(email.text.toString(), subject, emailText)
                goshaDaun()
            }
        }

        fckGoBack.setOnClickListener {
            fuckGoBack()
        }
    }

    private fun fuckGoBack() {
        val intent = Intent(this, Registry::class.java)
        startActivity(intent)
    }

    private fun goshaDaun() {
        val intent = Intent(this, OTP_Verrif::class.java)
        startActivity(intent)
    }


    private fun sendEmail(recipient: String, subject: String, emailText: String) {
        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = SMTP_HOST
        props["mail.smtp.port"] = SMTP_PORT

        val session = Session.getInstance(props, object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD)
            }
        })

        try {
            val message = MimeMessage(session)
            message.setFrom(InternetAddress(SENDER_EMAIL))
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient))
            message.subject = subject
            message.setText(emailText)

            Transport.send(message)
            println("Email sent successfully.")
        } catch (e: MessagingException) {
            println("Failed to send email. Error: ${e.message}")
        }
    }
}
