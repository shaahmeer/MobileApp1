package com.mirea.nawab.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    TextView textView;
    Handler handler;
    ChapterCount chapterCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        textView.setText("Current stream:" + mainThread.getName());
// Change the name and display in the text field
        mainThread.setName("MireaThread");
        textView.append("\n New stream name: " + mainThread.getName());
    }

    public void onClick(View view) {


            new Thread(new Runnable() {
                public void run() {
                    int numberThread = counter++;
                    Log.i("ThreadProject ", "Stream # started" + numberThread);
                    long endTime = System.currentTimeMillis()
                            + 20 * 1000;
                    while (System.currentTimeMillis() < endTime) {
                        synchronized (this) {
                            try {
                                wait(endTime -
                                        System.currentTimeMillis());
                            } catch (Exception e) {
                            }
                        }
                        Log.i("ThreadProject ", "Completed stream #" + numberThread);
                    }
                }
                }).start();
    }
}