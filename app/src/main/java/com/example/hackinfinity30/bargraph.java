package com.example.hackinfinity30;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.bargraph.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import android.annotation.SuppressLint;
import org.intellij.lang.annotations.JdkConstants;

import java.util.ArrayList;

public class bargraph extends AppCompatActivity {
    HorizontalBarChart mChart;
    @SuppressLint("MissingInFlatedID")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bargraph);
        mChart = (HorizontalBarChart) findViewById(R.id.chart1);

        setData(10, 300000);
    }
    private void setData(int count, int range){
        ArrayList<BarEntry> yVals = new ArrayList<>();
        float barWidth = 9f;
        float spaceofBar = 10f;

        for(int i=0;i<count;i++){
            float val = (float) (Math.random()*range);
            yVals.add(new BarEntry(i*spaceofBar, val));

            BarDataSet set1;
            set1 = new BarDataSet(yVals, "Prices");

            BarData data = new BarData(set1);
            data.setBarWidth(barWidth);
            mChart.setData(data);
        }
    }
}