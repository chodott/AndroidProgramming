package com.example.apgp_puzzlebobble;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

public class Score implements IGameObject{
    private final Bitmap bitmap;
    private final int srcWidth, srcHeight;
    private final float dstWidth, dstHeight;
    private float right, top;

    private float padX = 0.f;
    private final Rect srcRect = new Rect();
    private final RectF dstRect = new RectF();
    private int score= 0;
    private int displayScore=0;

    private boolean bAnimating = true;

    public Score(int mipmapResId, float right, float top, float width)
    {
        this.bitmap = BitmapPool.get(mipmapResId);
        this.right = right;
        this.top = top;
        this.srcWidth = bitmap.getWidth() / 10;
        this.srcHeight = bitmap.getHeight();
        this.dstWidth = width;
        this.dstHeight = dstWidth * srcHeight / srcWidth;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void movePos(float right , float top)
    {
        this.right = right;
        this.top = top;
    }

    public int getScore()
    {
        return score;
    }

    public void setbAnimating(boolean b)
    {
        bAnimating = b;
    }
    @Override
    public void update() {
        if (score < displayScore) {
            displayScore--;
        } else if (score > displayScore) {
            displayScore++;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        int value = this.displayScore;
        if(!bAnimating) value = score;
        float x = right;
        while(value > 0)
        {
            int digit = value % 10;
            int leftPos = digit * srcWidth;
            srcRect.set(leftPos, 0, leftPos + srcWidth, srcHeight);
            x -= dstWidth;
            dstRect.set(x, top, x + dstWidth, top + dstHeight);
            canvas.drawBitmap(bitmap, srcRect, dstRect, null);
            value /= 10;
        }
    }
}
