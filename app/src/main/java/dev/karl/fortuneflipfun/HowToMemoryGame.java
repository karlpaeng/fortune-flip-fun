package dev.karl.fortuneflipfun;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class HowToMemoryGame extends AppCompatActivity {

    TextView instructions, doneBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_memory_game);

        getWindow().setStatusBarColor(ContextCompat.getColor(HowToMemoryGame.this, R.color.black));
        getWindow().setNavigationBarColor(ContextCompat.getColor(HowToMemoryGame.this, R.color.black));

        instructions = findViewById(R.id.tvInstructions);
        doneBtn = findViewById(R.id.tvDoneHowToBtn);

        instructions.setText(
                "Tap on each square to flip open and reveal the icon. " +
                "Only two icons can be revealed at a time. " +
                "Try to memorize the location of an icon and its identical pair. " +
                "The game ends when all identical icons are completely paired up. " +
                "Good luck, and have fun!");

        doneBtn.setOnClickListener(view -> {
            finish();
        });
    }
}