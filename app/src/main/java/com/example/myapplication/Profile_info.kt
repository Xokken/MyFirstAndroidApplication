package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile_info.*

class Profile_info : AppCompatActivity() {

    var dataUsers = DataUsers()
    val APP_PREFERENCES = "mysettings"
    val APP_PREFERENCES_CURRENT_EMAIL = "currentEmail"
    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_info)
        pref = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        if (pref.contains(APP_PREFERENCES_CURRENT_EMAIL)) {

            val currentEmail = pref.getString(APP_PREFERENCES_CURRENT_EMAIL, "0")
            if (dataUsers.getDatabase().containsKey(currentEmail)) {

                nameInfo.text = dataUsers.getDatabase().get(currentEmail)?.name
                surNameInfo.text = dataUsers.getDatabase().get(currentEmail)?.surName
                emailInfo.text = dataUsers.getDatabase().get(currentEmail)?.email

            }


            logOut.setOnClickListener {
                val editor = pref.edit()
                editor.putString(APP_PREFERENCES_CURRENT_EMAIL, "0")
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

}
