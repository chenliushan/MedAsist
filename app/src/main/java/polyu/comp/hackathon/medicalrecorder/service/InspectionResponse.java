package polyu.comp.hackathon.medicalrecorder.service;

import java.util.List;

import polyu.comp.hackathon.medicalrecorder.domain.Inspection;
import polyu.comp.hackathon.medicalrecorder.domain.Record;

/**
 * Created by liushanchen on 16/2/20.
 */
public class InspectionResponse {
   private Inspection Inspection;
   private Error Error;//this can be null when success


   public polyu.comp.hackathon.medicalrecorder.domain.Inspection getInspection() {
      return Inspection;
   }

   public void setInspection(polyu.comp.hackathon.medicalrecorder.domain.Inspection inspection) {
      Inspection = inspection;
   }

   public polyu.comp.hackathon.medicalrecorder.service.Error getError() {
      return Error;
   }

   public void setError(polyu.comp.hackathon.medicalrecorder.service.Error error) {
      Error = error;
   }
}
