package com.mirea.nawab.thread;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class ChapterCount extends Thread {
    Map<String, Integer> chapter = new HashMap<>();
    double monthAverage = 0;
    Handler handler;

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(monthAverage);
    }

    public ChapterCount(Handler handler) {
        this.handler = handler;
        chapter.put("FirstMonday", 2);
        chapter.put("FirstTuesday", 4);
        chapter.put("FirstWednesday", 2);
        chapter.put("FirstThursday", 2);
        chapter.put("FirstFriday", 2);
        chapter.put("FirstSaturday", 2);
        chapter.put("SecondMonday", 4);
        chapter.put("SecondTuesday", 4);
        chapter.put("SecondWednesday", 4);
        chapter.put("SecondThursday", 2);
        chapter.put("SecondFriday", 0);
        chapter.put("SecondSaturday", 0);
    }

    @Override
    public void run() {
        for (Map.Entry<String, Integer> entry : chapter.entrySet()) {
            monthAverage += entry.getValue();
        }
        monthAverage += monthAverage + 10;
        monthAverage /= 30;
        Message msg = new Message();
        msg.obj = monthAverage;
        handler.sendMessage(msg);
    }
}


