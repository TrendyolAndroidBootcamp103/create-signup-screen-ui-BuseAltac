package com.busealtac.succulentshop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.busealtac.succulentshop.databinding.ActivitySignUpBinding
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val usernameValidator = UsernameValidator()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        val view = binding.root    //view binding enable
        setContentView(view)

        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener {

                validateEmail()
                validateUsername()
                validatePassword()
            }

            alreadyHaveAnAccountButton.setOnClickListener {
                navigateToLogInActivity()
            }
        }
    }

    private fun navigateToLogInActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun validate(textInputLayout: TextInputLayout, validator: Validator) =
        textInputLayout.let {
            val errorMessage = validator.validate(it.editText!!.text.toString())

            it.error = errorMessage?.resolveAsString()
            if (errorMessage == null) {
                it.error = null
                it.isErrorEnabled = false
            } else it.error = getString(errorMessage)

        }

    private fun validateEmail() = validate(binding.emailLayout, emailValidator)

    private fun validateUsername() = validate(binding.userNameLayout, usernameValidator)

    private fun validatePassword() = validate(binding.passwordLayout, passwordValidator)


    private fun Int.resolveAsString() = getString(this)

}



