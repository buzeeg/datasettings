package com.remifayolle.android.datasettings;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

public class DataSettingsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Create Intent
        Intent i = new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
        if(Build.VERSION.SDK_INT < 16)
            i.setClassName("com.android.phone", "com.android.phone.Settings");
       
        // Start activity and catch potential exception
        try {
            startActivity(i);        	
        } catch (ActivityNotFoundException e) {
        	Toast.makeText(this, R.string.data_exception, Toast.LENGTH_SHORT).show();
        }
        
        // Close myself
        finish();
    }
}
