package com.kalpicapp.homeground

import android.app.DownloadManager
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.webkit.CookieManager
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pdfviewtester.*

class Pdfviewtester : AppCompatActivity(){

    private var mwebview : WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfviewtester)



        mwebview = findViewById<View>(R.id.webView) as WebView

        mwebview!!.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                view.visibility =View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                view.visibility =View.VISIBLE
                progressBar.visibility = View.INVISIBLE
            }


        }






        val webSettings = mwebview!!.settings
        webSettings.javaScriptEnabled = true
        webSettings.setAppCacheEnabled(true)
        webSettings.domStorageEnabled = true
        webSettings.layoutAlgorithm
        webSettings.loadWithOverviewMode =true
        webSettings.useWideViewPort = true
        webSettings.setSupportZoom(true)
        webSettings.builtInZoomControls = true
        webSettings.displayZoomControls = false

//        mwebview!!.requestFocus()
//
//
//        webSettings.setAppCachePath(applicationContext.filesDir.absolutePath + "/cache")
//        webSettings.setAppCacheEnabled(true)
//        webSettings.setAppCachePath(this.cacheDir.absolutePath)

//        var url1 = "https://s3-ap-southeast-1.amazonaws.com/gtusitecirculars/uploads/circular-diwali%20vacation%202019_819161.pdf"
//        var url2 = "http://gate.iitd.ac.in/Syllabus/IN.pdf"
//        var url3 = "https://bit.ly/2Vwbu0H"
//        var finalurl = "https://docs.google.com/gview?embedded=true&url="+url3

//        mwebview!!.loadUrl("https://www.gtu.ac.in/Circular.aspx")

        mwebview!!.loadUrl("https://mygtuapp.wordpress.com/")
//        if (btnkey == 1) {
//            mwebview!!.loadUrl("https://www.gtu.ac.in")
//
//        }


//?android:attr/progressBarStyle

        mwebview!!.setDownloadListener { url, userAgent, contentDisposition, mimeType, contentLength ->
            val request = DownloadManager.Request(Uri.parse(url))
            request.setMimeType(mimeType)
            request.addRequestHeader("cookie", CookieManager.getInstance().getCookie(url))
            request.addRequestHeader("User-Agent", userAgent)
            request.setDescription("Downloading file...")
            request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimeType))
            request.allowScanningByMediaScanner()
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            request.setDestinationInExternalFilesDir(this, Environment.DIRECTORY_DOWNLOADS, ".png")
            val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            dm.enqueue(request)
            Toast.makeText(applicationContext, "Downloading File", Toast.LENGTH_LONG).show()
        }


    }
    override fun onBackPressed() {
        if (mwebview!!.canGoBack()) {
            mwebview!!.goBack()

        } else {
            super.onBackPressed()
        }

    }



}

/////////////////////////////////////////

/*

https://www.c-sharpcorner.com/article/how-to-add-download-listener-to-webview-in-kotlin/



 */




