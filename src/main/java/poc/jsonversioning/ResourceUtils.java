package poc.jsonversioning;


import java.io.UnsupportedEncodingException;

public class ResourceUtils {

    public static ResourceV3 getLatest(Resource resource) throws UnsupportedEncodingException {
        if (resource instanceof ResourceV3) {
            return (ResourceV3) resource;
        } else if (resource instanceof ResourceV2) {
            return upgradeV2ToV3((ResourceV2) resource);
        }  else if (resource instanceof ResourceV1) {
            return upgradeV2ToV3(upgradeV1ToV2((ResourceV1) resource));
        } else {
            throw new UnsupportedEncodingException();
        }
    }

    private static poc.jsonversioning.ResourceV2 upgradeV1ToV2(ResourceV1 resource){
        ResourceV2 resource2 = new ResourceV2();
        String[] breakdown = resource.getDate().split(",");
        resource2.setMonth(breakdown[0].trim());
        breakdown = breakdown[1].split("\\s+");
        resource2.setDay(Integer.parseInt(breakdown[0].trim()));
        resource2.setYear(Integer.parseInt(breakdown[1].trim()));
        return resource2;
    }

    private static ResourceV3 upgradeV2ToV3(ResourceV2 resource2){
        ResourceV3 resource3 = new ResourceV3();
        resource3.setDay(resource2.getDay());
        resource3.setMonth(resource2.getMonth());
        resource3.setYear(resource2.getYear());
        resource3.setStatus("Open"); // Default value
        return resource3;
    }


}
