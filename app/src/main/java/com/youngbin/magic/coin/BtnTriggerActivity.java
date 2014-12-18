package com.youngbin.magic.coin;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;


public class BtnTriggerActivity extends Activity {
    ImageView Coin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn_trigger);
        Coin= (ImageView)findViewById(R.id.coin);
    }

    @Override
    public void onBackPressed(){
        final Handler handler = new Handler();
        TimerTask tTask = new TimerTask() {
            @Override
            public void run() {


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Drawable coinimg = BtnTriggerActivity.this.
                                getResources().getDrawable(R.drawable.coin);
                        Coin.setImageDrawable(coinimg);
                    }
                });

                TimerTask ttTask = new TimerTask() {
                    @Override
                    public void run() {
                        finish();
                    }
                };
                Timer mTimer = new Timer();
                mTimer.schedule(ttTask, 3000);
            }
        };
        Timer mTimer = new Timer();

        mTimer.schedule(tTask, 3000);
    }


}
