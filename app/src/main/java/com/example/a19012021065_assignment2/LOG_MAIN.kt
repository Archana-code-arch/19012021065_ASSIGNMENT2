package com.example.a19012021065_assignment2


import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.android.material.textfield.TextInputEditText

class LOG_MAIN : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_main)
        setStatusBarTransparent()
        supportActionBar?.hide()

        val layout_signup = findViewById<TextView>(R.id.layou_signup)
        val text_signup = findViewById<TextView>(R.id.text_signup)

        layout_signup.setOnClickListener {
            Intent(this, SIGN_MAIN::class.java).apply {
                startActivity(this)
            }
        }


        text_signup.setOnClickListener {
            Intent(this,SIGN_MAIN::class.java).apply {
                startActivity(this)
            }
        }
        if (LoginInfo.state == true)
        {
            Intent(this, DASHBOARD_MAIN::class.java).apply {
                startActivity(this)
            }

        }
        else
        {
            val btn_login = findViewById<AppCompatButton>(R.id.login)
            val login_email = findViewById<TextInputEditText>(R.id.email_id)
            val login_password = findViewById<TextInputEditText>(R.id.password)

            btn_login.setOnClickListener {

                if (login_email.length() == 0 || login_password.length() ==0)
                {
                    Toast.makeText(this, "Any field can't be empty!!", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    if ((login_email.text.toString() == LoginInfo.email) && (login_password.text.toString() == LoginInfo.password))
                    {
                        Intent(this, DASHBOARD_MAIN::class.java).apply {
                            startActivity(this)
                        }
                        LoginInfo.state = true
                    }
                    else
                    {
                        login_email.setText("")
                        login_password.setText("")
                        Toast.makeText( this,"Invalid Email-Id or Password!!", Toast.LENGTH_SHORT).show()

                    }
                }



            }

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

    private fun setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT in 19..20){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
                setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
            }
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean){
        val winParameters=window.attributes
        if(on) {
            winParameters.flags = winParameters.flags or bits
        }else{
            winParameters.flags=winParameters.flags and bits.inv()
        }
        window.attributes=winParameters
    }

}

