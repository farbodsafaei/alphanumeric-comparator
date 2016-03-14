# alphanumeric-comparator

An alphanumeric comparator for comparing strings in a human readable format. It uses a combination numeric and alphabetic comparisons to compare two strings. This class uses standard Java classes, independent of 3rd party libraries.

Additionally this comparator uses ```java.text.Collator``` class to correctly sort strings containing special Unicode characters such as Umlauts and other similar letters of alphabet in different languages, such as: **å**, **è**, **ü**, **ö**, **ø**, or **ý**.

#### Example #1
For given list of strings:
- file-01.doc
- file-2.doc
- file-03.doc

The regular lexicographical sorts, e.g. ```java.util.Collections.sort()```, sorts the above list in following order:

[file-01.doc, file-03.doc, file-2.doc]

However using ```AlphaNumericComparator```, the list will be sorter in more meaningful and readable way:

[file-01.doc, file-2.doc, file-03.doc]

#### Example #2
For the following list of characters/strings: 
 * b
 * e
 * k
 * ě
 * f
 * è
 * g

The regular lexicographical sorts, e.g. ```java.util.Collections.sort()```, sorts the above list in following order:

**[b, e, f, g, k, è, ě]**

Using ```AlphaNumericComparator```, the list is correctly sorted as below:

**[b, e, è, ě, f, g, k]**

#### How To

Just pass the comparator as a paramer when sorting a list:
```java
List<String> list = new ArrayList<String>();
list.add("some string");
list.add("some other string");
...
list.sort(new AlphaNumericComparator());
```
or just simply use the ```compare()``` method in AlphaNumericComparator class as needed.
 
