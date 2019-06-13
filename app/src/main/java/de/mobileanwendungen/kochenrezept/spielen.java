package de.mobileanwendungen.kochenrezept;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class spielen extends AppCompatActivity {
    ImageView erdbeere, kiwi, orange, schale;
    int countErdbeere = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spielen);

        //--------Fuellen der Variablen---------------
        erdbeere = findViewById(R.id.erdbeere);
        kiwi = findViewById(R.id.kiwi);
        orange = findViewById(R.id.orange);
        schale = findViewById(R.id.schale);

        //-------Bilder für drag klickbar machen--
       /* erdbeere.setOnClickListener(clickListener);
        kiwi.setOnClickListener(clickListener);
        orange.setOnClickListener(clickListener);*/

        erdbeere.setOnTouchListener(new MyTouchListener());
        //------Bilder als Ziel für drag vorbereiten--
        schale.setOnDragListener(dragListener);


    }
//-------------touchListener definieren--------------
   private final class MyTouchListener implements View.OnTouchListener {
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(view);
            view.startDragAndDrop(data, myShadowBuilder, view, 0);
            // view.setVisibility(View.INVISIBLE);
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
            ClipData data = ClipData.newPlainText("", "");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDragAndDrop(data, myShadowBuilder, v, 0);
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
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.erdbeere) {
                        countErdbeere++;
                        if (countErdbeere == 2) schale.setVisibility(View.INVISIBLE);
                    }
                    break;

            }

            return true;
        }
    };


}
