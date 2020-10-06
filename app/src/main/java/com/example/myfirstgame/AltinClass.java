package com.example.myfirstgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class AltinClass extends View {
    private int altin_x,altin_y;
    public int width,height;

    Bitmap altin;
    public AltinClass(Context context,int x,int y) {
        super(context);
        altin_x=x;
        altin_y=y;

        altin = BitmapFactory.decodeResource(getResources(),R.drawable.altin2);
        width = altin.getWidth();
        height = altin.getHeight();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawBitmap(altin,altin_x,altin_y,null);
    }


    public int getAltin_x() {
        return altin_x;
    }

    public void setAltin_x(int altin_x) {
        this.altin_x = altin_x;
    }

    public int getAltin_y() {
        return altin_y;
    }

    public void setAltin_y(int altin_y) {
        this.altin_y = altin_y;
    }
}
