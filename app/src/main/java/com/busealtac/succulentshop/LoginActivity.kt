package com.busealtac.succulentshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.busealtac.succulentshop.databinding.ActivityLoginBinding
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val usernameValidator = UsernameValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = getString(R.string.log_in)

        binding.apply {

            logInButton.setOnClickListener {

                identifierInputLayout.validate()
                passwordLayout.validate()


            }
            createAccountButton.setOnClickListener {
                navigateToSignUpActivity()
            }
        }
    }

    private fun navigateToSignUpActivity() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        when (requestCode) {
            REQUEST_SECOND_ACTIVITY -> {
                if (resultCode == SecondActivity.RESULT_YES) {
                    Log.e("LoginActivity", "Yess!")
                } else Log.e("LoginActivity", "Noo!")
            }
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun navigateToSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("isLoggedIn", true)
        startActivityForResult(intent, REQUEST_SECOND_ACTIVITY)  //çalıştığında 2.activitye gider
    }

    private fun TextInputLayout.validate() {

        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }


    private fun Int.resolveAsString() = getString(this)


    private fun TextInputLayout.validator() = when (this) {

        binding.identifierInputLayout -> if ((this.editText?.text
                ?: "").contains("@")
        ) emailValidator else usernameValidator
        binding.passwordLayout -> passwordValidator


        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")

    }

    companion object {
        const val REQUEST_SECOND_ACTIVITY = 1001
    }


}