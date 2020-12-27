package poc.jsonversioning2;

import poc.jsonversioning2.annotations.JsonSince;
import poc.jsonversioning2.annotations.JsonUntil;
import poc.jsonversioning2.annotations.JsonVersionProperty;
import poc.jsonversioning2.annotations.JsonVersioned;

class MyApi {
    public static final String API_VERSION = "1.0";
}

@JsonVersioned(MyApi.API_VERSION) // This annotation is required for versioned POJOs. The version here indicate the latest version number.
public class ModelPojo {
    // This is the version attribute. Should be in the JSON body to indicate the version as well.
    @JsonVersionProperty
    private String version;  // This attribute can also be a "Version" type.
    
    @JsonSince("0.8")       // this attribute is added in version 0.8
    private String newAttrSince08;
    
    @JsonUntil("0.6")       // This attribute is deprecated in version 0.6
    private String oldAttrBefore06;
    
    private String alwaysHere;
    
    // @JsonVersionProperty, @JsonSince, and @JsonUntil can also be on the getters instead.  
    // getters and optionally, setters
}

