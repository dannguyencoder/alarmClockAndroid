package com.vinh.alarmclockandroid.activities;

import android.animation.ObjectAnimator;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vinh.alarmclockandroid.R;
import com.vinh.alarmclockandroid.database.DatabaseHandle;
import com.vinh.alarmclockandroid.database.QuizModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnswerQuestionsActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = AnswerQuestionsActivity.class.toString() ;
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i = 0;

    TextView noidungcauhoi_tv;
    RadioButton dapanA_rb, dapanB_rb, dapanC_rb, dapanD_rb;
    Button traloi_btn, boqua_btn;

    private QuizModel quizModel;

    List<QuizModel> quizList = new ArrayList<>();

    public int soCauTraLoiDung = 0;

    public boolean kiemTra = true;

    CountDownTimer countDown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_questions);

        startAniamtion();
        setupUI();
        loadData();
        startCountDownTimer();
//        kiemTraSoCauTraLoiDung();

        traloi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyCauTraLoi();
            }
        });

        boqua_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenCauHoi();
            }
        });
    }

    private void kiemTraSoCauTraLoiDung() {
        while (kiemTra)
        {
            if (soCauTraLoiDung == 3)
            {
                Toast.makeText(this, "Bạn đã trả lời được đủ 3 câu", Toast.LENGTH_SHORT).show();
                kiemTra = false;
            }
        }
    }

    private void startCountDownTimer() {

        boqua_btn.setEnabled(false);


        countDown = new CountDownTimer(15000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                boqua_btn.setText("Bỏ qua(15 giây)");
                int soGiayBoQua = (int) millisUntilFinished/1000;
                boqua_btn.setText(String.format("Bỏ qua(%s giây)", soGiayBoQua));
            }

            @Override
            public void onFinish() {
                boqua_btn.setText(String.format("Bỏ qua"));
                boqua_btn.setEnabled(true);
            }
        };

        countDown.start();
    }

    private void loadData() {

        quizList = DatabaseHandle.getInstance(this).getListQuiz();

        Random rand = new Random();

        int n = rand.nextInt(15) + 0;

        quizModel = quizList.get(n);

        Log.d(TAG, "loadData: " + quizModel.getQuestion());

        noidungcauhoi_tv.setText(quizModel.getQuestion());

        dapanA_rb.setText(quizModel.getAnswera());
        dapanB_rb.setText(quizModel.getAnswerb());
        dapanC_rb.setText(quizModel.getAnswerc());
        dapanD_rb.setText(quizModel.getAnswerd());
    }

    private void setupUI() {
        noidungcauhoi_tv = (TextView) findViewById(R.id.noidungcauhoi_tv);

        dapanA_rb = (RadioButton) findViewById(R.id.dapanA_rb);
        dapanB_rb = (RadioButton) findViewById(R.id.dapanB_rb);
        dapanC_rb = (RadioButton) findViewById(R.id.dapanC_rb);
        dapanD_rb = (RadioButton) findViewById(R.id.dapanD_rb);

        traloi_btn = (Button) findViewById(R.id.traloi_btn);
        boqua_btn = (Button) findViewById(R.id.boqua_btn);

    }

    private void startAniamtion() {
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 100, 0);
        progressAnimator.setDuration(30000);
        progressAnimator.setInterpolator(new DecelerateInterpolator());
        progressAnimator.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.traloi_btn:
                Log.d(TAG, "onClick: " + quizModel.getRealalswer());
                xulyCauTraLoi();
                break;
            case R.id.boqua_btn:
                chuyenCauHoi();
                break;
        }
    }

    private void xulyCauTraLoi() {
        int cauTraLoi = 0;

        if (dapanA_rb.isChecked())
        {
            cauTraLoi = 1;
        }
        else if (dapanB_rb.isChecked())
        {
            cauTraLoi = 2;
        }
        else if (dapanC_rb.isChecked())
        {
            cauTraLoi = 3;
        }
        else if (dapanD_rb.isChecked())
        {
            cauTraLoi = 4;
        }

        Log.d(TAG, "xulyCauTraLoi: " + quizModel.getRealalswer());
        
        if (cauTraLoi == quizModel.getRealalswer())
        {
            Toast.makeText(this, "Bạn trả lời đúng rồi", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Bạn trả lời đúng rồi");
            chuyenCauHoi();
            soCauTraLoiDung++;
        }
        else
        {
            Toast.makeText(this, "Bạn trả lời sai rồi", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Bạn trả lời sai rồi");
            chuyenCauHoi();
            soCauTraLoiDung = 0;
        }
    }

    private void chuyenCauHoi() {
        Random rand = new Random();

        int n = rand.nextInt(15) + 0;

        quizModel = quizList.get(n);

        Log.d(TAG, "loadData: " + quizModel.getQuestion());

        countDown.cancel();
        startCountDownTimer();
        startAniamtion();

        noidungcauhoi_tv.setText(quizModel.getQuestion());

        dapanA_rb.setText(quizModel.getAnswera());
        dapanB_rb.setText(quizModel.getAnswerb());
        dapanC_rb.setText(quizModel.getAnswerc());
        dapanD_rb.setText(quizModel.getAnswerd());
    }
}
