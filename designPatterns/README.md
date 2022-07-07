# Design Patterns

## Creational Patterns

### Singleton

- Simple Singleton Pattern

- Thread Safe

  - synchronized method
  - eager initialization (static final)
  - double-checked locking (synchronized block)
  - static inner class
- Break Singleton

  - Reflection
  - Serializable
- Detect Singleton

  - Enum
  - Detect Reflection

- Real Example

  - java.lang.Runtime
  - Spring Bean