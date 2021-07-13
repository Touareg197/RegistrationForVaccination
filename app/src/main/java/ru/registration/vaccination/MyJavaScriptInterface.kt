package ru.registration.vaccination

import android.webkit.JavascriptInterface
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


class MyJavaScriptInterface {
    @JavascriptInterface
    fun handleHtml(html: String?) {
        val doc: Document = Jsoup.parse(html)
        println(doc)
    }
}