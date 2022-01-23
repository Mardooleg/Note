package com.example.myprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

import java.util.Collections;
import java.util.List;

import static android.view.View.*;
import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;
import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class MainActivity extends AppCompatActivity implements OnClickListener, StateAdapter.OnClickToMore, StateAdapter1.OnClickToMore{
    boolean stateDarkMode = false;
        private AppCompatEditText acetStatus;
    private ListPopupWindow statusPopupList;
    private Dialog dialog, dialog2;
    private Dialog dialog1;
    private Layout list_item;

    private Button ShowDialog;

//    int swipe = 1;

//    int statusbar = 1;
//    1 - white; 0 - black

//    ORIGINAL NOTATKA

    TextView empty;
    TextView empty2;
    TextView systhem;
    TextView empty1;
    TextView background;
    TextView litback;
    TextView textNote;
    TextView textTitle;

    TextView title;
    TextView note;
    CircleMenu circleMenu;
    CircleMenu circleMenu1;

//    TextView back_dialog;

    ImageView plus;
    ImageView search;
    ImageView plus1;
    ImageView searchmove;
    ImageView astonaut;
    ImageView astonaut1;
    ImageView astonaut2;
    ImageView elipse4;
    //    ImageView item1;
//    ImageView item2;
//    ImageView item3;
//    ImageView item4;
//    ImageView item5;
//    ImageView item6;
//    ImageView elipse;
    ImageView elipse1;
//
    EditText edtext;
//    EditText acetStatus;
    Button delete_btn;


    final String LOG_TAG = "myLogs";
    final int DIALOG = 1;

    int colorFav = R.drawable.favorite;
    int colorTitle = R.drawable.elipse2;
    int colorDec = R.drawable.elipse3;
    int colorTitle1 = R.color.greenblue1;
    int colorDec1 = R.color.greenblue2;
    int colorBottom = R.color.greenblue3;
    int colorBack = R.color.white;
    int colorText = R.color.black;
     boolean grid;

//    int dialog2 = R.drawable.custom_dialog_background;

// Intent i = new Intent(Intent.ACTION_SEND);
//                i.setType("message/rfc822");
//                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"oleggevka@gmail.com"});
//                i.putExtra(Intent.EXTRA_SUBJECT, "Main Idea");
//                i.putExtra(Intent.EXTRA_TEXT   , "Text");
//                try {
//                    startActivity(Intent.createChooser(i, "Send mail..."));
//                } catch (android.content.ActivityNotFoundException ex) {
//                }



    private RecyclerView recyclerViewNotes;
    private RecyclerView recyclerViewFavorite;
    private BottomNavigationView bottomNavigation;



    private ViewPager viewPager;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.dark));

//        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_IMMERSIVE);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        Window window = getWindow();
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window.setStatusBarColor(getResources().getColor(R.color.white));

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Window w = activity.getWindow(); // in Activity's onCreate() for instance
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN);

// Hide the status bar. 

//        this.gestureDetector = new GestureDetector (MainActivity.this, this);

        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        /// R.drawable.favorite_greenblue,R.drawable.elipse2_greenblue,R.drawable.elipse3_greenblue,R.color.greenblue1, R.color.greenblue2);

        int color1 = prefs.getInt("COLOR1", R.drawable.favorite_greenblue);//"No name defined" is the default value.
        int color2 = prefs.getInt("COLOR2",R.drawable.elipse2_greenblue); //0 is the default value.
        int color3 = prefs.getInt("COLOR3", R.drawable.elipse3_greenblue);//0 is the default value.
        int color4 = prefs.getInt("COLOR4",  R.color.greenblue2); //0 is the default value.
        int color5 = prefs.getInt("COLOR5",R.color.greenblue1); //0 is the default value.
        int color6 = prefs.getInt("COLOR6", R.color.greenblue3); //0 is the default value.
        int color7 = prefs.getInt("COLOR7", R.color.white); //0 is the default value.
        int color8 = prefs.getInt("COLOR8", R.color.black); //0 is the default value.
        boolean nav_stat = false;
        
        int black_color= prefs.getInt("COLOR9", R.color.black);
        int white_color= prefs.getInt("COLOR10", R.color.white);

        getWindow().setNavigationBarColor(getResources().getColor(colorDec1));

        int viewColor=getResources().getColor(color7);
        if(viewColor==getResources().getColor(R.color.white)){
//            Toast.makeText(getApplicationContext(), "White",  Toast.LENGTH_SHORT).show();
            nav_stat = true;
        }else if (viewColor==getResources().getColor(R.color.dark)){
//            Toast.makeText(getApplicationContext(), "Black",  Toast.LENGTH_SHORT).show();
            nav_stat = false;
        }
        if(nav_stat == true){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        }else{
            getWindow().getDecorView().setSystemUiVisibility(0);

        }

//
// circleMenu1 = (CircleMenu) findViewById(R.id.circle_menu1);
//
//
//        circleMenu1.setMainMenu(Color.parseColor("#ababab"), R.drawable.ic__763404491553666161, R.drawable.ic__2462973021557749687);
//        circleMenu1.addSubMenu(Color.parseColor("#000000"), (Bitmap) null);
//        circleMenu1.addSubMenu(Color.parseColor("#ffffff"), (Bitmap) null);
//        circleMenu1.setOnMenuSelectedListener(new OnMenuSelectedListener() {
//            @Override
//            public void onMenuSelected(int index) {
//                switch (index) {
//                    case 0:
//                        colorStyle(color1, color2, color3,color4,color5,color6, R.color.dark, R.color.white);
//                        break;
//                    case 1:
//                        colorStyle(color1, color2, color3,color4,color5,color6, R.color.white, R.color.dark);
//                        break;
//                }
//            }
//        });
//        circleMenu1.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {
//
//
//            @Override
//            public void onMenuOpened() {
//            }
//
//            @Override
//            public void onMenuClosed() {
//            }
//
//        });


//        if (statusbar == 1){
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

//    white
//        }else{
//            getWindow().getDecorView().setSystemUiVisibility(0);
//    black
//        }

        circleMenu = (CircleMenu) findViewById(R.id.circle_menu);


        circleMenu.setMainMenu(Color.parseColor("#ababab"), R.drawable.ic__763404491553666161, R.drawable.ic__2462973021557749687);
        circleMenu.addSubMenu(Color.parseColor("#cccccc"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#005ecb"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#009624"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#00C3A0"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#9c27b0"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#ff6f00"), (Bitmap) null);
        circleMenu.addSubMenu(Color.parseColor("#d50000"), (Bitmap) null);
//        circleMenu.addSubMenu(Color.parseColor("#EFD700"), (Bitmap) null);
//        Intent intent9;
//        intent9 = new Intent( null , Dialog2.class);
//        intent9.putExtra("COLOR_TEXT", colorText);
//        intent9.putExtra("COLOR_BACK", colorBack);

//        startActivity(intent9);

        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);



                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        }                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));

                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay = dialog.findViewById(R.id.btn_okay);
                        Button Cancel = dialog.findViewById(R.id.btn_cancel);
                        TextView textView2 = dialog.findViewById(R.id.textView2);


                        TextView Back = dialog.findViewById(R.id.back);

                        Back.setBackgroundColor(getResources().getColor(colorBack));
                        Okay.setTextColor(getResources().getColor(colorText));
                        Cancel.setTextColor(getResources().getColor(colorText));
                        textView2.setTextColor(getResources().getColor(colorText));

                        ImageView imageView1 = dialog.findViewById(R.id.imageView);
                        ImageView imageView2 = dialog.findViewById(R.id.imageView2);
                        imageView1.setColorFilter(getResources().getColor(colorText));
                        imageView2.setColorFilter(getResources().getColor(colorText));

//                        imageView2.setColorFilter(getResources().getColor(colorText));

                        Okay.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_colorblind, R.drawable.elipse2_colorblind, R.drawable.elipse3_colorblind, R.color.colorblind_1, R.color.color_blind2, R.color.color_blind3, R.color.white, R.color.dark, true);


                                dialog.dismiss();


                            }
                        });
                        Cancel.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_colorblind, R.drawable.elipse2_colorblind, R.drawable.elipse3_colorblind, R.color.colorblind_1, R.color.color_blind2, R.color.color_blind3, R.color.dark, R.color.white, false);
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                        statusbar = 0;

                                dialog.dismiss();
                            }
                        });
                        dialog.show();

                        break;
                    case 1:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        }                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));

                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay1 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel1 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView3 = dialog.findViewById(R.id.textView2);

                        TextView Back1 = dialog.findViewById(R.id.back);

                        Back1.setBackgroundColor(getResources().getColor(colorBack));
                        Okay1.setTextColor(getResources().getColor(colorText));
                        Cancel1.setTextColor(getResources().getColor(colorText));
                        textView3.setTextColor(getResources().getColor(colorText));

                        ImageView imageView3 = dialog.findViewById(R.id.imageView);
                        ImageView imageView4 = dialog.findViewById(R.id.imageView2);
                        imageView3.setColorFilter(getResources().getColor(colorText));
                        imageView4.setColorFilter(getResources().getColor(colorText));

                        Okay1.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_blue, R.drawable.elipse2_blue, R.drawable.elipse3_blue, R.color.blue2, R.color.blue1, R.color.blue3, R.color.white, R.color.dark, true);
//                                statusbar = 1;
                                dialog.dismiss();
                            }
                        });
                        Cancel1.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_blue, R.drawable.elipse2_blue, R.drawable.elipse3_blue, R.color.blue2, R.color.blue1, R.color.blue3, R.color.dark, R.color.white, false);
//                                statusbar = 0;
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        break;
                    case 2:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay2 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel2 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView13 = dialog.findViewById(R.id.textView2);

                        TextView Back6 = dialog.findViewById(R.id.back);

                        Back6.setBackgroundColor(getResources().getColor(colorBack));
                        Okay2.setTextColor(getResources().getColor(colorText));
                        Cancel2.setTextColor(getResources().getColor(colorText));
                        textView13.setTextColor(getResources().getColor(colorText));


                        ImageView imageView5 = dialog.findViewById(R.id.imageView);
                        ImageView imageView6 = dialog.findViewById(R.id.imageView2);
                        imageView5.setColorFilter(getResources().getColor(colorText));
                        imageView6.setColorFilter(getResources().getColor(colorText));

                        Okay2.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_green, R.drawable.elipse2_green, R.drawable.elipse3_green, R.color.green2, R.color.green1, R.color.green3, R.color.white, R.color.dark, true);
//                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel2.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_green, R.drawable.elipse2_green, R.drawable.elipse3_green, R.color.green2, R.color.green1, R.color.green3, R.color.dark, R.color.white, false);
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        break;
                    case 3:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay3 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel3 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView5 = dialog.findViewById(R.id.textView2);

                        TextView Back2 = dialog.findViewById(R.id.back);

                        Back2.setBackgroundColor(getResources().getColor(colorBack));
                        Okay3.setTextColor(getResources().getColor(colorText));
                        Cancel3.setTextColor(getResources().getColor(colorText));
                        textView5.setTextColor(getResources().getColor(colorText));

                        ImageView imageView7 = dialog.findViewById(R.id.imageView);
                        ImageView imageView8 = dialog.findViewById(R.id.imageView2);
                        imageView7.setColorFilter(getResources().getColor(colorText));
                        imageView8.setColorFilter(getResources().getColor(colorText));

                        Okay3.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_greenblue, R.drawable.elipse2_greenblue, R.drawable.elipse3, R.color.greenblue2, R.color.greenblue1, R.color.greenblue3, R.color.white, R.color.dark, true);
//                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel3.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_greenblue, R.drawable.elipse2_greenblue, R.drawable.elipse3, R.color.greenblue2, R.color.greenblue1, R.color.greenblue3, R.color.dark, R.color.white, false);
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        break;
                    case 4:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay4 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel4 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView7 = dialog.findViewById(R.id.textView2);

                        TextView Back3 = dialog.findViewById(R.id.back);

                        Back3.setBackgroundColor(getResources().getColor(colorBack));
                        Okay4.setTextColor(getResources().getColor(colorText));
                        Cancel4.setTextColor(getResources().getColor(colorText));
                        textView7.setTextColor(getResources().getColor(colorText));

                        ImageView imageView9 = dialog.findViewById(R.id.imageView);
                        ImageView imageView10 = dialog.findViewById(R.id.imageView2);
                        imageView9.setColorFilter(getResources().getColor(colorText));
                        imageView10.setColorFilter(getResources().getColor(colorText));

                        Okay4.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.white, R.color.dark, true);
//                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel4.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.dark, R.color.white, false);
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss();
                            }
                        });dialog.show();
                        break;
                    case 5:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay5 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel5 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView9 = dialog.findViewById(R.id.textView2);

                        TextView Back4 = dialog.findViewById(R.id.back);

                        Back4.setBackgroundColor(getResources().getColor(colorBack));
                        Okay5.setTextColor(getResources().getColor(colorText));
                        Cancel5.setTextColor(getResources().getColor(colorText));
                        textView9.setTextColor(getResources().getColor(colorText));

                        ImageView imageView11 = dialog.findViewById(R.id.imageView);
                        ImageView imageView12 = dialog.findViewById(R.id.imageView2);
                        imageView11.setColorFilter(getResources().getColor(colorText));
                        imageView12.setColorFilter(getResources().getColor(colorText));

                        Okay5.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_orange, R.drawable.elipse2_orange, R.drawable.elipse3_orange, R.color.orange2, R.color.orange1, R.color.orange3, R.color.white, R.color.dark, true);// Метод
//                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel5.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_orange, R.drawable.elipse2_orange, R.drawable.elipse3_orange, R.color.orange2, R.color.orange1, R.color.orange3, R.color.dark, R.color.white, false);// Метод
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        break;
                    case 6:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay6 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel6 = dialog.findViewById(R.id.btn_cancel);

                        TextView textView11 = dialog.findViewById(R.id.textView2);

                        TextView Back5 = dialog.findViewById(R.id.back);

                        Back5.setBackgroundColor(getResources().getColor(colorBack));
                        Okay6.setTextColor(getResources().getColor(colorText));
                        Cancel6.setTextColor(getResources().getColor(colorText));
                        textView11.setTextColor(getResources().getColor(colorText));

                        ImageView imageView13 = dialog.findViewById(R.id.imageView);
                        ImageView imageView14 = dialog.findViewById(R.id.imageView2);
                        imageView13.setColorFilter(getResources().getColor(colorText));
                        imageView14.setColorFilter(getResources().getColor(colorText));

                        Okay6.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_red, R.drawable.elipse2_red, R.drawable.elipse3_red, R.color.red2, R.color.red1, R.color.red3, R.color.white, R.color.dark, true);
//                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel6.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_red, R.drawable.elipse2_red, R.drawable.elipse3_red, R.color.red2, R.color.red1, R.color.red3, R.color.dark, R.color.white, false);
//                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                        break;

                }

            }
        }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {


            @Override
            public void onMenuOpened() {
            }

            @Override
            public void onMenuClosed() {
            }

        });


//        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
//        Window window1 = getWindow();
//        window1.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window1.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window1.setStatusBarColor(getResources().getColor(R.color.white));



        List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll("");
        Collections.reverse(notatkas);
        StateAdapter stateAdapter = new StateAdapter(this, notatkas, color1, color2, color3, color4,  color5, color6, color7, color8 );
        stateAdapter.setOnClickToMore(this);


        List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite("");
        Collections.reverse(notatkas1);
        StateAdapter1 stateAdapter1 = new StateAdapter1(this, notatkas, color1, color2, color3, color4,  color5, color6, color7, color8);
        stateAdapter1.setOnClickToMore(this);
        recyclerViewNotes = findViewById(R.id.rv);
        recyclerViewNotes.setAdapter(stateAdapter);
        recyclerViewNotes.setLayoutManager(new GridLayoutManager(this, 2));

        circleMenu1 = (CircleMenu) findViewById(R.id.circle_menu1);

        circleMenu1.setMainMenu(Color.parseColor("#ababab"), R.drawable.ic__763404491553666161, R.drawable.ic__2462973021557749687);
        circleMenu1.addSubMenu(Color.parseColor("#cccccc"), R.drawable.ic__763404491553666161);
        circleMenu1.addSubMenu(Color.parseColor("#005ecb"), R.drawable.ic__763404491553666161);
        circleMenu1.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
//                        recyclerViewNotes.setLayoutManager(new GridLayoutManager(null , 2));

                   break;
                    case 1:
//                        recyclerViewNotes.setLayoutManager(new GridLayoutManager(null , 1));
//                        grid = false;
                        break;
                }
            }
        });
        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {


            @Override
            public void onMenuOpened() {
            }

            @Override
            public void onMenuClosed() {
            }

        });

        litback = findViewById(R.id.litback);
        recyclerViewFavorite = findViewById(R.id.fv);
        bottomNavigation = findViewById(R.id.bottom_nav);
        edtext = findViewById(R.id.searchwrite);
        astonaut = findViewById(R.id.astr);
        empty = findViewById(R.id.empty);
        background = findViewById(R.id.background1);
        astonaut1 = findViewById(R.id.astr1);
        empty1 = findViewById(R.id.emptyres);
        systhem = findViewById(R.id.systhem);
        astonaut2 = findViewById(R.id.astr2);
        empty2 = findViewById(R.id.emptyfav);
        title = findViewById(R.id.firsttitle);
        note = findViewById(R.id.firstnote);
        plus = findViewById(R.id.plus);

        delete_btn = findViewById(R.id.delete_btn);
//back_dialog = findViewById(R.id.back_dialog);

//        acetStatus = findViewById(R.id.acet_status);
//        EditText acet_status = findViewById(R.id.acet_status);
//        acetStatus.setOnClickListener(this);
//
//        item1 = findViewById(R.id.item1);
//        ImageView item1 = findViewById(R.id.item1);
//        item1.setOnClickListener(this);
//
//        item2 = findViewById(R.id.item2);
//        ImageView item2 = findViewById(R.id.item2);
//        item2.setOnClickListener(this);
//
//        item3 = findViewById(R.id.item3);
//        ImageView item3 = findViewById(R.id.item3);
//        item3.setOnClickListener(this);
//
//        item4 = findViewById(R.id.item4);
//        ImageView item4 = findViewById(R.id.item4);
//        item4.setOnClickListener(this);
//
//        item5 = findViewById(R.id.item5);
//        ImageView item5 = findViewById(R.id.item5);
//        item5.setOnClickListener(this);
//
//        item6 = findViewById(R.id.item6);
//        ImageView item6 = findViewById(R.id.item6);
//        item6.setOnClickListener(this);

//        if(ContextCompat.getColor(this, getResources().getColor(background))== R.color.white);{


        plus1 = findViewById(R.id.plus1);
        ImageView plus1 = findViewById(R.id.plus1);
        plus1.setOnClickListener(this);


        if (stateAdapter.getItemCount() == 0) {
            empty.setVisibility(VISIBLE);
            astonaut.setVisibility(VISIBLE);

        } else {
            empty.setVisibility(GONE);
            astonaut.setVisibility(GONE);
        }

//        if (statusbar == 1){
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//
////    white
//        }else{
//            getWindow().getDecorView().setSystemUiVisibility(0);
////    black
//        }

        edtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if (recyclerViewNotes.getVisibility() == VISIBLE) {
                    List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                    Collections.reverse(notatkas);
                    StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                    stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                    recyclerViewNotes.setAdapter(stateAdapter);
                } else if (recyclerViewFavorite.getVisibility() == VISIBLE) {
                    List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAllFavorite(edtext.getText().toString());
                    Collections.reverse(notatkas);
                    StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas,  colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                    stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
                    recyclerViewFavorite.setAdapter(stateAdapter1);

                }else{
//                                Toast.makeText(getApplicationContext(), "Black",  Toast.LENGTH_SHORT).show();

                }
            }

//            Switch onOffSwitch = (Switch) findViewById(R.id.switch1);
//        onOffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                private int[][] bottomNavBarStateList = new int[][]{{android.R.attr.state_checked}, {-android.R.attr.state_checked}};
//
//                @Override
//                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                    stateDarkMode = isChecked;
//                    if (isChecked) {
////                    Window window = getWindow();
////                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////                    window.setStatusBarColor(getResources().getColor(R.color.dark));
////                    background.setBackgroundColor(getResources().getColor(R.color.dark));
////                    litback.setBackgroundColor(getResources().getColor(R.color.dark));
////                    switch1.setTextColor(getResources().getColor(R.color.white));
////                    search.setColorFilter(getResources().getColor(R.color.dark));
////                    searchmove.setColorFilter(getResources().getColor(R.color.dark));
////                    systhem.setTextColor(getResources().getColor(R.color.white));
////                    plus1.setColorFilter(getResources().getColor(R.color.dark));
////                    colorblind(R.color.dark,R.color.white);
////                        colorStyle(color1,color2,color3,color4,color5,color6,R.color.dark,R.color.white);
//                    } else {
////                    Window window = getWindow();
////                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
////                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////                    window.setStatusBarColor(getResources().getColor(R.color.white));
////                    background.setBackgroundColor(getResources().getColor(R.color.white));
////                    litback.setBackgroundColor(getResources().getColor(R.color.white));
////                    switch1.setTextColor(getResources().getColor(R.color.black));
////                    search.setColorFilter(getResources().getColor(R.color.white));
////                    searchmove.setColorFilter(getResources().getColor(R.color.white));
////                    systhem.setTextColor(getResources().getColor(R.color.dark));
////                    plus1.setColorFilter(getResources().getColor(R.color.white));
////                    colorblind( R.color.white,R.color.dark);
////                        colorStyle(color1,color2,color3,color4,color5,color6,R.color.white,R.color.dark);
//
//                    }
//                }
//            });

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        searchmove = findViewById(R.id.searchmove);
        ImageView searchmove = findViewById(R.id.searchmove);
        searchmove.setOnClickListener(this);
//        elipse = findViewById(R.id.elipse);
        elipse4 = findViewById(R.id.elipse4);
        elipse1 = findViewById(R.id.elipse1);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.viewpager);
//        setUpViewPager();
        Menu menu = bottomNavigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(

                new BottomNavigationView.OnNavigationItemSelectedListener() {


                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.favorite:
//                                elipse.setVisibility(VISIBLE);
                                elipse1.setVisibility(VISIBLE);
                                edtext.setVisibility(VISIBLE);
//                                searchmove.setVisibility(VISIBLE);
                                empty.setVisibility(GONE);
                                astonaut.setVisibility(GONE);
                                plus.setVisibility(GONE);
                                plus1.setVisibility(GONE);
                                recyclerViewNotes.setVisibility(GONE);
                                List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite(edtext.getText().toString());
                                Collections.reverse(notatkas1);
                                StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas1 , colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                                stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
                                edtext.setVisibility(VISIBLE);
//                                switch1.setVisibility(INVISIBLE);
//                                acet_status.setVisibility(INVISIBLE);
                                recyclerViewFavorite.setAdapter(stateAdapter1);
                                recyclerViewFavorite.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//                                searchmove.setVisibility(VISIBLE);
                                circleMenu1.setVisibility(INVISIBLE);

//                                item1.setVisibility(INVISIBLE);
//                                item2.setVisibility(INVISIBLE);
//                                item3.setVisibility(INVISIBLE);
//                                item4.setVisibility(INVISIBLE);
//                                item5.setVisibility(INVISIBLE);
//                                item6.setVisibility(INVISIBLE);
                                systhem.setVisibility(INVISIBLE);
                                circleMenu.setVisibility(INVISIBLE);
                                recyclerViewFavorite.setVisibility(VISIBLE);
//                                swipe = 0;

                                if (stateAdapter1.getItemCount() == 0) {
                                    empty1.setVisibility(VISIBLE);
                                    astonaut1.setVisibility(VISIBLE);

                                } else {
                                    empty1.setVisibility(GONE);
                                    astonaut1.setVisibility(GONE);
                                }

                                viewPager.setCurrentItem(0);
closeKeyboard();
                                break;
                            case R.id.settings:
                                empty1.setVisibility(GONE);
                                astonaut1.setVisibility(GONE);
                                plus1.setVisibility(GONE);
                                plus.setVisibility(GONE);
                                edtext.setVisibility(GONE);
//                                acet_status.setVisibility(INVISIBLE);
                                recyclerViewFavorite.setVisibility(GONE);
                                recyclerViewNotes.setVisibility(GONE);

//                                elipse.setVisibility(GONE);
                                elipse1.setVisibility(GONE);
                                searchmove.setVisibility(INVISIBLE);
//                                search.setVisibility(GONE);


                                astonaut.setVisibility(GONE);
                                empty.setVisibility(GONE);

                                circleMenu.setVisibility(VISIBLE);
                                circleMenu.setVisibility(VISIBLE);
//                                circleMenu1.setVisibility(VISIBLE);

                                systhem.setVisibility(VISIBLE);
//                                swipe = 2;

                                viewPager.setCurrentItem(2);
                                closeKeyboard();
                                closeKeyboard();

                                break;
                            case R.id.home:
                                empty1.setVisibility(GONE);
                                astonaut1.setVisibility(GONE);
                                plus1.setVisibility(VISIBLE);
                                plus.setVisibility(VISIBLE);
                                recyclerViewFavorite.setVisibility(GONE);
                                List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                                Collections.reverse(notatkas);
                                StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                                stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                                recyclerViewNotes.setAdapter(stateAdapter);
//                                recyclerViewNotes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                                recyclerViewNotes.setVisibility(VISIBLE);
//                                search.setVisibility(VISIBLE);
//                                elipse.setVisibility(VISIBLE);
                                elipse1.setVisibility(VISIBLE);
                                edtext.setVisibility(VISIBLE);
//searchmove.setVisibility(VISIBLE);
                                circleMenu1.setVisibility(INVISIBLE);

                                systhem.setVisibility(INVISIBLE);
                                circleMenu.setVisibility(INVISIBLE);
//                                acet_status.setVisibility(INVISIBLE);
//                                item1.setVisibility(INVISIBLE);
//                                item2.setVisibility(INVISIBLE);
//                                item3.setVisibility(INVISIBLE);
//                                item4.setVisibility(INVISIBLE);
//                                item5.setVisibility(INVISIBLE);
//                                item6.setVisibility(INVISIBLE);
//                                swipe = 1;
                                viewPager.setCurrentItem(1);


                                if (stateAdapter.getItemCount() == 0) {
                                    empty.setVisibility(VISIBLE);
                                    astonaut.setVisibility(VISIBLE);

                                } else {
                                    empty.setVisibility(GONE);
                                    astonaut.setVisibility(GONE);
                                }

//                                if (statusbar == 1){
//                                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//
////    white
//                                }else{
//                                    getWindow().getDecorView().setSystemUiVisibility(0);
////    black
//                                }
                                closeKeyboard();

                                break;
                        }
                        return true;
                    }
                });





        colorStyle(color1,color2,color3,color4,color5, color6 ,color7, color8, nav_stat);



//




    }

    @Override
    public void onBackPressed() {
        dialog2 = new Dialog(MainActivity.this);
        dialog2.setContentView(R.layout.dialog4);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        }                            dialog2.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));

        dialog2.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog2.setCancelable(false); //Optional
        dialog2.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Yes = dialog2.findViewById(R.id.yes_btn);
        Button No = dialog2.findViewById(R.id.no_btn);
        TextView exit = dialog2.findViewById(R.id.textView_exit);



        Yes.setTextColor(getResources().getColor(colorText));
        No.setTextColor(getResources().getColor(colorText));
        exit.setTextColor(getResources().getColor(colorText));



        Yes.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finishapp();


                dialog2.dismiss();


            }



        });
        No.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog2.dismiss();
            }
        });
        dialog2.show();

//        super.onBackPressed();
    }


//    @Override
//    public() {
//
//    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
//

    public void finishapp() {
        this.finishAffinity();

    }
    public void changeColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.red1));
        }
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
//        ActionBar bar = getSupportActionBar();
//        bar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(resourseColor)));

    }

//    public void method1(Activity act){
//        TextView tv1 = (TextView)act.findViewById(R.id.textView);
//        tv1.setText("");
//    }

    @SuppressLint("ResourceType")
    private void colorStyle(int color1, int color2, int color3 , int color4 , int color5, int color6, int color7 , int color8, boolean nav_stat) {


        colorFav = color1;
        colorTitle = color2;
        colorDec = color3;
        colorTitle1 = color4;//light
        colorDec1 = color5;//dark
        colorBottom = color6;//коли не вибрана вкладка
        colorBack = color7;
        colorText = color8;
        bottomNavigation.setBackgroundColor(getResources().getColor(colorDec1));
        background.setBackgroundColor(getResources().getColor(colorBack));
        litback.setBackgroundColor(getResources().getColor(colorBack));
        plus1.setColorFilter(getResources().getColor(color6));
//        search.setColorFilter(getResources().getColor(colorBack));
        searchmove.setColorFilter(getResources().getColor(colorText));
        systhem.setTextColor(getResources().getColor(colorText));
        edtext.setHintTextColor(getResources().getColor(colorBack));
        edtext.setTextColor(getResources().getColor(colorBack));
        empty.setTextColor(getResources().getColor(colorText));
        empty1.setTextColor(getResources().getColor(colorText));
//        back_dialog.setBackgroundColor(getResources().getColor(colorBack));

//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

//        }
        getWindow().setNavigationBarColor(getResources().getColor(colorDec1));

        Window window9 = getWindow();
        window9.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window9.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window9.setStatusBarColor(getResources().getColor(colorBack));
//        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


//light
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


//dark
//        getWindow().getDecorView().setSystemUiVisibility(0);
if(nav_stat == true){
    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

}else{
    getWindow().getDecorView().setSystemUiVisibility(0);

}

        plus.setColorFilter(getResources().getColor(colorDec1));
//        elipse.setColorFilter(getResources().getColor(colorDec1));
        elipse4.setColorFilter(getResources().getColor(colorDec1));
        elipse1.setColorFilter(getResources().getColor(colorDec1));


        int[] colorList = null;

        if (stateDarkMode) {
            colorList = new int[]{ContextCompat.getColor(this,/*color4*/ colorBack), ContextCompat.getColor(this, color6)};
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        } else {
            colorList = new int[]{ContextCompat.getColor(this,/*R.color.dark*/ colorBack), ContextCompat.getColor(this, color6)}; }
        ColorStateList colorStateList = new ColorStateList(bottomNavBarStateList, colorList);

        bottomNavigation.setItemIconTintList(colorStateList);
        bottomNavigation.setItemTextColor(colorStateList);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);


        SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
        editor.putInt("COLOR1", color1);
        editor.putInt("COLOR2", color2);
        editor.putInt("COLOR3", color3);
        editor.putInt("COLOR4", color4);
        editor.putInt("COLOR5", color5);
        editor.putInt("COLOR6", color6);
        editor.putInt("COLOR7", color7);
        editor.putInt("COLOR8", color8);
//        editor.putInt("COLOR_NAV", boolean nav_stat);

        editor.apply();
    }


    private int[][] bottomNavBarStateList = new int[][]{{android.R.attr.state_checked}, {-android.R.attr.state_checked}};
    @Override
    public void onClick(View v) {
        Animation anim = null;
        Animation anim2 = null;
        switch (v.getId()) {

//            case R.id.searchmove:
//                closeKeyboard();
//                anim = AnimationUtils.loadAnimation(this, R.anim.search_anim2);
//                search.setVisibility(VISIBLE);
//                elipse.setVisibility(VISIBLE);
//                elipse1.setVisibility(INVISIBLE);
//                searchmove.setVisibility(INVISIBLE);
//                edtext.setVisibility(GONE);
//                anim2 = AnimationUtils.loadAnimation(this, R.anim.elipse_anim);
//                elipse4.setVisibility(INVISIBLE);
//                edtext.setText("");
//                break;


            case R.id.plus1:
                Intent intent2 = new Intent(this, Note.class);
                intent2.putExtra("COLOR_TITLE" ,colorTitle1 );
                intent2.putExtra("COLOR_DEC" ,colorDec1 );
                intent2.putExtra("COLOR_TEXT" ,colorBottom );

                startActivity(intent2);
                MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.pop);
                ring.start();

//                recyclerViewNotes.setLayoutManager(new GridLayoutManager(this, 1));

                break;

        }

        if (anim != null) {
            edtext.startAnimation(anim);
            searchmove.startAnimation(anim);
            elipse1.startAnimation(anim);
            elipse4.startAnimation(anim2);
        }
    }

    @Override
    public void onClick(Notatka notatka) {
        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background_black));
//            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


//        dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
//        dialog.getWindow().setBackgroundDrawableResource(getResources().getColor(colorBack));
    dialog.setCancelable(true); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        Button Delete = dialog.findViewById(R.id.delete_btn);
        Button Edit = dialog.findViewById(R.id.edit);
//        Button Cancel = dialog.findViewById(R.id.cancel);
        TextView Back = dialog.findViewById(R.id.back_dialog);
        TextView Ask = dialog.findViewById(R.id.askwhattodo);

        ImageView Edit_img = dialog.findViewById(R.id.edit_dialog1);
        ImageView Delete_img = dialog.findViewById(R.id.delete_dialog1);
        Edit_img.setColorFilter(getResources().getColor(colorBack));
        Delete_img.setColorFilter(getResources().getColor(colorBack));

        Edit_img.setColorFilter(getResources().getColor(colorText));
        Delete_img.setColorFilter(getResources().getColor(colorText));

        Back.setBackgroundColor(getResources().getColor(colorBack));
        Delete.setTextColor(getResources().getColor(colorText));
        Ask.setTextColor(getResources().getColor(colorText));
        Edit.setTextColor(getResources().getColor(colorText));
//        Cancel.setTextColor(getResources().getColor(colorText));


        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (notatka.isFavorite()) {
                    dialog.dismiss();

                    dialog1 = new Dialog(MainActivity.this);
                    dialog1.setContentView(R.layout.dialog3);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        dialog1.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));

                    }

                    dialog1.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog1.setCancelable(false); //Optional
                    dialog1.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog


                    Button Yes = dialog1.findViewById(R.id.yes);
                    Button No = dialog1.findViewById(R.id.no);
                    TextView Ask = dialog1.findViewById(R.id.ask);
                    TextView Back1 = dialog1.findViewById(R.id.back_dialog1);


                    Back1.setBackgroundColor(getResources().getColor(colorBack));
                    Yes.setTextColor(getResources().getColor(colorText));
                    No.setTextColor(getResources().getColor(colorText));


                    Ask.setTextColor(getResources().getColor(colorText));
                    Yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast toast = Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT);
                            toast.show();
                            App.getInstance().getAppDatabase().modelDao().delete(notatka);

                            MediaPlayer delete_pop = MediaPlayer.create(MainActivity.this, R.raw.delete);
                            delete_pop.start();

                            List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                            Collections.reverse(notatkas);
                            StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1, colorDec1, colorBottom, colorBack, colorText);
                            stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                            recyclerViewNotes.setAdapter(stateAdapter);

                            if (stateAdapter.getItemCount() == 0) {
                                empty.setVisibility(VISIBLE);
                                astonaut.setVisibility(VISIBLE);

                            } else {
                                empty.setVisibility(GONE);
                                astonaut.setVisibility(GONE);
                            }

                            dialog1.dismiss();
                        }
                    });
                    No.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialog1.dismiss();
                        }

                    });dialog1.show();

                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "You delete this note", Toast.LENGTH_SHORT);
                    toast.show();
                    App.getInstance().getAppDatabase().modelDao().delete(notatka);

                    MediaPlayer delete_pop = MediaPlayer.create(MainActivity.this, R.raw.delete);
                    delete_pop.start();

                    List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                    Collections.reverse(notatkas);
                    StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1, colorDec1, colorBottom, colorBack, colorText);
                    stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                    recyclerViewNotes.setAdapter(stateAdapter);

                    if (stateAdapter.getItemCount() == 0) {
                        empty.setVisibility(VISIBLE);
                        astonaut.setVisibility(VISIBLE);

                    } else {
                        empty.setVisibility(GONE);
                        astonaut.setVisibility(GONE);
                    }

                    dialog.dismiss();
                }
            }
        });
//        Cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//
//            }
//        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Note.class);
                MainActivity.this.startActivity(intent);

                Intent intent1 = new Intent(MainActivity.this, Note.class);
                intent1.putExtra("STRING_NOTE", notatka);

                intent1.putExtra("COLOR_TITLE", colorTitle1);
                intent1.putExtra("COLOR_DEC", colorDec1);
                MainActivity.this.startActivity(intent1);
                dialog.dismiss();
            }
        });
        dialog.show();

    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Animation anim_swipe = null;
//        Animation anim_swipe2 = null;
//        gestureDetector.onTouchEvent(event);
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                x1 = event.getX();
//                y1 = event.getY();
//                break;
//
//            case MotionEvent.ACTION_UP:
//                x2 = event.getX();
//                y2 = event.getY();
//                float valueX = x2 - x1;
//                float valueY = y2 - y1;
//

//                if (Math.abs(valueX) > MIN_DISTANSE) {
//
//                    if (x2 > x1) {
//                        if (swipe == 1) {
//
//
//                            plus.setVisibility(GONE);
//                            plus1.setVisibility(GONE);
//                            recyclerViewNotes.setVisibility(GONE);
//                            List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite(edtext.getText().toString());
//                            Collections.reverse(notatkas1);
//                            StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas1, colorFav, colorTitle, colorDec, colorTitle1, colorDec1, colorBottom);
//                            stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
//                            edtext.setVisibility(GONE);
//                            recyclerViewFavorite.setAdapter(stateAdapter1);
//                            recyclerViewFavorite.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//
////                            item1.setVisibility(INVISIBLE);
////                            item2.setVisibility(INVISIBLE);
////                            item3.setVisibility(INVISIBLE);
////                            item4.setVisibility(INVISIBLE);
////                            item5.setVisibility(INVISIBLE);
////                            item6.setVisibility(INVISIBLE);
//                            systhem.setVisibility(INVISIBLE);
//
//
//                            recyclerViewFavorite.setVisibility(VISIBLE);
//
//                            Menu menu = bottomNavigation.getMenu();
//                            MenuItem menuItem = menu.getItem(0);
//                            menuItem.setChecked(true);
//                        } else if (swipe == 2) {
//                            anim_swipe = AnimationUtils.loadAnimation(this, R.anim.swipe_anim);
//                            anim_swipe2 = AnimationUtils.loadAnimation(this, R.anim.swipe_anim2);
//
//                            plus1.setVisibility(VISIBLE);
//                            plus.setVisibility(VISIBLE);
//                            recyclerViewFavorite.setVisibility(GONE);
//                            edtext.setVisibility(GONE);
//                            List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
//                            Collections.reverse(notatkas);
//                            StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1, colorDec1, colorBottom, colorBack, colorText);
//                            stateAdapter.setOnClickToMore(MainActivity.this::onClick);
//                            recyclerViewNotes.setAdapter(stateAdapter);
//                            recyclerViewNotes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//                            recyclerViewNotes.setVisibility(VISIBLE);
//                            search.setVisibility(VISIBLE);
//                            elipse.setVisibility(VISIBLE);
//                            systhem.setVisibility(INVISIBLE);
//
////                            item1.setVisibility(INVISIBLE);
////                            item2.setVisibility(INVISIBLE);
////                            item3.setVisibility(INVISIBLE);
////                            item4.setVisibility(INVISIBLE);
////                            item5.setVisibility(INVISIBLE);
////                            item6.setVisibility(INVISIBLE);
//
//                            Menu menu1 = bottomNavigation.getMenu();
//                            MenuItem menuItem1 = menu1.getItem(1);
//                            menuItem1.setChecked(true);
//                        }
//
//                    } else {
//
////
//
//                    }
//                } else if (Math.abs(valueY) > MIN_DISTANSE) ;
//            {
//                if (y2 > y1) {
//
//
//                } else {
//
//
//                }
//            }
////        }
//        if (anim_swipe != null) {
////            item1.startAnimation(anim_swipe);
////            item2.startAnimation(anim_swipe);
////            item3.startAnimation(anim_swipe);
////            item4.startAnimation(anim_swipe);
////            item5.startAnimation(anim_swipe);
////            item6.startAnimation(anim_swipe);
//            systhem.startAnimation(anim_swipe);
//
//            recyclerViewNotes.startAnimation(anim_swipe2);
//            elipse.startAnimation(anim_swipe2);
//            search.startAnimation(anim_swipe2);
//            plus.startAnimation(anim_swipe2);
//            plus1.startAnimation(anim_swipe2);
//        }
//        return super.onTouchEvent(event);
//
//
//    }
//
//    @Override
//    public boolean onDown(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public void onShowPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onSingleTapUp(MotionEvent e) {
//        return false;
//    }
//
//    @Override
//    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//        return false;
//    }
//
//    @Override
//    public void onLongPress(MotionEvent e) {
//
//    }
//
//    @Override
//    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        return false;
////    }
//    private  void setUpViewPager(){
//        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPager.setAdapter(viewPageAdapter);
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position){
//                    case 0:
//                        Menu menu1 = bottomNavigation.getMenu();
//                        MenuItem menuItem1 = menu1.getItem(0);
//                        menuItem1.setChecked(true);
//
//                        plus.setVisibility(GONE);
//                        plus1.setVisibility(GONE);
//                        recyclerViewNotes.setVisibility(GONE);
//                        List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite(edtext.getText().toString());
//                        Collections.reverse(notatkas1);
//                        StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas1 , colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom);
//                        stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
//                        edtext.setVisibility(GONE);
//                        recyclerViewFavorite.setAdapter(stateAdapter1);
//                        recyclerViewFavorite.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//
////        item1.setVisibility(INVISIBLE);
////        item2.setVisibility(INVISIBLE);
////        item3.setVisibility(INVISIBLE);
////        item4.setVisibility(INVISIBLE);
////        item5.setVisibility(INVISIBLE);
////        item6.setVisibility(INVISIBLE);
//                        systhem.setVisibility(INVISIBLE);
//
//                        recyclerViewFavorite.setVisibility(VISIBLE);
//                        break;
//                    case 1:
//                        Menu menu2 = bottomNavigation.getMenu();
//                        MenuItem menuItem2 = menu2.getItem(1);
//                        menuItem2.setChecked(true);
//                        plus1.setVisibility(VISIBLE);
//                        plus.setVisibility(VISIBLE);
//                        recyclerViewFavorite.setVisibility(GONE);
//                        edtext.setVisibility(GONE);
//                        List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
//                        Collections.reverse(notatkas);
//                        StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
//                        stateAdapter.setOnClickToMore(MainActivity.this::onClick);
//                        recyclerViewNotes.setAdapter(stateAdapter);
//                        recyclerViewNotes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//                        recyclerViewNotes.setVisibility(VISIBLE);
//                        search.setVisibility(VISIBLE);
//                        elipse.setVisibility(VISIBLE);
//                        systhem.setVisibility(INVISIBLE);
//
////        item1.setVisibility(INVISIBLE);
////        item2.setVisibility(INVISIBLE);
////        item3.setVisibility(INVISIBLE);
////        item4.setVisibility(INVISIBLE);
////        item5.setVisibility(INVISIBLE);
////        item6.setVisibility(INVISIBLE);
//                        viewPager.setCurrentItem(1);
//
//                        break;
//                    case 2:
//                        Menu menu3 = bottomNavigation.getMenu();
//                        MenuItem menuItem3 = menu3.getItem(2);
//                        menuItem3.setChecked(true);
//
//                        plus1.setVisibility(GONE);
//                        plus.setVisibility(GONE);
//                        edtext.setVisibility(GONE);
//
//                        recyclerViewFavorite.setVisibility(GONE);
//                        recyclerViewNotes.setVisibility(GONE);
//
//                        searchmove.setVisibility(GONE);
//                        search.setVisibility(GONE);
//                        elipse.setVisibility(GONE);
//                        elipse1.setVisibility(GONE);
//
//                        astonaut.setVisibility(GONE);
//                        empty.setVisibility(GONE);
//
////        item1.setVisibility(VISIBLE);
////        item2.setVisibility(VISIBLE);
////        item3.setVisibility(VISIBLE);
////        item4.setVisibility(VISIBLE);
////        item5.setVisibility(VISIBLE);
////        item6.setVisibility(VISIBLE);
//                        systhem.setVisibility(VISIBLE);
//                        break;
//
//                }




//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//
//    }
//
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
}