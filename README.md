# A1 - Piraten Karpen

  * Author: Hamza Abou Jaib
  * Email: aboujaih@mcmaster.ca

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To run the project in development mode with trace mode enabled:
    * `mvn -q exec:java -Dexec.args="trace"`
  * To run the packaged delivery with trace mode enabled:
      * `java -jar target/piraten-karpen-jar-with-dependencies.jar trace`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The feature is done if it works as intended, is efficient and has no bugs. The feature must work 100% of the time and should do so while minimizing the duration of execution and memory usage.

### Backlog

| MVP? | Id  | Feature                                                                                                                                                                                                                                   | Status | Started  | Delivered  |
|------|-----|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------|----------|------------|
| x    | F02 | Roll eight dices                                                                                                                                                                                                                          | D      | 01/18/23 | 01/18/23   |
| x    | F03 | Players always play 42 games                                                                                                                                                                                                              | D      | 01/18/23 | 01/18/23   |
| x    | F04 | Show win percentage of each player after the games are done                                                                                                                                                                               | D      | 01/18/23 | 01/18/23   |
| x    | F05 | Once a player reaches 6000 points the other player is given one more turn. In the case of a tie each player is given one more turn and the one with more points after wins                                                                | D      | 01/18/23 | 01/24/23   |
| x    | F06 | End of turn with three or more skulls                                                                                                                                                                                                     | D      | 01/18/23 | 01/18/23   | 
| x    | F07 | Score points: count the number of gold coins and diamonds and multiply by 100                                                                                                                                                             | D      | 01/18/23 | 01/18/23   |
| x    | F08 | A simulation of a 2 player game with both players using the same strategy                                                                                                                                                                 | D      | 01/18/23 | 01/18/23   |
| x    | F09 | A player can choose to either re-roll or to end their turn                                                                                                                                                                                | D      | 01/18/23 | 01/18/23   |  
| x    | F10 | Randomly select and re-roll at least two non skull dice                                                                                                                                                                                   | D      | 01/18/23 | 01/24/23   |
| x    | F11 | Strategy: choose randomly the dice the player is keeping and ones the player is re-rolling until either three skulls are obtained or the player decides to end their turn to end the turn (dice that land on a skull cannot be rerolled). | D      | 01/18/23 | 01/18/23   | 
|      | F12 | Score points: score points based on the combo system in the rulebook                                                                                                                                                                      | D      | 01/24/23 | 01/24/23   |
|      | F13 | Strategy: choose what dice to re-roll and what dice to keep based on the current roll to maximize combos                                                                                                                                  | D      | 01/24/23 | 01/24/23   |
| ...  | ... | ...                                                                                                                                                                                                                                       |
*Note: Features start at F02

### Feature Priority In Terms of Business Value
I think feature F12 which introduces new a new scoring system has more business value than F13, which improves the AI, as it implements a core feature of the game, the combo scoring system.
This is more important because when the game is done and is launched, the consumers will become the human players, and they will only care about the game experience.\
The only time F13, adding a new strategy, would have more priority is if the AI is a key part of the game, such as an AI VS. AI or a player VS. AI mode.


