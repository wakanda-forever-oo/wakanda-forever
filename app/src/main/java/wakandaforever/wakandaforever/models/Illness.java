package wakandaforever.wakandaforever.models;

import java.io.Serializable;

public class Illness implements Serializable {
    private String createdAt;
    private long id;
    private String name;
    private float probability;

    public Illness(){

    }

    public Illness(String createdAt, long id, String name, float probability) {
        this.createdAt = createdAt;
        this.id = id;
        this.name = name;
        this.probability = probability;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }
}
