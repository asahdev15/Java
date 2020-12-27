package streams;

public class StreamsTest {

    public static void main(String[] args) {
        System.out.println("Testing");
//
//        Set<NodeInstanceEntity> nodeInstances = Sets.newHashSet();
//        nodeInstances.add(new NodeInstanceEntity("1","IK-1"));
//        nodeInstances.add(new NodeInstanceEntity("2","IK-2"));
//
//        List<NodeInstanceEntity> items = nodeInstances.stream().filter(item -> item.getId().equals("2")).collect(Collectors.toList());
//        items.stream().forEach(item-> item.setImportKey("IK-2New"));
//
//        Map<String, NodeInstanceEntity> nodeInstanceEntityMap = nodeInstances.stream().collect(Collectors.toMap(item -> item.getId(), item -> item));
//        System.out.println(items);
//



    }

    public static final long NO_END_DATE = 95617584000000L;
    public static final String FIELD_IMPORTKEY = "IMPORT_KEY";
    public static final String DATASOURCE_UNIT = "UNIT";
//
//    private void updateNodeInstanceMappings(Set<NodeInstanceEntity> nodeInstances, String datasource) {
//        // fetch the mappings based on nodeInstance.id
////        Date currentDate = new Date();
////        List<MappingEntity> nodeInstanceMappingsToUpdate = Lists.newArrayList();
////        Map<NodeInstanceEntity, List<MappingEntity>> nodeInstanceMappingMap = Maps.newHashMap();
////        Map<String, NodeInstanceEntity> nodeInstanceEntityMap = nodeInstances.stream().collect(Collectors.toMap(item -> item.getId(), item -> item));
////        List<MappingEntity> nodeInstanceMappings = findMappings();
////        Map<NodeInstanceEntity, MappingEntity> nodeInstanceEntityMappingMap = nodeInstanceMappings.stream().collect(Collectors.toMap(item -> nodeInstanceEntityMap.get(item.getReferenceId()), item -> item));
////        nodeInstanceEntityMappingMap.entrySet().stream().filter(entry -> entry.getValue().getMappingContexts().stream().filter(mappingContext ->
////                        mappingContext.getFieldName().equals(FIELD_IMPORTKEY) &&
////                                mappingContext.getEndDate().equals(new Date(NO_END_DATE)) &&
////                                !mappingContext.getFieldValue().equals(entry.getKey().getImportKey()) &&
////                                mappingContext.getDatasource().equals(DATASOURCE_UNIT)
////                )
////                        .findFirst()
////                        .isPresent()
////        ).forEach(entry -> entry.getValue().getMappingContexts().stream().filter(mappingContext ->
////                                mappingContext.getFieldName().equals(FIELD_IMPORTKEY) &&
////                                        mappingContext.getEndDate().equals(new Date(NO_END_DATE)) &&
////                                        !mappingContext.getFieldValue().equals(entry.getKey().getImportKey()) &&
////                                        !mappingContext.getDatasource().equals(datasource)
////                        ).forEach(item -> {
////                                                item.setFieldValue(entry.getKey().getImportKey());
////                                                item.setStartDate(currentDate);
////                                            }
////                        )
////                );
////        // update mappings.importkey value as nodeinstance.importkey (except for datasource value)
//        // persist the mappings
//    }
//
//    private static List<MappingEntity> findMappings() {
//        return Lists.newArrayList();
//    }
//

}
