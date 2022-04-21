package com.lyzirving.leetcode.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lyzirving.leetcode.debug.data.ArrayUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] src = new int[]{3,3};
        int rest = ArrayUtil.removeSpecificItem(src, 3);
        Log.i("test", "result = " + rest);
    }
}