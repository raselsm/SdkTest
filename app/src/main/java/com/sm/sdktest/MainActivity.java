package com.sm.sdktest;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sm.rasel_library.RssFeedProvider;
import com.sm.rasel_library.RssItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage, rslText, rslTextTwo;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        rslText = findViewById(R.id.rslText);
        rslTextTwo = findViewById(R.id.rslTextTwo);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        List<RssItem> list = RssFeedProvider.parse("super man");
        String itemListAsString = list.toString();
        rslText.setText(itemListAsString);

        //TestClass_ReclerbaseAdapter
    }

}
