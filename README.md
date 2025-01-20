## Fundamental Concepts of OOP

* Classes: Classes are blueprints for creating objects. They define the structure and behavior of objects by specifying attributes(data) and methods(functions) that instances of the class will possess.
* Objects: Objects are instances of classes. They represent real-world entities and contain data(attributes) and methods(functions) that operate on that data.
* Encapuslation: Encapsulation is the concept of bundling data(attributes) and the methods(functons) that operate on that data into a single unit, called a class. It restricts direct access to an object's internal state and enforces access through defined methods, thus hiding implemnetation details.
* Abstraction: Abstraction is the process of simplifying complex reality by modeling class based on their essential properties and behaviors while ignoring non-essential details. It allows developers to focus on what an object does rather than how it does it.
* Inheritance: Inheritance allows a new class(subclass/derived class) to inheirt attributes and methods from an existing class(superclass/base class). It promtoes code reuse and establishes a hierarchical relationship between classes.
* Polymorphism:
  * Compile-Time Polymorphism: Also known as method overloading, It involves defining multiple methods with the same name in a class, but with different parameters or types. The correct methid is determined at compile time based on method signature.
  * Runtime Polumorphism: Also known as method overriding, it occurs when a subclass provides a specific implementation for a method that is already defined in its superclass. The method to execute is determined at runtime based on the objects actual class.
 
------------

## Abstract Classes and Interfaces

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
## SOLID Principles

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
## Relationships Between Classes

* Composition: A strong relationship where one class (the whole) contains another class (the part) and the part cannot exist without the whole.
* Aggregation: A weaker relationship than composition, where one class is associated with another, but the associated class can exist independently.
* Association (Unidirectional): A relationship where one class is aware of another, allowing it to interact, but the reverse is not necessarily true.
* Association (Bidirectional): A mutual relationship where both classes are aware of each other, enabling interaction in both directions.
* Inheritance: A relationship where a subclass inherits attributes and behvaiors from a superclass, facilitating code reuse and hierarchy.
* Implementation: When a class adheres to an interface or abstract class's contract, it must provide specific behaviors defined by that contract.
------------------------------
![image](https://github.com/user-attachments/assets/42c46ee0-38d0-4335-989b-ba83ff332154)

-------------------------------
## Simple Factory Design Pattern

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

 ![image](https://github.com/user-attachments/assets/62183ff6-d79a-4843-b9bd-646eb95dff95)

-------------------------------
## Factory Method Design Pattern

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

![image](https://github.com/user-attachments/assets/a4a5b1b4-74c8-4c27-aaee-a3212f29b5dd)


-------------------------------
## Abstract Factory Design Pattern

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

![image](https://github.com/user-attachments/assets/d860fe09-cd5d-4126-be89-8c201a3478d8)


-------------------------------
## Builder Design Pattern

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
## Prototype Design Pattern

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
## Singleton Design Pattern

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
## Observer Design Pattern

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
## Command Design Pattern

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
## Chain of Responsibility Design Pattern

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
## Iterator Design Pattern

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
## Strategy Design Pattern

Defining a family of algorithms, encapsulating them, and making them interchangeable without altering client code. It's particularly useful in scenarios where you need to switch between multiple algorithms dynamically or add new ones without changing client code.

Key Components:

* Strategy: Declares an interface or abstract class for a family of algorithms.
* Concrete Strategies: Implement the strategy interface with specific algorithm variations.
* Context: Maintains a reference to a strategy and delegates tasks to it.

Advantages:

* Flexibility: Allows dynamoc selection of algorithms at runtime.
* Decoupling: Separates algorithm details from the cloent, promoting low coupling.
* Extensibility: Easily add new algorithms without modifying existing code.
* Testability: Simplifies unit testing by replacing strategies with mocks or stubs.

Disadvantages:

* Complexity: May introduce additional classes and indirection.
* Client Responsibility: Clients need to choose and set the appropriate strategy.
* Potential Overhead: Dynamic strategy selection can have some performance overhead.

Use Cases:

* Sorting Algorithms: Dynamic selection of sorting algorithms (e.g., quicksort, mergesort).
* Data Compression: Compressing data using various algorithms (e.g., gzip, zlib)
* Routing Algorithms: Selecting optimal routes for navigation.
* Text Editors: Implementing spell checking and autocorrent with different algorithms.
* Gaming: AI decision-making strategies for game characters.
* Image Processing: Applying filters or transformations using various algorithms.

-------------------------------
## Template Design Pattern

Defining the skeleton of an algorithm, allowing certain steps to be implemented by subclasses while maintaining the overall structure.

Key Components:

* Abstract Template: Declares the structure of the algorithm with place holder methods.
* Concrete Templates: Implement specific versions of the algorithm by filling in the placeholder methods.

Advantages:

* Code Reuse: Promotes reuse of common algorithms structure among multiple subclasses.
* Consistency: Enforces a consistent algorithm structure across subclasses.
* Extensibility: Allows for the customization of specific algorithm steps.
* Reduced Duplication: Minimizes duplicated code in similar algorithms.

Disadvantages:

* Complexity: Can introduce complexity when there are many optional stpes or hook methods.

Use Cases:

* Report Generation: Creating report templates with variable sections or data sources.
* Web Page Generation: Defining a common structure for web page rendering with customizable content.
* Database Access: Execting database queries with consistent connection management.
* Test Automation: Implementing test scripts with standardized setup and teardown steps.

-------------------------------
## Adapter Design Pattern
Bridging the incompatibility between two interfaces or classes, allowing them to work together.  
The Adapter pattern resolves the problem of interface or class incompatibility, enabling collaboration between  
components with differing interfaces. It is useful in scenarios where you need to integrate existing code or  
third-party libraries into your system without modifying their interfaces.  

Key Components:  

● Target Interface: Defines the interface expected by the client.  
● Adaptee: Represents the existing class or interface that needs adaptation.  
● Adapter: Implements the target interface, delegates requests to the adaptee, and acts as a bridge.  

Advantages:

● Compatibility: Enables collaboration between incompatible interfaces or classes.  
● Reuse: Reuses existing classes without modifying their code.  
● Encapsulation: Isolates the adaptational logic in the adapter class.  
● Flexibility: Supports adding multiple adapters for different interfaces.  

Disadvantages:  

● Complexity: Introducing adapters can increase code complexity.  
● Runtime Overhead: May introduce a slight performance overhead due to delegation.  

Use Cases:  

● Legacy Code Integration: Making legacy components compatible with modern systems.  
● Library Compatibility: Adapting third-party libraries to fit your application's interfaces.  
● API Versioning: Maintaining backward compatibility while upgrading APIs.  
● Language Translation: Converting data or messages between languages or formats.  
● User Interface Elements: Adapting user interface components for different platforms.  

-------------------------------
## Decorator Design Pattern
Adding behavior or responsibilities to objects dynamically without altering their code.  

Key Components:  

● Component: Defines the interface for objects that can be decorated.  
● Concrete Component: Implements the component interface, the base object being decorated.  
● Decorator: Maintains a reference to a component and implements the component interface.  
● Concrete Decorators: Extend the decorator class, adding or modifying behavior.  

Advantages:  

● Composition over Inheritance: Provides a flexible alternative to subclassing.  
● Dynamic Behavior: Allows adding or changing behavior at runtime.  

Disadvantages:  

● Complexity: Introducing multiple decorators can make the system more complex.  

Use Cases:

● Text Formatting: Adding styles (bold, italic) to text in a word processor.  
● Graphic Objects: Enhancing graphics with borders, shadows, or transparency.  
● Coffee Ordering: Customizing coffee with condiments (e.g., milk, sugar).  

-------------------------------
## Bridge Design Pattern

Separating an object's abstraction from its implementation, allowing both to evolve independently.  

Key Components:

● Abstraction: Defines the abstraction's interface and maintains a reference to the implementation.  
● Refined Abstraction: Extends the abstraction, adding more functionality.  
● Implementation: Declares the interface for the implementation and provides concrete implementations.  
● Concrete Implementation: Implements the implementation interface with specific functionality.  

Advantages:  

● Decoupling: Separates abstraction and implementation, reducing their interdependence.  
● Flexibility: Allows independent changes to abstraction and implementation.  
● Extensibility: Provides a mechanism for adding new abstractions and implementations.  
● Real-world Modeling: Suitable for modeling real-world entities with multiple dimensions.  

Disadvantages:  

● Complexity: Introducing the bridge pattern can increase the number of classes and complexity.  
● Design Overhead: Overuse of the pattern can lead to excessive class hierarchies.  

Use Cases:  

● Device Abstraction: Separating devices (TV, radio) from their remote control interfaces.  
● Database Drivers: Providing different database drivers for various database systems.  
● Drawing Tools: Separating drawing tools from their rendering engines.  
● Notification Systems: Implementing notifications with different transport mechanisms.  
● Web Development: Separating web page rendering from backend processing in web applications.  


-------------------------------

## Composite Design Pattern  

Composing objects into tree structures to represent part-whole hierarchies and treating individual objects and compositions uniformly.  

Key Components:  

● Component: Declares the interface for all objects in the composition, including leaf and composite objects.  
● Leaf: Represents individual objects that have no further composition.  
● Composite: Contains leaf and composite objects, implementing operations for both.  

Advantages:  

● Flexible Structure: Allows clients to work with individual objects and compositions interchangeably.  
● Recursive Composition: Supports nesting of objects to form complex structures.  
● Uniform Interface: Provides a consistent interface for all elements in the hierarchy.  
● Simplifies Client Code: Clients treat objects uniformly, regardless of whether they are leaf or composite.  

Disadvantages:  

● Complexity: Introducing the composite pattern may add complexity to the system.  
● Performance Overhead: Recursive traversal of composite structures may introduce some performance overhead.  

Use Cases:  

● Graphics and Shapes: Building complex graphics from simple shapes.  
● File Systems: Representing files and directories in a hierarchical structure.  
● Organization Hierarchies: Modeling organizational structures with departments and employees.  
● Menus and GUIs: Creating menu systems with nested menus and menu items.  
● Document Editors: Managing documents with paragraphs, sections, and headings.  
● Parts Assemblies: Designing products composed of smaller components.  

-------------------------------

## Facade Design Pattern  

Providing a simplified, high-level interface to a complex subsystem, shielding clients from its intricacies.  

Key Components:  

● Facade: Represents the simplified interface to the subsystem, managing client requests.  
● Subsystem: Consists of various components and classes with complex interactions.  

Advantages:  

● Simplified Interface: Offers a straightforward, high-level interface to a complex system.  
● Decouples Clients: Shields clients from subsystem changes, promoting loose coupling.  
● Code Organization: Enhances code structure by encapsulating subsystem complexity.  
● Promotes Best Practices: Facilitates adherence to best practices and design principles.  

Disadvantages:  

● Limited Customization: May not allow fine-grained control for advanced users.  
● Potential Bloat: Overuse can lead to a bloated facade with too many methods.  
● Complex Subsystems: Not suitable for simple subsystems without much complexity.  

Use Cases:  

● API Libraries: Simplifying the use of complex APIs or libraries.  
● Operating Systems: Providing a user-friendly interface to system functions.  
● Software Frameworks: Abstracting complex frameworks for easier use.  
● Payment Processing: Simplifying payment gateway integrations for e-commerce.  
● Authentication Systems: Managing user authentication and authorization.  
● Computer Boot Process: Abstracting the startup process for end-users.  

-------------------------------

## Proxy Design Pattern

Controlling access to an object or adding additional functionality to it without modifying its code.  
It is valuable in scenarios where you want to enhance security, improve performance, or add monitoring to object interactions.  

Key Components:  

● Subject: Defines the common interface for both real and proxy objects.  
● Real Subject: Represents the real object being proxied.  
● Proxy: Implements the same interface as the real subject, controlling access and providing additional functionality.  

Advantages:  

● Reduced Coupling: Proxies contribute to lower coupling between clients and real objects, making it easier to swap out or upgrade components without affecting the client code.  
● Performance Optimization: Proxies can optimize performance by implementing caching, reducing redundant calculations or data retrieval, and enhancing system responsiveness.  
● Resource Management: Proxies can help manage resource allocation and deallocation efficiently. For example, in a virtual proxy, the real object's creation can be delayed until it's genuinely needed, conserving resources.  

Disadvantages:  

● Complexity: Introducing proxies can add complexity to the system.  
● Performance Overhead: Proxy operations can introduce some performance overhead.  
● Potential for Overuse: Overusing proxies can lead to a bloated and less maintainable design.  

Types of Proxies:  

● Virtual Proxy: Represents an expensive-to-create real object, creating it only when necessary. Useful for large or resource-intensive objects.  
● Protection Proxy: Controls access to sensitive resources by adding authentication, authorization, or other security checks.  
● Remote Proxy: Acts as a local representation for an object in a different address space, facilitating remote communication between systems or processes.  
● Smart Proxy: Adds additional functionality to the real object, such as reference counting, lazy loading, or caching, without the client's knowledge.  

Use Cases:  
● Remote Services: Accessing remote services or APIs through proxies (e.g., REST APIs).  
● Lazy Loading: Loading and initializing heavy objects on-demand.  
● Access Control: Implementing access control for sensitive resources.  
● Caching: Implementing caching mechanisms to optimize resource retrieval.  
● Logging and Monitoring: Logging method calls, measuring performance, or adding security checks.  

-------------------------------



























