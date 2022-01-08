# Basic Java Graphics

By creating a new instance of JFrame, you can create a basic graphic interface in Java. With a new instance of Canvas, you can draw on that JFrame. 

This program uses a JFrame as the base and a Java Timer. That Timer loops continuously to reapply the Canvas to the JFrame. By using a variable in the Canvas paint function which is incremented for each drawing, an animation is created. 

Java JFrames can have different event listeners. Currently, only a resize handler is used to keep the graphics to scale. These event listeners can be used to create interactive graphic based programs such as simulations, games, and more. 

## Compile and run

Run `bash start.sh` in the terminal to compile and run the program. 