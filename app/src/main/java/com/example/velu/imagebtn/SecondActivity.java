package com.example.velu.imagebtn;
import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.PopupMenu;
import android.text.InputType;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Arrays;
public class SecondActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener{
    public static int pg_cnt,itm,gb_val,q1;

    public static String[] val=new String[100];
    int ct=0;
    int ply_cnt=0;  int av=0,gt_i=0;
    public static String prodnm="",prodamt="";
    public static int prodqty=0;
    public static String clknew[]=new String[100];
    public static String prodnm1[]=new String[100];
    public static String prodamt1[]=new String[100];
    public static String clkitms[]=new String[100];
    public static String indx[]=new String[100];
    public static int prodqty1[]=new int[100];
    //  public static int qtyfinal[]=new int[100];
    public static int p1;
    public static String prodfinal[]=new String[100];
    int cnt1=0,cnt=0, cnt_Brownie=0,cnt_Burger=0,cnt_Cole_saw_sandwich=0,cnt_French_fries=0;
    int cnt_Potato_cheese=0,cnt_Vada_paav=0,cnt_Veg_grilled_sandwich=0,cnt_Wedges=0;
    private ListView listview;
    private EditText editText;
    public MediaPlayer mp;
    private Button btn1;
    String shw="";
    private String names[]= {
            "Brownie",
            "Burger",
            "Cole saw sandwich",
            "French fries",
            "Potato cheese",
            "Vada paav",
            "Veg grilled sandwich",
            "Wedges"
    };

    private String desc[]={
            "Rs.60",
            "Rs.35",
            "Rs.40",
            "Rs.75",
            "Rs.40",
            "Rs.50",
            "Rs.50",
            "Rs.50",
            "Rs.45"
    };
    private Integer audio_id[]={
            R.raw.chocolate_milk_shake,
            R.raw.french_fries,
            R.raw.chocolate_milk_shake,
            R.raw.french_fries,
            R.raw.potato_cheese_shots,
            R.raw.vada_paav,
            R.raw.grilled_vegetable_sandwich,
            R.raw.potato_wedges
    };
    private Integer imageid[]={
            R.drawable.brownie,
            R.drawable.burger,
            R.drawable.cole_saw_sandwich,
            R.drawable.french_fries,
            R.drawable.potato_cheese,
            R.drawable.vada_paav,
            R.drawable.veg_grilled_sandwich,
            R.drawable.wedges
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CustomList customList = new CustomList(this, names, desc, imageid);
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(customList);
        mp = MediaPlayer.create(getApplicationContext(), audio_id[ply_cnt]);
        mp.setOnCompletionListener(this);
        mp.start();

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?>adapterView,View view,int i,long l) {
                Toast.makeText(getApplicationContext(), names[i] + " added to cart", Toast.LENGTH_SHORT).show();
                mp.release();
                val[p1]=names[i];
                p1++;
                goToscreenpopup();
                if( (names[i] == "Brownie"))
                {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    integer = prodqty * integer;
                    prodamt = Integer.toString(integer);
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Brownie") {

                            prodnm1[i] = prodnm;
                            prodamt1[i] = prodamt;
                            prodqty1[i] = prodqty;

                            av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }

                        prodnm1[itm] = prodnm;
                        prodamt1[itm] = prodamt;
                        prodqty1[itm] = prodqty;
                          av=0;}

                }
                else if (names[i] == "Burger") {
                    // gt_i=i;
                    //  System.out.println("burger = " + gt_i);
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    //prodqty=quantity.getVariable1();
                    // System.out.println(i +","+ "if prodnm == " +prodnm+","+prodamt +"," + quantity.getVariable() + ", "+prodqty);
                    // Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    //  int integer = in.nextInt();
                    //integer = ct * integer;
                    //prodamt = Integer.toString(integer);
                    //  prodqty=Integer.parseInt(quantity.getVariable().toString());
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    //  integer = prodqty * integer;
                    //  prodamt = Integer.toString(integer);
                    //  System.out.println("if prodamt2 == " +prodamt +"," +ct + ", "+prodamt);
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Burger") {
                            prodnm1[i] = prodnm;
                           // prodamt1[i] = prodamt;
                            //prodqty1[i] = prodqty;
                            // System.out.println("if == " + prodnm1[i] + ", " + prodamt1[i] + " , "+prodqty1[i] );
                            av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        //System.out.println("else part val == " + prodnm + ", " + prodamt + " , "+ct );
                        prodnm1[itm] = prodnm;
                        //prodamt1[itm] = prodamt;
                        //prodqty1[itm] = prodqty;
                        //prodqty1[itm] = cnt;
                        // System.out.println("else part == " + prodnm1[itm] + ", " + prodamt1[itm] + " , "+prodqty1[itm] );
                        av=0;}
                } else if (names[i] == "Cole saw sandwich") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Cole saw sandwich") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                } else if (names[i] == "French fries") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="French fries") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                } else if (names[i] == "Potato cheese") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Potato cheese") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                } else if (names[i] == "Vada paav") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Vada paav") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                } else if (names[i] == "Veg grilled sandwich") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Veg grilled sandwich") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                } else if (names[i] == "Wedges") {
                    mp.release();
                    prodnm = names[i];
                    prodamt=desc[i];
                    Scanner in = new Scanner(desc[i]).useDelimiter("[^0-9]+");
                    int integer = in.nextInt();
                    for(i=0;i<prodnm1.length;i++) {
                        if(prodnm1[i]=="Wedges") {
                            prodnm1[i] = prodnm;av=0;
                            break;
                        }else{av=1;}
                    }
                    if(av==1)
                    {
                        for(i=0;i<prodnm1.length;i++) {
                            if ((prodnm1[i] == null)) {
                                itm=i;break;
                            }
                        }
                        prodnm1[itm] = prodnm;
                        av=0;}
                }
            }
        });
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          mp.release();

                                          for(int i=0;i<val.length;i++)
                                          {   System.out.println("i= " + i + val[i]);
                                            //  System.out.println("i= " + i + prodnm1[i]+"," +prodqty1[i] +"," +prodamt1[i]);
                                          }
                                          for(int i=0;i<quantity.getqtys().length;i++)
                                          {
                                              if(quantity.getqtys()[i]!=0)
                                                  System.out.println(i + " shw = " +quantity.getqtys()[i]);}
                                          int k=0,fil=0;
                                          for(int i=0;i<names.length;i++) {
                                              if(names[i]!=null) {
                                                  for (int j = 0; j < val.length; j++) {
                                                      //System.out.println("if("+names[i]+"=="+val+")");
                                                      if (val[j] != null) {
                                                          if (names[i] == val[j]) {
                                                              k = i;
                                                              Scanner in = new Scanner(desc[k]).useDelimiter("[^0-9]+");
                                                              int integer = in.nextInt();
                                                              int l;
                                                              l = quantity.getqtys()[j];
                                                              integer = l * integer;
                                                              prodamt = Integer.toString(integer);
                                                              for (int k1 = 0; k1 < prodnm1.length; k1++) {
                                                                  if (prodnm1[k1] == val[j]) {
                                                                      prodamt1[k1] = prodamt;
                                                                      prodqty1[k1] = l;
                                                                  }
                                                              }
                                                              //break;
                                                          }
                                                      }
                                                  }
                                              }
                                          }
                                          for (int j = 0; j < val.length; j++)
                                          {val[j]=null;}
                                          for(int i=0;i<quantity.getqtys().length;i++)
                                          {
                                              quantity.getqtys()[i]=0;
                                          }
                                          goToThirdActivity();
                                      }
                                  }
        );


    }

    public void showSoftKeyboard(View view) {
        if (view.requestFocus()) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        }
    }
    public void onCompletion(MediaPlayer arg0) {
        arg0.release();
        if (ply_cnt < audio_id.length-1) {
            ply_cnt++;
            arg0 = MediaPlayer.create(getApplicationContext(), audio_id[ply_cnt]);
            arg0.setOnCompletionListener(this);
            arg0.start();
        }
    }

    public static String[] getVariable()
    {return prodnm1;}
    public static String[] getamt()
    {return prodamt1;}
    public static int[] getqty()
    // public static String[] getqty()
    {return prodqty1;}
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

    }


    private void goToThirdActivity()
    {
        Intent intent = new Intent(this, ThirdActivity.class);
        //  int checked = intent.getIntExtra("checked");
        startActivity(intent);

    }
    private  void goToscreenpopup()
    {
        mp.release();
        Intent intent = new Intent(this, quantity.class);
        startActivity(intent);}

    View.OnKeyListener listener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                //Do something
                return true;
            }
            return false;
        }
    };

}
