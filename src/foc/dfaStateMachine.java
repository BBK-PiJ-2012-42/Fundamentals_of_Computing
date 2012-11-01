
package foc;

/**
 *
 * @author tom
 */

// The overall style of the state machine depends on how we wish to build it.
// In this case the state machine is defined only with the langauge of objects
// to be used while it is running. States and state behaviour is created in turn.

public class dfaStateMachine {
    // The language can be an array of whatever type is needed.
    public final String[] language;
    private State currentState = null;
    public final State initialState = null;
    
    
    // The language used by the machine is defined as an array of objects that are
    // valid inputs to the machine.
    public dfaStateMachine(String[] language) {
        // Only the language is necessary as an argument for initial construction.
        this.language = language;
    }
    
    // Each state is added to the machine before the behaviour is defined because
    // behaviour is dependent on the states refered to by that behaviour being
    // already defined.
//    public addState(name) {
//        
//    }
    
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
    
    public void runString(String input) {
        
    }

    
}
