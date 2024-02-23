package org.example;

public class Candidate {
    private final String name;
    private int points;

    public Candidate(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void add(int points) {
        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){return false; }
        if(!(obj instanceof Candidate)){ return false; }
        return name.equals(((Candidate)obj).getName());
    }
}
