package com.example.menuapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.example.menuapp.R
import com.example.menuapp.firestore.FirestoreClass
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.auth.User
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.*
import kotlinx.android.synthetic.main.activity_sign_up_screen.toolbar_sign_up_activity as toolbar_sign_up_activity1

class SignUpScreen : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupActionBar()

        btn_sign_up.setOnClickListener {
            registerUser()
        }
    }

    fun userRegisteredSuccess(){
        Toast.makeText(
            this@SignUpScreen,
            "You have successfully registered.",
            Toast.LENGTH_SHORT
        ).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()
    }


    private fun setupActionBar() {
        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }
        toolbar_sign_up_activity.setNavigationOnClickListener { onBackPressed() }
    }

    /**
     * A function to register a user to our app using the Firebase.
     * For more details visit: https://firebase.google.com/docs/auth/android/custom-auth
     */
    @SuppressLint("RestrictedApi")
    private fun registerUser(){
        val name: String = et_name.text.toString().trim { it <= ' ' }
        val email: String = et_email.text.toString().trim { it <= ' ' }
        val password: String = et_password.text.toString().trim { it <= ' ' }
        val role: String = et_role_main.text.toString().trim { it <= ' ' }

        if (validateForm(name, email, password,role)) {
            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        /*
                        work here baad mai
                         */



                    } else {
                        Toast.makeText(
                            this,
                            task.exception!!.message, Toast.LENGTH_SHORT
                        )
                            .show()

                    }
                }
        }

    }

    /**
     * A function to validate the entries of a new user.
     */
    private fun validateForm(name: String, email: String, password: String, role: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            TextUtils.isEmpty(et_role_main.toString()) -> {
                showErrorSnackBar("Please enter role(admin/mentee).")
                false
            }
            else -> {
                true
            }
        }
    }

}