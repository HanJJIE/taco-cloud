package taco.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "phone is required")
    private String phone;
    @NotBlank(message = "address is required")
    private String address;

    private Long id;
    private Date createAt;

}
