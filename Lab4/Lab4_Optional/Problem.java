import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem {
    private List<Matching> matchingList = new ArrayList<>();
    private List<Resident> residentList = new ArrayList<>();
    private List<Hospital> hospitalList = new ArrayList<>();


    public Problem(List<Resident> residentList, List<Hospital> hospitalList) {
        this.residentList = residentList;
        this.hospitalList = hospitalList;
    }

    public List<Matching> getMatchingList() {
        return matchingList;
    }

    public void setMatchingList(List<Matching> matchingList) {
        this.matchingList = matchingList;
    }

    public List<Resident> getResidentList() {
        return residentList;
    }

    public void setResidentList(List<Resident> residentList) {
        this.residentList = residentList;
    }

    public List<Hospital> getHospitalList() {
        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
    }

    public void addMatchings(Matching ... matchings){
        Collections.addAll(matchingList, matchings);
    }

    public void addResidents(Resident ... residents){
        Collections.addAll(residentList, residents);
    }

    public void addHospitals(Hospital ... hospitals){
        Collections.addAll(hospitalList, hospitals);
    }
}
