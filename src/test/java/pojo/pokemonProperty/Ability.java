package pojo.pokemonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Ability extends AbilityItem {

    public Ability(String name, String url, Ability ability, boolean is_hidden, int slot) {
        super(name, url);
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public Ability() {
        super();
    }

    private Ability ability;
    private boolean is_hidden;
    private int slot;

    public Ability(Ability ability, boolean is_hidden, int slot) {
        this.ability = ability;
        this.is_hidden = is_hidden;
        this.slot = slot;
    }

    public Ability getAbility() {
        return ability;
    }
    public boolean isIs_hidden() {
        return is_hidden;
    }
    public int getSlot() {
        return slot;
    }
}
