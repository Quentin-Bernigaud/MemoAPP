package com.android.example.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()
        if (id == R.id.profile) {
            startActivity(Intent(this, UserInfoActivity::class.java))
        }

        if (id == R.id.list) {
            startActivity(Intent(this, MainActivity::class.java))
        }

//        if (id == R.id.authentification) {
//            startActivity(Intent(this, AuthenticationActivity::class.java))
//        }
        return super.onOptionsItemSelected(item)
    }
}
