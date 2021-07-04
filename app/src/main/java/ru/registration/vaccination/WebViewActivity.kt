package ru.registration.vaccination

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initWebView()
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

}