package com.blackbutterfly.mytab.Plan;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blackbutterfly.mytab.R;

import static com.blackbutterfly.mytab.R.id.btnStartDay;

/**
 * Created by samsung on 2017-12-06.
 */

public class AddTitleFragment extends Fragment {
    AddTitleActivity addTitleActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        addTitleActivity = (AddTitleActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        addTitleActivity = null;
    }

    @Nullable
    @Override
    // 여기서 버튼을 누르면 달력이 나오고, 달력을 설정해서 데이 숫자가 넘어와야한다.
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup addTitle = (ViewGroup) inflater.inflate(R.layout.fragment_add_title,container,false);

        Button startDay = (Button) addTitle.findViewById(btnStartDay);
        startDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTitleActivity = (AddTitleActivity) getActivity();
                addTitleActivity.addTitle_to_Calender(0);
            }
        });
        return addTitle;
    }
}
