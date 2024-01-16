package dev.karl.fortuneflipfun;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MenuActivity extends AppCompatActivity {
    TextView playBtn, howTo, exitBtn, policyBtn;
    CheckBox acceptCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getWindow().setStatusBarColor(ContextCompat.getColor(MenuActivity.this, R.color.black));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MenuActivity.this, R.color.black));

        playBtn = findViewById(R.id.tvPlayBtn);
        howTo = findViewById(R.id.tvHowToPlay);
        exitBtn = findViewById(R.id.tvExitBtn);
        policyBtn = findViewById(R.id.tvPolicyBtn);
        acceptCb = findViewById(R.id.cbIAgree);

        playBtn.setOnClickListener(view -> {
            if (acceptCb.isChecked()){
                Intent i = new Intent(MenuActivity.this, MainMemoryGame.class);
                startActivity(i);
            }else{
                //dia
                policyDialogMemoryGame();
            }

        });

        howTo.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this, HowToMemoryGame.class);
            startActivity(i);
        });
        exitBtn.setOnClickListener(view -> {
            finishAffinity();
        });

        policyBtn.setOnClickListener(view -> {
            Intent i = new Intent(MenuActivity.this, MemoryGamePolicyActivity.class);
            startActivity(i);
        });

        acceptCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!acceptCb.isChecked()){
                    policyDialogMemoryGame();
                }
            }
        });
    }

    public void policyDialogMemoryGame(){
        //
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        View v = getLayoutInflater().inflate(R.layout.policy_dialog_memory_game, null);

        TextView btn = v.findViewById(R.id.tvOkBtnPolicyDialog);

        builder.setView(v);
        builder.setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        btn.setOnClickListener(view -> {
            alertDialog.dismiss();
        });

    }
}