package com.zjgsu.ai.cameratest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Double on 18/10/2017.
 */

public class FaceView extends SurfaceView {

    private final String TAG = "MSG_Camera";

    private int[] mFaces;
    private Paint mPaint;
    private SurfaceHolder mHolder;
    private double scaleX, scaleY;

    public FaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        setZOrderOnTop(true);
        mHolder = getHolder();
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(7f);
        mHolder.setFormat(PixelFormat.TRANSPARENT);
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


    }

    public void setFaces(int[] faces) {
        this.mFaces = faces;
        invalidate();
    }

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        scaleX = getWidth() / 640.0;
        scaleY = getHeight() / 480.0;
        Log.i(TAG, "FaceView: scaleX = " + scaleX + " scaleY = " + scaleY);
        if (mFaces != null && mFaces.length % 3 == 0) {
            for (int i = 0; i < mFaces.length; i = i + 3) {
                canvas.drawRect((int) (mFaces[i] * scaleX),
                        (int) (mFaces[i + 1] * scaleY),
                        (int) ((mFaces[i] + mFaces[i + 2]) * scaleX),
                        (int) ((mFaces[i + 1] + mFaces[i + 2]) * scaleY),
                        mPaint);
            }
        }
        super.onDraw(canvas);
    }
}
