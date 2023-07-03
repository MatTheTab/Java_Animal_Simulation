Java Project - Animal Simulation

User's Manual:

This is my Java Project for the Object Orineted Programming Classes.
The program should function according to specifications stated in the project requirements file.
The user can add an animal by selecting a species from the ComboBox found on the right side of the window.
We window size should more or less automatically fit to the monitor's size (more or less because the actual size
is a bit smaller than the screensize, for the window not to get covered by toolbars, etc.). Both Preys and Predators
should behave as is specified in the requirements. When a mouse hovers over one of the animals or locations
simplified information about the object is displayed on the sidebar and when an object is clicked on, more extensive
information is displayed. Please note, that the information displayed is from the time the animal/location 
was clicked on/hovered over, so it may not be adequete if object's state has changed. Pressing the "Stop" button
located on the sidebar should delete all the animals without closing the window, so it can be used to reset
the simulation without turning the program off (stopping the simulation may take a few seconds if there are
a lot of animals).

Documentation can be found in the JavaDoc folder, both code and executable .jar file can be found in the Animal
folder, alongside ilustrations for the program created in pixelart style by me. Please, do not remove either code
or .jar file from the folder, as it will cause the program to be unable to locate ilustartions and you won't
be able to see anything besides paths!

Additional Notes:
- Map state is random, can look different upon every restart of the program
- As per agreement due to the probabilistic nature of the map, not every time two roads cross is 
"crossing" object created. Sometimes there are two paths that cross but are not synchronized. 
Differentiating betwen them is easy thanks to crossing objects having a brown dot as their illustartion and
being clickable. The "in universe" explonation to that, is the fact that the environment is very
chaotic and damaged, causing change in elevation (mountains, fallen over trees as brides, canyons, 
borrows in the ground, etc.)
- It may seem like a lot of animals are present in a Place even when a maximal capacity is reached, however
this is caused by the fact that animals will stop just before a location to check if they can enter and if they
cannot, they will wait. This sometimes causes Prey to stop just a few pixels away from location coordinates, 
giving illusion that they entered when they did not. To monitor actual number of animals in a location,
please look at the information displayed when a location is hovered over by a cursor.
- Dead Prey leaves bones behind, which should disappear after a while
- Predator's portrait will change when attacking/resting/walking
- The Predator has 2 states hunting or resting displayed in the Dialog Window
- If the Predator failes a hunt, they have to rest for a little while to give the Prey a fair chance at escaping
- If the Predator succeeds in a hunt, they enter a relaxation state lasting as long as is determined by 
an individual predator's max_relax_state variable
- Both reproduction and thirst level/food_level is probabilistic, meaning that for every few miliseconds
there is a chance that animal will become a bit more hungry/thirsty but it is not guaranteed (animals
don't become hungry/thirsty when waiting) and similarly
whether an animal will reproduce inside a hideout is also probabilistic
- Every WaterSource and Plant (FoodSource) has a certain material that can be depeleted, if that happens,
the animals have to wait for the consumable material to recharge, the recharge rate is proportional
to number of animals on the map, but it works on integers, so the rate only increases by multiplier of one
for every 10 animals on the map (can be adjusted through hyperparameters). The rate at which Prey gets
fed is also proportional to number of animals on the map in similar way (multiply of one per 10 animals).
- It can be hard to see the current occupation of animals on a crossroad due to them
being there very shortly, but their behaviour is synchronized and they will not enter a crossing
simulatniously as can be seen when for a large number of animals, clusters (traffic jams) occur near crossings.
- Prey may not always go to the target through the most optimal path, their behavior is a combination of greedy and
probabilistic behaviour so when you set a target to Prey, you may be forced to wait for a little while
before they reach the target.
- A lot of hyperparameters for the program's behaviours can be easily adjusted by using the Constants class
and changing a value of the corresponding variable, although doing things like changing number of hideouts to 100
may cause some errors