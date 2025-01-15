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
* Key Components:
    * Create (Factory) Class: Contains a static factory method for creating objects.
    * Concrete Products: Classes that implement a common interface or extend a common base class.
* Problem Solved:
    * Centralized object creation logic, reducing code duplication.
    * Encapsulates object creation details, making the system more maintainable and flexible.
    * Provides a single entry point for creating objects.
 
-------------------------------
<B> Factory Method Design Pattern </B>

 * Appropriate when you want to delegate the responsibility of object creation to subclassses.
 * Useful when you have a family of related classes, and clients should work with these classes through a common interface.
 * Has an abstract creator class or interface declaring a factory method.
 * Subclasses of the creator class implement the factory method to create specific objects.
 * Key Components:
   * Creator (Factory) Class: Declares the factory method, which returns an object of a common interface or base class.
   * Concrete Creators: Subclasses that implement the factory method to create specific products (objects).
   * Products: Classes that implement a common interface or extend a common base class.
* Problem Solved:
   * Support extensibility by enabling the addition of new products (objects) without modifying existing code.
   * Promotes loose coupling by allowing clients to work with the creator's interface, abstracting concrete class details.

-------------------------------
<B> Abstract Factory Design Pattern </B>

* Appropriate when you need to create families of related or dependent objects without specifying their concrete classes.
* Useful for building complex systems with multiple interrelated objects.
* Has multiple abstract factory classes (one for each family of objects).
* Concrete factory classes implement these abstract factories to create families of related objects.
* Key Components:
  * Abstract Factory: Declares factory methods for creating objects belonging to the family.
  * Concrete Factory: Implements the abstract factory, creating a family of related objects.
  * Products: Classes that implement a common interface or extend a common base class within a family.
* Problem Solved:
  * Addresses the challenge of creating complex systems with multiple interrelated objects.
  * Ensures that objects created by a factory are consistent and compatible with each other.
  * Promotes scalability by allowing the addition of new families of objects.

-------------------------------
<B> Builder Design Pattern </B>

















