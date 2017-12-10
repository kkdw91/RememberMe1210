package com.blackbutterfly.mytab.Plan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.blackbutterfly.mytab.R;


public class DayListFragment extends Fragment {


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup dayList = (ViewGroup) inflater.inflate(R.layout.fragment_day_list, container, false);
        LinearLayout dayListContainer =  (LinearLayout) dayList.findViewById(R.id.llDayListContainer);

        for(int i = 0 ; i<4; i++) {
            appendItemView(inflater, container, dayListContainer);
        }
        return dayList;
    }

    private void appendItemView(final LayoutInflater inflater, final ViewGroup container, final LinearLayout dayListContainer) {
        // fragment_day_list.xml(Day 별)
        ViewGroup itemView = (ViewGroup) inflater.inflate(R.layout.fragment_day_list_item, container, false);

        dayListContainer.addView(itemView);

        final LinearLayout dayListItemContainer = (LinearLayout) itemView.findViewById(R.id.llDAyListItemContainer);

        //Day별 장소추가버튼
        Button addbtn = (Button) itemView.findViewById(R.id.btnAddSpot);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendSpotView(inflater, container, dayListItemContainer);
            }
        });

        //Day별 장소를 기본 2개씩 생성
        for (int j = 0; j < 2; j++) {
            appendSpotView(inflater, container, dayListItemContainer);
        }
    }

    private void appendSpotView(LayoutInflater inflater, ViewGroup container, final LinearLayout dayListItemContainer){
        // spot_item.xml (장소 레이아웃) 인플레이터
        final ViewGroup spotView = (ViewGroup)   inflater.inflate(R.layout.spot_item,container,false);
        dayListItemContainer.addView(spotView);

        //Day별 장소제거버튼
        Button btnRemove = (Button) spotView.findViewById(R.id.btnRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dayListItemContainer.removeView(spotView);
            }
        });

    }
}
