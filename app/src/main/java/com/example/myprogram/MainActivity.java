package com.example.myprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
    private Dialog dialog;
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
    TextView title;
    TextView note;
    CircleMenu circleMenu;
    CircleMenu circleMenu1;

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
    ImageView elipse;
    ImageView elipse1;

    EditText edtext;
//    EditText acetStatus;


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





    private RecyclerView recyclerViewNotes;
    private RecyclerView recyclerViewFavorite;
    private BottomNavigationView bottomNavigation;




    private ViewPager viewPager;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        int black_color= prefs.getInt("COLOR9", R.color.black);
        int white_color= prefs.getInt("COLOR10", R.color.white);

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
        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay = dialog.findViewById(R.id.btn_okay);
                        Button Cancel = dialog.findViewById(R.id.btn_cancel);

                        Okay.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_colorblind, R.drawable.elipse2_colorblind, R.drawable.elipse3_colorblind, R.color.white, R.color.color_blind2, R.color.color_blind3, R.color.white, R.color.dark);
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                statusbar = 1;



                                    dialog.dismiss();



                            }
                        });
                        Cancel.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_colorblind, R.drawable.elipse2_colorblind, R.drawable.elipse3_colorblind, R.color.white, R.color.color_blind2, R.color.color_blind3,  R.color.dark, R.color.white);
                                        getWindow().getDecorView().setSystemUiVisibility(0);
//                                        statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();

                        break;
                    case 1:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay1 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel1 = dialog.findViewById(R.id.btn_cancel);

                        Okay1.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_blue, R.drawable.elipse2_blue, R.drawable.elipse3_blue, R.color.blue2, R.color.blue1, R.color.blue3, R.color.white, R.color.dark);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;
                                dialog.dismiss();
                            }
                        });
                        Cancel1.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_blue, R.drawable.elipse2_blue, R.drawable.elipse3_blue, R.color.blue2, R.color.blue1, R.color.blue3,  R.color.dark, R.color.white);
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;
                                dialog.dismiss(); }});
                        dialog.show();
                        break;
                    case 2:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay2 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel2 = dialog.findViewById(R.id.btn_cancel);

                        Okay2.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_green, R.drawable.elipse2_green, R.drawable.elipse3_green, R.color.green2, R.color.green1, R.color.green3,  R.color.white, R.color.dark);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel2.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_green, R.drawable.elipse2_green, R.drawable.elipse3_green, R.color.green2, R.color.green1, R.color.green3, R.color.dark, R.color.white);
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();
                        break;
                    case 3:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay3 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel3 = dialog.findViewById(R.id.btn_cancel);

                        Okay3.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_greenblue, R.drawable.elipse2_greenblue, R.drawable.elipse3, R.color.greenblue2, R.color.greenblue1, R.color.greenblue3, R.color.white, R.color.dark);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel3.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                colorStyle(R.drawable.favorite_greenblue, R.drawable.elipse2_greenblue, R.drawable.elipse3, R.color.greenblue2, R.color.greenblue1, R.color.greenblue3, R.color.dark, R.color.white);
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();
                        break;
                    case 4:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay4 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel4 = dialog.findViewById(R.id.btn_cancel);

                        Okay4.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.white, R.color.dark);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel4.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.dark, R.color.white);
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();
//                        colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, color7, color8);
//                        AlertDialog.Builder builder5 = new AlertDialog.Builder(MainActivity.this);
//                        ViewGroup viewGroup5 = findViewById(android.R.id.content);
//                        builder5.setTitle("Which main theme do you want yo use?");
//                        AlertDialog alertDialog5 = builder5.
//                                setNegativeButton("White", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.white, R.color.dark);
//                                    }}).
//                                setPositiveButton("Black", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        colorStyle(R.drawable.favorite_purple, R.drawable.elipse2_purple, R.drawable.elipse3_purple, R.color.purple2, R.color.purple1, R.color.purple3, R.color.dark, R.color.white);
//                                    }}).create();
//                        alertDialog5.show();
                        break;
                    case 5:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay5 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel5 = dialog.findViewById(R.id.btn_cancel);

                        Okay5.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_orange, R.drawable.elipse2_orange, R.drawable.elipse3_orange, R.color.orange2, R.color.orange1, R.color.orange3,  R.color.white, R.color.dark);// Метод
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel5.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_orange, R.drawable.elipse2_orange, R.drawable.elipse3_orange, R.color.orange2, R.color.orange1, R.color.orange3, R.color.dark, R.color.white);// Метод
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();
                        break;
                    case 6:
                        dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog2);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                        }
                        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        dialog.setCancelable(false); //Optional
                        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

                        Button Okay6 = dialog.findViewById(R.id.btn_okay);
                        Button Cancel6 = dialog.findViewById(R.id.btn_cancel);

                        Okay6.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_red, R.drawable.elipse2_red, R.drawable.elipse3_red, R.color.red2, R.color.red1, R.color.red3,R.color.white, R.color.dark);
                                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//                                statusbar = 1;

                                dialog.dismiss();
                            }
                        });
                        Cancel6.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                        colorStyle(R.drawable.favorite_red, R.drawable.elipse2_red, R.drawable.elipse3_red, R.color.red2, R.color.red1, R.color.red3,  R.color.dark, R.color.white);
                                getWindow().getDecorView().setSystemUiVisibility(0);
//                                statusbar = 0;

                                dialog.dismiss(); }});
                        dialog.show();
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

        circleMenu1 = (CircleMenu) findViewById(R.id.circle_menu1);


        circleMenu1.setMainMenu(Color.parseColor("#ababab"), R.drawable.ic__763404491553666161, R.drawable.ic__2462973021557749687);
        circleMenu1.addSubMenu(Color.parseColor("#cccccc"), (Bitmap) null);
        circleMenu1.addSubMenu(Color.parseColor("#005ecb"), (Bitmap) null);
        circleMenu1.setOnMenuSelectedListener(new OnMenuSelectedListener() {
            @Override
            public void onMenuSelected(int index) {
                switch (index) {
                    case 0:
//                        colorStyle(R.drawable.favorite_colorblind, R.drawable.elipse2_colorblind, R.drawable.elipse3_colorblind, R.color.white, R.color.color_blind2, R.color.color_blind3, color7, color8);

                        break;
                    case 1:
//                        colorStyle(R.drawable.favorite_blue, R.drawable.elipse2_blue, R.drawable.elipse3_blue, R.color.blue2, R.color.blue1, R.color.blue3, color7, color8);

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

//        getWindow().getDecorView().setSystemUiVisibility(SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR);
//        Window window1 = getWindow();
//        window1.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window1.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window1.setStatusBarColor(getResources().getColor(R.color.white));



        List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll("");
        Collections.reverse(notatkas);
        StateAdapter stateAdapter = new StateAdapter(this, notatkas, color1, color2, color3, color4,  color5, color6, color7, color8);
        stateAdapter.setOnClickToMore(this);


        List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite("");
        Collections.reverse(notatkas1);
        StateAdapter1 stateAdapter1 = new StateAdapter1(this, notatkas, color1, color2, color3, color4,  color5, color6);
        stateAdapter1.setOnClickToMore(this);
        recyclerViewNotes = findViewById(R.id.rv);
        recyclerViewNotes.setAdapter(stateAdapter);
        recyclerViewNotes.setLayoutManager(new GridLayoutManager(this, 2));



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

        search = findViewById(R.id.search);
        ImageView search = findViewById(R.id.search);
        search.setOnClickListener(this);

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
                    StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas,  colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom);
                    stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
                    recyclerViewFavorite.setAdapter(stateAdapter1);

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
        elipse = findViewById(R.id.elipse);
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
                                plus.setVisibility(GONE);
                                plus1.setVisibility(GONE);
                                recyclerViewNotes.setVisibility(GONE);
                                List<Notatka> notatkas1 = App.getInstance().getAppDatabase().modelDao().getAllFavorite(edtext.getText().toString());
                                Collections.reverse(notatkas1);
                                StateAdapter1 stateAdapter1 = new StateAdapter1(MainActivity.this, notatkas1 , colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom);
                                stateAdapter1.setOnClickToMore(MainActivity.this::onClick);
                                edtext.setVisibility(GONE);
//                                switch1.setVisibility(INVISIBLE);
//                                acet_status.setVisibility(INVISIBLE);
                                recyclerViewFavorite.setAdapter(stateAdapter1);
                                recyclerViewFavorite.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));

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
                                viewPager.setCurrentItem(0);

                                break;
                            case R.id.settings:
                                plus1.setVisibility(GONE);
                                plus.setVisibility(GONE);
                                edtext.setVisibility(GONE);
//                                acet_status.setVisibility(INVISIBLE);
                                recyclerViewFavorite.setVisibility(GONE);
                                recyclerViewNotes.setVisibility(GONE);

                                searchmove.setVisibility(GONE);
                                search.setVisibility(GONE);
                                elipse.setVisibility(GONE);
                                elipse1.setVisibility(GONE);

                                astonaut.setVisibility(GONE);
                                empty.setVisibility(GONE);

                                circleMenu.setVisibility(VISIBLE);
                                systhem.setVisibility(VISIBLE);
//                                swipe = 2;

                                viewPager.setCurrentItem(2);

                                break;
                            case R.id.home:
                                plus1.setVisibility(VISIBLE);
                                plus.setVisibility(VISIBLE);
                                recyclerViewFavorite.setVisibility(GONE);
                                edtext.setVisibility(GONE);
                                List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                                Collections.reverse(notatkas);
                                StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                                stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                                recyclerViewNotes.setAdapter(stateAdapter);
                                recyclerViewNotes.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                                recyclerViewNotes.setVisibility(VISIBLE);
                                search.setVisibility(VISIBLE);
                                elipse.setVisibility(VISIBLE);
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

                                break;
                        }
                        return true;
                    }
                });





        colorStyle(color1,color2,color3,color4,color5, color6 ,color7, color8);




//




    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.mymenu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.r:
//                Toast.makeText(this, "update clicked", Toast.LENGTH_SHORT).show();
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
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
    public void changeColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.red1));
        }
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
//        ActionBar bar = getSupportActionBar();
//        bar.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(resourseColor)));

    }


    @SuppressLint("ResourceType")
    private void colorStyle(int color1, int color2, int color3 , int color4 , int color5, int color6, int color7 , int color8) {


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
        plus1.setColorFilter(getResources().getColor(colorBack));
        search.setColorFilter(getResources().getColor(colorBack));
        searchmove.setColorFilter(getResources().getColor(colorBack));
        systhem.setTextColor(getResources().getColor(colorText));


//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

//        }

        Window window9 = getWindow();
        window9.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window9.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window9.setStatusBarColor(getResources().getColor(colorBack));
        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


//light
//                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


//dark
//        getWindow().getDecorView().setSystemUiVisibility(0);


        plus.setColorFilter(getResources().getColor(colorDec1));
        elipse.setColorFilter(getResources().getColor(colorDec1));
        elipse4.setColorFilter(getResources().getColor(colorDec1));
        elipse1.setColorFilter(getResources().getColor(colorDec1));


        int[] colorList = null;
        if (stateDarkMode) {
            colorList = new int[]{ContextCompat.getColor(this, colorBack), ContextCompat.getColor(this, color6)};
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        } else {
            colorList = new int[]{ContextCompat.getColor(this,colorBack), ContextCompat.getColor(this, color6)}; }
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

        editor.apply();
    }

//    @SuppressLint("ResourceType")
//    private void colorblind(  int color7 , int color8) {
//
//
////        colorFav = color1;
////        colorTitle = color2;
////        colorDec = color3;
////        colorTitle1 = color4;//light
////        colorDec1 = color5;//dark
////        colorBottom = color6;//коли не вибрана вкладка
//        colorBack = color7;
//        colorText = color8;
////        bottomNavigation.setBackgroundColor(getResources().getColor(colorDec1));
//        switch1.setTextColor(getResources().getColor(colorText));
//        background.setBackgroundColor(getResources().getColor(colorBack));
//        litback.setBackgroundColor(getResources().getColor(colorBack));
//        plus1.setColorFilter(getResources().getColor(colorBack));
//        search.setColorFilter(getResources().getColor(colorBack));
//        searchmove.setColorFilter(getResources().getColor(colorBack));
//        systhem.setTextColor(getResources().getColor(colorText));
//
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        Window window9 = getWindow();
//        window9.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        window9.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        window9.setStatusBarColor(getResources().getColor(colorBack));
//
////        plus.setColorFilter(getResources().getColor(colorDec1));
////        elipse.setColorFilter(getResources().getColor(colorDec1));
////        elipse4.setColorFilter(getResources().getColor(colorDec1));
////        elipse1.setColorFilter(getResources().getColor(colorDec1));
//
//        int[] colorList = null;
//        if (stateDarkMode) {
//            colorList = new int[]{ContextCompat.getColor(this, colorBack), ContextCompat.getColor(this, color6)};
//        } else {
//            colorList = new int[]{ContextCompat.getColor(this,colorBack), ContextCompat.getColor(this, color6)}; }
//        ColorStateList colorStateList = new ColorStateList(bottomNavBarStateList, colorList);
//        bottomNavigation.setItemIconTintList(colorStateList);
//        bottomNavigation.setItemTextColor(colorStateList);
//
//
//        SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
////        editor.putInt("COLOR1", color1);
////        editor.putInt("COLOR2", color2);
////        editor.putInt("COLOR3", color3);
////        editor.putInt("COLOR4", color4);
////        editor.putInt("COLOR5", color5);
////        editor.putInt("COLOR6", color6);
//        editor.putInt("COLOR7", color7);
//        editor.putInt("COLOR8", color8);
//
//        editor.apply();
//    }



    private int[][] bottomNavBarStateList = new int[][]{{android.R.attr.state_checked}, {-android.R.attr.state_checked}};
    @Override
    public void onClick(View v) {
        Animation anim = null;
        Animation anim2 = null;
        switch (v.getId()) {
            case R.id.search:
                anim = AnimationUtils.loadAnimation(this, R.anim.search_anim);
                search.setVisibility(GONE);
                elipse.setVisibility(VISIBLE);
                elipse1.setVisibility(VISIBLE);
                searchmove.setVisibility(VISIBLE);
                edtext.setVisibility(VISIBLE);
                anim2 = AnimationUtils.loadAnimation(this, R.anim.elipse_anim);
                break;

            case R.id.searchmove:
                closeKeyboard();
                anim = AnimationUtils.loadAnimation(this, R.anim.search_anim2);
                search.setVisibility(VISIBLE);
                elipse.setVisibility(VISIBLE);
                elipse1.setVisibility(INVISIBLE);
                searchmove.setVisibility(INVISIBLE);
                edtext.setVisibility(GONE);
                anim2 = AnimationUtils.loadAnimation(this, R.anim.elipse_anim);
                elipse4.setVisibility(INVISIBLE);
                edtext.setText("");
                break;


            case R.id.plus1:
                Intent intent2 = new Intent(this, Note.class);
                intent2.putExtra("COLOR_TITLE" ,colorTitle1 );
                intent2.putExtra("COLOR_DEC" ,colorDec1 );
                startActivity(intent2);
                MediaPlayer ring= MediaPlayer.create(MainActivity.this,R.raw.pop);
                ring.start();
                break;

//            case R.id.item1:
//                colorStyle(R.drawable.favorite_greenblue,R.drawable.elipse2_greenblue,R.drawable.elipse3_greenblue, R.color.greenblue2,R.color.greenblue1, R.color.greenblue3);
//
//                break;
//
//
//            case R.id.item2:
//                colorStyle(R.drawable.favorite_orange,R.drawable.elipse2_orange,R.drawable.elipse3_orange, R.color.orange2,R.color.orange1, R.color.orange3);// Метод
//
//
//                break;
//
//            case R.id.item3:
//                colorStyle(R.drawable.favorite_purple,R.drawable.elipse2_purple,R.drawable.elipse3_purple,R.color.purple2, R.color.purple1, R.color.purple3);
//
//                break;
//
//            case R.id.item4:
//                colorStyle(R.drawable.favorite_green,R.drawable.elipse2_green,R.drawable.elipse3_green,R.color.green2, R.color.green1, R.color.green3);
//
//
//                break;
//
//            case R.id.item5:
//                colorStyle(R.drawable.favorite_blue,R.drawable.elipse2_blue,R.drawable.elipse3_blue,R.color.blue2, R.color.blue1, R.color.blue3);
//
//                break;
//
//            case R.id.item6:
//                colorStyle(R.drawable.favorite_red,R.drawable.elipse2_red,R.drawable.elipse3_red,R.color.red2, R.color.red1, R.color.red3);
//
//                break;
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
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//// add a list
//        String[] first_dialog2 = {"Delete", "Edit", "Add Password"};
//        builder1.setItems(first_dialog2, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case 0:
//                        Toast toast = Toast.makeText(getApplicationContext(), "You delete this note", Toast.LENGTH_SHORT);
//                        toast.show();
//                        App.getInstance().getAppDatabase().modelDao().delete(notatka);
//
//                        MediaPlayer delete_pop= MediaPlayer.create(MainActivity.this, R.raw.delete);
//                        delete_pop.start();
//
//                        List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
//                        Collections.reverse(notatkas);
//                        StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
//                        stateAdapter.setOnClickToMore(MainActivity.this::onClick);
//                        recyclerViewNotes.setAdapter(stateAdapter);
//                        dialog.dismiss();
//
//                        break;
//                    case 1:
////                        Intent intent = new Intent(MainActivity.this, Note.class);
////                        MainActivity.this.startActivity(intent);
//
//                        Intent intent1 = new Intent(MainActivity.this, Note.class);
//                        intent1.putExtra("STRING_NOTE" , notatka);
//
//                        intent1.putExtra("COLOR_TITLE" , colorTitle1);
//                        intent1.putExtra("COLOR_DEC" ,colorDec1 );
//                        MainActivity.this.startActivity(intent1);
//                        dialog.dismiss();
//                        break;
//
//
//                    case 2: Intent intent22 = new Intent(MainActivity.this, Passcode_enter.class);
//                        MainActivity.this.startActivity(intent22);
//                        dialog.dismiss();
//
//                        break;

//                     }
//            }
//        });

        dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialog1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Delete = dialog.findViewById(R.id.delete);
        Button Edit = dialog.findViewById(R.id.edit);

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "You delete this note", Toast.LENGTH_SHORT);
                        toast.show();
                        App.getInstance().getAppDatabase().modelDao().delete(notatka);

                        MediaPlayer delete_pop= MediaPlayer.create(MainActivity.this, R.raw.delete);
                        delete_pop.start();

                        List<Notatka> notatkas = App.getInstance().getAppDatabase().modelDao().getAll(edtext.getText().toString());
                        Collections.reverse(notatkas);
                        StateAdapter stateAdapter = new StateAdapter(MainActivity.this, notatkas, colorFav, colorTitle, colorDec, colorTitle1,  colorDec1, colorBottom, colorBack, colorText);
                        stateAdapter.setOnClickToMore(MainActivity.this::onClick);
                        recyclerViewNotes.setAdapter(stateAdapter);
                        dialog.dismiss();
            }
        });
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Note.class);
                        MainActivity.this.startActivity(intent);

                        Intent intent1 = new Intent(MainActivity.this, Note.class);
                        intent1.putExtra("STRING_NOTE" , notatka);

                        intent1.putExtra("COLOR_TITLE" , colorTitle1);
                        intent1.putExtra("COLOR_DEC" ,colorDec1 );
                        MainActivity.this.startActivity(intent1);
                        dialog.dismiss();
                        }});
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