A general use interface package that can be used to create quick use easily modifiable interface.

While InterfacePlus comes several built in packages, it's also very easy to extend and create new RenderableObjects.

*BUILT IN OBJECTS*

- Panel: A general use, highly useful RenderableObject that simply displays an image at a certain spot. Very nice.

- Button: A button that can have a three different icons: a default icon, a hover icon, and a press icon. Buttons also have a task that will be executed on click. While this is optional, I'm not sure why you would want a button if you didn't want it to do anything.

*TASKS*

Tasks are objects that contain an execute() method that will run each tick while the program is active. Simply implement the Task interface and add your desired code to the execute() method.
