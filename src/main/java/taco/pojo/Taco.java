package taco.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Taco {

    private String name;
    private String cheese;
    private String protein;
    private String sauce;
    private String veggies;
    private String wrap;

}
