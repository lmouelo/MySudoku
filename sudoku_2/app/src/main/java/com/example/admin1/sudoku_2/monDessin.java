package com.example.admin1.sudoku_2;
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;



public class monDessin extends View {
    private int [][] tab=new int[9][9];
    private int valeur=0;

    public monDessin(Context context, AttributeSet attrs) {
        super(context, attrs);


    }

    @Override
    public void onDraw(Canvas canvas) {
        int compteur = 0;
        int compteur2 = 0;
        Paint paint =  new Paint();
        Paint paint2 = new Paint();
        Paint paint3 = new Paint();

        paint.setColor(Color.BLUE);
        paint2.setColor(Color.BLACK);
        paint3.setColor(Color.RED);
        paint2.setTextSize(40);

        String tab[] = new String[11];



////////////déplacement//////////////////////////////////////
      // final String TAG_LOG = "TouchActivity";
       // boolean LOG = true;
       //mFrameLayout = (FrameLayout)findViewById(R.id.layout);
//       mFrameLayout.setOnTouchListener((OnTouchListener) this);
////////////////////////////////////////////////////////////

        //canvas.drawCircle(100, 100, 50, paint);
        for (int i = 0; i < 1000; i += 100) {
            canvas.drawLine(0, i, 730, i, paint);
            if ((compteur == 3) || (compteur == 6) || (compteur == 9)) {
                canvas.drawLine(0, i, 730, i, paint2);
            }
            compteur = compteur + 1;
        }

        for (int i = 0; i < 720; i += 80) {
            canvas.drawLine(i, 0, i, 900, paint);
            if ((compteur2 == 3) || (compteur2 == 6) || (compteur2 == 9)) {
                canvas.drawLine(i, 0, i, 900, paint2);
            }
            compteur2++;
        }

        for (int i = 1000; i < 1500; i += 100) {
            canvas.drawLine(0, i, 730, i, paint3);
            canvas.drawText("1",i,i,paint2);
        }

        int numero =1 ;

        for (int i = 0; i < 700; i += 80) {
            canvas.drawLine(i, 1000, i, 1100, paint3);
            canvas.drawText(""+numero,i,1050,paint2);
            numero++;
        }
    }
////////////drag&drop//////////////////////////////////////

    public boolean onTouch(View v, MotionEvent event) {
        int x = (int)event.getX(); int y = (int)event.getY();
        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:
                valeur=(x/(getWidth()/9 ))+1;
                break;
                case MotionEvent.ACTION_MOVE: // mouvement vers x,y
                if(x<=getWidth()&& y<= getWidth()){
                    Log.d("x", "MOVE: "+(int)(x/(getWidth()/9 )+1));
                    Log.d("y", "MOVE: "+(int)(y/(getWidth()/9 )+1));
                }
                break;
                case MotionEvent.ACTION_UP:
                if(x<=getWidth()&& y<= getWidth() && tab[(int)(x/(getWidth()/9 ))][(int)(y/(getWidth()/9 ))]==0){
                    tab[(int)(x/(getWidth()/9 ))][(int)(y/(getWidth()/9 ))]=valeur;
                    Log.d("x", "UP: "+(int)(x/(getWidth()/9 )+1));
                    Log.d("y", "UP: "+(int)(y/(getWidth()/9 )+1));
                    Log.d("valeur", "UP: "+valeur);
                }
                break;
        }
        this.invalidate();
        return true;
    }
}



