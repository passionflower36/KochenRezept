package de.mobileanwendungen.kochenrezept;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class spielen extends AppCompatActivity {
    ImageView erdbeere, kiwi, orange, schale, obstsalat, cancel, fertig;
    ImageView banner;
    int countErdbeere, countOrange, countKiwi  = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spielen);

        popStart();

        //--------Fuellen der Variablen---------------
        erdbeere = findViewById(R.id.erdbeere);
        kiwi = findViewById(R.id.kiwi);
        orange = findViewById(R.id.orange);
        schale = findViewById(R.id.schale);
        cancel = findViewById(R.id.cancel);
        fertig = findViewById(R.id.fertig);
        banner = findViewById(R.id.bannerok);

        //-------unsichtbare Bilder-------------------
        banner.setVisibility(View.INVISIBLE);

        //-------Bilder für drag vorbereiten machen--
        erdbeere.setOnTouchListener(new MyTouchListener());
        kiwi.setOnTouchListener(new MyTouchListener());
        orange.setOnTouchListener(new MyTouchListener());

        //------Bilder als Ziel für drag vorbereiten--
        schale.setOnDragListener(dragListener);

        //------als clickbares Element vorbereiten-----
        fertig.setOnClickListener(clickListener);
        cancel.setOnClickListener(clickListener);

    }
//-------------touchListener definieren--------------
   private final class MyTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(data, myShadowBuilder, view, 0);
            return true;
        } else {
            return false;
        }
    }
}
    //---------clickListener definieren-------------
    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
           if (v==cancel) cancelCount();
           if(v==fertig) success();
        }
    };
    //--------dragListener definieren---------------
    View.OnDragListener dragListener = new View.OnDragListener() {

        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();
            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    break;
 //-----------Wenn Drop beendet wird, Anzahl der drops pro Frucht zaehlen----
                case DragEvent.ACTION_DROP:
                    if (view == erdbeere) countErdbeere++;
                    if (view == orange)countOrange++;
                    if (view == kiwi) countKiwi++;
                    break;
            }
            return true;
        }
    };

//--------Ueberprueft, ob Rezept erfuellt-----------------------
    public void success(){
        if( countOrange==1 && countErdbeere==4){
            schale.setImageResource(R.drawable.obstsalat);
            banner.setVisibility(View.VISIBLE);
        }else{
            banner.setImageResource(R.drawable.bannerschade);
            banner.setVisibility(View.VISIBLE);
        }
    }
    //-----abbrechen, count auf Null--------------------------
    public void cancelCount(){
        countErdbeere=0;
        countKiwi=0;
        schale.setImageResource(R.drawable.schale1);
        banner.setVisibility(View.INVISIBLE);
        banner.setImageResource(R.drawable.bannerok);
    }
    //------Pop-up starten------------------------------------------
    public void popStart(){
        Intent intent = new Intent( this, popUp.class);
        startActivity(intent);
    }
}
