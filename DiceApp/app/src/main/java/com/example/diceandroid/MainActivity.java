 package com.example.diceandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

 public class MainActivity extends AppCompatActivity {
    Button btnRoll;
    Random rand = new Random();



    void clickFunction(){
        ImageView dice1 = findViewById(R.id.firstDice);
        ImageView dice2 = findViewById(R.id.secondDice);
        int [] dices = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

        int randomNumberLength= dices.length;
        int randomNumber = rand.nextInt(randomNumberLength);
        dice1.setImageResource(dices[randomNumber]);
        int randomNumber2 = rand.nextInt(randomNumberLength);
        dice2.setImageResource(dices[randomNumber2]);


//        Log.i("DiceApp","The random Number is  " + dices.length);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRoll = findViewById(R.id.dicRoll);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
clickFunction();
mp.start();

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.firstDice));
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.secondDice));
            }
        });

    }
}