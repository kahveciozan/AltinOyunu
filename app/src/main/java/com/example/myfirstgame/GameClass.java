package com.example.myfirstgame;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;


import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.M)
public class GameClass extends View{

    Player p1 = new Player(this.getContext());
    TuglaClass tuglalar[] = new TuglaClass[2];
    AltinClass altinlar[] = new AltinClass[3];

    Paint paint = new Paint();

    int t_id;

    boolean carpisma_tugla=false;
    boolean carpisma_altin=false;

    int skor =0;

    public GameClass(Context context) {
        super(context);
        setBackgroundResource(R.drawable.background);
        for (int i=0;i<tuglalar.length;i++) {
            tuglalar[i] = new TuglaClass(this.getContext(), 500+(200*i), 1400);
        }
        for (int i=0;i<altinlar.length;i++) {
            altinlar[i] = new AltinClass(this.getContext(),300+(100*i),1200);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p1.ciz(canvas);

        for (int i=0;i<tuglalar.length;i++) {
            tuglalar[i].ciz(canvas);
        }

        for (int i=0;i<altinlar.length;i++){
            altinlar[i].draw(canvas);
        }

        carpismaOldu_Altin(canvas);
        carpismaOldu_Tugla(canvas);

        skorBas(canvas);

        invalidate();
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()==MotionEvent.ACTION_DOWN) {
            if(p1.hiz_x!=0) {
                p1.hiz_y = 15;
                p1.hiz_x_yedek = p1.hiz_x;
                p1.hiz_x = 0;
            }
        }
        return true;
    }

    private void carpismaOldu_Tugla(Canvas canvas){

        for (int i=0;i<tuglalar.length;i++){
            if(     p1.player_x+(p1.width/2)>=tuglalar[i].getTugla_x()
                    && p1.player_x+(p1.width/2)<=tuglalar[i].getTugla_x()+tuglalar[i].width
                    && p1.player_y+(p1.height/2)>=tuglalar[i].getTugla_y()+(tuglalar[i].height/2)
            )
            {
                p1.hiz_y=-25;
                carpisma_tugla=true;
                t_id=i;
                break;
            }
        }

        if (carpisma_tugla){
            //p1.ip.reset();
            if (tuglalar[t_id].getTugla_y()>=20) {

                tuglalar[t_id].setTugla_y(p1.player_y);

            } else if (tuglalar[t_id].getTugla_y()<20){

                tuglalar[t_id].setTugla_x((int) (Math.random()*(canvas.getWidth()-tuglalar[t_id].width)));
                tuglalar[t_id].setTugla_y((int) (Math.random()*(canvas.getHeight()-(tuglalar[t_id].height*1.5) ) ) );
                //tuglalar[t_id].setTugla_y(canvas.getHeight()-tuglalar[t_id].height-20);
                carpisma_tugla = false;
                skor=skor+1;
            }
        }

    }

    private void carpismaOldu_Altin(Canvas canvas){

        for (int i=0;i<altinlar.length;i++){
            if(     p1.player_x+(p1.width/2)>=altinlar[i].getAltin_x()
                    && p1.player_x+(p1.width/2)<=altinlar[i].getAltin_x()+altinlar[i].width
                    && p1.player_y+(p1.height/2)>=altinlar[i].getAltin_y()+(altinlar[i].height/2)
            )
            {
                p1.hiz_y=-25;
                carpisma_altin=true;
                t_id=i;
                break;
            }
        }

        if (carpisma_altin){
            //p1.ip.reset();
            if (altinlar[t_id].getAltin_y()>=20) {

                altinlar[t_id].setAltin_y(p1.player_y);

            } else if (altinlar[t_id].getAltin_y()<20){

                altinlar[t_id].setAltin_x((int) (Math.random()*(canvas.getWidth()-altinlar[t_id].width)));
                altinlar[t_id].setAltin_y((int) (Math.random()*(canvas.getHeight()-(altinlar[t_id].height*1.5) ) ) );
                //tuglalar[t_id].setTugla_y(canvas.getHeight()-tuglalar[t_id].height-20);
                carpisma_altin = false;
                skor=skor+1000;
            }
        }

    }

    private void skorBas(Canvas canvas){
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPaint(paint);
        paint.setTextSize(50);
        canvas.drawText("SKOR: "+skor, 0, canvas.getHeight()/2, paint);

    }
}
