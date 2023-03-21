package com.example.pokdex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class RectangleProgressBar extends View {
    private int progress;
    private int max;
    private Paint bgPaint;
    private Paint fgPaint;
    private Paint textPaint;
    private RectF bgRect;
    private RectF fgRect;
    private String progressText;

    public RectangleProgressBar(Context context) {
        super(context);
        init();
    }

    public RectangleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectangleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        // Initialize background paint
        bgPaint = new Paint();
        bgPaint.setColor(Color.GRAY);

        // Initialize foreground paint
        fgPaint = new Paint();
        fgPaint.setColor(Color.BLUE);

        // Initialize text paint
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextAlign(Paint.Align.CENTER);

        // Initialize background and foreground rectangles
        bgRect = new RectF();
        fgRect = new RectF();

        // Initialize progress text
        progressText = "";
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // Get view width and height
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);

        // Set view dimensions
        setMeasuredDimension(width, height);

        // Update background and foreground rectangles
        bgRect.set(0, 0, width, height);
        fgRect.set(0, 0, width * progress / max, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw background rectangle
        canvas.drawRect(bgRect, bgPaint);

        // Draw foreground rectangle
        canvas.drawRect(fgRect, fgPaint);

        // Draw progress text
        Rect bounds = new Rect();
        textPaint.getTextBounds(progressText, 0, progressText.length(), bounds);
        int x = getWidth() / 2;
        int y = (getHeight() + bounds.height()) / 2;
        canvas.drawText(progressText, x, y, textPaint);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        // Update foreground rectangle
        fgRect.set(0, 0, getWidth() * progress / max, getHeight());
        invalidate();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        invalidate();
    }

    public void setBackgroundColor(int color) {
        bgPaint.setColor(color);
        invalidate();
    }

    public void setProgressColor(int color) {
        fgPaint.setColor(color);
        invalidate();
    }

    public void setProgressText(String text) {
        progressText = text;
        invalidate();
    }
}
