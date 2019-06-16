package de.mobileanwendungen.kochenrezept;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class spielen extends AppCompatActivity {
    private ImageView erdbeere, kiwi, orange, schale, blaubeere, himbeere, banane;
    private ImageView banner, cancel, fertig, avatar;
    private int countErdbeere, countOrange, countKiwi, countBanane, countHimbeere, countBlaubeere = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spielen);

        //--------Pop-Up-Fenster erscheint---------
        popStart();

        //--------Fuellen der Variablen---------------
        erdbeere = findViewById(R.id.erdbeere);
        kiwi = findViewById(R.id.kiwi);
        orange = findViewById(R.id.orange);
        blaubeere = findViewById(R.id.blaubeere);
        himbeere = findViewById(R.id.himbeere);
        banane = findViewById(R.id.banane);

        schale = findViewById(R.id.schale);
        cancel = findViewById(R.id.cancel);
        fertig = findViewById(R.id.fertig);
        banner = findViewById(R.id.bannerok);
        avatar = findViewById(R.id.avatar);

        //-------unsichtbare Bilder-------------------
        banner.setVisibility(View.INVISIBLE);

        //-------Bilder für drag vorbereiten machen--
        erdbeere.setOnTouchListener(new MyTouchListener());
        kiwi.setOnTouchListener(new MyTouchListener());
        orange.setOnTouchListener(new MyTouchListener());
        blaubeere.setOnTouchListener(new MyTouchListener());
        himbeere.setOnTouchListener(new MyTouchListener());
        banane.setOnTouchListener(new MyTouchListener());

        //------Bilder als Ziel für drag vorbereiten--
        schale.setOnDragListener(dragListener);

        //------als clickbares Element vorbereiten-----
        fertig.setOnClickListener(clickListener);
        cancel.setOnClickListener(clickListener);
        avatar.setOnClickListener(clickListener);

        //------laedt Avatar auf Screen---------------
        loadData();
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
            if (v == cancel) cancelCount();
            if (v == fertig) success();
            if (v == avatar) popStart();
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
                    if (view == orange) countOrange++;
                    if (view == kiwi) countKiwi++;
                    if (view == himbeere) countHimbeere++;
                    if (view == blaubeere) countBlaubeere++;
                    if (view == banane) countBanane++;
                    break;
            }
            return true;
        }
    };

    //--------Ueberprueft, ob Rezept erfuellt-----------------------
    public void success() {
        if (countOrange == 1 && countErdbeere == 3 && countKiwi == 1 && countBanane == 1 && countBlaubeere == 4
                && countHimbeere == 4) {
            schale.setImageResource(R.drawable.obstsalat);
            banner.setVisibility(View.VISIBLE);
        } else {
            banner.setImageResource(R.drawable.bannerschade);
            banner.setVisibility(View.VISIBLE);
        }
    }

    //-----abbrechen, count auf Null--------------------------
    public void cancelCount() {
        countErdbeere = 0;
        countKiwi = 0;
        countBlaubeere = 0;
        countBanane = 0;
        countOrange = 0;
        countHimbeere = 0;
        schale.setImageResource(R.drawable.schale1);
        banner.setVisibility(View.INVISIBLE);
        banner.setImageResource(R.drawable.bannerok);
    }

    //------Pop-up starten------------------------------------------
    public void popStart() {
        Intent intent = new Intent(this, popUp.class);
        startActivity(intent);
    }

    //-----Avatar laden-----------------------------------------
    public void loadData() {
        SharedPreferences result = getSharedPreferences("SaveData", MODE_PRIVATE);
        int value = result.getInt("Value", 0);
        switch (value){
            case 0:
            break;
            case 1:
                avatar.setImageResource(R.drawable.koch);
                break;
            case 2:
                avatar.setImageResource(R.drawable.fuchs);
                break;
            case 3:
                avatar.setImageResource(R.drawable.panda);
                break;
            case 4:
                avatar.setImageResource(R.drawable.opa);
                break;
            case 5:
                avatar.setImageResource(R.drawable.oma);
                break;
            case 6:
                avatar.setImageResource(R.drawable.mickey);
            case 7:
                avatar.setImageResource(R.drawable.wizard);

        }

    }


}
