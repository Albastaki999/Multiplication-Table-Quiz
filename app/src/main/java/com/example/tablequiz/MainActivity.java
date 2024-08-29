package com.example.tablequiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView; // No
    private TextView textView3; // n1
    private TextView textView5; // n2
    private EditText editTextNumber; // Answer
    private Button button; // Submit
    private Random rand;
    private int no = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        editTextNumber = findViewById(R.id.editTextNumber);
        button = findViewById(R.id.button);
        rand = new Random();

        // Initialize textView with a default value
        textView.setText(String.valueOf(no));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick();
            }
        });

        // Set initial random values for textView3 and textView5
        updateQuestion();
    }

    private void updateQuestion() {
        int n1 = rand.nextInt(10) + 1;
        int n2 = rand.nextInt(10) + 1;
        textView3.setText(String.valueOf(n1));
        textView5.setText(String.valueOf(n2));
    }

    private void handleButtonClick() {
        if (!editTextNumber.getText().toString().equals("")) {
            int n1 = Integer.parseInt(textView3.getText().toString());
            int n2 = Integer.parseInt(textView5.getText().toString());

            if (Integer.parseInt(editTextNumber.getText().toString()) == (n1 * n2)) {
                Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                editTextNumber.setText("");
                no++;
                textView.setText(String.valueOf(no));
            } else {
                Toast.makeText(MainActivity.this, "Wrong, "+n1+" x "+n2+" = "+(n1*n2), Toast.LENGTH_SHORT).show();
                editTextNumber.setText("");
                no = 1;
                textView.setText(String.valueOf(no));
            }

            // Update question after handling button click
            updateQuestion();
        }
    }
}
