# Data Structures & Algorithms Interview Guide

This is a detailed interview-style answer bank for your listed topics.

## Arrays

### 1) What is the two-pointer technique?
Two-pointer is a pattern where we maintain two indices (pointers) to traverse an array/string, usually from:
- opposite ends (`left`, `right`), or
- same direction with different speeds/roles (`slow`, `fast`).

The pointers move based on conditions so we can avoid nested loops in many problems.

Common pointer setups:
- `left` and `right` from both ends: useful in sorted arrays and palindrome checks.
- `slow` and `fast`: useful for in-place compaction (remove duplicates, move zeros).
- two moving boundaries: partitioning around pivot.

Why it is powerful:
- often reduces $O(n^2)$ brute force to $O(n)$.
- uses constant extra space in many cases.

Example:
- Two Sum in sorted array: move `left/right` depending on current sum.

### 2) When should we use two pointers?
Use two pointers when:
- input is sorted (or can be sorted) and you need pair/triplet relations.
- question asks for pair conditions like sum/product/difference.
- need in-place array modification with minimal extra space.
- searching subarray boundaries or deduping consecutive values.

Typical problems:
- pair sum in sorted array
- remove duplicates from sorted array
- move zeros to end
- container with most water
- trapping rain water (optimized form)

Avoid/less useful when:
- random access relations need full history (hash map may be better)
- graph/tree traversal style dependencies

### 3) What is the sliding window technique?
Sliding window is an optimization for contiguous subarray/substring problems.

Instead of recomputing for every range, we maintain a window `[left, right]` and update state as the window expands/shrinks.

Two forms:
- Fixed-size window: window length is constant (e.g., max sum of size `k`).
- Variable-size window: length changes based on constraints (e.g., smallest window with sum >= target).

Core idea:
- Add element when expanding (`right++`)
- Remove element when shrinking (`left++`)
- Keep auxiliary state (sum/frequency map/distinct count)

### 4) When should sliding window be used?
Use sliding window when:
- problem is about contiguous ranges (subarray/substring).
- condition can be maintained incrementally while moving boundaries.
- brute force would check all ranges and be too slow.

Strong signals in questions:
- "longest/shortest substring/subarray"
- "at most/at least/exactly `k` distinct"
- "maximum/minimum over every window of size `k`"

Typical time complexity improvement:
- from $O(n^2)$ to $O(n)$ (amortized), because each element enters/exits window at most once.

## Hash Maps

### 5) When should we use a hash map?
Use a hash map when you need fast lookup by key.

Best use cases:
- frequency counting (character counts, element counts)
- checking if a value was seen before
- mapping value -> index (classic Two Sum unsorted)
- grouping items by key (anagrams, categories)
- prefix sum tricks (subarray sum equals `k`)

Typical complexity:
- average insert/search/delete: $O(1)$
- worst case: $O(n)$ (rare with good hashing and resizing)

### 6) How does hashing work internally?
High-level internals:
1. Key is passed to a hash function.
2. Hash function produces an integer hash code.
3. Hash code maps to a bucket index (usually `% capacity`).
4. Data is stored in that bucket.

Collision handling (two keys same bucket):
- Separate chaining: bucket stores list/tree of entries.
- Open addressing: probe other slots (linear/quadratic/double hashing).

Rehashing / resizing:
- when load factor crosses threshold (e.g., 0.75), table grows.
- existing keys are redistributed into new bucket array.

Interview point:
- Good hash maps trade extra memory for very fast average operations.

## Dynamic Programming (DP)

### 7) What is dynamic programming?
Dynamic Programming is an optimization technique for problems with:
- optimal substructure, and
- overlapping subproblems.

Instead of solving same subproblems repeatedly, DP stores results and reuses them.

DP workflow:
1. Define state (what does `dp[i]` or `dp[i][j]` mean?).
2. Write recurrence relation.
3. Set base cases.
4. Compute via memoization or tabulation.

### 8) What are overlapping subproblems?
Overlapping subproblems means recursive calls repeat the same smaller problem many times.

Example: Fibonacci recursion
- `fib(5)` calls `fib(4)` and `fib(3)`
- `fib(4)` again calls `fib(3)` and `fib(2)`
- `fib(3)` is recomputed multiple times

DP avoids this repetition by caching/storing results.

### 9) What is memoization?
Memoization = top-down DP.

Approach:
- Write recursive solution first.
- Store computed result for each state in cache (`array/map`).
- If state already computed, return cached value.

Pros:
- natural from recursive thinking
- computes only needed states

Cons:
- recursion stack overhead
- stack overflow risk on deep recursion

### 10) What is tabulation?
Tabulation = bottom-up DP.

Approach:
- Start from smallest base states.
- Fill DP table iteratively until target state.

Pros:
- no recursion stack
- often better constant factors

Cons:
- sometimes less intuitive initially
- may compute some unnecessary states

## Common DP Problems

### 11) Climbing Stairs
Problem: You can climb 1 or 2 steps. How many ways to reach step `n`?

State:
- `dp[i]` = ways to reach step `i`

Recurrence:
- `dp[i] = dp[i-1] + dp[i-2]`

Base:
- `dp[0] = 1`, `dp[1] = 1`

Complexity:
- with array: time $O(n)$, space $O(n)$
- optimized: space $O(1)$ using two variables

### 12) House Robber
Problem: Max money from houses in line, cannot rob adjacent houses.

State:
- `dp[i]` = max money from first `i` houses

Transition decision at house `i`:
- skip current: `dp[i-1]`
- rob current: `nums[i] + dp[i-2]`
- take max

Recurrence:
- `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`

Complexity:
- time $O(n)$, space $O(n)$ or $O(1)$ optimized

### 13) 0/1 Knapsack
Problem: `n` items with weights/values, capacity `W`; each item can be taken once.

State:
- `dp[i][w]` = max value using first `i` items with capacity `w`

Transition:
- not take item `i`: `dp[i-1][w]`
- take item `i` (if weight allows): `value[i] + dp[i-1][w-weight[i]]`

Take max of both.

Complexity:
- time $O(nW)$, space $O(nW)$
- space can be reduced to $O(W)$ with reverse loop over capacity

### 14) Longest Common Subsequence (LCS)
Problem: Longest subsequence common to strings `s1` and `s2`.

State:
- `dp[i][j]` = LCS length for prefixes `s1[0..i-1]`, `s2[0..j-1]`

Transition:
- if chars match: `dp[i][j] = 1 + dp[i-1][j-1]`
- else: `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`

Complexity:
- time $O(mn)$, space $O(mn)$

### 15) Coin Change
Classic version: minimum number of coins to form amount `A` (unlimited coin use).

State:
- `dp[x]` = min coins to make amount `x`

Transition:
- for each coin `c`, if `x-c >= 0`:
- `dp[x] = min(dp[x], 1 + dp[x-c])`

Base:
- `dp[0] = 0`, others initialized as infinity

Result:
- if `dp[A]` still infinity, return -1

Complexity:
- time $O(A * n)$ where `n` is number of coins
- space $O(A)$

## Trees

### 16) What is a binary tree?
A binary tree is a hierarchical structure where each node has at most two children:
- left child
- right child

Terminology:
- root: top node
- leaf: node with no children
- height/depth: path length measures

Common types:
- full, complete, perfect, balanced, skewed
- BST is a special binary tree with ordering property

### 17) What are tree traversals?
Traversal means visiting every node in a specific order.

Major traversals:
- DFS variants: inorder, preorder, postorder
- BFS variant: level order

### 18) What is inorder traversal?
Order: Left -> Root -> Right

For BST, inorder gives nodes in sorted order.

Complexity:
- time $O(n)$
- space $O(h)$ recursive stack (`h` = tree height)

### 19) What is preorder traversal?
Order: Root -> Left -> Right

Useful for:
- copying/serializing tree
- prefix expression tree processing

Complexity: time $O(n)$, space $O(h)$

### 20) What is postorder traversal?
Order: Left -> Right -> Root

Useful for:
- deleting/freeing tree (children first)
- evaluating expression trees bottom-up

Complexity: time $O(n)$, space $O(h)$

### 21) What is level order traversal?
Traverse level by level from top to bottom, left to right.

Implementation:
- use queue (BFS on tree)

Complexity:
- time $O(n)$
- space $O(w)$ where `w` is max width of tree

## Graphs

### 22) What is BFS?
Breadth-First Search explores graph level by level from a start node.

Data structure:
- queue

Properties:
- finds shortest path (minimum edges) in unweighted graphs
- good for nearest-neighbor style exploration

Complexity:
- adjacency list: $O(V+E)$

### 23) What is DFS?
Depth-First Search goes as deep as possible before backtracking.

Data structure:
- recursion stack or explicit stack

Properties:
- useful for connectivity, components, topological patterns, cycle checks

Complexity:
- adjacency list: $O(V+E)$

### 24) When should BFS be used?
Use BFS when:
- need shortest path in unweighted graph
- need level/distance from source
- need minimum steps / minimum moves problems
- spread simulation (rotting oranges, contagion, multi-source distance)

### 25) When should DFS be used?
Use DFS when:
- exploring all paths/possibilities deeply
- topological sort (DAG)
- cycle detection and strongly connected components (with variants)
- backtracking on graph-like search spaces

### 26) What is cycle detection in graphs?
Cycle detection means checking whether a path leads back to a previously reachable node.

Methods:
- Undirected graph:
	- DFS with parent tracking
	- or Union-Find (Disjoint Set Union)
- Directed graph:
	- DFS with recursion stack / color states
	- Kahn's algorithm (topological sort): if all nodes not processed, cycle exists

Complexity:
- usually $O(V+E)$

## Complexity

### 27) What is Big-O notation?
Big-O describes upper bound growth rate of an algorithm as input size `n` grows.

It focuses on asymptotic behavior, ignoring constants and lower-order terms.

Examples:
- $O(1)$ constant
- $O(\log n)$ binary search
- $O(n)$ linear scan
- $O(n \log n)$ merge sort
- $O(n^2)$ double loop

### 28) How do you analyze time complexity?
Interview method:
1. Define input size (`n`, maybe `m`, `V`, `E`, etc.).
2. Count dominant operations.
3. Analyze loops:
	 - single loop -> often $O(n)$
	 - nested loops -> often multiply
4. Analyze recursion with recurrence (if needed).
5. Keep worst-case unless asked average/amortized.

Examples:
- Two nested loops each up to `n` -> $O(n^2)$
- Binary search halves each step -> $O(\log n)$
- Merge sort recurrence $T(n)=2T(n/2)+O(n)$ -> $O(n\log n)$

### 29) How do you analyze space complexity?
Space complexity = extra memory used by algorithm relative to input size.

Include:
- auxiliary arrays/maps/stacks/queues
- recursion call stack

Do not count input storage itself (usually).

Examples:
- iterative two-pointer scan -> $O(1)$ extra
- hash map for frequencies of `n` items -> $O(n)$
- recursive DFS on skewed tree with height `n` -> $O(n)$ stack

## Interview Tips (Quick)

1. Start with brute force and complexity.
2. Identify pattern: two-pointer, sliding window, hash map, DP, BFS/DFS.
3. Explain why chosen approach is correct.
4. State time/space clearly.
5. Mention edge cases (empty input, single element, duplicates, overflow, disconnected graph).

If you want, I can also add Java code templates for each pattern directly below this guide.
