package com.yht.example.minegame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yht.example.minegame.base.BaseFragment;

/**
 * Created by Administrator on 2019/12/26 0026.
 */
public class LevelFragment extends BaseFragment implements View.OnClickListener {
    protected RelativeLayout mRoot;
    private Button mLowLevel;
    private Button mMediumLevel;
    private Button mHeightLevel;
//    private Button mCustomLevel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRoot = (RelativeLayout) View.inflate(getContext(),R.layout.activity_level, null);
        mLowLevel = (Button) mRoot.findViewById(R.id.low_level);
        mMediumLevel = (Button) mRoot.findViewById(R.id.medium_level);
        mHeightLevel = (Button) mRoot.findViewById(R.id.height_level);
//        mCustomLevel = (Button) mRoot.findViewById(R.id.custom_level);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        changeMatchPartent(mRoot);
        mLowLevel.setOnClickListener(this);
        mMediumLevel.setOnClickListener(this);
        mHeightLevel.setOnClickListener(this);
//        mCustomLevel.setOnClickListener(this);
    }
    TextView messageView;
    @Override
    public void onClick(View v) {
//        if(v.getId() == R.id.custom_level){
//            return;
//        }
        SharedPreferences sp = getActivity().getPreferences(Context.MODE_PRIVATE);
        int level = MineManager.esayMineNum;
        switch (v.getId()){
            case R.id.low_level:
                level = MineManager.esayMineNum;
                break;
            case R.id.medium_level:
                level = MineManager.mediumMineNum;
                break;
            case R.id.height_level:
                level = MineManager.heightMineNum;
                break;
//            case R.id.custom_level:
//                new AlertDialog
//                        .Builder(messageView.getContext())
//                        .setTitle("请输入数字：")
//                        .setCancelable(false)
//                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                                MainActivity.self.onBackPressed();
//                            }
//                        })
//
//                        .show();


        }
        sp.edit()
                .putBoolean("haveOldGame",true)
                .putInt("game_level",level)
                .apply();
        getSelfActivity().showFragment(
                MainActivity.GAME_FRAGMENT,true);
    }
}
