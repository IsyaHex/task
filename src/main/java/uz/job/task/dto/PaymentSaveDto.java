package uz.job.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import uz.job.task.entity.Invoice;

import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

public class PaymentSaveDto {

    private Long id;
    private ZonedDateTime time;
    @JsonProperty
    private String status;
    @JsonProperty
    private double amount;
    @NotBlank
    @JsonProperty
    private Invoice invoice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
