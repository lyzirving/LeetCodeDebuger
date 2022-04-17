package com.lyzirving.leetcode.debug;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lyzirving.leetcode.debug.algorithmn.FourSum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] input = new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000};
        FourSum.execute1(input, 1000000000);
    }
}