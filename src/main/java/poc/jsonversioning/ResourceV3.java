package poc.jsonversioning;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public class ResourceV3 extends ResourceV2 {
    private String status;
}