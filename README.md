# KNAV – Pokročilé techniky programování a návrhové vzory

Ukázky a cvičení k předmětu **KNAV** (Univerzita Pardubice, KST, studijní program Webové technologie). Projekt obsahuje Java implementace GoF návrhových vzorů, které procházíme na cvičeních.

## Přehled cvičení

| Cvičení | Vzory |
|---|---|
| 1 | Factory Method, Abstract Factory, Prototype, Builder, Singleton |
| 2 | Adapter, Bridge, Composite, Decorator, Facade, Flyweight |
| 3 | Chain of Responsibility, Command, Interpreter, Iterator, Mediator, Proxy |
| 4 | Memento, Observer, State, Strategy, Template Method, Visitor |

Celkem 23 vzorů. Na každém cvičení nejdřív krátce probereme, k čemu vzory jsou, a pak se společně díváme do kódu.

## Struktura

```
src/exercises/
├─ exercise1/
│  ├─ Exercise1PoC.java        # spustí všechny ukázky cvičení
│  └─ patterns/<vzor>/         # kód vzoru + PDF se zadáním
├─ exercise2/ …
├─ exercise3/ …
└─ exercise4/ …
slides/                        # prezentace ke cvičením (PDF)
docs/                          # poznámky k projektu
```

## Jak spustit

Potřebujete **JDK 21** a libovolné IDE (doporučeno IntelliJ IDEA). Projekt nepoužívá Maven ani Gradle, žádné závislosti.

1. Otevřete složku projektu v IntelliJ IDEA.
2. Nastavte `src` jako Sources Root, pokud to IDE neudělalo samo.
3. Spusťte `Exercise1PoC` (případně `Exercise2PoC` a další) přes *Run*.

## Prezentace

Prezentace ke cvičením najdete ve složce [`slides/`](slides/README.md).

## Kontakt

jakub.obornik+knav@gmail.com
