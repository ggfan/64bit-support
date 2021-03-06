package com.example.bit64;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.aar_lib.*;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("app_lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SampleLib myLib = new SampleLib();

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        String msg = stringFromJNI();
        msg += " " + myLib.add(10, 15);
        msg += " " + myLib.product(10, 15);

        tv.setText(msg);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
