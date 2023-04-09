package pojo.pokemonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseData {

    public ResponseData(ArrayList<Ability> abilities, int baseExperience, ArrayList<Form> forms, int weight) {
        this.abilities = abilities;
        this.forms = forms;
        this.weight = weight;
    }

    public ResponseData() {
        super();
    }

    private ArrayList<Ability> abilities;
    private ArrayList<Form> forms;
    private int weight;

    public ArrayList<Ability> getAbilities() {
        return abilities;
    }
    public ArrayList<Form> getForms() {
        return forms;
    }
    public int getWeight() {
        return weight;
    }
}
