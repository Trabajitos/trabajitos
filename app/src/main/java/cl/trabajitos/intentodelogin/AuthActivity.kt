package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_auth.emailEditText
import kotlinx.android.synthetic.main.activity_auth.passwordEditText

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setup()
    }

    private fun setup() {

        logInButton.setOnClickListener {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(
                emailEditText.text.toString(), passwordEditText.text.toString()
            ).addOnCompleteListener{
                if(it.isSuccessful){
                    val start :Intent = Intent(this,MapActivity::class.java)
                    startActivity(start)
                    finish()
                }
            }
        }

        sUpButton.setOnClickListener{
            val signUpIntent :Intent = Intent(this,SignUpActivity::class.java)
            startActivity(signUpIntent)
            finish()
        }

    }

}