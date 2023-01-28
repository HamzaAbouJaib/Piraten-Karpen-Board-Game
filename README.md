# A1 - Piraten Karpen

  * Author: Hamza Abou Jaib
  * Email: aboujaih@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode, the arguments for the strategies are required. Strategy options are ["combo", "random"]:
    * `mvn -q exec:java -Dexec.args="[strategy for player 1] [strategy for player 2]"` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery, the arguments for the strategies are required. Strategy options are ["combo", "random"]:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar [strategy for player 1] [strategy for player 2]` 
  * To run the project in development mode with trace mode enabled:
    * `mvn -q exec:java -Dexec.args="[strategy for player 1] [strategy for player 2] trace"`
  * To run the packaged delivery with trace mode enabled:
      * `java -jar target/piraten-karpen-jar-with-dependencies.jar [strategy for player 1] [strategy for player 2] trace`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The feature is done if it works as intended, is efficient and has no bugs. The feature must work 100% of the time and should do so while minimizing the duration of execution and memory usage.

### Backlog

| MVP? | Id  | Feature                                                                                                                                                                                                                                   | Status | Started  | Delivered |
|------|-----|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|----------|-----------|
| x    | F02 | Roll eight dices                                                                                                                                                                                                                          | D      | 01/18/23 | 01/18/23  |
| x    | F03 | Players always play 42 games                                                                                                                                                                                                              | D      | 01/18/23 | 01/18/23  |
| x    | F04 | Show win percentage of each player after the games are done                                                                                                                                                                               | D      | 01/18/23 | 01/18/23  |
| x    | F05 | Once a player reaches 6000 points the other player is given one more turn. In the case of a tie each player is given one more turn and the one with more points after wins                                                                | D      | 01/18/23 | 01/28/23  |
| x    | F06 | End of turn with three or more skulls                                                                                                                                                                                                     | D      | 01/18/23 | 01/18/23  | 
| x    | F07 | Score points: count the number of gold coins and diamonds and multiply by 100                                                                                                                                                             | D      | 01/18/23 | 01/18/23  |
|      | F08 | A simulation of a 2 player game with both players using the same or different strategy                                                                                                                                                    | D      | 01/18/23 | 01/24/23  |
| x    | F09 | A player can choose to either re-roll or to end their turn                                                                                                                                                                                | D      | 01/18/23 | 01/18/23  |  
| x    | F10 | Randomly select and re-roll at least two non skull dice                                                                                                                                                                                   | D      | 01/18/23 | 01/24/23  |
| x    | F11 | Strategy: choose randomly the dice the player is keeping and ones the player is re-rolling until either three skulls are obtained or the player decides to end their turn to end the turn (dice that land on a skull cannot be rerolled). | D      | 01/18/23 | 01/18/23  | 
|      | F12 | Score points: score points based on the combo system in the rulebook                                                                                                                                                                      | D      | 01/24/23 | 01/24/23  |
|      | F13 | Strategy: choose what dice to re-roll and what dice to keep based on the current roll to maximize combos. Maximizes Monkey and Parrot faces when MonkeyBusiness card is picked.                                                           | D      | 01/24/23 | 01/28/23  |
|      | F14 | Get user input for the type of strategy each player should be using                                                                                                                                                                       | D      | 01/24/23 | 01/24/23  |
|      | F15 | Introduce fortune cards into the game                                                                                                                                                                                                     | D      | 01/26/23 | 01/28/23  |
|      | F16 | Shuffle cards at the start of a game and pick a card at the start of each turn and in the case all cards are used, reshuffle the cards and start picking again                                                                            | D      | 01/26/23 | 01/26/23  |
|      | F17 | Score points: sea battle fortune card allows player to gain or lose a specified number of points                                                                                                                                          | D      | 01/26/23 | 01/26/23  |
|      | F18 | Strategy: when a sea battle card is picked prioritize rolling sabers                                                                                                                                                                      | D      | 01/26/23 | 01/26/23  |
| ...  | ... | ...                                                                                                                                                                                                                                       |


*Note: Features start at F02



