package com.example.myfirstgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;

public class Player extends View {
    Paint red_paintbrush_fill, blue_paintbrush_fill, green_paintbrush_fill;
    Paint red_paintbrush_stroke, blue_paintbrush_stroke, green_paintbrush_stroke;

    public Bitmap player_image;
    public int player_x,player_y;
    public int hiz_x,hiz_y;
    public int hiz_x_yedek;
    public int width,height;

    Path ip;

    public Player(Context context) {
        super(context);
        player_image= BitmapFactory.decodeResource(getResources(),R.drawable.cengel);
        Paint_Olusturucu();
        // -- Default Positions and Speeds --
        player_x = 0; player_y = 0;
        hiz_x = 5; hiz_y = 0;

        width = player_image.getWidth();
        height = player_image.getHeight();

        ip = new Path();


    }

    public void ciz(Canvas canvas){
        koordinatGuncelle(canvas);


        Log.e("W ",""+player_image.getWidth());
        Log.e("H",""+player_image.getHeight());

        canvas.drawBitmap(player_image,player_x,player_y,null);

        ip.reset();
        ip.moveTo(player_x+width/2,0);
        ip.lineTo(player_x+width/2,player_y);
        canvas.drawPath(ip,red_paintbrush_stroke);


    }


    public void koordinatGuncelle(Canvas canvas){
        if (player_x>canvas.getWidth()-player_image.getWidth()){ hiz_x=-5; }
        if (player_x<0 ){hiz_x=5;}
        if (player_y>canvas.getHeight()-player_image.getHeight()){ hiz_y=-6;}
        if (player_y<0){ hiz_y=0;player_y=0;hiz_y=0;hiz_x=hiz_x_yedek;}


        player_x = player_x +hiz_x;
        player_y = player_y +hiz_y;

    }



    private void Paint_Olusturucu(){
// Fill s
        red_paintbrush_fill = new Paint();
        red_paintbrush_fill.setColor(Color.RED);
        red_paintbrush_fill.setStyle(Paint.Style.FILL);

        blue_paintbrush_fill = new Paint();
        blue_paintbrush_fill.setColor(Color.BLUE);
        blue_paintbrush_fill.setStyle(Paint.Style.FILL);

        green_paintbrush_fill = new Paint();
        green_paintbrush_fill.setColor(Color.GREEN);
        green_paintbrush_fill.setStyle(Paint.Style.FILL);

        // Stroke s
        red_paintbrush_stroke = new Paint();
        red_paintbrush_stroke.setColor(Color.RED);
        red_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        red_paintbrush_stroke.setStrokeWidth(15);

        blue_paintbrush_stroke = new Paint();
        blue_paintbrush_stroke.setColor(Color.BLUE);
        blue_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        blue_paintbrush_stroke.setStrokeWidth(10);

        green_paintbrush_stroke = new Paint();
        green_paintbrush_stroke.setColor(Color.GREEN);
        green_paintbrush_stroke.setStyle(Paint.Style.STROKE);
        green_paintbrush_stroke.setStrokeWidth(20);
    }
}
