package com.erlendhaartveit.gooeymenu2test

//import com.pes.androidmaterialcolorpickerdialog.ColorPicker;
//import com.pes.androidmaterialcolorpickerdialog.ColorPickerCallback;

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.erlendhaartveit.gooeymenu2.GooeyMenu2
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity:AppCompatActivity(),GooeyMenu2.GooeyMenuInterface {

    val ma="MainActivity";
    var main_con:ConstraintLayout?=null;
    private var fab_test:FloatingActionButton?=null;
    private var icon1:Drawable?=null;private var icon2:Drawable?=null;private var icon3:Drawable?=null;private var icon4:Drawable?=null;private var icon5:Drawable?=null;
    private var gooeyMenu:GooeyMenu2?=null;
    private var prime_dark:Int?=null;
    private var prime:Int?=null;
    private var accent:Int?=null;

    override fun onCreate(savedInstanceState: Bundle?){super.onCreate(savedInstanceState);
        prime_dark=ContextCompat.getColor(this,R.color.colorPrimaryDark);
        prime=ContextCompat.getColor(this,R.color.colorPrimary);
        accent=ContextCompat.getColor(this,R.color.colorAccent);
        icon1=getDrawable(R.drawable.ic_sentiment_dissatisfied_black_24dp);
        icon2=getDrawable(R.drawable.ic_sentiment_neutral_black_24dp);
        icon3=getDrawable(R.drawable.ic_sentiment_satisfied_black_24dp);
        icon4=getDrawable(R.drawable.ic_sentiment_very_satisfied_black_24dp);

        setContentView(R.layout.activity_main);

        main_con=findViewById(R.id.main_con);
        fab_test=findViewById(R.id.fab_test1);
        gooeyMenu=findViewById(R.id.gooey_menu);
        gooeyMenu!!.setOnMenuListener(this);

        // Hide fab button atm:
        fab_test!!.visibility=View.INVISIBLE;

        // works!
        var open=gooeyMenu!!.isMenuOpen;
        Log.d(ma,"gooeyMenu!!.isMenuOpen: $open");// true
        // it worked!
        //gooeyMenu!!.borderColor=prime_dark!!;
        gooeyMenu!!.borderColor=accent!!;
        gooeyMenu!!.circleColor=accent!!;
        Log.d(ma,"gooeyMenu!!.borderColor: "+gooeyMenu!!.borderColor);// -13172557
        Log.d(ma,"gooeyMenu!!.circleColor: "+gooeyMenu!!.circleColor);// -16524603
        // works!
        gooeyMenu!!.animationDuration=500;// works!
        Log.d(ma,"gooeyMenu!!.animationDuration: "+gooeyMenu!!.animationDuration);// 500

        //gooeyMenu!!.animate().alpha(0f).setDuration(10000).start();// it worked.
        //gooeyMenu!!.animate().scaleX(0f).scaleY(0f).y(500f).setDuration(5000).start();

        val vto: ViewTreeObserver =main_con!!.viewTreeObserver;
        vto.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener{override fun onGlobalLayout(){
            val w=gooeyMenu!!.width;val h=gooeyMenu!!.height;
            Log.d(ma,"ViewTreeObserver ~ gooeyMenu ~ w: $w, h: $h");// w: 1080, h: 480 // Hm... Too big? :/
            main_con!!.viewTreeObserver.removeOnGlobalLayoutListener(this);
        }});

        gooeyMenu!!.setOnClickListener {
            Log.d(ma,"gooeyMenu clicked!");// hm, doesn't trigger. weird...
        }

        // works! // hm, but how about item-to-item distance?...
        gooeyMenu!!.menuToItemDistance=80;
        gooeyMenu!!.menuRadius=40;
        gooeyMenu!!.itemRadius=20;
        val distance=gooeyMenu!!.menuToItemDistance;
        val menu_size=gooeyMenu!!.menuRadius;
        val item_size=gooeyMenu!!.itemRadius;
        Log.d(ma,"gooeyMenu!!.menuToItemsDistance: $distance");
        Log.d(ma,"gooeyMenu!!.itemToItemDistance: $menu_size");
        Log.d(ma,"gooeyMenu!!.menuRadius: $item_size");

        //if(gooeyMenu!!.isMenuOpen){gooeyMenu!!.toggleMenu()}

        //gooeyMenu!!.setMenuIcons(icon1,icon2,icon3,icon4,null);

    }

    override fun menuItemClicked(menuNumber: Int) {
        Log.d(ma,"Gooey ~ menuItemClicked. menuNumber: $menuNumber");
    }

    override fun menuOpen() {
        Log.d(ma,"Gooey ~ menuOpen");
    }

    override fun menuClose() {
        Log.d(ma,"Gooey ~ menuClose");
    }

}
