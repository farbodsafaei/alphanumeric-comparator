[![Build Status](https://travis-ci.org/farbodsafaei/alphanumeric-comparator.svg?branch=master)](https://travis-ci.org/farbodsafaei/alphanumeric-comparator)
# alphanumeric-comparator

An alphanumeric comparator in Java, for comparing strings in a human readable format. It uses a combination of numeric and alphabetic comparisons to compare two strings. This class uses standard Java classes and is independent of any 3rd party libraries.

Additionally this comparator uses ```java.text.Collator``` class to correctly sort strings containing special characters like Umlauts or similar alphabet letters in different languages, such as: **å**, **è**, **ü**, **ö**, **ø**, or **ý**.

#### Example #1
For given list of strings:
- file-01.doc
- file-2.doc
- file-03.doc

A regular lexicographical sort, e.g. ```java.util.Collections.sort()```, sorts the above list in the following order:

**[file-01.doc, file-03.doc, file-2.doc]**

However using ```AlphaNumericComparator```, the list will be sorted in a more meaningful and readable way:

**[file-01.doc, file-2.doc, file-03.doc]**

#### Example #2
For the following list of characters/strings: 
 * b
 * e
 * k
 * ě
 * f
 * è
 * g

A regular lexicographical sort, e.g. ```java.util.Collections.sort()```, sorts the above list in the following order:

**[b, e, f, g, k, è, ě]**

Using ```AlphaNumericComparator```, the list is correctly sorted as below:

**[b, e, è, ě, f, g, k]**

#### How To

Simply pass the comparator as a parameter when sorting a list:
```java
List<String> list = new ArrayList<String>();
list.add("some string");
list.add("some other string");
...
list.sort(new AlphaNumericComparator());
```
or just simply use the ```compare()``` method in ```AlphaNumericComparator``` class as needed.
 
