package poc.jsonversioning;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include=JsonTypeInfo.As.PROPERTY, property="version", defaultImpl = Resource.class)
@JsonSubTypes({
    @Type(name="v1", value= ResourceV1.class),
    @Type(name="v2", value= ResourceV2.class),
    @Type(name="v3", value= ResourceV3.class)
})
public interface Resource {}