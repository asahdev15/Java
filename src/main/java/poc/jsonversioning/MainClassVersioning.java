package poc.jsonversioning;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClassVersioning {

    public static void main(String[] args) throws Exception{

        String json1 = "{\"date\" : \"March,30 2018\", \"version\": \"v1\"}";
        String json2 = "{\"day\" : \"30\",\"month\": \"3\", \"year\": \"2018\",\"version\": \"v2\"}";
        String json3 = "{\"day\" : \"30\",\"month\": \"3\", \"year\": \"2018\",\"status\": \"Open\" ,\"version\": \"v3\"}";

        Resource resource1 = getResource(json1);
        System.out.println(resource1);

        Resource resource2 = getResource(json2);
        System.out.println(resource2);

        Resource resource3 = getResource(json3);
        System.out.println(resource3);

        System.out.println(poc.jsonversioning.ResourceUtils.getLatest(resource1));

    }

    private static Resource getResource(String json) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Resource.class);
    }
}
