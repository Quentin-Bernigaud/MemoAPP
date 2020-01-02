package com.android.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Authentification"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
