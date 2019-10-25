package inetinfotech.north.songs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button a,b,c,d;
    int n,y;
    MediaPlayer mp;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        y=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        a=findViewById(R.id.button);
        b=findViewById(R.id.button2);
        c=findViewById(R.id.button3);
        d=findViewById(R.id.button4);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mp=MediaPlayer.create(MainActivity.this,R.raw.abc);
               mp.start();
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,y, 0);//increase volume in app
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=mp.getCurrentPosition();
                mp.pause();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(n);
                mp.start();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
            }
        });
    }
}
