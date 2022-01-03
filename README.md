# Coursework 1 (ECS7002P - AI in Games)


<img src="https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fwww.bilingualism-matters.ppls.ed.ac.uk%2Fwp-content%2Fuploads%2F2014%2F11%2Fqueen-mary-logo.jpg&f=1&nofb=1" height=130>


Module Leader: Diego Perez-Liebana

Semester 1 

Due: 8th November 2021.

#### Final Mark: Distinction

Group Members: Alexander Sworski, Patric Levermore, Dominic Muthumbi Nzimi

## Assignment
Using AI agents for the game Pommerman.

## Requirements
The goal of the assignment is to create or modify one agent, which you must compare against other agents in the framework (or previous iterations of the same agent you submit or modify), describing your findings in a report.

#### Marking Criteria:
- Complexity of the implemented agent:
	- Improvements of advanced tree search or evolutionary agents 
- Experimentation
	- in FFA & TEAM modes: fulfilling all criteria for 2:1 plus experimentation extended also to TEAM mode.
- Quality of the written report
	- report written with the quality and rigor of a scientific publication. The quality of the report would not need to be at the level where it would be accepted by a venue, but it would need to have sufficient quality that it could be considered for an eventual submission.



# Instructions to run the artifact:
	1. You need Java 8.0.1 version (or higher) to run this code.
 	2. Option 1: download the source, compile and execute the class Run.java (see below for execution modes). 
 	3. Option 2: directly run run.jar, included in jars/ 
	
### Executing Run.java / run.jar
This runs either a single game of pommerman (visuals on) or a series of games (headless), reporting statistics at the end. The usage is 'java Run' or 'java -jar run.jar' with 8 parameters:

[arg index = 0] Game Mode. 0: FFA; 1: TEAM
[arg index = 1] Number of level generation seeds [S]. "-1" to execute with the ones from the paper (20).
[arg index = 2] Repetitions per seed [N]. "1" for one game only with visuals.
[arg index = 3] Vision Range [VR]. (0, 1, 2 for PO; -1 for Full Observability)
[arg index = 4-7] Agents. When in TEAM, agents are mates as indices 4-6, 5-7:
0 DoNothing
1 Random
2 OSLA
3 SimplePlayer
4 RHEA 200 itereations, shift buffer On, pop size 1, random init, length: 12
5 MCTS 200 iterations, length: 12
6 Human Player (controls: cursor keys + space bar)

