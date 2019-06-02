package refreshing_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Ignacio_Gonzalez
 */
public class Graph {

    private Map<Vertex, List<Vertex>> adjVertices;

    public Graph() {
        this.adjVertices=new HashMap<>();
    } 

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public void setAdjVertices(Map<Vertex, List<Vertex>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    void remoVertex(String label) {
        Vertex v = new Vertex(label);
        //Iter among the values (list of vertex) and iter among the vertex of each list
        //if i find any vertex v, i delete it so I end up deleting all the relationships with vertex V of every vertex in the graph
        adjVertices.values().stream().forEach(e -> e.remove(v));
        //Then, I delete the key. Namely, I delete vertex v itself
        //Now, there is no trace of vertex V nor its relationships.
        adjVertices.remove(new Vertex(label));
    }

    void addEdge(String label1, String label2) {
        //The purpose of this function is removing relatioships without removing vertex. For example, I Rob and ALice quite being friends, no one died
        //the relationship stops working
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null) {
            eV1.remove(v2);
        }
        if (eV2 != null) {
            eV2.remove(v1);
        }
    }

    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
}

class Vertex {

    String label;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.label);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertex other = (Vertex) obj;
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return label;
    }
    

}
