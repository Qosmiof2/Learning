package com.learn.script.FirstScript;

import com.learn.script.FirstScript.framework.Task;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;

/**
 * Created by Qosmiof2 on 27.2.2015.
 */
public class Interact extends Task {

    @Override
    public boolean activate() {
        GameObject o = GameObjects.newQuery().names("Object name").actions("Action (To interact / click)").results().sortByDistance().limit(3).random();
        /*This will return for:

        Name = objects with the specified name
        Actions = Objects that contain this action / pattern.
        Results = get all the objects with stuff declared before calling "results()"
        Sort by distance = sort results by distance from Players.getLocal()
        Limit(x) = You can use this feature for selecting random object sort by distance for 3 objects.
        Random = select random object from the first three

        Code above will return: All GameObjects with name("Object name"), action("Action (To interact / click)");

        Its all the same with Npcs, Objects etc.

        */

        return 1 > 0 && 10 * 5 != 30 && o != null && o.isVisible(); // Set requirements to activate and execute
    }

    @Override
    public void execute() {

        // Executed if all above is true.

        GameObject o = GameObjects.newQuery().names("Object name").actions("Action (To interact / click)").results().sortByDistance().limit(3).random();

        if (o.isVisible()) {
            if (o.interact("Action (To interact / click)")) {
                Execution.delayUntil(() -> Players.getLocal().getInteractionPoint() != null && Players.getLocal().getAnimationId() != -1, 1000);
                // Wait until players.getinteractionPoint() is not null AND animation is not -1 (-1 means its idle). Wait max 1000ms = 1s
            } else {
                //Fail save
            }
        } else {
            // Else turn camera.
            Camera.turnTo(o.getPosition().randomize(0, 10));
        }
    }
}
