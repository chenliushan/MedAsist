package polyu.comp.hackathon.medicalrecorder.service;

import java.util.List;

import polyu.comp.hackathon.medicalrecorder.domain.Record;

/**
 * Created by liushanchen on 16/2/20.
 */
public class RecordResponse {
   private List<Record> Record;
   private String countItem;
   private String pageNum;
   private Error Error;//this can be null when success

   public RecordResponse(List<Record> records, String countItem, String pageNum, Error error) {
      this.Record = records;
      this.countItem = countItem;
      this.pageNum = pageNum;
      this.Error = error;
   }

   public List<Record> getRecords() {
      return Record;
   }

   public void setRecords(List<Record> records) {
      this.Record = records;
   }

   public String getCountItem() {
      return countItem;
   }

   public void setCountItem(String countItem) {
      this.countItem = countItem;
   }

   public String getPageNum() {
      return pageNum;
   }

   public void setPageNum(String pageNum) {
      this.pageNum = pageNum;
   }

   public Error getError() {
      return Error;
   }

   public void setError(Error error) {
      this.Error = error;
   }
}
