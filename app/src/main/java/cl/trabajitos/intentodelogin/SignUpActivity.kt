package cl.trabajitos.intentodelogin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.graphics.toColorInt
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


            if (personalInfoLayout.visibility == View.VISIBLE &&
                contactInfoLayout.visibility == View.GONE
            ) {
                personalInfoLayout.visibility = View.GONE
                contactInfoLayout.visibility = View.VISIBLE
                pageTextView.setText("2 de 2")
                typeTextView.setText("De Contacto")

            } else if (contactInfoLayout.visibility == View.VISIBLE &&
                personalInfoLayout.visibility == View.GONE
            ) {

                val intentCreateUser: Intent = Intent(this, CreateUserActivity::class.java)
                startActivity(intentCreateUser)
            }

        }
        backSignUpButton.setOnClickListener{
            if(personalInfoLayout.visibility == View.GONE &&
                    contactInfoLayout.visibility == View.VISIBLE){
                personalInfoLayout.visibility = View.VISIBLE
                contactInfoLayout.visibility = View.GONE
                pageTextView.setText("1 de 2")
                typeTextView.setText("Personales")
            }
        }
    }


}