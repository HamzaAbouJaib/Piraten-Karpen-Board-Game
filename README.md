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

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * The feature is done if it works as intended, is efficient and has no bugs. The feature must work 100% of the time and should do so while minimizing the duration of execution and memory usage.

### Backlog

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice |  S | 01/01/23 |  |
| x   | F02 | Roll eight dices  |  B (F01) |   |
| x   | F03 | Players always play 42 games  |  P  |   |
| x   | F04 | Show win percentage of each player after the games are done  |  B (F03&F05)  |   |
| x   | F05 | The player with the most points at the end wins  |  B (F07)  |   |
| x   | F06 | End of turn with three or more skulls | P | |
| x   | F07 | Score points: count the number of gold coins and diamons and multiple by 100 | B (F02) | |
| x   | F08 | 2 player game with both players using the same strategy | B (F09) | |
| x   | F09 | Strategy: choose randomly the dice the player is keeping and re-roll until three skulls are obtained then end the turn. dice that land on a skull cannot be rerolled | B (F02) | |
| ... | ... | ... |


