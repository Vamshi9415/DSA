#  Complete DSA Time & Space Complexity Cheat Sheet



---

##  Table of Contents

1. [Data Structures](#data-structures)
2. [Sorting Algorithms](#sorting-algorithms)
3. [Searching Algorithms](#searching-algorithms)
4. [Graph Algorithms](#graph-algorithms)
5. [Tree Algorithms](#tree-algorithms)
6. [String Algorithms](#string-algorithms)
7. [Dynamic Programming Patterns](#dynamic-programming-patterns)
8. [Important Formulas & Theorems](#important-formulas--theorems)

---

## 1. Data Structures

### 1.1 Array

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Access | O(1) | O(n) |
| Search | O(n) | O(1) |
| Insert (at end) | O(1) | O(1) |
| Insert (at beginning/middle) | O(n) | O(1) |
| Delete (from end) | O(1) | O(1) |
| Delete (from beginning/middle) | O(n) | O(1) |

**Explanation:**
- **Access:** Direct index access is constant time
- **Search:** Must check each element in worst case
- **Insert/Delete at beginning:** Must shift all elements

---

### 1.2 Linked List (Singly)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Access | O(n) | O(n) |
| Search | O(n) | O(1) |
| Insert (at beginning) | O(1) | O(1) |
| Insert (at end) | O(n) | O(1) |
| Insert (at end with tail pointer) | O(1) | O(1) |
| Delete (at beginning) | O(1) | O(1) |
| Delete (given node) | O(1) | O(1) |
| Delete (given value) | O(n) | O(1) |

**Explanation:**
- **Access/Search:** Must traverse from head
- **Insert at beginning:** Just update head pointer
- **Delete given node:** Need previous node, so O(n) to find it

---

### 1.3 Doubly Linked List

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Access | O(n) | O(n) |
| Search | O(n) | O(1) |
| Insert (at beginning/end) | O(1) | O(1) |
| Delete (given node) | O(1) | O(1) |
| Delete (given value) | O(n) | O(1) |

**Explanation:**
- **Delete given node:** O(1) because we have prev pointer (unlike singly linked list)
- Extra space for prev pointers in each node

---

### 1.4 Stack

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Push | O(1) | O(n) |
| Pop | O(1) | O(1) |
| Peek/Top | O(1) | O(1) |
| Search | O(n) | O(1) |
| IsEmpty | O(1) | O(1) |

**Implementation:**
- Array-based or Linked List-based
- LIFO (Last In First Out)

---

### 1.5 Queue

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Enqueue | O(1) | O(n) |
| Dequeue | O(1) | O(1) |
| Front | O(1) | O(1) |
| Rear | O(1) | O(1) |
| IsEmpty | O(1) | O(1) |

**Implementation:**
- Array-based (Circular Queue) or Linked List-based
- FIFO (First In First Out)

---

### 1.6 Binary Search Tree (BST)

| Operation | Average | Worst Case | Space |
|-----------|---------|------------|-------|
| Search | O(log n) | O(n) | O(n) |
| Insert | O(log n) | O(n) | O(n) |
| Delete | O(log n) | O(n) | O(n) |
| Find Min/Max | O(log n) | O(n) | O(1) |
| Inorder Traversal | O(n) | O(n) | O(h)* |
| Preorder Traversal | O(n) | O(n) | O(h)* |
| Postorder Traversal | O(n) | O(n) | O(h)* |

**\*h = height of tree (for recursion stack)**

**Explanation:**
- **Average Case:** Balanced tree, height = O(log n)
- **Worst Case:** Skewed tree (like linked list), height = O(n)
- **Space for traversals:** Recursion stack uses O(height)

**Properties:**
- Left subtree < Root < Right subtree
- Inorder traversal gives sorted order

---

### 1.7 AVL Tree (Self-Balancing BST)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |
| Find Min/Max | O(log n) | O(1) |

**Explanation:**
- **Guaranteed O(log n)** because tree stays balanced
- Balance factor: |height(left) - height(right)| ≤ 1
- Rotations: Single (LL, RR) and Double (LR, RL)

---

### 1.8 Red-Black Tree

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |

**Properties:**
1. Every node is Red or Black
2. Root is always Black
3. Red nodes cannot have Red children
4. Every path from root to NULL has same number of Black nodes
5. New insertions are always Red

**Comparison with AVL:**
- AVL: More balanced (faster search)
- Red-Black: Fewer rotations (faster insert/delete)

---

### 1.9 B-Tree

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |

**Properties:**
- Degree t (minimum): Each node has t-1 to 2t-1 keys
- All leaves at same level
- Used in databases and file systems

---

### 1.10 Heap (Binary Heap)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Find Min/Max | O(1) | O(n) |
| Insert | O(log n) | O(1) |
| Delete Min/Max | O(log n) | O(1) |
| Heapify | O(n) | O(1) |
| Build Heap | O(n) | O(1) |
| Search | O(n) | O(1) |

**Types:**
- **Min Heap:** Parent ≤ Children
- **Max Heap:** Parent ≥ Children

**Implementation:** Usually array-based
- Parent at index i: Children at 2i+1 and 2i+2
- Child at index i: Parent at (i-1)/2

**Explanation:**
- **Heapify:** Fix single violation, O(log n)
- **Build Heap:** Bottom-up heapify, O(n) not O(n log n)!

---

### 1.11 Hash Table

| Operation | Average | Worst Case | Space |
|-----------|---------|------------|-------|
| Search | O(1) | O(n) | O(n) |
| Insert | O(1) | O(n) | O(n) |
| Delete | O(1) | O(n) | O(n) |

**Collision Resolution:**
1. **Chaining:** O(1 + α) where α = n/m (load factor)
2. **Open Addressing:** O(1/(1-α))
   - Linear Probing: h(k, i) = (h(k) + i) mod m
   - Quadratic Probing: h(k, i) = (h(k) + c₁i + c₂i²) mod m
   - Double Hashing: h(k, i) = (h₁(k) + i·h₂(k)) mod m

**Explanation:**
- **Average O(1):** Good hash function, low load factor
- **Worst O(n):** All keys hash to same bucket

---

### 1.12 Trie (Prefix Tree)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Insert | O(m) | O(ALPHABET_SIZE × m × n) |
| Search | O(m) | O(1) |
| Delete | O(m) | O(1) |
| Prefix Search | O(m + k) | O(k) |

**m = length of word, k = number of results, n = number of words**

**Use Cases:**
- Autocomplete
- Spell checker
- IP routing (longest prefix matching)

---

### 1.13 Segment Tree

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Build | O(n) | O(4n) ≈ O(n) |
| Query (range) | O(log n) | O(log n) |
| Update (point) | O(log n) | O(log n) |
| Update (range) | O(log n) | O(log n) |

**Use Cases:**
- Range sum/min/max queries
- Range updates with lazy propagation

---

### 1.14 Fenwick Tree (Binary Indexed Tree)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Build | O(n log n) | O(n) |
| Query (prefix sum) | O(log n) | O(1) |
| Update (point) | O(log n) | O(1) |
| Range Query | O(log n) | O(1) |

**Advantages over Segment Tree:**
- Less space: O(n) vs O(4n)
- Simpler implementation
- Only for **invertible** operations (addition, XOR)

---

### 1.15 Disjoint Set Union (Union-Find)

| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| MakeSet | O(1) | O(n) |
| Find | O(α(n))* | O(1) |
| Union | O(α(n))* | O(1) |

**\*α(n) = Inverse Ackermann function, practically O(1)**

**Optimizations:**
1. **Path Compression:** Make all nodes point to root during Find
2. **Union by Rank/Size:** Attach smaller tree under larger tree

**Use Cases:**
- Kruskal's algorithm
- Detecting cycles in undirected graph
- Connected components

---

### 1.16 Graph Representations

#### Adjacency Matrix
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Add Edge | O(1) | O(V²) |
| Remove Edge | O(1) | - |
| Check Edge | O(1) | - |
| Find all adjacent | O(V) | - |

**Best for:** Dense graphs, frequent edge queries

#### Adjacency List
| Operation | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| Add Edge | O(1) | O(V + E) |
| Remove Edge | O(V) | - |
| Check Edge | O(V) | - |
| Find all adjacent | O(degree) | - |

**Best for:** Sparse graphs, most real-world graphs

---

## 2. Sorting Algorithms

### 2.1 Comparison-Based Sorting

#### Bubble Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n) | O(1) |
| Average | O(n²) | O(1) |
| Worst | O(n²) | O(1) |

**Properties:**
- **Stable:** Yes
- **In-place:** Yes
- **Adaptive:** Yes (optimized version)

**How it works:**
- Compare adjacent elements and swap if needed
- After each pass, largest element "bubbles" to end
- Optimization: Stop if no swaps in a pass

**Best case:** Already sorted (with optimization)

---

#### Selection Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n²) | O(1) |
| Average | O(n²) | O(1) |
| Worst | O(n²) | O(1) |

**Properties:**
- **Stable:** No (can be made stable)
- **In-place:** Yes
- **Adaptive:** No

**How it works:**
- Find minimum element and swap with first position
- Find second minimum and swap with second position
- Continue for all positions

**Note:** Always O(n²) comparisons, but only O(n) swaps

---

#### Insertion Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n) | O(1) |
| Average | O(n²) | O(1) |
| Worst | O(n²) | O(1) |

**Properties:**
- **Stable:** Yes
- **In-place:** Yes
- **Adaptive:** Yes

**How it works:**
- Build sorted array one element at a time
- Insert each element in correct position in sorted part
- Shift larger elements to make space

**Best case:** Already sorted
**Use case:** Small arrays, nearly sorted data

---

#### Merge Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n log n) | O(n) |
| Average | O(n log n) | O(n) |
| Worst | O(n log n) | O(n) |

**Properties:**
- **Stable:** Yes
- **In-place:** No
- **Adaptive:** No

**How it works:**
- Divide array into two halves
- Recursively sort both halves
- Merge the sorted halves

**Recurrence:** T(n) = 2T(n/2) + O(n)

**Advantages:**
- Guaranteed O(n log n)
- Stable sort
- Good for linked lists (O(1) space)

**Disadvantages:**
- Requires O(n) extra space
- Not adaptive

---

#### Quick Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n log n) | O(log n) |
| Average | O(n log n) | O(log n) |
| Worst | O(n²) | O(n) |

**Properties:**
- **Stable:** No
- **In-place:** Yes
- **Adaptive:** No

**How it works:**
- Choose pivot element
- Partition: elements < pivot on left, > pivot on right
- Recursively sort both partitions

**Pivot Selection:**
- First/Last element: O(n²) on sorted data
- Random: Average O(n log n)
- Median-of-three: Better average case

**Space:** O(log n) for recursion stack (balanced), O(n) worst case

**Advantages:**
- Fast in practice
- In-place (almost)
- Cache-friendly

**Disadvantages:**
- O(n²) worst case
- Unstable

---

#### Heap Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n log n) | O(1) |
| Average | O(n log n) | O(1) |
| Worst | O(n log n) | O(1) |

**Properties:**
- **Stable:** No
- **In-place:** Yes
- **Adaptive:** No

**How it works:**
1. Build max heap: O(n)
2. Extract max (root) and heapify: O(log n) × n times

**Advantages:**
- Guaranteed O(n log n)
- O(1) space
- No worst case like Quick Sort

**Disadvantages:**
- Not stable
- Not cache-friendly
- Slower than Quick Sort in practice

---

### 2.2 Non-Comparison Based Sorting

#### Counting Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| All | O(n + k) | O(k) |

**k = range of input values**

**Properties:**
- **Stable:** Yes
- **In-place:** No

**How it works:**
1. Count frequency of each value
2. Calculate cumulative sum
3. Place elements in correct position

**Constraints:**
- Input must be integers in range [0, k]
- Not suitable for large k

**Use case:** Small range of integers

---

#### Radix Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| All | O(d × (n + k)) | O(n + k) |

**d = number of digits, k = range of each digit (usually 10)**

**Properties:**
- **Stable:** Yes (if using stable sorting for digits)
- **In-place:** No

**How it works:**
- Sort by least significant digit first
- Then by next digit, and so on
- Uses stable sort (like Counting Sort) for each digit

**Time:** O(d × (n + k)) where d = log_k(max_value)
- For decimal: O(d × n) where d = number of digits

**Use case:** Fixed-length integers or strings

---

#### Bucket Sort
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(n + k) | O(n + k) |
| Average | O(n + k) | O(n + k) |
| Worst | O(n²) | O(n) |

**k = number of buckets**

**Properties:**
- **Stable:** Depends on sorting algorithm used
- **In-place:** No

**How it works:**
1. Distribute elements into k buckets
2. Sort each bucket individually
3. Concatenate all buckets

**Best case:** Uniform distribution
**Worst case:** All elements in one bucket

**Use case:** Uniformly distributed data

---

### 2.3 Sorting Algorithm Comparison

| Algorithm | Best | Average | Worst | Space | Stable | Adaptive |
|-----------|------|---------|-------|-------|--------|----------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | ✓ | ✓ |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | ✗ | ✗ |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | ✓ | ✓ |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | ✓ | ✗ |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | ✗ | ✗ |
| Heap Sort | O(n log n) | O(n log n) | O(n log n) | O(1) | ✗ | ✗ |
| Counting Sort | O(n+k) | O(n+k) | O(n+k) | O(k) | ✓ | ✗ |
| Radix Sort | O(d(n+k)) | O(d(n+k)) | O(d(n+k)) | O(n+k) | ✓ | ✗ |
| Bucket Sort | O(n+k) | O(n+k) | O(n²) | O(n+k) | ✓* | ✗ |

**When to use which:**
- **Small array (n < 50):** Insertion Sort
- **Nearly sorted:** Insertion Sort or Bubble Sort
- **Guaranteed O(n log n):** Merge Sort or Heap Sort
- **Average case performance:** Quick Sort
- **Stable sort needed:** Merge Sort
- **Memory constrained:** Heap Sort or Quick Sort
- **Integer range known:** Counting Sort or Radix Sort
- **Uniform distribution:** Bucket Sort

---

## 3. Searching Algorithms

### 3.1 Linear Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(1) | O(1) |
| Average | O(n) | O(1) |
| Worst | O(n) | O(1) |

**When to use:** Unsorted data, small arrays

---

### 3.2 Binary Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(1) | O(1) iterative, O(log n) recursive |
| Average | O(log n) | Same as above |
| Worst | O(log n) | Same as above |

**Prerequisite:** Array must be sorted

**Recurrence:** T(n) = T(n/2) + O(1) = O(log n)

---

### 3.3 Interpolation Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| Best | O(1) | O(1) |
| Average | O(log log n) | O(1) |
| Worst | O(n) | O(1) |

**When to use:** Uniformly distributed sorted data

**Formula:** pos = low + [(x - arr[low]) × (high - low) / (arr[high] - arr[low])]

---

### 3.4 Jump Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| All | O(√n) | O(1) |

**Optimal jump size:** √n

**When to use:** Alternative to binary search, better for sequential access

---

### 3.5 Exponential Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| All | O(log n) | O(1) |

**How it works:**
1. Find range where element exists: O(log n)
2. Binary search in that range: O(log n)

**When to use:** Unbounded/infinite arrays

---

### 3.6 Ternary Search
| Case | Time Complexity | Space Complexity |
|------|----------------|------------------|
| All | O(log₃ n) | O(1) |

**Note:** Slower than binary search despite log₃ n < log₂ n
- More comparisons per iteration

---

## 4. Graph Algorithms

### 4.1 Graph Traversals

#### Breadth-First Search (BFS)
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Data Structure:** Queue

**Applications:**
- Shortest path in unweighted graph
- Level-order traversal
- Connected components
- Bipartite graph check

**Space:** O(V) for queue + visited array

---

#### Depth-First Search (DFS)
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Data Structure:** Stack (or recursion)

**Applications:**
- Topological sorting
- Cycle detection
- Strongly connected components
- Path finding

**Space:** O(V) for recursion stack (or explicit stack) + visited array

---

### 4.2 Shortest Path Algorithms

#### Dijkstra's Algorithm
| Metric | Complexity |
|--------|-----------|
| Time (Binary Heap) | O((V + E) log V) |
| Time (Fibonacci Heap) | O(E + V log V) |
| Space | O(V) |

**Use case:** Single-source shortest path, non-negative weights

**Data Structure:** Min-heap (priority queue)

**Limitation:** Doesn't work with negative weights

---

#### Bellman-Ford Algorithm
| Metric | Complexity |
|--------|-----------|
| Time | O(V × E) |
| Space | O(V) |

**Use case:** Single-source shortest path, negative weights allowed

**Advantages:**
- Detects negative cycles
- Works with negative weights

**Algorithm:** Relax all edges V-1 times

---

#### Floyd-Warshall Algorithm
| Metric | Complexity |
|--------|-----------|
| Time | O(V³) |
| Space | O(V²) |

**Use case:** All-pairs shortest path

**Works with:** Negative weights (but not negative cycles)

**Algorithm:** Dynamic programming with 3 nested loops

---

#### A* Algorithm
| Metric | Complexity |
|--------|-----------|
| Time | O(b^d) worst case, often better |
| Space | O(b^d) |

**b = branching factor, d = depth of solution**

**Use case:** Pathfinding with heuristic

**Formula:** f(n) = g(n) + h(n)
- g(n): cost from start to n
- h(n): estimated cost from n to goal (heuristic)

**Optimality:** If h(n) is admissible (never overestimates)

---

### 4.3 Minimum Spanning Tree

#### Kruskal's Algorithm
| Metric | Complexity |
|--------|-----------|
| Time | O(E log E) or O(E log V) |
| Space | O(V) |

**Algorithm:**
1. Sort edges by weight: O(E log E)
2. Use Union-Find to detect cycles: O(E × α(V))

**Data Structure:** Disjoint Set Union (Union-Find)

---

#### Prim's Algorithm
| Metric | Complexity |
|--------|-----------|
| Time (Binary Heap) | O((V + E) log V) |
| Time (Fibonacci Heap) | O(E + V log V) |
| Space | O(V) |

**Data Structure:** Min-heap (priority queue)

**Algorithm:** Greedy, start from any vertex, add minimum edge

---

### 4.4 Other Graph Algorithms

#### Topological Sort
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Use case:** DAG (Directed Acyclic Graph) ordering

**Methods:**
1. DFS-based: O(V + E)
2. Kahn's Algorithm (BFS-based): O(V + E)

---

#### Tarjan's Algorithm (Strongly Connected Components)
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Use case:** Find SCCs in directed graph

---

#### Kosaraju's Algorithm (Strongly Connected Components)
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Algorithm:**
1. DFS on original graph: O(V + E)
2. DFS on transposed graph: O(V + E)

---

#### Articulation Points and Bridges
| Metric | Complexity |
|--------|-----------|
| Time | O(V + E) |
| Space | O(V) |

**Use case:** Find critical vertices/edges

---

#### Maximum Flow (Ford-Fulkerson)
| Metric | Complexity |
|--------|-----------|
| Time | O(E × max_flow) |
| Space | O(V²) or O(V + E) |

**Better implementations:**
- **Edmonds-Karp (BFS):** O(V × E²)
- **Dinic's Algorithm:** O(V² × E)

---

#### Bipartite Matching (Hungarian Algorithm)
| Metric | Complexity |
|--------|-----------|
| Time | O(V³) |
| Space | O(V²) |

---

## 5. Tree Algorithms

### 5.1 Tree Traversals

| Traversal | Time | Space (Recursive) | Space (Iterative) |
|-----------|------|-------------------|-------------------|
| Inorder | O(n) | O(h) | O(h) |
| Preorder | O(n) | O(h) | O(h) |
| Postorder | O(n) | O(h) | O(h) |
| Level-order | O(n) | O(w) | O(w) |

**h = height, w = maximum width**

---

### 5.2 Tree Operations

#### Lowest Common Ancestor (LCA)
| Method | Preprocessing | Query | Space |
|--------|---------------|-------|-------|
| Naive | O(1) | O(h) | O(1) |
| Binary Lifting | O(n log n) | O(log n) | O(n log n) |
| Euler Tour + RMQ | O(n) | O(1) | O(n) |

---

#### Diameter of Tree
| Metric | Complexity |
|--------|-----------|
| Time | O(n) |
| Space | O(h) |

**Algorithm:** Two DFS/BFS passes

---

#### Check if Balanced
| Metric | Complexity |
|--------|-----------|
| Time | O(n) |
| Space | O(h) |

---

## 6. String Algorithms

### 6.1 Pattern Matching

#### Naive String Matching
| Metric | Complexity |
|--------|-----------|
| Time | O(n × m) |
| Space | O(1) |

**n = text length, m = pattern length**

---

#### KMP (Knuth-Morris-Pratt)
| Metric | Complexity |
|--------|-----------|
| Preprocessing | O(m) |
| Searching | O(n) |
| Space | O(m) |

**Total:** O(n + m)

**Key:** LPS (Longest Proper Prefix which is also Suffix) array

---

#### Rabin-Karp
| Metric | Complexity |
|--------|-----------|
| Best/Average | O(n + m) |
| Worst | O(n × m) |
| Space | O(1) |

**Method:** Rolling hash

**Use case:** Multiple pattern search

---

#### Boyer-Moore
| Metric | Complexity |
|--------|-----------|
| Best | O(n/m) |
| Worst | O(n × m) |
| Space | O(m) |

**Fastest in practice for large alphabets**

---

#### Z-Algorithm
| Metric | Complexity |
|--------|-----------|
| Time | O(n + m) |
| Space | O(n + m) |

**Use case:** Pattern matching, palindrome finding

---

### 6.2 String Processing

#### Longest Common Subsequence (LCS)
| Metric | Complexity |
|--------|-----------|
| Time | O(n × m) |
| Space | O(n × m) or O(min(n,m)) |

**DP approach**

---

#### Longest Common Substring
| Metric | Complexity |
|--------|-----------|
| Time | O(n × m) |
| Space | O(n × m) |

---

#### Edit Distance (Levenshtein)
| Metric | Complexity |
|--------|-----------|
| Time | O(n × m) |
| Space | O(n × m) or O(min(n,m)) |

**Operations:** Insert, Delete, Replace

---

#### Suffix Array
| Metric | Complexity |
|--------|-----------|
| Construction (Naive) | O(n² log n) |
| Construction (Optimized) | O(n log n) |
| Pattern Search | O(m log n) |
| Space | O(n) |

---

#### Suffix Tree
| Metric | Complexity |
|--------|-----------|
| Construction (Ukkonen) | O(n) |
| Pattern Search | O(m) |
| Space | O(n) |

**Applications:**
- Longest repeated substring: O(n)
- Longest common substring: O(n + m)
- Longest palindrome: O(n)

---

## 7. Dynamic Programming Patterns

### Common DP Problems

| Problem | Time | Space |
|---------|------|-------|
| Fibonacci | O(n) | O(1) |
| Climbing Stairs | O(n) | O(1) |
| Coin Change | O(n × m) | O(n) |
| 0/1 Knapsack | O(n × W) | O(n × W) or O(W) |
| Unbounded Knapsack | O(n × W) | O(W) |
| Longest Increasing Subsequence | O(n²) or O(n log n) | O(n) |
| Matrix Chain Multiplication | O(n³) | O(n²) |
| Egg Dropping | O(n × k²) or O(n × k log k) | O(n × k) |
| Partition Problem | O(n × sum) | O(sum) |
| Rod Cutting | O(n²) | O(n) |
| Word Break | O(n² × m) | O(n) |
| Palindrome Partitioning | O(n³) | O(n²) |

---

## 8. Important Formulas & Theorems

### 8.1 Catalan Numbers
**Formula:**
$$C_n = \frac{1}{n+1}\binom{2n}{n} = \frac{(2n)!}{(n+1)! \cdot n!}$$

**Recursive:**
$$C_n = \sum_{i=0}^{n-1} C_i \cdot C_{n-1-i}$$

**Applications:**
- Binary trees with n nodes: C_n
- Valid parentheses with n pairs: C_n
- Ways to triangulate (n+2)-gon: C_n
- Monotonic paths below diagonal: C_n

**Sequence:** 1, 1, 2, 5, 14, 42, 132, 429...

---

### 8.2 Tree Properties

**Binary Tree:**
- Maximum nodes at level i: 2^i
- Maximum nodes in tree of height h: 2^(h+1) - 1
- Minimum height for n nodes: ⌈log₂(n+1)⌉ - 1
- For n nodes: n = i + L where i = internal, L = leaves

**Strictly Binary Tree:**
- L = I + 1 (leaves = internal + 1)
- Total nodes = 2L - 1

**Complete Binary Tree:**
- Height = ⌊log₂ n⌋
- Leaves = ⌈n/2⌉

**Full Binary Tree:**
- Nodes = 2h + 1 (for height h)

---

### 8.3 Graph Properties

**Handshaking Lemma:**
$$\sum_{v \in V} degree(v) = 2|E|$$

**Trees:**
- |E| = |V| - 1
- Exactly one path between any two vertices
- Connected and acyclic

**Complete Graph K_n:**
- Edges = n(n-1)/2

**Bipartite Graph:**
- Can be 2-colored
- No odd-length cycles

---

### 8.4 Asymptotic Notations

**Common Growth Rates (slowest to fastest):**
1. O(1) - Constant
2. O(log log n) - Double logarithmic
3. O(log n) - Logarithmic
4. O(√n) - Square root
5. O(n) - Linear
6. O(n log n) - Linearithmic
7. O(n²) - Quadratic
8. O(n³) - Cubic
9. O(2^n) - Exponential
10. O(n!) - Factorial

**Properties:**
- O(log n) base doesn't matter: log₂ n = O(log₁₀ n)
- O(n log n) is optimal for comparison-based sorting
- O(n) for comparison-based sorting lower bound: Ω(n log n)

---

### 8.5 Master Theorem

For recurrence: T(n) = aT(n/b) + f(n)

**Case 1:** If f(n) = O(n^c) where c < log_b(a)
- T(n) = Θ(n^(log_b a))

**Case 2:** If f(n) = Θ(n^c log^k n) where c = log_b(a)
- T(n) = Θ(n^c log^(k+1) n)

**Case 3:** If f(n) = Ω(n^c) where c > log_b(a) and regularity condition
- T(n) = Θ(f(n))

**Examples:**
- T(n) = 2T(n/2) + O(n) → O(n log n) [Merge Sort]
- T(n) = 2T(n/2) + O(1) → O(n) [Binary Search]
- T(n) = T(n/2) + O(1) → O(log n)
- T(n) = 2T(n/2) + O(n²) → O(n²)

---

### 8.6 Probability in Algorithms

**Quick Sort:**
- Expected time: O(n log n)
- Probability of worst case: Very low with random pivot

**Hashing:**
- Expected collisions with n keys in m slots: n²/(2m)
- Load factor α = n/m
- Expected chain length: α

**Skip List:**
- Expected search/insert/delete: O(log n)
- Space: O(n) expected

---

## 📝 Quick Reference Summary

### When to Use What

**Searching:**
- Unsorted data → Linear Search O(n)
- Sorted data → Binary Search O(log n)
- Uniformly distributed → Interpolation Search O(log log n)

**Sorting:**
- Small data → Insertion Sort O(n²)
- General purpose → Quick Sort O(n log n) avg
- Guaranteed O(n log n) → Merge Sort or Heap Sort
- Stable sort needed → Merge Sort
- Integer range known → Counting/Radix Sort O(n+k)

**Data Structure:**
- Fast access by index → Array O(1)
- Fast insert/delete → Linked List O(1)
- Fast search/insert/delete → Hash Table O(1) avg
- Sorted data operations → BST O(log n)
- Guaranteed O(log n) → AVL/Red-Black Tree
- Priority operations → Heap O(log n)
- Prefix operations → Trie O(m)
- Range queries → Segment Tree O(log n)

**Graph:**
- Shortest path (unweighted) → BFS O(V+E)
- Shortest path (weighted, non-negative) → Dijkstra O((V+E) log V)
- Shortest path (negative weights) → Bellman-Ford O(VE)
- All pairs shortest path → Floyd-Warshall O(V³)
- Minimum spanning tree → Kruskal/Prim O(E log V)
- Topological sort → DFS O(V+E)

---

## 🎯 Final Exam Tips

1. **Understand, don't memorize:** Know WHY complexities are what they are
2. **Best/Average/Worst:** Always consider all three cases
3. **Space complexity:** Don't forget recursion stack space
4. **Trade-offs:** Time vs Space (e.g., DP memoization)
5. **Amortized analysis:** Some operations are O(1) amortized (e.g., dynamic array resize)
6. **Lower bounds:** Some problems have proven lower bounds (e.g., sorting)
7. **Practical vs Theoretical:** Big-O is asymptotic; constants matter in practice

---

