package ru.registration.vaccination

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {

    val START_URL = "https://ya.ru"
    val TARGET_URL = "vk.com"

    lateinit var webView: WebView
    lateinit var buttonShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        initListeners()
        initWebView()
    }

    fun initWebView() {
        webView = findViewById(R.id.main_webview)
        webView.settings.setJavaScriptEnabled(true)

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                showOrHideShareButton(url)

                view?.loadUrl(url)
                return true
            }

            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {

                return super.shouldInterceptRequest(view, request)
            }
        }

        webView.loadUrl(START_URL)
    }

    override fun onBackPressed() {
        when {
            webView.canGoBack() == true -> {
                webView.goBack()
            }
            else -> super.onBackPressed()
        }
    }

    fun initListeners() {
        buttonShare = findViewById(R.id.share_btn)
        buttonShare.setOnClickListener {
//            Snackbar.make(it, "Вы нажали кнопку ПОДЕЛИТЬСЯ", Snackbar.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val textToSend = "https://developers.sber.ru/"
            intent.putExtra(Intent.EXTRA_TEXT, textToSend)
            try {
                startActivity(Intent.createChooser(intent, "Поделиться через"))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(applicationContext, "Some error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun showOrHideShareButton(url: String) {
        if (url.contains(TARGET_URL)) {
            buttonShare.visibility = View.VISIBLE
        } else {
            buttonShare.visibility = View.GONE
        }
    }

}