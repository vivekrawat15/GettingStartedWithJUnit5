package patientIntakeSystem;

public enum Doctor {
    vivek("Vivek Rawat"),
    soniya("Soniya Panwar"),
    gurdeep("Gurdeep Singh");

    private String name;

    Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
