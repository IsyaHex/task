package uz.job.task.constant;

public enum CountryEnum {
    UZBEKISTAN(1),
    USA(2),
    RUSSIA(3),
    UGANDA(4),
    MONGOLIA(5),
    ENGLAND(6),
    SWEDEN(7),
    SWITZERLAND(8),
    WAKANDA(9),
    TITAN(10);

    private final Integer country;

    CountryEnum(Integer value) {
        this.country = value;
    }

    public Integer getCountry() {
        return country;
    }
}
