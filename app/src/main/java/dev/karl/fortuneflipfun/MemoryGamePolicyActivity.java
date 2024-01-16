package dev.karl.fortuneflipfun;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MemoryGamePolicyActivity extends AppCompatActivity {
    TextView btn;
    WebView policyMemoGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game_policy);
        getWindow().setStatusBarColor(ContextCompat.getColor(MemoryGamePolicyActivity.this, R.color.black));
        getWindow().setNavigationBarColor(ContextCompat.getColor(MemoryGamePolicyActivity.this, R.color.black));

        btn = findViewById(R.id.tvAcceptPolicyBtn);
        policyMemoGame = findViewById(R.id.wvPolicyMemoGame);
        policyMemoGame.loadUrl(this.getResources().getString(R.string.policy_url));
        btn.setOnClickListener(view -> {
            finish();
        });
    }
}