package uz.job.task.constant;

public enum Status {
    SUCCESS(1),
    FAILED(2);

    private final Integer status;

    Status(Integer value) {
        this.status = value;
    }

    public Integer getStatus() {
        return status;
    }
}
