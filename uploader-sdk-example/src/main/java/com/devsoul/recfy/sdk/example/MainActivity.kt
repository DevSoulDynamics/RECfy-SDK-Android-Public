package com.devsoul.recfy.sdk.example

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devsoul.recfy.sdk.RecfyUploaderSDK
import com.devsoul.recfy.sdk.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val uploaderSDK: RecfyUploaderSDK by lazy {
        RecfyUploaderSDK.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUp()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            RecfyUploaderSDK.ACTION_UPLOAD  -> {
                when (resultCode) {
                    Activity.RESULT_OK ->  toastMessage("media uploaded.")
                    RecfyUploaderSDK.RESULT_UPLOAD_FAIL ->  toastMessage("media upload fail.")
                    RecfyUploaderSDK.RESULT_USER_CANCEL ->  toastMessage("media upload cancel by user")
                }
            }
            else -> {
                // nothing to do
            }
        }
    }

    private fun setUp() {
        if (BuildConfig.DEBUG) {
            binding.emailEditText.setText(USER_EMAIL)
            binding.eventEditText.setText(EVENT_CODE)
        }

        binding.uploadButton.setOnClickListener {
            checkForm()
        }
    }

    private fun checkForm() {
        val email = binding.emailEditText.text.toString()
        val eventCode = binding.eventEditText.text.toString()

        if(email.isBlank()){
            toastMessage("email invalid")
            return
        }

        if(eventCode.isBlank()){
            toastMessage("eventCode invalid")
            return
        }

        uploaderSDK.uploadMedia(email, eventCode, USER_GDPR)
    }

    private fun toastMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EVENT_CODE = "Devsoul"
        const val USER_EMAIL = "test@test.com"
        const val USER_GDPR = true
    }
}
