A general use interface package that can be used to create quick use easily modifiable interface.

While InterfacePlus comes several built-in packages, it's also very easy to extend and create new RenderableObjects.

*BUILT IN OBJECTS*

- Panel: A general use, highly useful RenderableObject that simply displays an image at a certain spot. Very nice.

- Button: A button that can have three different icons: a default icon, a hover icon, and a press icon. Buttons also have a task that will be executed on click. While this is optional, I'm not sure why you would want a button if you didn't want it to do anything.

- AnimatedPanel: A panel with multiple image frames with a configurable frame rate.

- NodePanel: An extension of the AnimatedPanel that only cycles to the next frame when the next() method is called.

- TextComponent: Self-explanatory. Displays text on the screen with configurable size, font, and style.

*TASKS*

Tasks are objects that contain an execute() method that will run each tick while the program is active.
In order to use a task, first choose which one you would like to use. If it is a standard task (run by the interface each tick), simply implement the Task interface and override the execute() method. However, there are other tasks that are pre-created for other purposes (like onClick for the Button). Here is a list:

- DeferredTask<T extends RenderableObject>: Used to assign an object (after its creation) to the task. Override the fill() method and assign the container value to the parameter to use this correctly.