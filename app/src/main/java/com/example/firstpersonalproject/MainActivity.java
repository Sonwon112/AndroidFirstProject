package com.example.firstpersonalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtClassList1, txtClassList2, txtClassList3, txtClassList4, txtClassList5, txtClassList6;
    Button btnEditProfile, btnEditListenClassList;
    ImageButton imgBtn;

    String[] linkArr = {"https://lms.yc.ac.kr/course/view.php?id=3410",
            "https://lms.yc.ac.kr/course/view.php?id=3408",
            "https://lms.yc.ac.kr/course/view.php?id=3229",
            "https://lms.yc.ac.kr/course/view.php?id=3394",
            "https://lms.yc.ac.kr/course/view.php?id=3371",
            "https://lms.yc.ac.kr/course/view.php?id=3226"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtn = (ImageButton) findViewById(R.id.imgBtn);

        btnEditProfile = (Button) findViewById(R.id.btnEditProfile);
        btnEditListenClassList = (Button) findViewById(R.id.btnEditListenClassList);

        txtClassList1 = (TextView) findViewById(R.id.txtClassList1);
        txtClassList2 = (TextView) findViewById(R.id.txtClassList2);
        txtClassList3 = (TextView) findViewById(R.id.txtClassList3);
        txtClassList4 = (TextView) findViewById(R.id.txtClassList4);
        txtClassList5 = (TextView) findViewById(R.id.txtClassList5);
        txtClassList6 = (TextView) findViewById(R.id.txtClassList6);

        imgBtn.setOnClickListener(view -> {
            goEditProfileActivity();
        });
        btnEditProfile.setOnClickListener(view -> {
            goEditProfileActivity();
        });

        txtClassList1.setOnClickListener(listClick);
        txtClassList2.setOnClickListener(listClick);
        txtClassList3.setOnClickListener(listClick);
        txtClassList4.setOnClickListener(listClick);
        txtClassList5.setOnClickListener(listClick);
        txtClassList6.setOnClickListener(listClick);

    }

    View.OnClickListener listClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String link = "";
            switch (view.getId()){
                case R.id.txtClassList1:
                    link = linkArr[0];
                    break;
                case R.id.txtClassList2:
                    link = linkArr[1];
                    break;
                case R.id.txtClassList3:
                    link = linkArr[2];
                    break;
                case R.id.txtClassList4:
                    link = linkArr[3];
                    break;
                case R.id.txtClassList5:
                    link = linkArr[4];
                    break;
                case R.id.txtClassList6:
                    link = linkArr[5];
                    break;
            }
            goClassWebSite(link);
        }
    };

    public void goClassWebSite(String link){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(link));
        startActivity(intent);
    }

    public void goEditProfileActivity(){
        Intent intent = new Intent(getApplicationContext(),EditProfile.class);
        startActivity(intent);
    }
}

/*Uri Uniform Resource Identifier의 약자
        리소스를 구별하는 식별자
        Uri를  통해 우리가 접근해야 하는 리소스가 어디있는지 알 수 있다.
        Uri는 인터넷, 모바일 기기에서도 Uri 형식이 지정되어 있다.
        이를 이용해 OS 내부의 리소스에 접근 할 수 있다.
        intent에 인자를 어떤것을 넣느냐에 따라 전화걸기/
        웹 브라우저/ 갤러리/ 카메라/ 음악/동영상 실행 가능*/