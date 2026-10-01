# Course exercise and pattern structure

## Goal

Organize the course pattern examples as runnable exercise POCs. Keep each pattern's Java code and original assignment PDF together so the exercises can be run and studied independently.

## Scope

The project covers the five patterns in exercise 1 and their matching assignments in `Blok 1_cv`:

- Factory Method (`Factorymethod_zadani.pdf`)
- Abstract Factory (`AbstarctFactory_zadaní.pdf`)
- Prototype (`Prototype.pdf`)
- Builder (`Builder_zadaní.pdf`)
- Singleton (`Singleton_zadaní.pdf`)

Exercise 2 covers the six assignments in `Blok 2_cv`: Adapter, Bridge, Composite, Decorator, Facade, and Flyweight. Exercise 3 covers the six assignments in `Blok 3_cv`: Chain of Responsibility, Command, Interpreter, Iterator, Mediator, and Proxy. The similarly named Builder and Singleton PDFs in `Blok 1_cv/cv3` are duplicate material and are not used. Exercise 4 covers the six lecture PDFs in `Blok 4` (no `_cv` assignment folder exists, so demos follow each lecture's own example): Memento, Observer, State, Strategy, Template Method, and Visitor.

## Structure

Keep Java packages under `exercises.exerciseN.patterns`, with one subpackage per pattern. Put each source PDF beside its pattern's Java files in that package directory. Give each exercise its own runnable entry point: `Exercise1PoC`, `Exercise2PoC`, or `Exercise3PoC`. Each entry point invokes its block's demonstrations in a readable sequence. Keep pattern-specific demo logic within its own package. Exercise 1 uses the existing `src/exercises/exercise1` structure and remains the first entry point.

The project currently uses a plain IntelliJ Java source root and has no Maven or Gradle build. Preserve that setup and Java 21-compatible language features.

## Behavior

Running an exercise's POC demonstrates every pattern assigned to that exercise. Exercise 1 demonstrates five patterns; exercises 2 and 3 demonstrate six each. The exercise 1 examples retain their teaching intent and visible output. PDFs are stored as project files beside the corresponding source package; they are not loaded at runtime.

## Validation

Compile all Java files from the configured `src` source root and run all three exercise entry points. Confirm all 17 pattern sections appear in output and that all 17 assignment PDFs exist beside their respective pattern sources and match the originals byte-for-byte.

## Assumptions

Exercise numbering follows the practical assignment block folders: `Blok 1_cv` is exercise 1, `Blok 2_cv` is exercise 2, and `Blok 3_cv` is exercise 3. The project remains a plain IntelliJ Java module with no external dependencies or build tool. Block 4 is exercise 4, based on lecture PDFs.
