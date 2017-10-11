package com.example.hp.chasesitewords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtInfo;
    TextView txtWord;
    EditText edtGuess;
    Button btnCheck;
    Button btnNew;

    Random r;
    String currentWord;

    String[] dictionary = {
            "a",
            "and",
            "are",
            "can",
            "do",
            "for",
            "go",
            "has",
            "have",
            "he",
            "here",
            "I",
            "is",
            "like",
            "little",
            "look",
            "me",
            "my",
            "play",
            "said",
            "see",
            "she",
            "the",
            "this",
            "to",
            "was",
            "we",
            "what",
            "where",
            "with",
            "jump",
            "up",
            "not",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInfo = (TextView)findViewById(R.id.textViewInfo);
        txtWord = (TextView)findViewById(R.id.textViewWord);
        edtGuess = (EditText)findViewById(R.id.editTextGuess);
        btnCheck = (Button)findViewById(R.id.buttonCheck);
        btnNew = (Button)findViewById(R.id.buttonNew);

        r = new Random();
        newGame();


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtGuess.getText().toString().equalsIgnoreCase(currentWord)) {
                    txtInfo.setText("Good job Chase!");
                    btnCheck.setEnabled(false);
                    btnNew.setEnabled(true);

                }
                else {
                    txtInfo.setText("Oops try again Chase!");
                }

            }
        });

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();

            }
        });





    }

    private String shuffleWord(String word){
        List<String> letters = Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for(String letter : letters) {
            shuffled += letter;

        }
        return shuffled;
    }

    private void newGame() {
        currentWord = dictionary[r.nextInt(dictionary.length)];
        txtWord.setText(shuffleWord(currentWord));
        edtGuess.setText("");
        btnNew.setEnabled(false);
        btnCheck.setEnabled(true);
    }
}
