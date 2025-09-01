# 📊 Graph DSA Problems

This repository contains **Java implementations** of Graph-related Data Structures and Algorithms problems from platforms like **GeeksforGeeks** and **LeetCode**.  
Each solution is written to be **clean, efficient**, and includes **comments** for better understanding.

---

## 📁 File Structure

Each file is named after the problem it solves.  
Problem statements and source links are included as comments inside the respective files.

---

## 📚 Problem List

| Problem | File | Source | Description |
|---------|------|--------|-------------|
| BFS Traversal | `bfs_graph.java` | [GFG - BFS Traversal](https://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/) | Performs BFS traversal on an undirected graph starting from node 0 |
| DFS Traversal | `dfs_graph.java` | [GFG - DFS Traversal](https://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/) | Performs DFS traversal on an undirected graph starting from node 0 |
| Detecting Cycle (Undirected - BFS) | `detecting_cycle_undirected_graph_bfs.java` | [GFG - Detect cycle using BFS](https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-bfs/) | Detects cycle in an undirected graph using BFS |
| Detecting Cycle (Undirected - DFS) | `detecting_cycle_undirected_graph_dfs.java` | [GFG - Detect cycle using DFS](https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-dfs/) | Detects cycle in an undirected graph using DFS |
| Detecting Cycle (Directed - DFS) | `detecting_cycle_directed_graph_dfs.java` | [GFG - Detect cycle in directed graph](https://www.geeksforgeeks.org/detect-cycle-in-a-graph/) | Detects cycle in a directed graph using DFS |
| Flood Fill | `flood_fill.java` | [LeetCode 733 - Flood Fill](https://leetcode.com/problems/flood-fill/) | Recolors a connected region in a grid from a starting pixel using DFS/BFS |
| Rotting Oranges | `rotting_oranges.java` | [LeetCode 994 - Rotting Oranges](https://leetcode.com/problems/rotting-oranges/) | Uses BFS to calculate the minimum time for all fresh oranges to rot |
| Number of Provinces | `number_of_provinces.java` | [LeetCode 547 - Number of Provinces](https://leetcode.com/problems/number-of-provinces/) | Uses DFS on the adjacency matrix to count the number of connected components (provinces) |
| Number of Islands (BFS) | `number_of_islands.java` | [LeetCode 200 - Number of Islands](https://leetcode.com/problems/number-of-islands/) | Uses BFS to count distinct islands in a 2D grid |
| Topological Sort (DFS) | `topological_sort.java` | [GFG - Topological Sorting](https://www.geeksforgeeks.org/topological-sorting/) | Performs topological sort in a DAG using DFS |
| Topological Sort (Kahn's BFS) | `kahns_algo_topological_sort_bfs.java` | [GFG - Kahn's Algorithm](https://www.geeksforgeeks.org/topological-sort/) | Performs topological sort in a DAG using Kahn’s Algorithm (BFS) |
| Course Schedule I | `course_schedule_I.java` | [LeetCode 207 - Course Schedule](https://leetcode.com/problems/course-schedule/) | Determines if all courses can be completed using cycle detection (Kahn’s BFS Topological Sort) |
| Course Schedule II | `course_schedule_II.java` | [LeetCode 210 - Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | Returns one possible order of course completion using Kahn’s BFS Topological Sort |
| Bipartite Graph (DFS) | `bipartite_graph_dfs.java` | [GFG - Bipartite Graph](https://www.geeksforgeeks.org/bipartite-graph/) | Checks if a graph is bipartite using DFS graph coloring |
| Bipartite Graph (BFS) | `bipartite_graph_bfs.java` | [LeetCode 785 - Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/) | Checks if a graph is bipartite using BFS graph coloring |
| Detecting Cycle (Undirected - DSU) | `detecting_cycle_using_dsu.java` | [GFG - Detect cycle using DSU](https://www.geeksforgeeks.org/detect-cycle-in-an-undirected-graph-using-disjoint-set/) | Detects cycle in an undirected graph using Disjoint Set Union (Union-Find) |
| Number of Operations to Make Network Connected | `number_of_operations_to_make_network_connected_dsu.java` | [LeetCode 1319 - Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | Uses DSU to find minimum operations to connect all nodes in a network |
| Satisfiability of Equality Equations | `satisfiability_of_equality_equations_dsu.java` | [LeetCode 990 - Satisfiability of Equality Equations](https://leetcode.com/problems/satisfiability-of-equality-equations/) | Uses DSU to determine if a set of equality and inequality equations can be satisfied |
| Count Unreachable Pairs in Undirected Graph | `count_unreachable_pairs.java`              | [LeetCode 2316 - Count Unreachable Pairs of Nodes in an Undirected Graph](https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/) | Uses Disjoint Set Union (Union-Find) to count the number of unordered pairs of nodes that cannot reach each other |
| Dijkstra’s Algorithm (Min-Heap) | `dijkstra_algo_heap.java` | [GFG - Dijkstra’s Algorithm using Priority Queue](https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-using-priority_queue-stl/) | Finds shortest paths from a source node to all other nodes using a priority queue (min-heap) |
---

## 🚀 How to Run

Compile and run any Java file:

