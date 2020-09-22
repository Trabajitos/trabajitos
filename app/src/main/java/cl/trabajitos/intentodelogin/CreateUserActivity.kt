package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        setUp()
    }

    private fun setUp(){
        title="Crear Usuario"

        finishButton.setOnClickListener {

            val intentHome :Intent = Intent(this,HomeActivity::class.java)
            startActivity(intentHome)
        }

    }
}