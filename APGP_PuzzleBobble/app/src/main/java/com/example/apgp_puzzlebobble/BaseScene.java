package com.example.apgp_puzzlebobble;

import android.graphics.Canvas;

import java.util.ArrayList;

public class BaseScene {
    private static ArrayList<BaseScene> stack = new ArrayList<>();
    public static float frameTime;
    public static BaseScene getTopScene()
    {
        return stack.get(stack.size()-1);
    }
    public int pushScene()
    {
        stack.add(this);
        return stack.size();
    }
    public int add(IGameObject gobj)
    {
        gameObjects.add(gobj);
        return gameObjects.size();
    }
    public void update(long elapsedNanos)
    {
        frameTime = elapsedNanos/ 1_000_000_000f;
        for(IGameObject gobj:gameObjects)
        {
            gobj.update();
        }
    }
    public void draw(Canvas canvas)
    {
        for (IGameObject gobj :gameObjects)
        {
            gobj.draw(canvas);
        }
    }

    private ArrayList<IGameObject> gameObjects = new ArrayList<>();
}