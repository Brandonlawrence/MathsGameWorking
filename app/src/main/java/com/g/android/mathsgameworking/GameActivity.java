package com.g.android.mathsgameworking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {

    TextView questionTextView;
    EditText answerField;
    Button submitButton;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);






        questionTextView = (TextView) findViewById(R.id.questionTextView);
        answerField = (EditText) findViewById(R.id.answerField);
        submitButton = (Button) findViewById(R.id.submitAnswer);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String question = game.getQuestionsArrayList().get(0);
                questionTextView.setText(question);
                Log.d("MathsGameWorking", String.valueOf(game.getQuestionsArrayList().size()));
            }
        });
    }
}
