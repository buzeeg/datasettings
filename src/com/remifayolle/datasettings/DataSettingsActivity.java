package com.remifayolle.datasettings;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DataSettingsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Create Intent
        Intent i = new Intent(android.provider.Settings.ACTION_DATA_ROAMING_SETTINGS);
        ComponentName cName = new ComponentName("com.android.phone","com.android.phone.Settings");
        i.setComponent(cName); 
        
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
