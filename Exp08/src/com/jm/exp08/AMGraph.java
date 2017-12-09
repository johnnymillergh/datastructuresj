package com.jm.exp08;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.sort;

public class AMGraph implements IGraph {

    public final static int INFINITY = Integer.MAX_VALUE;
    private GraphCategory category;
    private int vertexAmount, arcAmount;
    private Object[] vertexes;
    private int[][] adjacentMatrix;

    public AMGraph() {
        this(null, 0, 0, null, null);
    }

    public AMGraph(GraphCategory category, int vertexAmount, int arcAmount, Object[] vertexes, int[][] adjacentMatrix) {
        this.category = category;
        this.vertexAmount = vertexAmount;
        this.arcAmount = arcAmount;
        this.vertexes = vertexes;
        this.adjacentMatrix = adjacentMatrix;
    }

    @Override
    public void create() {
        System.out.print("Enter the category of the graph: \n" +
                "    (UndirectedGraph,\n" +
                "    DirectedGraph,\n" +
                "    UndirectedNetwork,\n" +
                "    DirectedNetwork): ");
//        String str = KeyInput.readString();
        String str = "UndirectedNetwork";
        GraphCategory category = GraphCategory.valueOf(str);
        switch (category) {
            case UndirectedGraph:
                createUndirectedGraph();
                break;
            case DirectedGraph:
                break;
            case UndirectedNetwork:
                createUndirectedNetwork();
                break;
            case DirectedNetwork:
        }
    }

    private void createUndirectedNetwork() {
        int tempAmount = 0;
        System.out.print("Enter the amount of vertex(es): ");
        vertexAmount = KeyInput.readInt();
        System.out.print("Enter the amount of arc(s): ");
        arcAmount = KeyInput.readInt();
        vertexes = new Object[vertexAmount];
        System.out.println("Enter the identification of the vertex of the graph: ");
        for (int i = 0; i < vertexAmount; i++) {
            System.out.print("Vertex No. " + (i + 1) + ": ");
            vertexes[i] = KeyInput.readString();
        }
        // Initial the adjacent matrix
        adjacentMatrix = new int[vertexAmount][vertexAmount];
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                adjacentMatrix[i][j] = INFINITY;
            }
        }
        System.out.println("Enter the each vertex of the graph: ");
        for (int i = 0; i < arcAmount; i++) {
            int a = KeyInput.readInt();
            int b = KeyInput.readInt();
            adjacentMatrix[a][b] = adjacentMatrix[b][a] = KeyInput.readInt();
        }
    }

    private void createUndirectedGraph() {

    }

    @Override
    public int getVertexAmount() {
        return vertexAmount;
    }

    @Override
    public int getArcAmount() {
        return arcAmount;
    }

    @Override
    public Object getVertex(int index) throws Exception {
        if (index < 0 || index >= vertexAmount) {
            throw new Exception("The vertex No. " + index + " does not exist.");
        }
        return vertexes[index];
    }

    @Override
    public int locateVertex(Object vertex) {
        for (int i = 0; i < vertexAmount; i++) {
            if (vertexes[i].equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int firstAdjacentVertex(int v) throws Exception {
        if (v < 0 || v >= vertexAmount) {
            throw new Exception("The vertex No. " + v + " does not exist.");
        }
        for (int i = 0; i < vertexAmount; i++) {
            if (adjacentMatrix[v][i] != 0 && adjacentMatrix[v][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int nextAdjacentVertex(int v, int w) throws Exception {
        if (v <= 0 || v >= vertexAmount) {
            throw new Exception("The vertex No. " + v + " does not exist.");
        }
        for (int i = w + 1; i < vertexAmount; i++) {
            if (adjacentMatrix[v][i] != 0 && adjacentMatrix[v][i] < INFINITY) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int[] findVertexesByArc(int weightOfArc) {
        int[] result = new int[2];
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = i; j < vertexAmount; j++) {
                if (adjacentMatrix[i][j] == weightOfArc) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public void display() {
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                if (adjacentMatrix[i][j] == INFINITY) {
                    System.out.print("* ");
                } else {
                    System.out.print(adjacentMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public List<Object> primAlgorithm(Object beginningVertex) {
        int indexOfBeginningVertex = locateVertex(beginningVertex);
        int[] weights = new int[vertexAmount];
        List<Object> prims = new ArrayList<>();
        prims.add(vertexes[indexOfBeginningVertex]);

        // Initialize the weight of the 1st vertex connected to other vertex
        for (int i = 0; i < vertexAmount; i++) {
            weights[i] = adjacentMatrix[indexOfBeginningVertex][i];
        }
        weights[indexOfBeginningVertex] = 0;

//        System.out.print("Initial weights: ");
//        for (int i : weights) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        for (int i = 0; i < vertexAmount; i++) {
            if (i == indexOfBeginningVertex) {
                continue;
            }
            int j = 0, indexOfMinAdVertex = 0, min = INFINITY;
            while (j < vertexAmount) {
                if (weights[j] != 0 && weights[j] < min) {
                    min = weights[j];
                    indexOfMinAdVertex = j;
                }
                j++;
            }
            prims.add(vertexes[indexOfMinAdVertex]);
            System.out.println("Add: " + vertexes[indexOfMinAdVertex]);
            weights[indexOfMinAdVertex] = 0;
            for (j = 0; j < vertexAmount; j++) {
                if (weights[j] != 0 && weights[j] > adjacentMatrix[indexOfMinAdVertex][j]) {
                    weights[j] = adjacentMatrix[indexOfMinAdVertex][j];
                }
            }
        }
        System.out.println("Minimum spanning tree(Prim's algorithm):\n" + prims.toString());
        return prims;
    }

    public void kruskalAlgorithm() {
        DisjointSet disjointSet = new DisjointSet(vertexAmount);
        int[] weightsOfArcs = new int[arcAmount];
        int indexOfWeightsOfArcs = 0;
        for (int i = 0; i < vertexAmount; i++) {
            for (int j = 0; j < vertexAmount; j++) {
                if (i > j) {
                    if (adjacentMatrix[i][j] != INFINITY) {
                        weightsOfArcs[indexOfWeightsOfArcs] = adjacentMatrix[i][j];
                        indexOfWeightsOfArcs++;
                    }
                }
            }
        }
        sort(weightsOfArcs);
        indexOfWeightsOfArcs = 0;

        for (int i = 0; i < arcAmount; i++) {
            int[] indexOfVertexes = findVertexesByArc(weightsOfArcs[indexOfWeightsOfArcs]);
            int root0 = disjointSet.findRoot(indexOfVertexes[0]);
            int root1 = disjointSet.findRoot(indexOfVertexes[1]);
            if (root0 != root1) {

                disjointSet.union(indexOfVertexes[0], indexOfVertexes[1]);
                System.out.println(vertexes[indexOfVertexes[0]] + "--" + weightsOfArcs[indexOfWeightsOfArcs] + "--" + vertexes[indexOfVertexes[1]]);
            }
            System.out.println(disjointSet.getParent());
            indexOfWeightsOfArcs++;
        }
    }
}
