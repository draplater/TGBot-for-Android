package cn.drapl.tgsmsbot.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cn.drapl.tgsmsbot.R;
import cn.drapl.tgsmsbot.TGPoll;

/**
 * Created by draplater on 2017/10/19.
 */

public class SettingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        Intent startIntent = new Intent(SettingActivity.this, TGPoll.class);
        startService(startIntent);
    }
}