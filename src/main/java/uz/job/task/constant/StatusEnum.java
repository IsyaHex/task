package uz.job.task.constant;

public enum StatusEnum {
    SUCCESS(1),
    FAILED(2);

    private final Integer status;

    StatusEnum(Integer value) {
        this.status = value;
    }

    public Integer getStatus() {
        return status;
    }
}
