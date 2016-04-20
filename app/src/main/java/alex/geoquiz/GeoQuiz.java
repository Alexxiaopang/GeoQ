package alex.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

public class GeoQuiz extends Activity {
    private Button truebutton;
    private Button falsebutton;
    private Button mNest;
    private TextView mTextView;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, false),
            new TrueFalse(R.string.question_5, true),

    };
    private int mCurrentIndex = 0;


    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mTextView.setText(question);
    }


    private void checkAnswer(boolean userPressedTrue) {

        boolean answerIstrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId = 0;
        if (userPressedTrue == answerIstrue) {
            messageResId = R.string.corrent;
        } else {
            messageResId = R.string.fcorrent;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geoquiz);
        truebutton = (Button) findViewById(R.id.btn1);
        falsebutton = (Button) findViewById(R.id.btn2);
        mTextView = (TextView) findViewById(R.id.question);
       // int question = mQuestionBank[mCurrentIndex].getQuestion();
       // mTextView.setText(question);
/*
*
* set toast begin
* */
        /*true button begin*/
        truebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast toast = Toast.makeText(GeoQuiz.this, R.string.corrent, Toast.LENGTH_SHORT);
                //toast.show();
                checkAnswer(true);
                Log.e("true", "dianjiletrue");
            }
        });
       /*true button end and false begin*/
        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(GeoQuiz.this, R.string.fcorrent, Toast.LENGTH_LONG).show();
                checkAnswer(false);
                Log.e("false", "dianjilefalse");
            }
        });
        /*false button end*/
/*
* set toast end
*
* */

        mNest = (Button) findViewById(R.id.next_button);
        mNest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                Log.e("mcurrent","is"+mCurrentIndex+"check");
             //   int question = mQuestionBank[mCurrentIndex].getQuestion();
             //   mTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();


    }


}
