package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private TextView completeText;
    private ImageButton nextButton;

    private int currentQuestionIndex;

    private Question[] questionBank = new Question[] {

          new Question(R.string.my_text_question, false),
          new Question(R.string.textQ, true),
          new Question(R.string.textQ1, false),
          new Question(R.string.textQ3, true),
          new Question(R.string.textQ4, true),

        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Question question = new Question(R.string.my_text_question, true);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        completeText = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_button);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                 checkAnswer(true);
                 break;

            case R.id.next_button:
                currentQuestionIndex++;
                Log.d("Current", "On Click" + currentQuestionIndex);
                completeText.setText(questionBank[currentQuestionIndex].getAnswerResID());
                if(currentQuestionIndex == (questionBank.length -1)) {
                    currentQuestionIndex = -1;
                }
        }
    }
    private void checkAnswer(boolean userChoseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId = 0;

        if (userChoseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, toastMessageId,Toast.LENGTH_SHORT).show();

    }
}
