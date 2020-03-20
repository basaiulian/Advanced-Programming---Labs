
public class Matching {
    private Hospital hospital;
    private Resident resident;

    public Matching() {
    }

    public Matching(Hospital hospital) {
        this.hospital = hospital;
    }

    public Matching(Resident resident) {
        this.resident = resident;
    }

    public Matching(Hospital hospital, Resident resident) {
        this.hospital = hospital;
        this.resident = resident;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "\nMatching{" +
                "hospital=" + hospital +
                ", resident=" + resident +
                "}";
    }
}