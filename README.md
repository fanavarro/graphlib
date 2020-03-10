# graphlib
Java library for graph management.

## Graph representation
This library provides interfaces and abstract classes representing graphs, together with algorithms that can be applied to those graphs.

 Normally,  graphs are defined in such way that two nodes are connected by one edge only. Nonetheless, the graph model used by this library permits that two nodes to be linked by more than one edge, which is common in fields like ontologies.

The library relies on the Graph interface, which is parametrized with N (type of the nodes), and E (type of the edges), and declares graph methods, such as getNodes, getAdjacentNodes, or getIncomingNodes. Moreover, an AbstractGraph implementing most part of Graph interface is provided. By extending this abstract class, you only will have to implement the methods getNodes and getAdjacentNodesWithEdges. 


The idea of this library is to help developers to define custom graphs by extending the AbstractGraph class. We also provide a simple map-based implementation (SimpleGraphImpl class), which could be an example of use case where the graph backend is a java map.

## Algorithms
The library defines the following interfaces for algorithm usage:

* **Algorithm** declares the method *apply*, which receives an *AlgorithmInput* and returns an *AlgorithmOutput*.
* **AlgorithmInput** represents the input for an algorithm. The input will contain, at least, the graph in which the algorithm will be applied.
* **AlgorithmOutput** represents the output of an algorithm.

The available algorithms are described next.

### Shortest path algorithm
The shortest path algorithm (ShortestPathAlgorithm class) computes the shortest path between two nodes.

#### Input
The following parameters could be specified in ShortestPathInput class:

* **graph**: the graph in which the algorithm will be applied.
* **sourceNode**: the starting node.
* **targetNode**: the ending node.
* **maxDepth**: the maximum allowed distance.

#### Output
The algorithm returns an object with the following fields:

* **path**: the path from *sourceNode* to *targetNode* found.


### Least common node
The least common node algorithm (LeastCommonNodeAlgorithm class) computes the node or nodes that are transitively linked to a given set of nodes, minimizing the distance.

#### Input
The following parameters could be specified in LeastCommonNodeInput class:

* **graph**: the graph in which the algorithm will be applied.
* **nodes**: the nodes from which the common least node will be calculated.
* **reverse**: a boolean parameter indicating the direction in which edges will be traverse. If reverse is true, the least common ancestor will be searched by exploring the incoming nodes of the *nodes*. If reverse is false, outcoming nodes of *nodes* will be used for traversal.


#### Output
The algorithm returns a LeastCommonNodeOutput object with the following fields:

* **nodes**: the original *nodes* from which the least common node has been calculated.
* **reverse**: the *reverse* parameter specified in the input.
* **leastCommonNodes**: the node or nodes which are the least common nodes of *nodes*.


### Subtree algorithm
The subtree algorithm (SubtreeAlgorithm class) extracts a tree containing a given set of nodes.

#### Input
The following parameters could be specified in SubtreeInput class:

* **graph**: the graph in which the algorithm will be applied.
* **nodesToBeContained**: the nodes that should be present in the resulting tree.


#### Output
The algorithm returns a SubtreeOutput object with the following fields:

* **trees**: a set of trees that contain the nodes specified in *nodesToBeContained*.