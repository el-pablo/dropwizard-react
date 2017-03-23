package org.elpablo.beer;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by thomap12 on 23/03/17.
 */
public class Beer {

    private final int id;
    @Length(max = 20)
    private final String name;
    private final double strength;

    public Beer(int id, String name, double strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public double getStrength() {
        return strength;
    }
}
