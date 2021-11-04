package players.custom_mcts.mcts;

import core.GameState;
import players.Player;
import players.optimisers.ParameterizedPlayer;
import utils.ElapsedCpuTimer;
import utils.Types;

import java.util.ArrayList;
import java.util.Random;

public class Custom_MCTSPlayer extends ParameterizedPlayer {

    /**
     * Random generator.
     */
    private Random m_rnd;

    /**
     * All actions available.
     */
    public Types.ACTIONS[] actions;

    /**
     * Params for this MCTS
     */
    public Custom_MCTSParams params;

    public Custom_MCTSPlayer(long seed, int id) {
        this(seed, id, new Custom_MCTSParams());
    }

    public Custom_MCTSPlayer(long seed, int id, Custom_MCTSParams params) {
        super(seed, id, params);
        reset(seed, id);

        ArrayList<Types.ACTIONS> actionsList = Types.ACTIONS.all();
        actions = new Types.ACTIONS[actionsList.size()];
        int i = 0;
        for (Types.ACTIONS act : actionsList) {
            actions[i++] = act;
        }
    }

    @Override
    public void reset(long seed, int playerID) {
        super.reset(seed, playerID);
        m_rnd = new Random(seed);

        this.params = (Custom_MCTSParams) getParameters();
        if (this.params == null) {
            this.params = new Custom_MCTSParams();
            super.setParameters(this.params);
        }
    }

    @Override
    public Types.ACTIONS act(GameState gs) {

        /* MODIFIED
        Initially after 500 ticks we decide to change the strategy to
        be from the current version to an CUSTOM_HEURISTICS.
        We modify the code below by obtain the current number of tick and switching strategy.
        from the current strategy to a new strategy.

         */
//
        if (gs.getTick() > 500&&this.params.CHANGE_HEURISTIC){
            this.params.heuristic_method = this.params.ADVANCED_HEURISTIC;
        }
//

        // TODO update gs
        if (gs.getGameMode().equals(Types.GAME_MODE.TEAM_RADIO)){
            int[] msg = gs.getMessage();
        }

        ElapsedCpuTimer ect = new ElapsedCpuTimer();
        ect.setMaxTimeMillis(params.num_time);

        // Number of actions available
        int num_actions = actions.length;

        // Root of the tree
        Custom_SingleTreeNode m_root = new Custom_SingleTreeNode(params, m_rnd, num_actions, actions);
        m_root.setRootGameState(gs);

        //Determine the action using MCTS...
        m_root.mctsSearch(ect);

        //Determine the best action to take and return it.
        int action = m_root.mostVisitedAction();

        // TODO update message memory

        //... and return it.
        return actions[action];
    }

    @Override
    public int[] getMessage() {
        // default message
        int[] message = new int[Types.MESSAGE_LENGTH];
        message[0] = 1;
        return message;
    }

    @Override
    public Player copy() {
        return new Custom_MCTSPlayer(seed, playerID, params);
    }
}