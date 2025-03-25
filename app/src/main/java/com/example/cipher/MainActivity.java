package com.example.cipher;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Load the native C++ library
    static {
        System.loadLibrary("native-lib");
    }

    // Declare native methods
    public native String encrypt(String text);
    public native String decrypt(String text);

    private EditText inputText;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        resultText = findViewById(R.id.resultText);
        Button encryptButton = findViewById(R.id.encryptButton);
        Button decryptButton = findViewById(R.id.decryptButton);

        if (inputText == null || resultText == null || encryptButton == null || decryptButton == null) {
            throw new RuntimeException("One or more UI elements are missing from the layout.");
        }

        encryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputText.getText().toString().trim();
                if (!message.isEmpty()) {
                    String encrypted = encrypt(message);
                    resultText.setText(encrypted);
                } else {
                    resultText.setText("Please enter a message.");
                }
            }
        });

        decryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputText.getText().toString().trim();
                if (!message.isEmpty()) {
                    String decrypted = decrypt(message);
                    resultText.setText(decrypted);
                } else {
                    resultText.setText("Please enter a message.");
                }
            }
        });
    }
}
