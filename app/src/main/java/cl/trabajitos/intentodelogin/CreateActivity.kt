package cl.trabajitos.intentodelogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create.*
import kotlinx.android.synthetic.main.activity_signup.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)
        setUp()
    }

    private fun setUp() {
        nextWorkButton.setOnClickListener {
            firstLayout.visibility = View.GONE
            secondLayout.visibility = View.VISIBLE
        }
        backWorkButton.setOnClickListener {
            firstLayout.visibility = View.VISIBLE
            secondLayout.visibility = View.GONE
        }
        nextButton.setOnClickListener{
            val start :Intent = Intent(this,MapActivity::class.java)
            startActivity(start)
            finish()
        }
    }

}