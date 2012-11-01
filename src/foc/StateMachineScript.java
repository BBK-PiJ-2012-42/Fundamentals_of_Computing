package foc;

/**
 *
 * @author Tom Nealon
 */
public class StateMachineScript {
    
    public void loader() {
        // Using DFA A1 from p14 of FoC11-4.pdf
        
        // First setup the machine and language.
        String[] myLanguage = {"a", "b"};
        dfaStateMachine myMachine = new dfaStateMachine(myLanguage);
        
        // Then create the states.
        State s = new State("s");
        State q = new State("q");
        State r = new State("r");
        
        // Then define the behaviour of each state.
        s.addAction("a", s);
        s.addAction("b", q);
        q.addAction("a", r);
        q.addAction("b", q);
        r.addAction("a", r);
        r.addAction("b", r);
        
        // Don't forget to give it a start state,
        myMachine.initialState(s);
        
        
        // Some tests.
        System.out.println("Input: bbaaa");
        myMachine.runString("bbaaa");
        
        System.out.println("Input: aabb");
        myMachine.runString("aabb");
        
        System.out.println("Input: bbb");
        myMachine.runString("bbb");        
        
    }
    
    
    public static void main(String[] args) {
        new StateMachineScript().loader();
    }
    
}
