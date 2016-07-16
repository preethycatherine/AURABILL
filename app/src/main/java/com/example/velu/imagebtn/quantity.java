package com.example.velu.imagebtn;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quantity extends AppCompatActivity implements MediaPlayer.OnCompletionListener
{
    Button button1;
    int ct=0;
    public RadioGroup radioGroup;
    public static String qty_optd;
    int ply_cnt=0;
    private Integer audio_qty[]={
            R.raw.one,
            R.raw.two,
            R.raw.three,
            R.raw.four,
            R.raw.five
    };
    public static int qty_optd1,cnt_q;
    public MediaPlayer mp;
    public static int qtyfinal[]=new int[100];
    public static int q1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cnt_q++;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_popup);
        addListenerOnButton();
        mp = MediaPlayer.create(getApplicationContext(), audio_qty[ply_cnt]);
        mp.setOnCompletionListener(this);
        mp.start();
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        int checked=radioGroup.getCheckedRadioButtonId();
       // for(int i=0;i<qtyfinal.length;i++)
        {
         //   qtyfinal[i]=0;
        }

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=(RadioButton)findViewById(checkedId);
                Toast.makeText(getApplicationContext(), rb.getText(), Toast.LENGTH_SHORT).show();
                qty_optd=rb.getText().toString();
               qtyfinal[q1]=Integer.parseInt(qty_optd);
               q1++;
            }
        });

        qty_optd1++;
    }
    public void addListenerOnButton() {
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mp.release();

                goToSecondActivity();
            }
        });
    }
    private void goToSecondActivity()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    public static int[] getqtys()
    {return qtyfinal;}
    public static int getVariable()
    {return cnt_q;}
    public void onCompletion(MediaPlayer arg0) {
        arg0.release();
        if (ply_cnt < audio_qty.length-1) {
            ply_cnt++;
            arg0 = MediaPlayer.create(getApplicationContext(), audio_qty[ply_cnt]);
            arg0.setOnCompletionListener(this);
            arg0.start();
        }
    }
    public static String getVariable1()
    {return qty_optd;}
}
