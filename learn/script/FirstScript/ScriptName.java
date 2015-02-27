package com.learn.script.FirstScript;

import com.learn.script.FirstScript.framework.Task;
import com.runemate.game.api.client.paint.PaintListener;
import com.runemate.game.api.script.framework.LoopingScript;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Qosmiof2 on 27.2.2015.
 */
public class ScriptName extends LoopingScript implements PaintListener {

    private ArrayList<Task> taskList = new ArrayList<Task>();


    @Override
    public void onStart(String... a) {
        setLoopDelay(300, 500); //Set a random loop delay between activating / checking tasks.
        getEventDispatcher().addListener(this);
        super.onStart(a);
    }

    @Override
    public void onStop() {
        // You can add stuff here for dynamic signature later.
        super.onStop();
    }

    @Override
    public void onPause() {
        // Stop timer / runTime here if you have one
        super.onPause();
    }

    @Override
    public void onResume() {
        // Run the timer / runTime again.
        super.onResume();
    }

    @Override
    public void onLoop() {
        for (Task t : taskList) { // For every Task in taskList
            if (t.activate()) { // If the Task named T has an activation requirement that is true it will execute (run) it.
                t.execute(); // Open the Task.java to see what is this framework.
            }
        }
    }

    private int x, y, width, height;
    private Color color = new Color(0, 0, 0); // If: new Color(0,0,0, 120); 120 is an integer for opacity

    @Override
    public void onPaint(Graphics2D g) {
        g.setColor(color); // You can also use Color.WHITE
        g.drawRect(x, y, width, height);
        g.drawString("String", x, y);
    }


    private void Add(){
        taskList.add(new Interact());
    }
}
