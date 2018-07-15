package com.example.varun.myquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    // Question 1
    RadioButton questionOneChoiceThree;
    // Question 2
    RadioButton questionTwoChoiceTwo;
    // Question 3
    CheckBox questionThreeChoiceOne;
    CheckBox questionThreeChoiceTwo;
    CheckBox questionThreeChoiceThree;
    CheckBox questionThreeChoiceFour;
    // Question 4
    RadioButton questionFourChoiceTwo;
    // Question 5
    EditText questionFiveAnswer_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide the keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_main);
    }


    public void submitAnswers(View view) {
        CharSequence resultsDisplay;
        Log.e(LOG_TAG, " " + this.findViewById(R.id.questionThreeChoiceThree));
        int answerOneScore;
        int answerTwoScore;
        int answerThreeScore;
        int answerFourScore;
        int answerFiveScore;
        int finalScore;

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is #3 (DNA)
        //------------------------------------------------------------------------------------------
        Boolean answerOne;

        questionOneChoiceThree = this.findViewById(R.id.questionOneChoiceThree);
        answerOne = questionOneChoiceThree.isChecked();
        if (answerOne) {
            answerOneScore = 1;
        } else {
            answerOneScore = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 2  - Correct Answers is #2 "Pine trees"
        //------------------------------------------------------------------------------------------
        Boolean answer5;
        questionTwoChoiceTwo = this.findViewById(R.id.questionTwoChoiceTwo);
        answer5 = questionTwoChoiceTwo.isChecked();
        if (answer5) {
            answerTwoScore = 1;
        } else {
            answerTwoScore = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 3  - Correct Answers are #3 (Harayana) and #4 (Punjab)
        //------------------------------------------------------------------------------------------
        Boolean answerSevenChoiceOne;
        Boolean answerSevenChoiceTwo;
        Boolean answerSevenChoiceThree;
        Boolean answerSevenChoiceFour;
        questionThreeChoiceOne = this.findViewById(R.id.questionThreeChoiceOne);
        questionThreeChoiceTwo = this.findViewById(R.id.questionThreeChoiceTwo);
        questionThreeChoiceThree = this.findViewById(R.id.questionThreeChoiceThree);
        questionThreeChoiceFour = this.findViewById(R.id.questionThreeChoiceFour);
        answerSevenChoiceOne = questionThreeChoiceOne.isChecked();
        answerSevenChoiceTwo = questionThreeChoiceTwo.isChecked();
        answerSevenChoiceThree = questionThreeChoiceThree.isChecked();
        answerSevenChoiceFour = questionThreeChoiceFour.isChecked();
        if (!answerSevenChoiceOne && !answerSevenChoiceTwo && answerSevenChoiceThree && answerSevenChoiceFour) {
            answerThreeScore = 1;
        } else {
            answerThreeScore = 0;
        }


        //------------------------------------------------------------------------------------------
        // Question 4  - Correct Answers is #2 "Patna"
        //------------------------------------------------------------------------------------------
        Boolean answerFour;
        questionFourChoiceTwo = this.findViewById(R.id.questionFourChoiceTwo);
        answerFour = questionFourChoiceTwo.isChecked();
        if (answerFour) {
            answerFourScore = 1;
        } else {
            answerFourScore = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 5 - Correct Answer is "NEW DELHI"
        //------------------------------------------------------------------------------------------
        String answerFive;
        questionFiveAnswer_ = this.findViewById(R.id.questionFiveAnswer);
        answerFive = questionFiveAnswer_.getText().toString().toLowerCase();
        if (answerFive.equals("new delhi")) {
            answerFiveScore = 1;
        } else {
            answerFiveScore = 0;
        }

        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        finalScore = answerOneScore + answerTwoScore + answerThreeScore + answerFourScore + answerFiveScore;

        if (finalScore == 5) {
            resultsDisplay = "Perfect! You scored 5 out of 5";
        } else {
            resultsDisplay = "Try again. You scored " + finalScore + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
