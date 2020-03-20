package com.company.lab4.compulsory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Resident residentArray[];
        residentArray = IntStream.rangeClosed(0, 3)
                .mapToObj(i -> new Resident("Resident" + i))
                .toArray(Resident[]::new);

        System.out.println("Residents = " + Arrays.toString(residentArray));

        List<Resident> residentList = new ArrayList<>();

        residentList.addAll(Arrays.asList(residentArray));

        Hospital hospitalArray[];
        hospitalArray = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Hospital("Hospital" + i, residentList))
                .toArray(Hospital[]::new);
        System.out.println("Hospitals = " + Arrays.toString(hospitalArray));

        System.out.println("Residents as a list = " + residentList);

        residentList.sort(Comparator.comparing(Resident::getName));

        System.out.println("Residents as a list(SORTED) = " + residentList);

        Set<Hospital> hospitalSet = new TreeSet<>();
        Collections.addAll(hospitalSet, hospitalArray);

        System.out.println("Hospitals as set = " + hospitalSet);

        Map<Resident, List<Hospital>> firstResidentPreferences = new HashMap<>();


        firstResidentPreferences.put(residentArray[0], Arrays.asList(hospitalArray[0], hospitalArray[1], hospitalArray[2]));
        firstResidentPreferences.put(residentArray[1], Arrays.asList(hospitalArray[0], hospitalArray[1], hospitalArray[2]));
        firstResidentPreferences.put(residentArray[2], Arrays.asList(hospitalArray[0], hospitalArray[1]));
        firstResidentPreferences.put(residentArray[3], Arrays.asList(hospitalArray[0], hospitalArray[2]));

        System.out.println("\nfirstResidentPreferences:");
        System.out.println(firstResidentPreferences);

        Map<Resident, List<Hospital>> secondResidentPreferences = new LinkedHashMap<>(firstResidentPreferences);

        secondResidentPreferences.keySet().forEach(key -> System.out.println(key + "" + secondResidentPreferences.get(key)));

        System.out.println("\nsecondResidentPreferences:");

        residentArray[0].addHospital(hospitalArray[0], hospitalArray[1], hospitalArray[2]);
        residentArray[1].addHospital(hospitalArray[0], hospitalArray[1], hospitalArray[2]);
        residentArray[2].addHospital(hospitalArray[0], hospitalArray[1]);
        residentArray[3].addHospital(hospitalArray[0], hospitalArray[2]);

        List<Resident> residentsAcceptingHospital0;
        residentsAcceptingHospital0 = residentList.stream()
                .filter(resident -> resident.getHospitalList().stream().anyMatch(hospital -> hospital.getName().equals("Hospital0")))
                .filter(resident -> resident.getHospitalList().stream().anyMatch(hospital -> hospital.getName().equals("Hospital2")))
                .collect(Collectors.toList());
        System.out.println("\n\nResidents accepting 'Hospital0' and  'Hospital2' hospitals: \n" + residentsAcceptingHospital0);

        List<Hospital> hospitalList = new ArrayList<>();

        hospitalList.addAll(Arrays.asList(hospitalArray));

        hospitalArray[0].addResident(residentArray[3], residentArray[0], residentArray[1], residentArray[2]);
        hospitalArray[1].addResident(residentArray[0], residentArray[2], residentArray[1]);
        hospitalArray[2].addResident(residentArray[0], residentArray[1], residentArray[3]);


        List<Hospital> hospitalAcceptingResident0;
        hospitalAcceptingResident0 = hospitalList.stream()
                .filter(hospital -> hospital.getResidentList().get(0).getName().equals(residentArray[0].getName()))
                .collect(Collectors.toList());

        System.out.println("\n\nHospitals accepting 'Resident0' as first option: \n" + hospitalAcceptingResident0);

    }


}
