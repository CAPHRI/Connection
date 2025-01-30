package bayes;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
    public enum AttributeType {bool, string, numeric, real}

    //Simplified Class for WebRequests that require communicating about Nodes
    private List<String> parents = new ArrayList<>();
    private String name;
    private AttributeType type;
    private List<Theta> probabilities = new ArrayList<>();
    private Set<Bin> bins = new HashSet<>();

    public Set<Bin> getBins() {
        return bins;
    }

    public void setBins(Set<Bin> bins) {
        this.bins = bins;
    }

    public List<Theta> getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(List<Theta> probabilities) {
        this.probabilities = probabilities;
    }

    public List<String> getParents() {
        return parents;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node.AttributeType getType() {
        return type;
    }

    public void setType(Node.AttributeType type) {
        this.type = type;
    }
}
