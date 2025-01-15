<B>Fundamental Concepts of OOP:</B>

* Classes: Classes are blueprints for creating objects. They define the structure and behavior of objects by specifying attributes(data) and methods(functions) that instances of the class will possess.
* Objects: Objects are instances of classes. They represent real-world entities and contain data(attributes) and methods(functions) that operate on that data.
* Encapuslation: Encapsulation is the concept of bundling data(attributes) and the methods(functons) that operate on that data into a single unit, called a class. It restricts direct access to an object's internal state and enforces access through defined methods, thus hiding implemnetation details.
* Abstraction: Abstraction is the process of simplifying complex reality by modeling class based on their essential properties and behaviors while ignoring non-essential details. It allows developers to focus on what an object does rather than how it does it.
* Inheritance: Inheritance allows a new class(subclass/derived class) to inheirt attributes and methods from an existing class(superclass/base class). It promtoes code reuse and establishes a hierarchical relationship between classes.
* Polymorphism:
  * Compile-Time Polymorphism: Also known as method overloading, It involves defining multiple methods with the same name in a class, but with different parameters or types. The correct methid is determined at compile time based on method signature.
  * Runtime Polumorphism: Also known as method overriding, it occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. The method to execute is determined at runtime based on the objects actual class.
 
------------

<B> Abstract Classes and Interfaces:</B>

Abstract Class:

* They serve as a blueprint or template for other classes, known as its subclasses or derived classes.
* They cannot be instantiated directly, they exist solely to be inherited from by other classes.
* They can include both method declarations(Signatures) and method implementations. This flexibility allows you to have some default behaviour.
* Subclasses that inherit from an abstract class are required to implement the abstract methods declared in the base class.

Interfaces:

* They focus on defining a contract specifying a set of method signatures that a class must adhere to.
* They do not contain any method implementations; they solely declare the methods that implementing classes must provide.
* The primary purpose of interfaces is to establish a common set of behaviors that multiple, often unrelated, classes can adhere to.
* This promotes a high degree of flexibility and polymorphism in the codebase, as classes from different hierarchies can implement the same interface.

--------------------
<B> SOLID Principles </B>

Single Responsibility Principle (SRP):

* A class should have only one reason to change, meaning it should have a single responsibility or job.
* It is only a guideline for designing.
* Single Responsibility can be subjective and dependent on the specific context of application.
* Example - Order Validation can be either a single class's responsibility or there can be multiple classes to validate user inputs, generating error messages and checking permissions.

Open-Closed Principle (OCP):

* Software entities (classes, modules, functions) should be open for extension but closed for modification, allowing new functionality to be added without alterint existing code.
* Once code is written and tested, it shouldn't have to be modified to add new features.
* code should be extensible.
* Example - Logger has Info and Error levels, we should be able to add Debug Level seamlessly.

Liskov Substitution Principle (LCP):

* Subtypes (derived classes) should be substitutable for their base types (parent classes) without affecting the correctness of the program.
* Example - We should be able to replace employee with manager or intern seamlessly.

Interface Segregation Principle (ISP):

* Clients should not be forced to depend on interfaces they don't use.
* We should aim for smaller, more specific interfaces.
* Example - In Swiggy, a customer shouldn't be forced to implement KYC like Delivery Partner and Restaurant Owner.

Dependency Inversion Principle (DIP):

* High-level modules should not depend on low-level modules.
* Both should depend on abstractions.
* Abstractions should not depend on details; details should depend on abstractions.
* High-level order processing modules should depend on a abstract "PaymentGateway" interface, not on specific payment service implementations like Paypal or CredirCardProcessor.

-----------------------------
<B> Relationships Between Classes </B>

* Composition: A strong relationship where one class (the whole) contains another class (the part) and the part cannot exist without the whole.
* Aggregation: A weaker relationship than composition, where one class is associated with another, but the associated class can exist independently.
* Association (Unidirectional): A relationship where one class is aware of another, allowing it to interact, but the reverse is not necessarily true.
* Association (Bidirectional): A mutual relationship where both classes are aware of each other, enabling interaction in both directions.
* Inheritance: A relationship where a subclass inherits attributes and behvaiors from a superclass, facilitating code reuse and hierarchy.
* Implementation: When a class adheres to an interface or abstract class's contract, it must provide specific behaviors defined by that contract.
------------------------------
![image](https://github.com/user-attachments/assets/42c46ee0-38d0-4335-989b-ba83ff332154)

-------------------------------
<B> Simple Factory Design Pattern </B>

* Appropriate when you want to create objects without exposing their instantiation logic to clients.
* Useful when you have multiple classes that share a common interface or base class and need to create instances of these classes based on certain conditions.
* Has a central factory class with a static method for object creation.
* The client ocde interacts with this factory class to obtain instances of objects without direct knowledge of their concrete types.
Key Components:

   * Create (Factory) Class: Contains a static factory method for creating objects.
   * Concrete Products: Classes that implement a common interface or extend a common base class.

Problem Solved:

   * Centralized object creation logic, reducing code duplication.
   * Encapsulates object creation details, making the system more maintainable and flexible.
   * Provides a single entry point for creating objects.
 
-------------------------------
<B> Factory Method Design Pattern </B>

 * Appropriate when you want to delegate the responsibility of object creation to subclassses.
 * Useful when you have a family of related classes, and clients should work with these classes through a common interface.
 * Has an abstract creator class or interface declaring a factory method.
 * Subclasses of the creator class implement the factory method to create specific objects.

Key Components:

   * Creator (Factory) Class: Declares the factory method, which returns an object of a common interface or base class.
   * Concrete Creators: Subclasses that implement the factory method to create specific products (objects).
   * Products: Classes that implement a common interface or extend a common base class.
 
 Problem Solved:
 
   * Support extensibility by enabling the addition of new products (objects) without modifying existing code.
   * Promotes loose coupling by allowing clients to work with the creator's interface, abstracting concrete class details.

-------------------------------
<B> Abstract Factory Design Pattern </B>

* Appropriate when you need to create families of related or dependent objects without specifying their concrete classes.
* Useful for building complex systems with multiple interrelated objects.
* Has multiple abstract factory classes (one for each family of objects).
* Concrete factory classes implement these abstract factories to create families of related objects.

Key Components:

  * Abstract Factory: Declares factory methods for creating objects belonging to the family.
  * Concrete Factory: Implements the abstract factory, creating a family of related objects.
  * Products: Classes that implement a common interface or extend a common base class within a family.
 
 Problem Solved:
 
  * Addresses the challenge of creating complex systems with multiple interrelated objects.
  * Ensures that objects created by a factory are consistent and compatible with each other.
  * Promotes scalability by allowing the addition of new families of objects.

-------------------------------
<B> Builder Design Pattern </B>

Where it is used:

* Complex Object Creation: Building objects with many optional settings.
* Fluent Interface: Readable, chainable configuration code.
* Variability in Creation: Creating Variations of Objects.
* Document Generation: Constructing complex documents or reports.
* Configurable Components: Simplifying component configuration.

Key Components:

* Director: Responsible for orchestrating the construction process and delegates the construction steps to the builder.
* Builder: Abstract interface or base class for creating parts of the complext object.
* Concrete Builder: Implements the builder interface and provides specific implementations for constructing the parts and assembling the object.
* Product: Represents the complex object being constructed.

Advantages:

* Separation of Concerns: The Builder pattern separates the construction logic from the representation, promoting a clean separation of concerns.
* Complex Object Creation: It simplifies the creation of complex objects with many optional parameters by providing a step-by-step construciton process.

Disadvantages:

* Code Overhead: Introducing a builder can lead to additional code and complexity, especially for objects with only a few parameters.
* Complexity: For simple objects, using the Builder pattern can be overkill and make the code unnecessaruly complex.
* Increased Memory Usage: Builders can lead to increased memory usage, as they involve creating multiple objects during construction.

Example Use Cases:

* Building complex documents (e.g., HTML, PDF) with various formatting options.
* Constructing complex meals with various components (e.g., fast-food order).

-------------------------------
<B> Prototype Design Pattern </B>

Where it is Used:

* Object Copying: Creating objects by copying existing ones.
* Reducing Object Creation Overhead: Costly object initialization.
* Minimizing Subclassing: Avoiding a hierarchy of subclasses.
* Variations of Object Instances: Creating similar, but distinct, instances.
* Cloning Complex Structures: Deep copying of intricate objects.
* Prototype Registration: Managing a collection of prototypes.

Key Components:

* Prototype: An abstract interface or base class that declares a method for cloning itself.
* Concrete Prototpye: Implements the prototype interface and provides a method for cloning itself.
* Client: Initiates the cloning process by requesting the creation of new objects from prototypes.

Advantages:

* Reduced Object Creation Overhead: It eliminates the need to create objects from scratch, saving time and resources.
* Dynamic Object Creation: Allows for the creation of new object instances with varying configurations and data, making it suitable for scenarios where objects evolve.
* Simplifies Object Initialization: Objects can be created with a default state and customized as needed, simplifying the initializaiton process.

Disadvantages:

* Cloning Complexity: Cloning objects may be complex, especially when dealing with deep copies of objects with complex internal structures.
* Shallow Copy Limitations: By default, prototypes often perform shallow copies, which may not be suitable for objects with complex or shared internal state.

Example Use Cases:

* Creating copies of graphical objects in a drawing application.
* Generating copies of documents or reports with different data.
* Cloning configurations for software development.

-------------------------------
<B> Singleton Design Pattern </B>

Ensuring a class has only one instance and providing a global point of access to that instance.

Key Components:

* Private Constructor: Restricts direct object creation.
* Private Static Instance: Holds the unique instance.
* Public Statis Method(Getter): Provides access to the instance.

Advantages:

* Single Instances ensures that only one instance of the class exists throughput the application's lifetime.
* Global access provides a centralized point for accessing the instance, facilitating easy communication and resource sharing.

Disadvantages:

* Global State: can introduce global state, affecting testability.
* Limited Extensibility: Hard to subclass or mock for testing.
* Violates Single Responsibility Principle: Combines instance management with class logic.

Early/Eager and Late Initialization:

* Early/Eager Initialization: Involves creating the singleton instance at the time the class is loaded or during application startup. It ensures that the instance is always available but may consume resources even if not immediately needed.
* Late Initialization: In late initialization, the singleton instance is created when it is first requested. This conserves resources and is often used for scenarios where the creation of the instance is costly, and it's desirable to delay it until necessary/

Double-Checked Locking:

* Double-checked locking is a synchronization mechanism used in multi-threaded environments to improve the performance of lazy initialization of a singleton.
* It's needed to prevent the overhead of acquiring a lock every time a thread checks if the instance is initialized. With double-checked locking, a lock is acquired only when the instance is not already initialized, reducing contention among threads.

Exmaples:

* Logging: Centralized logging across the application.
* Database Connection Pool: Managing shared database connections.
* Caching: Maintaining a single cache instance.
* Configuration Management: Global application settings.
* Thread Pools: Managing a limited set of worker threads.
* Device Drivers: Ensuring one instance for hardware control.
* Resource Managers: Controlling access to resources like file systems.

-------------------------------
<B> Observer Design Pattern </B>

Establishing a one-to-many dependency between objects where one object (the subject) notifies multiple observers about its state changes.

Key Components:

* Subject (Observable): Maintains a list of observers, notifies them of state changes.
* Observer: Defines an update method to receive and respond to subject notifications.
* Concrete Observer: Implements the observer interface, responds to udpates from the subject.

Advantages:

* Loose Coupling: Promotes decoupling between subjects and observers, allowing changes in one without affecting the other.
* Dynamic Registration: Supports dynamic addition and removal of observers at runtime.
* Broadcast Notification: Facilitates broadcasting state changes to multiple interested parties.
* Event Handling: Commonly used for event handling systems and UI Components.

Disadvantages:

* Ordering Dependencies: The order in which observers are notified can be curcial in some cases.
* complexity: In complex systems, managing observers and notifications can become intricate.

Examples:

* Event Handling: GUI frameworks for responding to user actions.
* Stock Market Updates: Notify multiple subscribers of price changes.
* Whether Forecast: Disseminating weather updates to various whether apps.
* Chat Applications: Informing users about new message in group chats.
* Traffic Management: Real-time traffic updates to GPS navigation systems.
* Monitoring Systems: Alerting administrators to system health changes.

-------------------------------
<B> Command Design Pattern </B>

Decoupling the sender of a request from its receiver and allowing for parameterization of requests.

Key Components:

* Command: Encapsulates a request as an object, including the action to be performed and its parameters.
* Concrete Command: Implements the command interface, binding a specific action to a receiver.
* Invoker: Initiates the command execution without knowing its details.
* Receiver: Executes the action associated with the command.

Advantages:

* Decoupling: Separates sender and receiver, reducing dependencies.
* Flexibility: Allows for dynamic command composition and execution.
* Undo/Redo: supports undoing and redoing operatons by storing command history.
* Queueing: enables queuing, logging and scheduling of commands.

Disadvantages:

* Complexity: May introduce additional classes and indirection.
* Maintenance: Can lead to a large number of command classes for complext systems.

Examples:

* GUI Applications: Implementing undo/redo functionality and managing user actions.
* Remote Control Systems: Handling button presses for various devices.
* Queueing Systems: Building job queues for tasks with different parameters.
* Transaction Management: Managing database transactions as commands.

-------------------------------
<B> Chain of Responsibility Design Pattern </B>

Avoiding tight coupling between sender and receiver of a request and allowing multiple objects to handle a request.

Key Components:

* Handler: Defines an interface for handling requests and optionally passing them to the next handler.
* Concrete Handler: Implements the handler interface, handles requests, and may pass them to the next handler.
* Client: Initiates requests, unaware of the handler's hierarchy.

Advantages:

* Decoupling: Separates request senders from receivers, promoting loose coupling.
* Dynamic Handling: Allows dynamic addition, removeal or reordering of handlers.
* Responsibility Distribution: Divides responsibilities amoung multiple handlers.

Disadvantages:

* Unprocessed Requests: There's a risk that requests may go unhandled if there's no suitable handler in the chain.
* Complexity: Managing the chain hierarchy can introduce complexity.

Examples:

* Approval Workflows: Handling approcal requests through multiple stages.
* Exception Handling: Handling exceptions through a series of exception handlers.
* Security Filters: Authorizing and authentication requests in a web application.

-------------------------------
<B> Iterator Design Pattern </B>

Providing a uniform way to traverse collections without exposing their underlying structure or implementation.

Key Components:

* Iterator: Defines a common interface for iterating elements.
* Concrete Iterator: Implements the iterator interface for a specific collection.
* Aggregate: Defines an interface for creating an iterator.
* Concrete Aggregate: Implements the aggregate interface and provides an iteraor for its elements.

Advantages:

* Decoupling: Separates collection traversal from its internal structure.
* Uniform Interface: Provides a consistent way to access elements in various collections.
* Iteration Control: Allows iteration control (e.g., forward, backward) without changing collection code.

Disadvantages:

* Complexity: Introducing iterators can make the code more complex.
* Overhead: May Introduce overhead when creating iterator objects.
* Not Suitable for All Collections: May not be practical for small or simple collections.

Examples:

* File Systems: Iterating files and directories in a file system.
* Menu Systems: Iterating through menu items in user interfaces.
* Text Processing: Scanning words or characters in a text document.
* Playlist Management: Managing song playlists in music players.

-------------------------------





































