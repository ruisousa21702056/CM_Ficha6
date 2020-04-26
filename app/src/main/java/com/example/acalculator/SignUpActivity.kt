package com.example.acalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.apache.commons.codec.digest.DigestUtils

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val users = intent.getParcelableArrayListExtra<User>("users_from_login")

        submit_regist_button.setOnClickListener {
            var name = input_regist_name.text.toString()
            var email = findViewById<EditText>(R.id.input_regist_email)
            var pass = findViewById<EditText>(R.id.input_regist_password)
            var confirm_pass = findViewById<EditText>(R.id.input_regist_confirmpassword)

            if(!text_name.equals("") && !text_email.equals("") && text_pass.equals(text_confirm_pass)){
                val text_pass_aux = DigestUtils.sha256Hex(text_pass)
                val user = User(text_name,text_email, text_pass_aux)
                var usersAux = ArrayList<User>()
                if(users != null){
                    usersAux = users
                }
                usersAux.add(user)
                Toast.makeText(this,"Registo efetuado com sucesso", Toast.LENGTH_LONG).show()
                val returnIntent = Intent(this,  LoginActivity::class.java)
                returnIntent.apply {putParcelableArrayListExtra("users_from_regist", ArrayList(usersAux))}
                startActivity(returnIntent)
                finish()
            }
            else {
                Toast.makeText(this,"As passwords devem ser iguais", Toast.LENGTH_LONG).show()
            }
        }

        back_regist_button.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
