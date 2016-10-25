
package com.example.android.apis.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.android.apis.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebviewTest extends Activity {
    private static final String ERROR_RETRY_HTML = "file:///android_asset/html/network_err.html";
    private static final String ERROR_RETRY_HTML_NIGHT = "file:///android_asset/html/network_err_night.html";
    private WebView webView = null;
    private String mLastUrl = null;
    private String lastErrorUrl  = null;
    ProgressBar progress_loading = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_2);

        webView = (WebView) findViewById(R.id.wv2);
        progress_loading = (ProgressBar) findViewById(R.id.progress_loading);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setInitialScale(70);
        webView.setHorizontalScrollbarOverlay(true);
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description,
                    String failingUrl)
            { // Handle the error
                lastErrorUrl = failingUrl;
                view.stopLoading();
                view.clearView();
                loadLocalRetryPage(failingUrl);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
            
            @Override
            public void onPageFinished(WebView view, String url) {
              mLastUrl = url;
              if(!(mLastUrl.equals(view.getUrl())) && mLastUrl.equals(lastErrorUrl)){
                  showProgress();
              }else{
                  hideProgress();
              }
                super.onPageFinished(view, url);
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                showProgress();
                super.onPageStarted(view, url, favicon);
            }
        });
        webView.loadUrl("http://baidu.com");
    }

    private void loadLocalRetryPage(String url) {
        String encodedUrl = null;
        encodedUrl = ERROR_RETRY_HTML + encodeUrl(url);
        webView.loadUrl(encodedUrl);
    }

    private String encodeUrl(String url) {
        if (url == null) {
            return "";
        }
        String ret = "?url=";
        try {
            ret = ret + URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ret = "";
        }
        return ret;
    }

    private void showProgress(){
        webView.setVisibility(View.GONE);
        progress_loading.setVisibility(View.VISIBLE);
    }

    private void hideProgress(){
        webView.setVisibility(View.GONE);
        progress_loading.setVisibility(View.VISIBLE);
    }
}
