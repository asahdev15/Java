package java8.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MappingContextVo {
    private String datasource;
    private String fieldName;
    private String fieldValue;
    private Date startDate;
    private Date endDate;
}
