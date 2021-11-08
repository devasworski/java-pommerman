To use this agent, the entire custom_mcts.mcts folder need to be placed within: {project_directory}/src/players/

To create a new instance of the custom MCTS agent, the following code needs to be executed:

    new Custom_MCTSPlayer(seed, playerID);

To create an instance of the Agent in the Run.java class, the following code has to be added:

     case 6:
            p = new Custom_MCTSPlayer(seed, playerID++);
            playerStr[i-4] = "Custom_MCTS_Group_AB";
            break;