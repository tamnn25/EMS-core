# 🌳 Java Collections Framework (Complete)

```java
import java.util.*;
```

---

## 1️⃣ List (Ordered, Duplicates Allowed, Index Access)

```java
// ✔ Ordered (insertion order)
// ✔ Allows duplicate elements
// ✔ Access by index
// ✔ Multiple nulls allowed
// ❌ Not thread-safe
List<String> list = new ArrayList<>();
```

### Common Implementations

```java
ArrayList<String> arrayList = new ArrayList<>();
LinkedList<String> linkedList = new LinkedList<>();
```

**Use when:** order matters and duplicates are allowed.

---

## 2️⃣ Set (Unique Elements, No Index Access)

```java
// ✔ No duplicates
// ❌ No index access
// ✔ At most one null (HashSet)
// ❌ Not thread-safe
Set<String> set = new HashSet<>();
```

### Set Implementations

```java
HashSet<String> hashSet = new HashSet<>();           // No order
LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(); // Insertion order
TreeSet<String> treeSet = new TreeSet<>();           // Sorted order
```

**Use when:** uniqueness matters.

---

## 3️⃣ Map (Key–Value Pairs)

```java
// ✔ Key–value structure
// ✔ Keys are unique
// ✔ Fast lookup by key
// ❌ Not part of Collection interface
Map<String, Integer> map = new HashMap<>();
```

### Map Implementations

```java
HashMap<String, Integer> hashMap = new HashMap<>();           // No order
LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(); // Insertion order
TreeMap<String, Integer> treeMap = new TreeMap<>();           // Sorted keys
Hashtable<String, Integer> hashtable = new Hashtable<>();     // Legacy, synchronized
```

**Use when:** key-based access is required.

---

## 4️⃣ Queue (FIFO – First In First Out)

```java
// ✔ Ordered processing
// ✔ Typically FIFO
// ❌ No index access
Queue<String> queue = new LinkedList<>();
```

### Queue Implementations

```java
PriorityQueue<String> priorityQueue = new PriorityQueue<>(); // Natural priority
ArrayDeque<String> arrayDeque = new ArrayDeque<>();           // Faster than LinkedList
```

**Use when:** task scheduling or buffering.

---

## 5️⃣ Deque (Double-Ended Queue)

```java
// ✔ Insert/remove from both ends
// ✔ Can act as stack or queue
Deque<String> deque = new ArrayDeque<>();
```

**Use when:** stack or queue behavior is needed.

---

## 6️⃣ Legacy Collections (Avoid in New Code)

```java
Vector<String> vector = new Vector<>();     // Synchronized, slow
Stack<String> stack = new Stack<>();         // Extends Vector
Hashtable<String, String> table = new Hashtable<>();
```

---

## 7️⃣ Thread-Safe / Concurrent Collections

```java
import java.util.concurrent.*;
```

```java
ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();
CopyOnWriteArraySet<String> cowSet = new CopyOnWriteArraySet<>();
```

**Use when:** multi-threaded environments.

---

## 🧠 Big Picture Hierarchy

```
Iterable
 └── Collection
      ├── List
      │    ├── ArrayList
      │    └── LinkedList
      ├── Set
      │    ├── HashSet
      │    ├── LinkedHashSet
      │    └── TreeSet
      └── Queue
           ├── PriorityQueue
           └── Deque
                └── ArrayDeque

Map (separate hierarchy)
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 ├── Hashtable
```

---

## ⚡ Quick Comparison Table

| Type  | Ordered | Duplicates | Index | Null | Use Case     |
| ----- | ------- | ---------- | ----- | ---- | ------------ |
| List  | ✔       | ✔          | ✔     | ✔    | Ordered data |
| Set   | ❌       | ❌          | ❌     | ✔*   | Unique data  |
| Map   | ✔*      | ❌ keys     | ❌     | ✔*   | Key-value    |
| Queue | ✔       | ✔          | ❌     | ❌    | FIFO         |
| Deque | ✔       | ✔          | ❌     | ❌    | Stack/Queue  |

* Depends on implementation

---

## 🎯 Interview Golden Rules

* Default **List** → `ArrayList`
* Default **Set** → `HashSet`
* Default **Map** → `HashMap`
* FIFO → `Queue`
* Stack → `Deque`
* Multi-thread → `ConcurrentHashMap`

---

If you want next:

* 🔥 **Real interview questions**
* 🔥 **Collection performance deep dive**
* 🔥 **equals/hashCode traps**
* 🔥 **Concurrent collections explained**

Just tell me 👍
