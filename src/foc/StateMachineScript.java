package foc;

/**
 *
 * @author tom
 */
public class StateMachineScript {
    
    public void loader() {
        // Using DFA A1 from p14 of FoC11-4.pdf
        String[] myLanguage = {"a", "b"};
        dfaStateMachine myMachine = new dfaStateMachine(myLanguage);
        State s = new State("s");
        State q = new State("q");
        State r = new State("r");
        s.addAction("a", s);
        s.addAction("b", q);
        
        q.addAction("a", r);
        q.addAction("b", q);
        
        r.addAction("a", r);
        r.addAction("b", r);
        
        String inputString = "bbaaa";
        
        
        
    }
    
    
    public static void main(String[] args) {
        new StateMachineScript().loader();
    }
    
}
