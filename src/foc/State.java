
package foc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Tom Nealon
 */
public class State {
    String stateName;
    Map<String,State> behaviour = new HashMap<String,State>(200);
    //Map<char,State> behaviour = new HashMap<Object, State>();

    public State(String name) {
        this.stateName = name;
    }
    
    public void addAction(String input, State change) {
        behaviour.put(input, change);
    }
    
    // Set the behaviour map in one go. Useful if being used by a scripting
    // language like groovy that lets you define a map in one line.
    public void addBehaviour(Map<String,State> behaviour) {
        this.behaviour = behaviour;
    }
    
    public State response(String input) {
        return behaviour.get(input);
    }

}
