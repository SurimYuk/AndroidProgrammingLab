package org.androidtown.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import static android.graphics.Paint.Style.STROKE;

/**
 * Created by SurimYuk on 2018-05-10.
 */

public class MyDrawEx extends View {
    public MyDrawEx(Context c, AttributeSet a){
        super(c, a);
    }

    Path path = new Path();
    Paint Pnt = new Paint();
    public void onDraw(Canvas canvas){
        Pnt.setColor(Color.BLUE);
        Pnt.setStrokeWidth(16);
        Pnt.setStyle(STROKE); //draw just a line
        Pnt.setStrokeJoin(Paint.Join.ROUND); //rounded edge

        canvas.drawPath(path, Pnt); //draw path
    }

    float x, y;
    public boolean onTouchEvent(MotionEvent event){
        //get x, y coordinate of the event
        x = event.getX();
        y = event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            path.moveTo(x,y); //decide where to start
        }
        else if(event.getAction() == MotionEvent.ACTION_MOVE){
            path.lineTo(x,y); //decide how far to draw line
        }

        invalidate(); //for continuous updating

        return true;
    }
}
