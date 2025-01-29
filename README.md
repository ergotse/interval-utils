# interval-utils

## Objective
`interval-utils` is a utility tool designed for handling intervals efficiently. It provides a structured way to manage and manipulate intervals using Java, making it useful for scenarios that require range calculations, interval collections, and sequence-based operations.

## Installation
To include `interval-utils` in your project, add the following Maven dependency:

```xml
<dependency>
    <groupId>se.ergot</groupId>
    <artifactId>interval-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage
```java
// Creating an Interval
final Interval<SequentiableInteger> interval = new Interval<>(SequentiableInteger.of(1), SequentiableInteger.of(20));
final Integer start = interval.getStart().getValue(); 
final Integer end = interval.getEnd().getValue();
System.out.println(interval.toString());  // 1-20
```

```java
// Using IntervalCollection
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