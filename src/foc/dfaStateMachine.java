
package foc;

/**
 *
 * @author Tom Nealon
 */

// This is my attempt at a general purpose deterministic finite automation (DFA)
// state machine as described in the Fundamentals of Computing module.


// The overall style of the state machine depends on how we wish to build it.
// In this case the state machine is defined only with a language of strings that
// defines valid input to be used while it is running. States and state
// behaviour are created in turn.

public class dfaStateMachine {
    // The language can be an array of whatever type is needed.
    public final String[] language;
    private State currentState = null;
    public State initialState = null;
    
    
    // The language used by the machine is defined as an array of objects that are
    // valid inputs to the machine.
    public dfaStateMachine(String[] language) {
        // Only the language is necessary as an argument for initial construction.
        this.language = language;
    }
    
    public State currentState() {
        return currentState;
    }

    public boolean isStateDefined(State state) {
        for (int i = 1; i < language.length; i++) {
            if (!state.behaviour.containsKey(language[i])) {
                return false;
            }
        }
        return true;
    }
    
    // Sends a input to the machine and responds with the resulting state.
    public State send(String input) {
        // No checking for a valid input yet.
        State stateResponse = currentState.response(input);
        // Changes the current state of the machine based on the reponse.
        currentState = stateResponse;
        return stateResponse;
    }
    
    // Resets the machine to the inital state.
    public void reset() {
        // Does not check that the initial state has actually been set.
        currentState = initialState;
    }
    
    // Takes a string and uses each character as input to the machine.
    public void runString(String input) {
        int length = input.length();
        for (int i = 0; i < length; i++) {
            //System.out.println(input.substring(0,1));
            
            System.out.println("(" + currentState.stateName + ", " + input + ")");
            this.send(input.substring(0,1));
            input = input.substring(1, input.length());        
        }
        this.reset();
    }

    void initialState(State s) {
        initialState = s;
        this.reset();
    }

    
}
