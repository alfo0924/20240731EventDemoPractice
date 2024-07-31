package com.example.a20240731eventdemopractice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView sizeDisplay;
    private float textSize = 16f; // Initial text size in SP

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize views
        textView = findViewById(R.id.textView);
        sizeDisplay = findViewById(R.id.sizeDisplay);
        Button zoomInButton = findViewById(R.id.zoomIn);
        Button zoomOutButton = findViewById(R.id.zoomOut);

        // Set initial text size
        updateTextSize();

        // Set button click listeners
        zoomInButton.setOnClickListener(v -> {
            textSize *= 1.5; // Increase text size by 2 SP
            updateTextSize();
        });

        zoomOutButton.setOnClickListener(v -> {
            textSize /= 2; // Decrease text size by 2 SP
            updateTextSize();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void updateTextSize() {
        textView.setTextSize(textSize);
        sizeDisplay.setText("Text Size: " + textSize + "sp");
    }
}