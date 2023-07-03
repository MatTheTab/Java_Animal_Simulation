# Java Project - Animal Simulation

This program is meant to be a simplified simulation of the natural cycle of life if animals living in the savanna. Predators can eat prey and prey can try to escape but
not every predator can hunt every type of prey. Animals get tired and require food and water, as well as rest. The behaviour of animals is simulated concurrently. <br>

<b> Warning: </b> <br>
Due to relative path provided in the code, ilustrations of animals and places may not be visible if program is not opened correctly. If you wish to run the program locally, then please, open the folder "Animal" in an IDEA, not the whole downloaded project. <br>

<b>User's Manual:</b> <br>

This is a Java project developed for Object-Oriented Programming classes. The program simulates animal behavior based on project requirements. Users can add animals by selecting a species from the ComboBox located on the right side of the window. The window size should automatically adjust to fit the monitor's size. Both preys and predators behave according to the specified requirements.

When the mouse hovers over an animal or location, simplified information about the object is displayed on the sidebar. Clicking on an object provides more extensive information. Please note that the displayed information reflects the state of the object at the time of interaction and may not be up-to-date.

The "Stop" button on the sidebar deletes all animals without closing the window, allowing you to reset the simulation without turning off the program. Please be aware that stopping the simulation may take a few seconds if there are many animals.

Documentation can be found in the JavaDoc folder, and the code and executable .jar file are located in the Animal folder. Illustrations for the program, created in pixel art style, are also included. Do not remove any code or the .jar file from the folder, as it will cause the program to be unable to locate the illustrations.

<b>Additional Notes:</b> <br>

The map state is randomized and may appear different with each program restart. <br>
Not every crossing point has a "crossing" object, but paths can still intersect. Crossing objects are easily identifiable with their brown dot illustration and clickable functionality. <br>
The number of animals in a location may appear higher than the maximal capacity due to animals stopping just before entering. <br>
Dead prey leaves bones behind, which disappear after a while. <br>
Predator's portrait changes based on their activity (attacking, resting, walking). <br>
Predators have two states: hunting or resting, displayed in the Dialog Window. <br>
If a predator fails a hunt, they rest for a while to give the prey a fair chance to escape. <br>
If a predator succeeds in a hunt, they enter a relaxation state for a duration determined by their individual max_relax_state variable. <br>
Reproduction, thirst level, and food level are probabilistic. Animals become more hungry/thirsty over time, and reproduction inside a hideout is also probabilistic. <br>
Water sources and food sources have depletable materials. When depleted, animals have to wait for the materials to recharge. <br>
The rate of recharge and feeding depends on the number of animals on the map. <br>
The occupation of animals at a crossroad may be difficult to observe due to their short stay, but their behavior is synchronized. <br>
Prey may not always follow the most optimal path to the target. Their behavior combines greediness and probability. <br>
Adjustments to program behavior can be made through the Constants class, which contains various hyperparameters. <br>
Please note that changing certain hyperparameters drastically may lead to errors. <br>

<b>Feel free to explore the program and enjoy the animal simulation!<b/>
