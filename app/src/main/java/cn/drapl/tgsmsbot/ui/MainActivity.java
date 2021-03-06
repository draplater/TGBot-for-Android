package cn.drapl.tgsmsbot.ui;

import android.os.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.content.Intent;
import android.widget.Button;

import cn.drapl.tgsmsbot.R;
import cn.drapl.tgsmsbot.TGPoll;

/*
TGBot for Android
Agus Ibrahim
http://fb.me/mynameisagoes

License: GPLv2
http://www.gnu.org/licenses/gpl-2.0.html
*/
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button startBtn = (Button) findViewById(R.id.btn_start);
        startBtn.setOnClickListener(v -> {
            String errMsg = TGPoll.checkConfig(MainActivity.this);
            if(errMsg.length() != 0) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(
                        MainActivity.this)
                        .setMessage(errMsg)
                        .setPositiveButton("OK", ((dialog, which) -> dialog.cancel()));
                builder1.create().show();
                return;
            }
            Intent startIntent = new Intent(MainActivity.this, TGPoll.class);
            startService(startIntent);
        });

        Button stopBtn = (Button) findViewById(R.id.btn_stop);
        stopBtn.setOnClickListener(v -> {
            Intent stopIntent = new Intent(MainActivity.this, TGPoll.class);
            stopService(stopIntent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_config:
                startActivity(new Intent(this, SettingActivity.class));
        }
        return true;
    }
}