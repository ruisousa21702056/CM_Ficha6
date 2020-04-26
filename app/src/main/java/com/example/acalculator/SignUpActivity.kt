package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.apache.commons.codec.digest.DigestUtils

class SignUpActivity : AppCompatActivity() {

    private lateinit var viewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        submit_regist_button.setOnClickListener {
            if(viewModel.signUp(input_regist_name.text.toString(), input_regist_email.text.toString(),
                input_regist_password.text.toString(), input_regist_confirmpassword.text.toString())){
                Toast.makeText(this,"Registo efetuado com sucesso", Toast.LENGTH_LONG).show()
                val returnIntent = Intent(this,  LoginActivity::class.java)
                startActivity(returnIntent)
                finish()
            }
            else {
                Toast.makeText(this,"Dados inválidos", Toast.LENGTH_LONG).show()
            }
        }

        back_regist_button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
