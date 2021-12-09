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



class SIGN_MAIN : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_main)
        setStatusBarTransparent()
        supportActionBar?.hide()


        val layout_login = findViewById<TextView>(R.id.layout_login)




        layout_login.setOnClickListener {
            Intent(this,LOG_MAIN::class.java).apply {
                startActivity(this)

            }
        }



        val  btn_sign_up = findViewById<AppCompatButton>(R.id.sign_up)


        btn_sign_up.setOnClickListener {
            val  signup_name = findViewById<TextInputEditText>(R.id.name)
            val  signup_phone_no = findViewById<TextInputEditText>(R.id.phone)
            val  signup_city = findViewById<TextInputEditText>(R.id.city)
            val  signup_email = findViewById<TextInputEditText>(R.id.email_id)
            val  signup_password = findViewById<TextInputEditText>(R.id.password)
            val  signup_confrim_password = findViewById<TextInputEditText>(R.id.confrim_password)




            if(signup_name.length() == 0 || signup_phone_no.length() == 0 || signup_city.length() == 0 || signup_email.length() == 0 || signup_password.length() == 0)
            {
                Toast.makeText(this, "Any field can't be empty!!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                val t1 = signup_name.text.toString()
                val t2 = signup_phone_no.text.toString()
                val t3 = signup_city.text.toString()
                val t4 = signup_email.text.toString()
                val t5 = signup_password.text.toString()
                val t6 = signup_confrim_password.text.toString()

                if ((t5 == t6))
                {


                    LoginInfo.name = t1
                    LoginInfo.phone_no = t2
                    LoginInfo.city = t3
                    LoginInfo.email = t4
                    LoginInfo.password =t5
                    LoginInfo.confirm_password = t6


                    Intent(this, LOG_MAIN::class.java).apply {
                        startActivity(this)
                    }
                    Toast.makeText( this,"Successfully Registered!!", Toast.LENGTH_SHORT).show()

                }
                else
                {
                    signup_name.setText("")
                    signup_phone_no.setText("")
                    signup_city.setText("")
                    signup_email.setText("")
                    signup_password.setText("")
                    signup_confrim_password.setText("")
                    Toast.makeText( this,"Password and Confirm Password Must be Match!!", Toast.LENGTH_SHORT).show()
                }

            }


        }
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