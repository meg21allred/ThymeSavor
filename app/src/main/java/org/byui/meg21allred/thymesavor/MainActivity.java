package org.byui.meg21allred.thymesavor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button enterNewRecipeBtn;
    private SoundPool soundPool;
    private int yumSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        enterNewRecipeBtn = (Button) findViewById(R.id.enterNewRecipeBtn);

       soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);

       yumSound = soundPool.load(this, R.raw.yum_sound, 1);

    }

    public void newRecipe(View v) {
        openNewRecipeActivity();
    }

    public void openNewRecipeActivity() {
        Intent intent = new Intent(this, AddRecipeRoom.class);
        soundPool.play(yumSound, 5,5,0,0,1);
        startActivity(intent);

    }

}
