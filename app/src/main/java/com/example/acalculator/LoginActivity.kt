package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener{
           if(viewModel.login(input_login_email.text.toString(),input_login_password.text.toString())){
               var intentLogin = Intent(this,MainActivity::class.java)
               var logged_user = viewModel.getLoggedUser()
               intentLogin.apply { putExtra("user_name", logged_user.name) }
               intentLogin.apply { putExtra("user_email", logged_user.email) }
               startActivity(intentLogin)
               finish()
           }
            else{
               Toast.makeText(this,"E-mail/Password inválidos", Toast.LENGTH_LONG).show()
            }
        }

        regist_login_button.setOnClickListener {
            val intent = Intent(this,  SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
