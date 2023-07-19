import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Enumeration of task types
 */
public enum TaskType {
    ACTIVATION("sim-services","simservice.ws.url", "/sims/bulk/activation","/stopTask",1, 1000, 100),
    IMPORT("ip-services","ipservice.ws.url","/ip/bulk/import","/stopTask",2,1000, 100),
    GROUP_MODIFICATION("sim-services","simservice.ws.url","/sims/bulk/changeGroup","/stopTask",2, 1000, 100);

    private String targetTreatmentService;
    private String targetPathPrefix;
    private String targetTreatmentEndPoint;
    private String targetCancelEndPoint;
    private Integer defaultPriority;
    private Integer priorityCountThreshold;
    private Integer pagination;

    TaskType(String targetTreatmentService, String targetPathPrefix, String targetTreatmentEndPoint, String targetCancelEndPoint, Integer defaultPriority, Integer priorityCountThreshold, Integer pagination) {
        this.targetTreatmentService = targetTreatmentService;
        this.targetPathPrefix = System.getenv(targetPathPrefix);
        this.targetTreatmentEndPoint = targetTreatmentEndPoint;
        this.targetCancelEndPoint = targetCancelEndPoint;
        this.defaultPriority = defaultPriority;
        this.priorityCountThreshold = priorityCountThreshold;
        this.pagination = pagination;
    }

    public List<String> getAllTargetTreatmentService(){
        HashSet<String> setService = new HashSet<>();
        for (TaskType type:TaskType.values()) {
            setService.add(type.getTargetTreatmentService());
        }
        List<String> listService = new ArrayList<>(setService);
        return listService;
    }

    public String getTargetTreatmentService() {
        return targetTreatmentService;
    }

    public String getTargetTreatmentEndPoint() {
        return targetTreatmentEndPoint;
    }

    public String getTargetCancelEndPoint() {
        return targetCancelEndPoint;
    }
    public String getTargetPathPrefix() {
        return targetPathPrefix;
    }

    public Integer getDefaultPriority() {
        return defaultPriority;
    }

    public Integer getPagination() {
        return pagination;
    }

    public Integer getPriorityCountThreshold() {
        return priorityCountThreshold;
    }

    public void setTargetTreatmentService(String targetTreatmentService) {
        this.targetTreatmentService = targetTreatmentService;
    }

    public void setTargetPathPrefix(String targetPathPrefix) {
        this.targetPathPrefix = targetPathPrefix;
    }

    public void setTargetTreatmentEndPoint(String targetTreatmentEndPoint) {
        this.targetTreatmentEndPoint = targetTreatmentEndPoint;
    }

    public void setTargetCancelEndPoint(String targetCancelEndPoint) {
        this.targetCancelEndPoint = targetCancelEndPoint;
    }

    public void setDefaultPriority(Integer defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    public void setPriorityCountThreshold(Integer priorityCountThreshold) {
        this.priorityCountThreshold = priorityCountThreshold;
    }

    public void setPagination(Integer pagination) {
        this.pagination = pagination;
    }

}
