package com.appsflyer.androidsampleapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.appsflyer.*;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {


    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetInstallDataText();

        Button trackEventButton = findViewById(R.id.trackEventButton);
        trackEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* Track Events in real time */
//                Map<String, Object> eventValue = new HashMap<String, Object>();
//                eventValue.put(AFInAppEventParameterName.REVENUE, 2.99);
//                eventValue.put(AFInAppEventParameterName.CONTENT_TYPE, "category_a");
//                eventValue.put(AFInAppEventParameterName.CONTENT_ID, "1234567");
//                eventValue.put(AFInAppEventParameterName.CURRENCY, "USD");
//                AppsFlyerLib.getInstance().trackEvent(getApplicationContext(), AFInAppEventType.PURCHASE, eventValue);


                Map<String, Object> dict = new HashMap<String, Object>();
                Double price = 4.99;
                dict.put(AFInAppEventParameterName.REVENUE, price); //skuDetails.getPrice());
                dict.put(AFInAppEventParameterName.CONTENT_ID, 898);
                dict.put(AFInAppEventParameterName.CURRENCY, "EUR");
                dict.put(AFInAppEventParameterName.QUANTITY,"1");

                AppsFlyerLib.getInstance().trackEvent(getBaseContext(),AFInAppEventType.PURCHASE,dict);

            }
        });
    }



    /*** Ignore - used to display install data ***/
    public void SetInstallDataText(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView installData = findViewById(R.id.installDataText);
                installData.setText(AFApplication.InstallConversionData);
            }
        } , 2500);

    }

}