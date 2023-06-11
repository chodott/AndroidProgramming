package com.example.apgp_puzzlebobble;

import android.graphics.Canvas;
import android.graphics.Rect;

public class Button extends Sprite
{
    public Rect srcRect = new Rect();
    public Button(int bitmapResId, float cx, float cy, float width, float height) {
        super(bitmapResId, cx, cy, width, height);
    }

    public void setSrcRect(int type)
    {
        int srcHeight = bitmap.getHeight();
        srcRect.set(0, type * srcHeight/2, bitmap.getWidth(), (type + 1) * srcHeight/2);
    }

    @Override
    public void update()
    {

    }

    @Override
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(bitmap,srcRect,dstRect,null);
    }

    public boolean checkTouched(float cx, float cy) {
        if(cx <= x + width/2 && cx >= x -width/2 && cy <= y + height && cy >= y - height)
        {
               return true;
        }
        return false;
    }
}
