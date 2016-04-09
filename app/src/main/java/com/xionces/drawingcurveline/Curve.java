package com.xionces.drawingcurveline;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by TayfunCesur on 09/04/16.
 */
public class Curve extends View {

    Path path;
    Paint paint,paint2;
    float length;

    public Curve(Context context)
    {
        super(context);
    }

    public Curve(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public Curve(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public void init(Path path)
    {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);

        this.path = path;







        PathMeasure measure = new PathMeasure(path, false);
        length = measure.getLength();

        float[] intervals = new float[]{length, length};

        ObjectAnimator animator = ObjectAnimator.ofFloat(Curve.this, "phase", 1.0f, 0.0f);
        animator.setDuration(2000);
        animator.start();
    }

    public void setPhase(float phase)
    {
        paint.setPathEffect(createPathEffect(length, phase, 0.0f));
        invalidate();
    }

    private static PathEffect createPathEffect(float pathLength, float phase, float offset)
    {
        return new DashPathEffect(new float[] { pathLength, pathLength },
                Math.max(phase * pathLength, offset));
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        c.drawPath(path, paint);
    }



}
