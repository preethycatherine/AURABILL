package com.example.velu.imagebtn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    ImageButton imageButton,imageButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }
    public void addListenerOnButton() {
        imageButton = (ImageButton) findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this,
                        "You have chosen Quick Bites", Toast.LENGTH_SHORT).show();
                               {goToSecondActivity();}

            }


        });
        imageButton2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Toast.makeText(MainActivity.this,
                        "You have chosen Cool Drinks", Toast.LENGTH_SHORT).show();
                {goTocooldrinks();}

            }


        });
    }
    private void goToSecondActivity()
    {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    private void goTocooldrinks()
    {
        Intent intent = new Intent(this, cool_drinks.class);
        startActivity(intent);
    }
}
