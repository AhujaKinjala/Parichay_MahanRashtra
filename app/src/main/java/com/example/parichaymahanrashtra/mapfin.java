package com.example.parichaymahanrashtra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class mapfin extends AppCompatActivity {
    private WebView mywebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapfin);

        mywebView=(WebView) findViewById(R.id.mwebview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://friendly-strudel-ca2b2e.netlify.app/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.map);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem ){
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplication(),
                                nav_home.class));
//                        overridePendingTrnasition();
                        return true;

                    case R.id.map:
                        startActivity(new Intent(getApplication(),
                                mapfin.class));
//                        overridePendingTrnasition();
                        return true;

                    case R.id.transport:
                        startActivity(new Intent(getApplication(),
                                transportfin.class));

                        return true;


                    case R.id.bucketList:
                        startActivity(new Intent(getApplication(),
                                bucketfin.class));
                        return true;


                    case R.id.profile:
                        startActivity(new Intent(getApplication(),
                                profilefin.class));

                        return true;


                }


                return false;
            }
        });
    }

    public class mywebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

}





