package common.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pronoun {
    @JsonProperty("CustomPersonalPronoun")
    private String customPersonalPronoun;
    @JsonProperty("PersonalPronoun")
    private String personalPronoun;
    private String personalPronounId;

    public String getCustomPersonalPronoun() {
        return customPersonalPronoun;
    }

    public void setCustomPersonalPronoun(String customPersonalPronoun) {
        this.customPersonalPronoun = customPersonalPronoun;
    }

    public String getPersonalPronoun() {
        return personalPronoun;
    }

    public void setPersonalPronoun(String personalPronoun) {
        this.personalPronoun = personalPronoun;
    }

    public String getPersonalPronounId() {
        return personalPronounId;
    }

    public void setPersonalPronounId(String personalPronounId) {
        this.personalPronounId = personalPronounId;
    }
}
