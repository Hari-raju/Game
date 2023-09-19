package com.raju.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Random compChoices = new Random(3);
    ImageView rockB,paperB,scissorB;
    TextView userScore,compScore;
    Button playAgain;
    static int totChances=0;
    static int userPoints=0;
    static int compPoints=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigning layout button id's to Objects in java file

        rockB=findViewById(R.id.Rock);
        paperB=findViewById(R.id.Paper);
        scissorB=findViewById(R.id.Scissors);
        playAgain=findViewById(R.id.game_over);

        //Assigning layout scores in text id's to objects of Textview in code

        userScore=findViewById(R.id.user_score);
        compScore=findViewById(R.id.comp_score);

        //Setting initial Scores
        userScore.setText(String.valueOf(userPoints));
        compScore.setText(String.valueOf(compPoints));
        Listeners();

    }

    private void Listeners(){
        rockB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totChances<10){
                    totChances++;
                    int compChoice=compChoices.nextInt(3);
                    if(compChoice==1){
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                    }
                    else if(compChoice==2){
                        userPoints++;
                        userScore.setText(String.valueOf(userPoints));
                    }
                    else{
                        userPoints++;
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                        userScore.setText(String.valueOf(userPoints));
                    }
                }
                else{
                    String winner=userPoints>compPoints ? "User Won" : "Comp Won";
                    Toast.makeText(MainActivity.this, winner+" and Game Over", Toast.LENGTH_SHORT).show();
                }
            }
        });

        paperB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totChances<10){
                    totChances++;
                    int compChoice=compChoices.nextInt(3);
                    if(compChoice==2){
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                    }
                    else if(compChoice==0){
                        userPoints++;
                        userScore.setText(String.valueOf(userPoints));
                    }
                    else{
                        userPoints++;
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                        userScore.setText(String.valueOf(userPoints));
                    }
                }
                else{
                    String winner=userPoints>compPoints ? "User Won" : "Comp Won";
                    Toast.makeText(MainActivity.this, winner+" and Game Over", Toast.LENGTH_SHORT).show();
                }
            }
        });

        scissorB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totChances<10){
                    totChances++;
                    int compChoice=compChoices.nextInt(3);
                    if(compChoice==0){
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                    }
                    else if(compChoice==1){
                        userPoints++;
                        userScore.setText(String.valueOf(userPoints));
                    }
                    else{
                        userPoints++;
                        compPoints++;
                        compScore.setText(String.valueOf(compPoints));
                        userScore.setText(String.valueOf(userPoints));
                    }
                }
                else{
                    String winner=userPoints>compPoints ? "User Won" : "Comp Won";
                    Toast.makeText(MainActivity.this, winner+" and Game Over", Toast.LENGTH_SHORT).show();
                }
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userPoints=0;
                compPoints=0;
                compScore.setText(String.valueOf(compPoints));
                userScore.setText(String.valueOf(userPoints));
                Toast.makeText(MainActivity.this, "Lets Start", Toast.LENGTH_SHORT).show();
            }
        });
    }
}