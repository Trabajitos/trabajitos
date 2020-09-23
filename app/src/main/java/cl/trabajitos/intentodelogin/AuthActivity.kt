package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        setup()
    }

    private fun setup() {
        title = "Autentificación"
        logInButton.setOnClickListener {
            if (emailEditText.text.isNotEmpty() && passwordEditText.text.isNotEmpty()) {

                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()).addOnCompleteListener{
                    if(it.isSuccessful){
                showHome(it.result?.user?.email?:" ", ProviderType.BASIC)
                        val db = FirebaseFirestore.getInstance()
                    }
                }
            }

        }
        sUpButton.setOnClickListener{
            val signUpIntent :Intent = Intent(this,SignUpActivity::class.java)
            startActivity(signUpIntent)
        }

    }

    private fun showHome (email: String, provider: ProviderType){

        val homeIntent :Intent = Intent(this,HomeActivity::class.java).apply{
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)
    }


}