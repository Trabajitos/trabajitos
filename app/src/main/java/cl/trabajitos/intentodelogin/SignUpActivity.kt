package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {


    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setup()
    }

    private fun setup() {

        spinnerConfig()

        backButton.setOnClickListener {
            onBackPressed()
            finish()
        }
        nextButton.setOnClickListener {
            if (personalInfoLayout.visibility == View.VISIBLE &&
                contactInfoLayout.visibility == View.GONE
            ) {
                showPanelTwo()
            } else if (contactInfoLayout.visibility == View.VISIBLE &&
                personalInfoLayout.visibility == View.GONE
            ) {
                register()
                val intentCreateUser: Intent = Intent(this, CreateActivity::class.java)
                startActivity(intentCreateUser)
                finish()
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
        typeTextView.setText("Personales")
        pageTextView.setText("1 de 2")
        backSignUpButton.visibility = View.INVISIBLE
    }

    private fun showPanelTwo() {
        personalInfoLayout.visibility = View.GONE
        contactInfoLayout.visibility = View.VISIBLE
        typeTextView.setText("De Contacto")
        pageTextView.setText("2 de 2")
        backSignUpButton.visibility = View.VISIBLE

    }

    private fun spinnerConfig() {
        val countries = resources.getStringArray(R.array.countries)

        val spinner = findViewById<Spinner>(R.id.countrySpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, countries
            )
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
    }

    private fun register() {
        if(phoneEditText.text != null && emailEditText.text != null){


        if(emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                emailEditText.text.toString(),
                passwordEditText.text.toString()
            )
        }
        db.collection("users").document(emailEditText.text.toString()).set(
            hashMapOf(
                "name" to nameEditText.text.toString(),
                "lastName" to lastNameEditText.text.toString(),
                "country" to countrySpinner.selectedItem.toString(),
                "birth" to birthEditTextDate.text.toString(),
                "phone" to phoneEditText.text.toString()
            )
        )


    }
    }

}