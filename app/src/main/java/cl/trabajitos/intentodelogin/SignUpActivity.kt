package cl.trabajitos.intentodelogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setup()
    }

    private fun setup() {

        backButton.setOnClickListener {
            onBackPressed()
        }

        nextButton.setOnClickListener {


            if (nameEditText.text.isNotEmpty() &&
                lastNameEditText.text.isNotEmpty() &&
                birthEditTextDate.text.isNotEmpty()
            ) {

                personalInfoLayout.visibility = View.GONE
                contactInfoLayout.visibility = View.VISIBLE
                pageTextView.setText("2 de 3")

            }

        }
    }


}