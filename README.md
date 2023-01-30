# JavaFX Implementation of Pacman 

This GUI implementation of pacman was created using the AGILE development process as well as the Model-View-Controller design pattern to make the code scalable and efficient. 

The game includes three different mazes for the easy, difficult, and hard level. Each maze has a varying number of pellets (increase score) and ghosts.

# Feautures
Users begin on the intro screen, where they can insert their name, choose their level (easy, medium, or hard), and choose a pacman color (yellow, blue, or pink). The arrows keys control the movement of pacman. 

Maze layouts are stored in a 2D array in the maze class. 
* 'P' indicates a normal pellet (+ 1 score increase) 
* 'W' indicates a wall 
* 'G' indicates the ghost's release area
* 'B' indicates a big pellet (+ 3 score increase) 
* 'C' indicates a cherry (extra life) 
* 'S' indicates a sheild (temporary protection from a ghost) 

The shield and cherry location are generated randomly in the maze each game. The maze array is updated in the GameView class once the icons are generated during the instantiation of a GameModel object. 




## GameModel Class

This class controls the game logic of the game by creating: 

* Enums for the current game state and direction of the character (pacman, ghost) 
* 3 Algorithms to move each ghost
  * random movement
  * random generation of the Manhattan distance to pacman
  * semi-random movement, where the ghost follows pacman if they enter the same space of the maze
* HashMap to store the direction velocity pairs 
* Classes to move pacman, update the score, and handle unqiue maze features (shield, bonus lives)

## GameControl Class

This class controls the game function by:

* Using key-event handlers to move pacman with user input 
* Instantiating a GameModel object and displaying the primary stage of the game 
* Instantiating a single timer to control the duration of the game
* Logic to determine if the ghost is currently able to eat pacman 

## GameView Class

This class controls the UI of the game by: 
* Creating image objects for each character and icon 
* Using scene inheritance to add and remove pellets from the stage 
* Updating the user's view of pacman and the ghosts (orientation and life status) based on the game logic 
* Displaying key statistics such as lives and score 

## Sprints 

### Sprint 1

Implemented game start and exit controls, a player configuration screen with error handling for null or white-space only usernames, character choices, and a maze which includes the starting lives and score. 

### Sprint 2 
Implemented valid pacman movements (all directions, no access to wall regions), pellet eating functionality, and visual feedback of a pellet being eaten.  

### Sprint 3 
Implemented enemy (ghost) spawning, unique ghost movement and tracking algorithms, game over and in-game states, and an invulnerability period for pacman after it is eaten by a ghost. 

### Sprint 4
Implemented shield and cherry icons, additional ghosts in the hard maze, visual feedback of lives using a pacman icon, and a modified game over screen that allows players to restart their game after winning or losing. 

## Contributors 
Coding team: Isha Perry, Emily Wu, Audrey Chung 

Design Team: Suemin Lee, Anita Singh, Cassandra Marshall 



