import com.juans.echoes.model.Choice;
import com.juans.echoes.model.Player;
import com.juans.echoes.model.State;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Player john = new Player();

        Map<String, Choice> shoreChoices = new HashMap<>();
        Map<String, Choice> jungleChoices = new HashMap<>();
        Map<String, Choice> caveChoices = new HashMap<>();
        Map<String, Choice> ruinsChoices = new HashMap<>();
        Map<String, Choice> endCaveChoices = new HashMap<>();

        State shore = new State("Shore", shoreChoices, false);
        State jungle = new State("Jungle", jungleChoices, false);
        State cave = new State("Cave", caveChoices, false);
        State ruins = new State("Ruins", ruinsChoices, false);
        State endCave = new State("End Cave", endCaveChoices, false);
        State death = new State("Death", Collections.emptyMap(), false);

        john.setCurrentState(shore);
        System.out.println("Current state: " + john.getCurrentState().getId());

        shoreChoices.put("A", new Choice("Stay by the shore and build a fire. Explore later, survival is more important", jungle));
        shoreChoices.put("B", new Choice("Follow the scream into the jungle.", death));

        john.setCurrentState(
                john.getCurrentState().getChoices().get("A").getNextState()
        );
        System.out.println("Current state: " + john.getCurrentState().getId());

    }
}
