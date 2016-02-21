package polyu.comp.hackathon.medicalrecorder.service;

import java.util.Objects;

import polyu.comp.hackathon.medicalrecorder.domain.Patient;

/**
 * Created by liushanchen on 16/2/20.
 */
public class LoginResponse {
    Error Error;
    Patient Patient;

    public polyu.comp.hackathon.medicalrecorder.service.Error getError() {
        return Error;
    }

    public void setError(polyu.comp.hackathon.medicalrecorder.service.Error error) {
        Error = error;
    }

    public polyu.comp.hackathon.medicalrecorder.domain.Patient getPatient() {
        return Patient;
    }

    public void setPatient(polyu.comp.hackathon.medicalrecorder.domain.Patient patient) {
        Patient = patient;
    }
}
