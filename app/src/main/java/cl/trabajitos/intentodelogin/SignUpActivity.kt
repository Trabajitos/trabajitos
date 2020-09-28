package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
                showPanelTwo()
                backSignUpButton.visibility = View.VISIBLE
            } else if (contactInfoLayout.visibility == View.VISIBLE &&
                personalInfoLayout.visibility == View.GONE
            ) {
                val intentCreateUser: Intent = Intent(this, CreateActivity::class.java)
                startActivity(intentCreateUser)
            }
        }

        backSignUpButton.setOnClickListener {
            if (personalInfoLayout.visibility == View.GONE &&
                contactInfoLayout.visibility == View.VISIBLE
            ) {
                showPanelOne()
                backSignUpButton.visibility = View.INVISIBLE
            }
        }
    }

    private fun showPanelOne() {
        contactInfoLayout.visibility = View.GONE
        personalInfoLayout.visibility = View.VISIBLE
        pageTextView.setText("1 de 2")
        typeTextView.setText("Personales")
    }

    private fun showPanelTwo() {
        personalInfoLayout.visibility = View.GONE
        contactInfoLayout.visibility = View.VISIBLE
        pageTextView.setText("2 de 2")
        typeTextView.setText("De Contacto")
    }

}