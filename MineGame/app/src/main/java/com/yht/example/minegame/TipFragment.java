package com.yht.example.minegame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yht.example.minegame.base.BaseFragment;


/**
 * Created by Administrator on 2019/12/28 0028.
 */

public class TipFragment extends BaseFragment {
    private FrameLayout mRoot;
    private TextView textView1;
    private TextView textView2;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRoot = (FrameLayout) View.inflate(getContext(),R.layout.activity_tip, null);
        textView1 = (TextView)mRoot.findViewById(R.id.textView1);
        textView2 = (TextView)mRoot.findViewById(R.id.textView2);
        textView1.setText("友情提示：\n\n");
        textView2.setText(
                "1：单击进行排雷\n" +
                "2：长按进行标记\n" +
                "3：长按之后单击在旗子和问号之间选择\n" +
                "4：再次长按取消标记\n\n" );
        return mRoot;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        changeMatchPartent(mRoot);

    }
}
