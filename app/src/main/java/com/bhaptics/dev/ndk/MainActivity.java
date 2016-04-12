package com.bhaptics.dev.ndk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.bhaptics.ndk.opensl_exampleJNI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_record).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);

        findViewById(R.id.btn_record).setEnabled(true);
        findViewById(R.id.btn_stop).setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_record:
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        opensl_exampleJNI.start_process();
                    }
                });
                thread.start();
                thread.setPriority(Thread.MAX_PRIORITY);

                findViewById(R.id.btn_record).setEnabled(false);
                findViewById(R.id.btn_stop).setEnabled(true);
                break;
            case R.id.btn_stop:
                opensl_exampleJNI.stop_process();
                findViewById(R.id.btn_record).setEnabled(true);
                findViewById(R.id.btn_stop).setEnabled(false);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        opensl_exampleJNI.stop_process();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Log.e(TAG, "onDestroy: ", e);
        }

        thread = null;
    }
}
