package com.android.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Memo"
//        actionbar!!.subtitle = "Authentification"
        //set back button
//        actionbar.setDisplayHomeAsUpEnabled(true)
//        actionbar.setDisplayHomeAsUpEnabled(true)


        val navController = findNavController(R.id.nav_host_fragment)
        val nCS = navController.toString()

        setupActionBarWithNavController(navController)
//        supportActionBar?.subtitle = nCS

        if (findNavController(R.id.nav_host_fragment).toString() == "fragment_login") {
            this.setContentView(R.layout.fragment_login)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
