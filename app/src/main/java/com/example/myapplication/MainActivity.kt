package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    val APP_PREFERENCES = "mysettings"
    val APP_PREFERENCES_CURRENT_EMAIL = "currentEmail"
    var usersDatabase = DataUsers()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var pref: SharedPreferences = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        if (pref.contains(APP_PREFERENCES_CURRENT_EMAIL)) {
            val currentEmail = pref.getString(APP_PREFERENCES_CURRENT_EMAIL, "0");
            if(!currentEmail.equals("0")){
                val intent = Intent(this, Profile_info::class.java)
                startActivity(intent)
                finish()
            }
        }

        signMain.setOnClickListener {
            val emailCheck = Regex(pattern = "^([a-z0-9-]+)*[a-z0-9-]+@[a-z0-9-]+([.a-z0-9-]+)\\.[a-z]{2,6}\$")
            val passwordCheck = Regex(pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}\$")

            val emailString = emailMain.text.toString()
            val passwordString = passwordMain.text.toString()
            if (emailCheck.containsMatchIn(emailString) && passwordCheck.containsMatchIn(passwordString)) {
                if (checkData(emailString, passwordString)) {
                    val editor = pref.edit()
                    editor.putString(APP_PREFERENCES_CURRENT_EMAIL, emailString)
                    editor.apply()
                    val intent = Intent(this, Profile_info::class.java)
                    startActivity(intent)
                    finish()
                }
                else {
                    val status = "This user does not exist or incorrect password."
                    Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
                }
            }
            else{
                val status = "Invalid email or password."
                Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
            }

        }

    }

    fun checkData(stringEmail : String , stringPassword : String):Boolean{
        if (usersDatabase.getDatabase().containsKey(stringEmail)){
            return usersDatabase.getDatabase().getValue(stringEmail).password.equals(stringPassword)
        }
        else{
            return false
        }

    }



}