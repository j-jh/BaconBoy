
Jadon Huang

Kevin Bacon's Law/6 degrees of connections program.

Notes: 

In order to properly run the program, the run configuration must contain the argument of 'tmdb_5000_credits.csv' with the file in the same folder as the java program. 

Under the Eclipse IDE, this was done through Run -> Run configurations -> Arguments -> Program arguments: 'tmdb_5000_credits.csv'

The Kevin Bacon java class containing the main function takes in the .csv file as an argument. The argument args[0] is then handled by FileRead's graph read() function where the file's contents are split and tokenized to extract actor names. \

The .csv file could not be rendered visible after being pushed through terminal. Github was treating the file as a binary file and not showing it. Had to compress and upload as a .zip instead
