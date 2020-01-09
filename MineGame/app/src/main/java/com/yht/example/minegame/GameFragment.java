package com.yht.example.minegame;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import com.yht.example.minegame.aidl.MineDataProvider;
import com.yht.example.minegame.base.BaseFragment;
import com.yht.example.minegame.view.MineView;

/**
 * Created by Administrator on 2019/12/26 0026.
 */
public class GameFragment extends BaseFragment {
    private View mRoot;
    private GridLayout mControl;
    private MineManager mManager;
    public TextView mMineNum;
    public TextView mTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = View.inflate(getContext(), R.layout.activity_game, null);
        mControl = (GridLayout) mRoot.findViewById(R.id.control);
        mMineNum = (TextView) mRoot.findViewById(R.id.mine_num);
        mTime = (TextView) mRoot.findViewById(R.id.time);
        int game_level = getActivity().getPreferences(Context.MODE_PRIVATE).getInt("game_level", MineManager.esayMineNum);
        mManager = new MineManager(game_level);
        MineDataProvider.mManager = mManager;
        mManager.setMineNum(mMineNum,mTime,game_level);
        mManager.createMines();
        mControl.setRowCount(mManager.row);
        mControl.setColumnCount(mManager.column);

        mManager.setMineToUI(new MineManager.MineCallback() {
            @Override
            public void callback(Mine mine) {
                mControl.addView(new MineView(mine,getContext()));
            }
        });

        return mRoot;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        changeMatchPartent(mRoot);
        MineView.clickMINE = false;
        MineDataProvider.gameStarted = true;
        MineDataProvider.gameState = 1;
    }

    @Override
    public void onDestroyView() {
        MineDataProvider.gameStarted = false;
        MineDataProvider.gameState = 0;
        MineDataProvider.mManager = null;
        super.onDestroyView();
    }
}
