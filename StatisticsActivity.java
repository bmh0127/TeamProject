package com.example.mysql;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StatisticsActivity extends AppCompatActivity {
    private LineChart lineChart;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_statistics);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // TabLayout과 LineChart 초기화
        lineChart = findViewById(R.id.lineChart);
        tabLayout = findViewById(R.id.tabLayout);

        // Tab 추가
        tabLayout.addTab(tabLayout.newTab().setText("한주"));
        tabLayout.addTab(tabLayout.newTab().setText("한달"));
        tabLayout.addTab(tabLayout.newTab().setText("전체"));

        // 기본 데이터 설정 (한주 데이터)
        setLineChartData(getWeeklyData1(), getWeeklyData2());

        // Tab 선택 시 데이터 변경
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        setLineChartData(getWeeklyData1(), getWeeklyData2());  // '한주' 데이터
                        break;
                    case 1:
                        setLineChartData(getMonthlyData1(), getMonthlyData2()); // '한달' 데이터
                        break;
                    case 2:
                        setLineChartData(getTotalData1(), getTotalData2());   // '전체' 데이터
                        break;
                }
                // 선택된 Tab에 따라 제목 변경
                setTitle(tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    // 그래프 데이터를 설정하는 함수
    private void setLineChartData(List<Entry> entries1, List<Entry> entries2) {
        LineDataSet lineDataSet1 = new LineDataSet(entries1, "수축기 혈압");
        lineDataSet1.setColor(Color.RED);
        lineDataSet1.setCircleColor(Color.RED);
        lineDataSet1.setCircleRadius(4f);
        lineDataSet1.setLineWidth(2f);

        LineDataSet lineDataSet2 = new LineDataSet(entries2, "이완기 혈압");
        lineDataSet2.setColor(Color.BLUE);
        lineDataSet2.setCircleColor(Color.BLUE);
        lineDataSet2.setCircleRadius(4f);
        lineDataSet2.setLineWidth(2f);

        LineData lineData = new LineData(lineDataSet1, lineDataSet2);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    // '한주' 데이터를 반환하는 함수
    private List<Entry> getWeeklyData1() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 100f));
        entries.add(new Entry(1f, 120f));
        entries.add(new Entry(2f, 80f));
        entries.add(new Entry(3f, 140f));
        entries.add(new Entry(4f, 110f));
        entries.add(new Entry(5f, 140f));
        entries.add(new Entry(6f, 110f));
        return entries;
    }

    private List<Entry> getWeeklyData2() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 50f));
        entries.add(new Entry(1f, 30f));
        entries.add(new Entry(2f, 70f));
        entries.add(new Entry(3f, 80f));
        entries.add(new Entry(4f, 50f));
        entries.add(new Entry(5f, 80f));
        entries.add(new Entry(6f, 90f));
        return entries;
    }

    // '한달' 데이터를 반환하는 함수
    private List<Entry> getMonthlyData1() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 100f));
        entries.add(new Entry(1f, 130f));
        entries.add(new Entry(2f, 120f));
        entries.add(new Entry(3f, 140f));
        entries.add(new Entry(4f, 150f));
        entries.add(new Entry(5f, 170f));
        entries.add(new Entry(6f, 120f));
        entries.add(new Entry(7f, 140f));
        entries.add(new Entry(8f, 100f));
        entries.add(new Entry(9f, 130f));
        entries.add(new Entry(10f, 120f));
        entries.add(new Entry(11f, 140f));
        entries.add(new Entry(12f, 150f));
        entries.add(new Entry(13f, 170f));
        entries.add(new Entry(14f, 120f));
        entries.add(new Entry(15f, 140f));
        entries.add(new Entry(16f, 100f));
        entries.add(new Entry(17f, 130f));
        entries.add(new Entry(18f, 120f));
        entries.add(new Entry(19f, 140f));
        entries.add(new Entry(20f, 150f));
        entries.add(new Entry(21f, 170f));
        entries.add(new Entry(22f, 120f));
        entries.add(new Entry(23f, 140f));
        entries.add(new Entry(24f, 100f));
        entries.add(new Entry(25f, 130f));
        entries.add(new Entry(26f, 120f));
        entries.add(new Entry(27f, 140f));
        entries.add(new Entry(28f, 150f));
        entries.add(new Entry(29f, 170f));
        entries.add(new Entry(30f, 120f));
        return entries;
    }

    private List<Entry> getMonthlyData2() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 50f));
        entries.add(new Entry(1f, 30f));
        entries.add(new Entry(2f, 20f));
        entries.add(new Entry(3f, 70f));
        entries.add(new Entry(4f, 90f));
        entries.add(new Entry(5f, 50f));
        entries.add(new Entry(6f, 40f));
        entries.add(new Entry(7f, 30f));
        entries.add(new Entry(8f, 10f));
        entries.add(new Entry(9f, 80f));
        entries.add(new Entry(10f, 10f));
        entries.add(new Entry(11f, 40f));
        entries.add(new Entry(12f, 50f));
        entries.add(new Entry(13f, 70f));
        entries.add(new Entry(14f, 20f));
        entries.add(new Entry(15f, 40f));
        entries.add(new Entry(16f, 00f));
        entries.add(new Entry(17f, 30f));
        entries.add(new Entry(18f, 20f));
        entries.add(new Entry(19f, 40f));
        entries.add(new Entry(20f, 50f));
        entries.add(new Entry(21f, 70f));
        entries.add(new Entry(22f, 20f));
        entries.add(new Entry(23f, 40f));
        entries.add(new Entry(24f, 30f));
        entries.add(new Entry(25f, 30f));
        entries.add(new Entry(26f, 20f));
        entries.add(new Entry(27f, 40f));
        entries.add(new Entry(28f, 50f));
        entries.add(new Entry(29f, 70f));
        entries.add(new Entry(30f, 20f));
        return entries;
    }

    // '전체' 데이터를 반환하는 함수
    private List<Entry> getTotalData1() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 100f));
        entries.add(new Entry(1f, 130f));
        entries.add(new Entry(2f, 120f));
        entries.add(new Entry(3f, 140f));
        entries.add(new Entry(4f, 150f));
        entries.add(new Entry(5f, 170f));
        entries.add(new Entry(6f, 120f));
        entries.add(new Entry(7f, 140f));
        entries.add(new Entry(8f, 100f));
        entries.add(new Entry(9f, 130f));
        entries.add(new Entry(10f, 120f));
        entries.add(new Entry(11f, 140f));
        entries.add(new Entry(12f, 150f));
        entries.add(new Entry(13f, 170f));
        entries.add(new Entry(14f, 120f));
        entries.add(new Entry(15f, 140f));
        entries.add(new Entry(16f, 100f));
        entries.add(new Entry(17f, 130f));
        entries.add(new Entry(18f, 120f));
        entries.add(new Entry(19f, 140f));
        entries.add(new Entry(20f, 150f));
        entries.add(new Entry(21f, 170f));
        entries.add(new Entry(22f, 120f));
        entries.add(new Entry(23f, 140f));
        entries.add(new Entry(24f, 100f));
        entries.add(new Entry(25f, 130f));
        entries.add(new Entry(26f, 120f));
        entries.add(new Entry(27f, 140f));
        entries.add(new Entry(28f, 150f));
        entries.add(new Entry(29f, 170f));
        entries.add(new Entry(30f, 120f));
        entries.add(new Entry(31f, 120f));
        entries.add(new Entry(32f, 140f));
        entries.add(new Entry(33f, 150f));
        entries.add(new Entry(34f, 170f));
        entries.add(new Entry(35f, 120f));
        return entries;

    }

    private List<Entry> getTotalData2() {
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0f, 50f));
        entries.add(new Entry(1f, 30f));
        entries.add(new Entry(2f, 20f));
        entries.add(new Entry(3f, 70f));
        entries.add(new Entry(4f, 90f));
        entries.add(new Entry(5f, 50f));
        entries.add(new Entry(6f, 40f));
        entries.add(new Entry(7f, 30f));
        entries.add(new Entry(8f, 10f));
        entries.add(new Entry(9f, 80f));
        entries.add(new Entry(10f, 10f));
        entries.add(new Entry(11f, 40f));
        entries.add(new Entry(12f, 50f));
        entries.add(new Entry(13f, 70f));
        entries.add(new Entry(14f, 20f));
        entries.add(new Entry(15f, 40f));
        entries.add(new Entry(16f, 00f));
        entries.add(new Entry(17f, 30f));
        entries.add(new Entry(18f, 20f));
        entries.add(new Entry(19f, 40f));
        entries.add(new Entry(20f, 50f));
        entries.add(new Entry(21f, 70f));
        entries.add(new Entry(22f, 20f));
        entries.add(new Entry(23f, 40f));
        entries.add(new Entry(24f, 30f));
        entries.add(new Entry(25f, 30f));
        entries.add(new Entry(26f, 20f));
        entries.add(new Entry(27f, 40f));
        entries.add(new Entry(28f, 50f));
        entries.add(new Entry(29f, 70f));
        entries.add(new Entry(30f, 20f));
        entries.add(new Entry(31f, 10f));
        entries.add(new Entry(32f, 40f));
        entries.add(new Entry(33f, 50f));
        entries.add(new Entry(34f, 70f));
        entries.add(new Entry(35f, 20f));
        return entries;

    }
}