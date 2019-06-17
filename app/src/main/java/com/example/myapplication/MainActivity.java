package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText people=findViewById(R.id.People);
        String test=people.getText().toString();
        final String num=test;

        //num , test 데이터 확인 테스트 코드
        System.out.println("people num= "+num+"test"+test);

        final int Count[] = new int[9];
        for(int i=0; i<9;i++){
            Count[i] =0;
        }

        ImageView image[] = new ImageView[9];
        Integer imageId[] = {R.id.ima1,R.id.ima2,R.id.ima3,R.id.ima4,R.id.ima5,R.id.ima6,R.id.ima7,R.id.ima8,R.id.ima9};
        final String imgName[] = {"떡볶이", "순대", "김밥","어묵","튀김", "라면", "비빔밥","냉면","음료"};

        for(int i=0; i<imageId.length; i++){
            final int index;
            index =i;
            image[index]=findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Count[index]++;
                    Toast.makeText(getApplicationContext(), imgName[index]+" 총 "+Count[index]+"개 선택",Toast.LENGTH_LONG).show();
                }
            });
        }

        setTitle("느리킹 분식");


        Button orderButton;
        orderButton=findViewById(R.id.OrderButton);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),second_activity.class);
                intent.putExtra("VoteCount",Count);
                intent.putExtra("ImageName",imgName);
                intent.putExtra("peopleNum",num);
                startActivity(intent);

                //second_activity 에 데이터 전송후 음식 Count초기화 코드
                for(int i=0; i<9; i++) {
                    Count[i]=0;
                }
            }
        });



    }
}
