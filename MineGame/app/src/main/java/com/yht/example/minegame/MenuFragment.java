package com.yht.example.minegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.yht.example.minegame.base.BaseFragment;

/**
 * Created by Administrator on 2019/12/26 0026.
 */

public class MenuFragment  extends BaseFragment implements View.OnClickListener {
    private FrameLayout mRoot;
    private Button mNewGame;
    private Button mHelp;
    private Button mExitGame;
    private LinearLayout mButtons;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRoot = (FrameLayout) View.inflate(getActivity(),R.layout.activity_menu,null);
        mNewGame = (Button) mRoot.findViewById(R.id.new_game);
        mButtons = (LinearLayout) mRoot.findViewById(R.id.buttons);
        mHelp = (Button) mRoot.findViewById(R.id.help);
        mExitGame = (Button) mRoot.findViewById(R.id.exit_game);
        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        changeMatchPartent(mRoot);
        mNewGame.setOnClickListener(this);
        mExitGame.setOnClickListener(this);
        mHelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_game:
                getSelfActivity().showFragment(MainActivity.LEVEL_FRAGMENT,false);
                break;
            case R.id.help:
                getSelfActivity().showFragment(MainActivity.TIP_FRAGMENT, false);
                break;
            case R.id.exit_game:
                System.exit(0);
                break;
        }
    }
    public void hideAll(){
        mButtons.setVisibility(View.GONE);
    }
    public void showAll(){
        mButtons.setVisibility(View.VISIBLE);
    }
}
