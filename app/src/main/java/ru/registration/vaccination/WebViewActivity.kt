package ru.registration.vaccination

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initWebView()
        initListeners()
    }

    fun initWebView() {
        webView = findViewById(R.id.main_webview)
        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webView.loadUrl("https://yandex.ru")
    }

    override fun onBackPressed() {
        when {
            webView.canGoBack() == true -> webView.goBack()
            else -> super.onBackPressed()
        }
    }

    fun initListeners() {
        val buttonShare: Button = findViewById(R.id.share_btn)
        buttonShare.setOnClickListener {
//            Snackbar.make(it, "Вы нажали кнопку ПОДЕЛИТЬСЯ", Snackbar.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val textToSend = "https://yandex.ru"
            intent.putExtra(Intent.EXTRA_TEXT, textToSend)
            try {
                startActivity(Intent.createChooser(intent, "Поделиться через"))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(applicationContext, "Some error", Toast.LENGTH_SHORT).show()
            }
        }
    }

}