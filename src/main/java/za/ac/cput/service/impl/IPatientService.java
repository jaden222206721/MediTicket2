package za.ac.cput.service.impl;

import za.ac.cput.domain.user.Patient;

import java.util.List;

public interface IPatientService extends IService <Patient,Integer > {

    List<Patient> getAll();
}
