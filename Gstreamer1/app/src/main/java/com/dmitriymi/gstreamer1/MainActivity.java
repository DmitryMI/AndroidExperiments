package com.dmitriymi.gstreamer1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import org.freedesktop.gstreamer.GStreamer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            GStreamer.init(this);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        Toast.makeText(this, "Welcome to " + nativeGetGStreamerInfo() + " !", Toast.LENGTH_LONG).show();
        TextView tv = (TextView)findViewById(R.id.gstreamerVersionView);
        tv.setText("Welcome to " + nativeGetGStreamerInfo() + " !");
    }

    private native String nativeGetGStreamerInfo();
    static {
        System.loadLibrary("gstreamer_android");
        System.loadLibrary("tutorial-1");
    }
}