package pojo.pokemonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Form {

    public Form(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Form() {
        super();
    }

    private String name;
    private String url;

    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }
}
