package com.blackbutterfly.mytab.Plan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blackbutterfly.mytab.R;

public class AddTitleActivity extends AppCompatActivity {
    //여행 제목과 달력 입력하는 뷰
    CalenderFragment CF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_title);

        AddTitleFragment addTitleFragment = new AddTitleFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.addTitle_container, addTitleFragment).commit();

    }

    // 제목에서 달력으로 가는 메소드
    public void addTitle_to_Calender(int index) {
        if (index == 0) {
            CF = new CalenderFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.addCalender, CF).commit();

    }else if(index ==1){
        getSupportFragmentManager().beginTransaction().remove(CF).commit();
    }
}
// 달력에서 데이리스트로 가는 메소드
    public void Calender_to_DayList(int index){
        if(index==0){
           DayListFragment DF = new DayListFragment();
            AddTitleFragment addTitleFragment = new AddTitleFragment();
            addTitle_to_Calender(1);
            getSupportFragmentManager().beginTransaction().remove(addTitleFragment).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.addDayList,DF).commit();
        }
    }
}


