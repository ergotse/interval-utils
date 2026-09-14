# interval-utils

## Objective
`interval-utils` compresses a collection of discrete, orderable values into the smallest set of contiguous ranges. Given the years `2024, 2021, 2020, 2018, 2016, 2017`, it produces the intervals `2016-2018`, `2020-2021`, `2024`.

It works with any type that implements the `Sequentiable<T>` interface, not just numbers - built-in support is provided for `Integer`, `Long`, `java.time.Year`, and `java.time.LocalDate`.

## Installation
To include `interval-utils` in your project, add the following Maven dependency:

```xml
<dependency>
    <groupId>se.ergot</groupId>
    <artifactId>interval-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

Requires Java 18 or later.

## Usage

### Interval
An `Interval` holds an ordered pair - its start and end - and is created with `Interval.of(...)`, which always orders the two values regardless of the order they're passed in.

```java
final Interval<SequentiableInteger> interval = Interval.of(SequentiableInteger.of(1), SequentiableInteger.of(20));
final Integer start = interval.getStart().getValue();
final Integer end = interval.getEnd().getValue();
System.out.println(interval);  // 1-20
```

### IntervalCollection
`IntervalCollection` takes any collection of `Sequentiable` values, deduplicates and sorts them, and compresses consecutive runs into intervals via `getIntervals()`.

```java
final IntervalCollection<SequentiableInteger, Integer> collection = IntervalCollection.of(Set.of(
        SequentiableInteger.of(2024),
        SequentiableInteger.of(2021),
        SequentiableInteger.of(2020),
        SequentiableInteger.of(2018),
        SequentiableInteger.of(2016),
        SequentiableInteger.of(2017)
));

final List<Interval<SequentiableInteger>> intervals = collection.getIntervals();
System.out.println(String.join(", ", intervals.stream().map(Interval::toString).toList())); // 2016-2018, 2020-2021, 2024
```

## Sequentiable types
Any value that can be ordered and stepped through can be used, by implementing `Sequentiable<T>`:

- `getValue()` / `getNext()` / `getPrevious()` - the current value and its neighbors
- `getDistance(T other)` - how far apart two values are
- `compareTo(Sequentiable<T> o)` - ordering, consistent with `equals()`

Built-in implementations:

| Type               | Wraps          |
|--------------------|----------------|
| `SequentiableInteger`   | `Integer`          |
| `SequentiableLong`      | `Long`             |
| `SequentiableYear`      | `java.time.Year`   |
| `SequentiableLocalDate` | `java.time.LocalDate` |

Each is created via a static `of(...)` factory, e.g. `SequentiableInteger.of(5)`. To support another type (e.g. `YearMonth`), implement `Sequentiable<YearMonth>` following the same pattern.

## License
Licensed under the [Apache License, Version 2.0](LICENSE).
