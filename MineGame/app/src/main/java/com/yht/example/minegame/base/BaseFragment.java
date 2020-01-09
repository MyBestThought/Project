package com.yht.example.minegame.base;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;

import com.yht.example.minegame.MainActivity;

/**
 * Created by Administrator on 2019/12/26 0026.
 */

public class BaseFragment extends Fragment {
    public MainActivity getSelfActivity(){
        FragmentActivity activity = getActivity();
        if(activity instanceof MainActivity)
            return (MainActivity) activity;
        else
            return null;
    }
    public final void changeMatchPartent(View view){
        if(view != null){
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if(layoutParams == null){
                layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }else {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
            }
            view.setLayoutParams(layoutParams);
        }

    }
}
