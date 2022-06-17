package com.example.appsendmsm

import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var mensagem: EditText
    lateinit var numero: EditText
    var smsPara: String = ""
    var smsMensagem: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnEnviar)
        mensagem = findViewById(R.id.etxMensagem)
        numero = findViewById(R.id.etxNumero)

        button.setOnClickListener {
            smsMensagem = mensagem.text.toString()
            smsPara = numero.text.toString()

            try {
                var smsManager = SmsManager.getDefault()
                smsManager.sendTextMessage(smsPara, null, smsMensagem, null, null)
                Toast.makeText(applicationContext, "SMS Enviado...", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(applicationContext, "SMS Não Enviado...", Toast.LENGTH_LONG).show()
            }
        }
    }
}
