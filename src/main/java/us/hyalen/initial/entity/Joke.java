package us.hyalen.initial.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Joke {
    private Long id;
    private String type;
    private String setup;
    private String punchline;

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }
}
