package java8.streams;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MappingEntity {
    private String referenceId;
    private List<MappingContextVo> mappingContexts;
}
