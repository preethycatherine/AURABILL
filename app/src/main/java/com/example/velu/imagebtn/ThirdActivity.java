package com.example.velu.imagebtn;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
public class ThirdActivity extends AppCompatActivity {

    Button button1;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

          String prodnm1[]=new String[100];
          TextView showCartContent=(TextView)findViewById(R.id.showcart);
        String show="";
        int txt=0;

     //   System.out.println("qty_optd1= " +qty_optd1);
        System.out.println("Items in the Cart");
        System.out.println("-----------------");
        for(int i=0;i<prodnm1.length;i++) {
          //  if (SecondActivity.getamt()[i] != null)
            if (SecondActivity.getVariable()[i] != null)
            {
                System.out.println(SecondActivity.getVariable()[i]+","+SecondActivity.getqty()[i] + " , " + SecondActivity.getamt()[i]);
                             show += "Item Name : " + SecondActivity.getVariable()[i] + "\n" +
                        "Quantity : " +SecondActivity.getqty()[i]+"\n"+
                        "Price    : Rs." + SecondActivity.getamt()[i] + "\n"+
                        "-----------------------------------------------\n";
            }
        }
         showCartContent.setText(show);
    }

}
