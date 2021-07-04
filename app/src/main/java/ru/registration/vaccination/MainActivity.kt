package ru.registration.vaccination

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
    }

    fun initListeners() {
        val imageBackground: ImageView = findViewById(R.id.main_picture)
        val goToWebView: ImageView = findViewById(R.id.go_to_webview)

        val buttonGuest: Button = findViewById(R.id.guest_btn)
        val buttonSchokoladnica: Button = findViewById(R.id.schokoladnica_btn)
        val buttonWildberries: Button = findViewById(R.id.wildberries_btn)

        buttonGuest.setOnClickListener {
            imageBackground.setImageResource(R.drawable.guest_background)
        }
        buttonSchokoladnica.setOnClickListener {
            imageBackground.setImageResource(R.drawable.schokoladnica_backgroud)
        }
        buttonWildberries.setOnClickListener {
            imageBackground.setImageResource(R.drawable.wildberrries_background)
        }

        goToWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

}