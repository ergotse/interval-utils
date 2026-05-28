# interval-utils

## Objective
`interval-utils` is a utility library for handling intervals in Java. It provides a structured way to manage and manipulate intervals, making it useful for scenarios that require range calculations, interval collections, and sequence-based operations.

## Requirements
- Java 21+
- Maven 3.8+

## Installation
Add the following Maven dependency to your project:

```xml
<dependency>
    <groupId>se.ergot</groupId>
    <artifactId>interval-utils</artifactId>
    <version>1.0.1</version>
</dependency>
```

## Usage

### Creating an Interval
```java
final Interval<SequentiableInteger> interval = new Interval<>(SequentiableInteger.of(1), SequentiableInteger.of(20));
final Integer start = interval.getStart().getValue();
final Integer end = interval.getEnd().getValue();
System.out.println(interval.toString());  // 1-20
```

Arguments are automatically ordered, so `new Interval<>(of(20), of(1))` produces the same result as above.

### Using IntervalCollection
`IntervalCollection` groups a set of values into contiguous intervals:

```java
final IntervalCollection<SequentiableInteger, Integer> collection = new IntervalCollection<>(Set.of(
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

### Supported types
Out of the box: `SequentiableInteger`, `SequentiableLong`, `SequentiableYear`. Implement the `Sequentiable<T>` interface to add your own type.

## Building
```bash
mvn clean test
```

## License
Licensed under the [Apache License, Version 2.0](LICENSE).
