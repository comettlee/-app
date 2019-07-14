package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class second_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        Intent intent=getIntent();
        final int[] voteResult=intent.getIntArrayExtra("VoteCount");
        final String[] imageName=intent.getStringArrayExtra("ImageName");
        String peoplenum=intent.getStringExtra("peopleNum");
        final int[] pri={3000,2500,2000,1000,1500,2500,4000,4500,1000};

        System.out.println("인원수 확인 : peoplenum 값은 : "+peoplenum);

        TextView menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8,menu9,activity_hap,print_OnePeople;

        menu1=findViewById(R.id.Memu1);
        menu2=findViewById(R.id.Memu2);
        menu3=findViewById(R.id.Memu3);
        menu4=findViewById(R.id.Memu4);
        menu5=findViewById(R.id.Memu5);
        menu6=findViewById(R.id.Memu6);
        menu7=findViewById(R.id.Memu7);
        menu8=findViewById(R.id.Memu8);
        menu9=findViewById(R.id.Memu9);

        activity_hap=findViewById(R.id.Hap);
        print_OnePeople=findViewById(R.id.Print_OnePeople);



        int hap=0;
        int cut = 0;
        final TextView menu[]={menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8,menu9};
        for(int i=0;i<9;i++){
            final int index;
            index=i;
            if(voteResult[index]!=0) {
                menu[cut].setVisibility(View.VISIBLE);
                menu[cut].setText(imageName[index] + " 총 " + voteResult[index] + "개 선택");
                cut++;
                hap+=pri[index]*voteResult[index];
                if (cut >= 10) {
                    cut = 0;
                }
            }
        }

        int co=Integer.parseInt(peoplenum);
        activity_hap.setText(hap +"원");
        int comet=hap/co;
        print_OnePeople.setText(comet +"원");


        Button endButton;

        setTitle("주문확인");
        endButton=findViewById(R.id.EndButton);



        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(second_activity.this);
                builder.setTitle("주문 완료");
                builder.setMessage("성공적으로 주문이 완료 되었습니다.");
                builder.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.show();
                Toast.makeText(getApplicationContext(), "주문이 완료 되었습니다. ",Toast.LENGTH_LONG).show();


            }
        });

    }
}
