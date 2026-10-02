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

## Podmínky předmětu

**Docházka** na cvičení není povinná, ale zapisuji ji.

**Odevzdávané příklady.** Z každého cvičení odevzdáte 2 příklady návrhových vzorů. Z těch, které jsme na cvičení probírali, si vyberete libovolné dva (z 1. cvičení například Singleton a Prototype) a každý z nich zpracujete jako vlastní příklad v Javě. Příklad musí být spustitelný projekt, který jde otevřít a spustit v IDE (např. IntelliJ IDEA). Pošlete ho mi e-mailem na adresu [jakub.obornik+knav@gmail.com](mailto:jakub.obornik+knav@gmail.com) nejpozději do příštího cvičení. Předmět e-mailu zapište ve tvaru „KNAV – cvičení 1 – Jméno Příjmení“. Za celý semestr tak odevzdáte 8 příkladů (2 × 4 cvičení). Kdo píše test na 4. (posledním) cvičení, vypracuje i 2 vzory ze 4. cvičení buď před ním, nebo přímo na tomto cvičení.

**Zkouška** je písemný test v papírové podobě. Dostanete ho vytištěný a odpovídáte ručně na papír, včetně nakreslení diagramů tříd. Test má zhruba 12 otázek, na vypracování máte 60 minut a na úspěch stačí 50 %. Podrobnosti jsou v úvodní prezentaci ([`slides/00-uvod.pdf`](slides/00-uvod.pdf)).

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
