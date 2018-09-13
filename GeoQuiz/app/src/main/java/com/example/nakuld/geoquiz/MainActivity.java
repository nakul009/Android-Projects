package com.example.nakuld.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";
    Button mTrueButton;
    Button mFalseButton;
    Button mNextButton;
    TextView mQuestionTextView;
    TrueFalse[] mQuestionStore = new TrueFalse[]{new TrueFalse(2130968584, true), new TrueFalse(2130968585, false), new TrueFalse(2130968586, false), new TrueFalse(2130968587, true), new TrueFalse(2130968588, true)};
    int mCurrentIndex = 0;

    public MainActivity() {
    }

    private void updateQuestion() {
        int question = this.mQuestionStore[this.mCurrentIndex].getQuestion();
        this.mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = this.mQuestionStore[this.mCurrentIndex].isTrueQuestion();
        boolean messageResId = false;
        int messageResId1;
        if(userPressedTrue == answerIsTrue) {
            messageResId1 = 2130968581;
        } else {
            messageResId1 = 2130968582;
        }

        Toast.makeText(this, messageResId1, 0).show();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("QuizActivity", "onCreate() called");
        this.setContentView(2130903040);
        this.mTrueButton = (Button)this.findViewById(2131165185);
        this.mTrueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.checkAnswer(true);
            }
        });
        this.mFalseButton = (Button)this.findViewById(2131165186);
        this.mFalseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.checkAnswer(false);
            }
        });
        this.mNextButton = (Button)this.findViewById(2131165187);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.updateQuestion();
            }
        });
        if(savedInstanceState != null) {
            this.mCurrentIndex = savedInstanceState.getInt("index", 0);
        }

        this.updateQuestion();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("QuizActivity", "onSaveInstanceState");
        savedInstanceState.putInt("index", this.mCurrentIndex);
    }

    public void onStart() {
        super.onStart();
        Log.i("QuizActivity", "onStart");
    }

    public void onResume() {
        super.onResume();
        Log.i("QuizActivity", "onResume");
    }

    public void onPause() {
        super.onPause();
        Log.i("QuizActivity", "onPause");
    }

    public void onStop() {
        super.onStop();
        Log.i("QuizActivity", "onStop");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("QuizActivity", "onDestroy");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131099648, menu);
        return true;
    }
}
