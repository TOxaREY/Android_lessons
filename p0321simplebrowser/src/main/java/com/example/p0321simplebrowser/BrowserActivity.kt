package com.example.p0321simplebrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class BrowserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.browser)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()
        val data = intent.data
        webView.loadUrl(data.toString())
    }
}
