# Design Pattern Exercises Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [x]`) syntax for tracking.

**Goal:** Organize 17 design pattern examples from practical blocks 1–3 into three runnable exercise POCs, each with its original assignment PDFs.

**Architecture:** Keep each exercise under `exercises.exerciseN.patterns.<pattern>` and place its original assignment PDF beside the Java sources. Each exercise has one entry point (`Exercise1PoC`, `Exercise2PoC`, `Exercise3PoC`) that runs each package's demonstration.

**Tech Stack:** Java 21, IntelliJ IDEA plain Java module with `src` as source root; no Maven or Gradle.

**Spec:** `docs/superpowers/specs/2026-09-25-lesson1-exercise-structure-design.md`

## Global Constraints

- Keep the existing plain IntelliJ source-root setup; do not add Maven or Gradle.
- Use Java 21-compatible language features.
- Keep each pattern's Java code and original assignment PDF in its own pattern package directory.
- Keep all five existing pattern examples runnable from one exercise entry point.
- Include the six assignments from `Blok 2_cv` as exercise 2 and the six assignments from `Blok 3_cv` as exercise 3.
- Use only Java standard library APIs; the project has no external dependencies or build tool.

## Review Focus

- Stale imports or package declarations after moving files; compile the complete source tree after migration.
- A missing or mismatched assignment PDF; compare each copied PDF byte-for-byte with its source and check all five destinations.
- Missing or reordered pattern demonstrations in the exercise runner; inspect its output after running it.
- Builder and Singleton demonstrations lost during runner replacement; preserve their current displayed configuration fields.
- Prototype's related types split across packages; move all four types together and retain their shared package access.
- A POC section omitted or repeated; each of exercises 2 and 3 must call each of its six demo methods exactly once.
- Adapter adds an undeclared dependency; the example must compile with the Java standard library only.
- Proxy demo delays make the POC impractically slow; verify cache behavior without multi-second sleeps.

---

### Task 1: Move Builder and Singleton into Exercise 1

**Files:**
- Move: `src/patterns/builder/Configuration.java` to `src/exercises/exercise1/patterns/builder/Configuration.java`
- Move: `src/patterns/singleton/ConfigurationManager.java` to `src/exercises/exercise1/patterns/singleton/ConfigurationManager.java`
- Copy: `../../Builder_zadání.pdf` to `src/exercises/exercise1/patterns/builder/Builder_zadání.pdf`
- Copy: `../../Singleton_zadání.pdf` to `src/exercises/exercise1/patterns/singleton/Singleton_zadání.pdf`

**Interfaces:**
- Consumes: Existing `Configuration` builder methods and `ConfigurationManager.getInstance().getConfiguration()`.
- Produces: Those same public APIs under `exercises.exercise1.patterns.builder` and `exercises.exercise1.patterns.singleton`.

- [x] Move each Java file and update its package declaration.
- [x] Update `ConfigurationManager` to import `exercises.exercise1.patterns.builder.Configuration`.
- [x] Copy the two specified PDFs beside their respective Java files without altering their bytes.
- [x] Search `src` for imports of the old Builder and Singleton packages and update each match.

### Task 2: Move Abstract Factory and Factory Method into Exercise 1

**Files:**
- Move: `src/patterns/abstractfactory/AbstractFactoryDemo.java` to `src/exercises/exercise1/patterns/abstractfactory/AbstractFactoryDemo.java`
- Move: `src/patterns/factorymethod/FactoryMethodDemo.java` to `src/exercises/exercise1/patterns/factorymethod/FactoryMethodDemo.java`
- Copy: `../../AbstarctFactory_zadání.pdf` to `src/exercises/exercise1/patterns/abstractfactory/AbstarctFactory_zadání.pdf`
- Copy: `../../Factorymethod_zadani.pdf` to `src/exercises/exercise1/patterns/factorymethod/Factorymethod_zadani.pdf`

**Interfaces:**
- Consumes: Existing static `run()` entry points.
- Produces: `exercises.exercise1.patterns.abstractfactory.AbstractFactoryDemo.run()` and `exercises.exercise1.patterns.factorymethod.FactoryMethodDemo.run()`.

- [x] Move both Java files and change their package declarations to the matching `exercises.exercise1.patterns` subpackages.
- [x] Copy the specified original PDFs byte-for-byte beside the matching Java source.
- [x] Search `src` for old Abstract Factory and Factory Method package references and update each match.

### Task 3: Move Prototype into Exercise 1

**Files:**
- Move: `src/patterns/prototype/Car.java` to `src/exercises/exercise1/patterns/prototype/Car.java`
- Move: `src/patterns/prototype/CarRegistry.java` to `src/exercises/exercise1/patterns/prototype/CarRegistry.java`
- Move: `src/patterns/prototype/Prototype.java` to `src/exercises/exercise1/patterns/prototype/Prototype.java`
- Move: `src/patterns/prototype/PrototypeDemo.java` to `src/exercises/exercise1/patterns/prototype/PrototypeDemo.java`
- Copy: `../../Prototype.pdf` to `src/exercises/exercise1/patterns/prototype/Prototype.pdf`

**Interfaces:**
- Consumes: Existing `PrototypeDemo.run()` and package-local Prototype example types.
- Produces: `exercises.exercise1.patterns.prototype.PrototypeDemo.run()` and its three supporting types in the same package.

- [x] Move all four Java files together and change their package declarations.
- [x] Copy `Prototype.pdf` byte-for-byte beside the Java files.
- [x] Search `src` for old Prototype package references and update each match.

### Task 4: Add the Exercise 1 POC entry point

**Files:**
- Create: `src/exercises/exercise1/Exercise1PoC.java`
- Modify or remove: `src/PoCRunner.java`

**Interfaces:**
- Consumes: The Builder, Singleton, Abstract Factory, Factory Method, and Prototype APIs from Tasks 1–3.
- Produces: Public entry point `exercises.exercise1.Exercise1PoC.main(String[] args)`.

- [x] Create `Exercise1PoC` with `main(String[] args)` and sections for Builder, Singleton, Abstract Factory, Factory Method, and Prototype in that order.
- [x] Preserve the current Builder/Singleton output for user name, language, and dark mode.
- [x] Invoke each existing demo's `run()` method exactly once.
- [x] Remove `PoCRunner.java` after its responsibilities have moved, so only the exercise entry point remains.

### Task 5: Check the migrated exercise

**Files:**
- Check: all Java files under `src/exercises/exercise1`
- Check: all five PDFs under `src/exercises/exercise1/patterns`

**Interfaces:**
- Consumes: Complete source tree and copied assignment files from Tasks 1–4.
- Produces: A compiling project and a POC run that displays each pattern section.

- [x] From the project root, compile the source tree with `javac -d /tmp/lesson1-classes $(find src -name '*.java')`; expect exit code 0.
- [x] Run `java -cp /tmp/lesson1-classes exercises.exercise1.Exercise1PoC`; confirm all five sections appear and the configuration output is retained.
- [x] Compare each destination PDF with the named source PDF using `cmp`; expect no differences.
- [x] Confirm no Java files or imports remain under the old `patterns.*` packages.

### Task 6: Add exercise 2 patterns from Block 2

**Files:**
- Create: `src/exercises/exercise2/Exercise2PoC.java`
- Create one `*Demo.java` in each of `patterns/adapter`, `patterns/bridge`, `patterns/composite`, `patterns/decorator`, `patterns/facade`, and `patterns/flyweight`.
- Copy: `Blok 2_cv/Adapter_zadani/Adapter.pdf` beside Adapter sources; copy `Blok 2_cv/Bridge.pdf`, `Composite.pdf`, `Decorator.pdf`, `Facade.pdf`, and `Flyweight.pdf` beside their matching sources.

**Interfaces:**
- Produces: Public entry point `exercises.exercise2.Exercise2PoC.main(String[] args)` and one public static `run()` per pattern demo.
- Pattern internals stay in their package; use nested private types inside each small demo to keep the example focused.

- [x] Write a temporary smoke source importing `Exercise2PoC`, compile it against `src`, and confirm compilation fails because the entry point is absent.
- [x] Implement `AdapterDemo` with an XML service, a JSON service interface, and an adapter that converts a small XML record using only JDK XML APIs and string output.
- [x] Implement `BridgeDemo` with `MediaPlayer`, MP3/MP4 players, abstract `Media`, and `Music`/`Video`; demonstrate at least two crossed combinations and stopping playback.
- [x] Implement `CompositeDemo` with `EmployeeComponent`, `Employee`, and recursive `Department`; print a nested organization and its summed salary.
- [x] Implement `DecoratorDemo` with `Message`, `SimpleMessage`, a delegating decorator, and encryption, whitespace compression, and word-count decorators; print a base message and composed variants.
- [x] Implement `FacadeDemo` with Light, DVD player, Projector, SoundSystem, and HomeTheaterFacade; show movie startup and shutdown only through the facade.
- [x] Implement `FlyweightDemo` with shared `TreeType`, positioned `Tree`, factory cache, and forest; show two trees of the same type share one TreeType.
- [x] Implement `Exercise2PoC` to call the six demo `run()` methods exactly once in pattern order.
- [x] Copy all six PDFs byte-for-byte from the specified source paths beside their corresponding demo classes.
- [x] Compile every source with `javac --release 21 -d /tmp/lesson1-exercise2-classes $(find src -name '*.java')`, then run `java -cp /tmp/lesson1-exercise2-classes exercises.exercise2.Exercise2PoC`; expect exit code 0 and six sections.

### Task 7: Add exercise 3 patterns from Block 3

**Files:**
- Create: `src/exercises/exercise3/Exercise3PoC.java`
- Create one `*Demo.java` in each of `patterns/chainofresponsibility`, `patterns/command`, `patterns/interpreter`, `patterns/iterator`, `patterns/mediator`, and `patterns/proxy`.
- Copy: `Blok 3_cv/Chain of Responsibility.pdf`, `Command.pdf`, `Interpreter2.pdf`, `Iterator.pdf`, `Mediator.pdf`, and `Proxy.pdf` beside their matching sources.

**Interfaces:**
- Produces: Public entry point `exercises.exercise3.Exercise3PoC.main(String[] args)` and one public static `run()` per pattern demo.
- Pattern internals stay in their package; use nested private types inside each small demo to keep the example focused.

- [x] Write a temporary smoke source importing `Exercise3PoC`, compile it against `src`, and confirm compilation fails because the entry point is absent.
- [x] Implement Chain of Responsibility with support request type/priority/message, linked handlers for technical and billing requests, and a general fallback; demonstrate all three paths.
- [x] Implement Command with a text editor, write/delete commands, and an invoker stack; demonstrate execute and undo for both command types.
- [x] Implement Interpreter with number, addition, and subtraction expression types; evaluate `5 + 3 - 2` to `6`.
- [x] Implement Iterator with a song collection and genre-filtered iterator; print songs grouped by Rock, Pop, and Jazz.
- [x] Implement Mediator with a chat mediator, users, and broadcast excluding the sender; send a message between two users.
- [x] Implement Proxy with a user service, real service, cache proxy, and `clearCache`; use a call counter instead of a two-second sleep and show miss, hit, clear, and reload.
- [x] Implement `Exercise3PoC` to call the six demo `run()` methods exactly once in pattern order.
- [x] Copy all six PDFs byte-for-byte from the specified source paths beside their corresponding demo classes.
- [x] Compile every source with `javac --release 21 -d /tmp/lesson1-exercise3-classes $(find src -name '*.java')`, then run `java -cp /tmp/lesson1-exercise3-classes exercises.exercise3.Exercise3PoC`; expect exit code 0 and six sections.

### Task 8: Validate all exercise POCs and assignment PDFs

**Files:**
- Check: all Java sources under `src/exercises/exercise1`, `exercise2`, and `exercise3`.
- Check: all 17 PDFs under the pattern package directories.

**Interfaces:**
- Consumes: all three exercise entry points and copied assignments.
- Produces: all 17 demos compile under Java 21 and all three POCs run successfully.

- [x] Compile the complete source tree using `javac --release 21 -d /tmp/lesson1-all-classes $(find src -name '*.java')`.
- [x] Run `Exercise1PoC`, `Exercise2PoC`, and `Exercise3PoC`; confirm their sections total 5, 6, and 6 respectively.
- [x] Compare all 17 copied PDFs byte-for-byte with their source assignment PDFs.
- [x] Confirm no stale `package patterns.*`, no obsolete `PoCRunner`, and no external dependency imports remain.
