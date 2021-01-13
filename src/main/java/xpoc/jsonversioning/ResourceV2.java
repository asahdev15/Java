package xpoc.jsonversioning;

import lombok.Data;

@Data
public class ResourceV2 implements Resource {
   private Integer day;
   private String month;
   private Integer year;
}