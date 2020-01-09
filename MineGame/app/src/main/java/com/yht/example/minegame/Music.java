package com.yht.example.minegame;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Administrator on 2019/12/28 0028.
 */

public class Music {

    private static MediaPlayer mp =null;
    public static void play(Context context, int resource){
        stop(context);
        mp = MediaPlayer.create(context, resource);
        mp.setLooping(true);
        mp.start();
    }
    public static void stop(Context context) {
        // TODO Auto-generated method stub
        if(mp!= null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }


}