package dev.karl.fortuneflipfun;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

import dev.karl.fortuneflipfun.databinding.ActivityMainMemoryGameBinding;

public class MainMemoryGame extends AppCompatActivity {
    ActivityMainMemoryGameBinding binding;
    GridAdapter gridAdapter;
    ArrayList<CardsModel> intList = new ArrayList<>();

    boolean firstOpen;
    Integer firstCardPosition, openedCtr;

    TextView tvResetBtn;
    Chronometer cmGameTime;

    public MediaPlayer openSound, wrongSound, correctSound, completeSound, resetSound, bgSound, closeDiaSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainMemoryGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setStatusBarColor(ContextCompat.getColor(MainMemoryGame.this, R.color.black));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MainMemoryGame.this, R.color.black));
        //
        bgSound =MediaPlayer.create(this, R.raw.bg_music_memo_game);
        bgSound.setLooping(true);

        openSound = MediaPlayer.create(this, R.raw.open_sound);
        wrongSound = MediaPlayer.create(this, R.raw.wrong_open_sound);
        correctSound = MediaPlayer.create(this, R.raw.correct_open_sound);
        completeSound = MediaPlayer.create(this, R.raw.comlpete_sound);
        resetSound = MediaPlayer.create(this, R.raw.restart_sound);
        closeDiaSound = MediaPlayer.create(this, R.raw.close_dia_sound);

        cmGameTime = findViewById(R.id.cmClock);
        tvResetBtn = findViewById(R.id.tvResetBtn);

        bgSound.seekTo(0);
        bgSound.start();
        newGame();

        binding.gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            if (!firstOpen && !gridAdapter.cardsList.get(i).isFlippedOpen){

                firstOpen = true;
                firstCardPosition = i;
                gridAdapter.flipOpen(i);
                openSound.seekTo(0);
                openSound.start();

            }else if (firstOpen && !gridAdapter.cardsList.get(i).isFlippedOpen){

                gridAdapter.flipOpen(i);
                if (Objects.equals(gridAdapter.cardsList.get(i).resource, gridAdapter.cardsList.get(firstCardPosition).resource)){
                    gridAdapter.setColorIndicator(i, 2);
                    gridAdapter.setColorIndicator(firstCardPosition, 2);
                    openedCtr++;
                    if (openedCtr == 18){
                        //win
                        Toast.makeText(MainMemoryGame.this, "You won!", Toast.LENGTH_SHORT).show();
                        winDialog(cmGameTime.getText().toString());
                        completeSound.seekTo(0);
                        completeSound.start();
                    }else {
                        correctSound.seekTo(0);
                        correctSound.start();
                    }
                }else{
                    //
                    binding.gridView.setEnabled(false);


                    gridAdapter.setColorIndicator(i, 1);
                    gridAdapter.setColorIndicator(firstCardPosition, 1);

                    wrongSound.seekTo(0);
                    wrongSound.start();
                    new Handler().postDelayed(() -> {
                        gridAdapter.flipClose(i);
                        gridAdapter.flipClose(firstCardPosition);
                        gridAdapter.setColorIndicator(i, 0);
                        gridAdapter.setColorIndicator(firstCardPosition, 0);
                        binding.gridView.setEnabled(true);
                        firstCardPosition = null;
                    }, 500);

                }

                firstOpen = false;
            }
        });

        tvResetBtn.setOnClickListener(view -> {
            newGame();
        });

    }
    public void newGame(){
        resetSound.seekTo(0);
        resetSound.start();

        cmGameTime.setBase(SystemClock.elapsedRealtime());
        cmGameTime.start();

        intList.clear();
        intList.add(new CardsModel(R.drawable.card01,false, 0));
        intList.add(new CardsModel(R.drawable.card02,false, 0));
        intList.add(new CardsModel(R.drawable.card03,false, 0));
        intList.add(new CardsModel(R.drawable.card04,false, 0));
        intList.add(new CardsModel(R.drawable.card05,false, 0));
        intList.add(new CardsModel(R.drawable.card06,false, 0));
        intList.add(new CardsModel(R.drawable.card07,false, 0));
        intList.add(new CardsModel(R.drawable.card08,false, 0));
        intList.add(new CardsModel(R.drawable.card09,false, 0));
        intList.add(new CardsModel(R.drawable.card10,false, 0));
        intList.add(new CardsModel(R.drawable.card11,false, 0));
        intList.add(new CardsModel(R.drawable.card12,false, 0));
        intList.add(new CardsModel(R.drawable.card13,false, 0));
        intList.add(new CardsModel(R.drawable.card14,false, 0));
        intList.add(new CardsModel(R.drawable.card15,false, 0));
        intList.add(new CardsModel(R.drawable.card16,false, 0));
        intList.add(new CardsModel(R.drawable.card17,false, 0));
        intList.add(new CardsModel(R.drawable.card18,false, 0));
        intList.add(new CardsModel(R.drawable.card01,false, 0));
        intList.add(new CardsModel(R.drawable.card02,false, 0));
        intList.add(new CardsModel(R.drawable.card03,false, 0));
        intList.add(new CardsModel(R.drawable.card04,false, 0));
        intList.add(new CardsModel(R.drawable.card05,false, 0));
        intList.add(new CardsModel(R.drawable.card06,false, 0));
        intList.add(new CardsModel(R.drawable.card07,false, 0));
        intList.add(new CardsModel(R.drawable.card08,false, 0));
        intList.add(new CardsModel(R.drawable.card09,false, 0));
        intList.add(new CardsModel(R.drawable.card10,false, 0));
        intList.add(new CardsModel(R.drawable.card11,false, 0));
        intList.add(new CardsModel(R.drawable.card12,false, 0));
        intList.add(new CardsModel(R.drawable.card13,false, 0));
        intList.add(new CardsModel(R.drawable.card14,false, 0));
        intList.add(new CardsModel(R.drawable.card15,false, 0));
        intList.add(new CardsModel(R.drawable.card16,false, 0));
        intList.add(new CardsModel(R.drawable.card17,false, 0));
        intList.add(new CardsModel(R.drawable.card18,false, 0));

        Collections.shuffle(intList);

        gridAdapter = new GridAdapter(MainMemoryGame.this, intList);
        binding.gridView.setAdapter(gridAdapter);

        firstOpen = false;
        openedCtr = 0;
    }

    public void winDialog(String time){
        //
        cmGameTime.stop();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainMemoryGame.this);
        View v = getLayoutInflater().inflate(R.layout.win_dialog, null);

        TextView tvTime = v.findViewById(R.id.tvTimer);
        tvTime.setText(time);

        builder.setView(v);
        builder.setCancelable(true);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        alertDialog.setOnDismissListener(dialogInterface -> {
            closeDiaSound.seekTo(0);
            closeDiaSound.start();
        });
    }

    @Override
    protected void onStop() {
        cmGameTime.stop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        cmGameTime.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        cmGameTime.stop();
        bgSound.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cmGameTime.start();
        bgSound.start();
    }
}