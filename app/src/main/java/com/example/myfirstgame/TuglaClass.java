package com.example.myfirstgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

public class TuglaClass extends View {
    private Bitmap tugla_image;
    private int tugla_x,tugla_y;
    public int width,height;
    public TuglaClass(Context context, int x, int y) {
        super(context);
        tugla_image = BitmapFactory.decodeResource(getResources(),R.drawable.tugla3);
        tugla_x = x;
        tugla_y = y;

        width = tugla_image.getWidth();
        height = tugla_image.getHeight();

    }

    public void ciz(Canvas canvas){
        canvas.drawBitmap(tugla_image,tugla_x,tugla_y,null);
    }



    public int getTugla_x() {
        return tugla_x;
    }

    public void setTugla_x(int tugla_x) {
        this.tugla_x = tugla_x;
    }

    public int getTugla_y() {
        return tugla_y;
    }

    public void setTugla_y(int tugla_y) {
        this.tugla_y = tugla_y;
    }
}
