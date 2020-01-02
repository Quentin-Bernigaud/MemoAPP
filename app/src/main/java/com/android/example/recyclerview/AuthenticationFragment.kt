package com.android.example.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.authentication_fragment.*

class AuthenticationFragment: Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        login.setOnClickListener {
            findNavController().navigate(R.id.action_authenticationFragment_to_loginFragment)
        }

        signup.setOnClickListener {
            findNavController().navigate(R.id.action_authenticationFragment_to_signupFragment)
        }
    }

}
