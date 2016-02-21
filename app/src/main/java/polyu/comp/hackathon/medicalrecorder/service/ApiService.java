package polyu.comp.hackathon.medicalrecorder.service;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

import polyu.comp.hackathon.medicalrecorder.constant.CommonConstant;
import polyu.comp.hackathon.medicalrecorder.domain.Inspection;
import polyu.comp.hackathon.medicalrecorder.domain.Medicine;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.client.Request;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;
import retrofit.http.QueryMap;

/**
 * Created by liushanchen on 16/2/20.
 */
public interface ApiService {
    @GET("/patientlogin.php")
    void getTest(@QueryMap Map<String, String> parameters, Callback<LoginResponse> callback);
    @GET("/patientregister.php")
    void patientRegister(@QueryMap Map<String, String> parameters, Callback<LoginResponse> callback);
    @GET("/patientgetRecord.php")
    void recordList(@QueryMap Map<String, String> parameters, Callback<RecordResponse> callback);
    
    @GET("/patientgetInspection.php")
    void inspectionList(@QueryMap Map<String, String> parameters, Callback<InspectionResponse> callback);
    @GET("/patientregister.php")
    void medicineList(@QueryMap Map<String, String> parameters, Callback<List<Medicine>> callback);


//    @POST("/patientlogin.php")
//    void patientLogin(@Body Patient signInRequest, Callback<LoginResponse> callback);
//    @POST("/patientregister.php")
//    void patientRegister(@Body Patient signInRequest, Callback<LoginResponse> callback);
//    @POST("/records")
//    void recordList(@Body RecordRequest recordRequest, Callback<RecordResponse> recordResponseCallback);

    public static class Creator {
        private static ApiService apiService;

        public static ApiService create(final Context mycontext) {
            String apiEndpoint = CommonConstant.apiEndpoint;
            Gson gson = new GsonBuilder().create();
            RequestInterceptor requestInterceptor = new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
//                    String token = PreferenceUtils.getUser(mycontext).getToken();
//                    request.addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            };
            OkHttpClient okHttpClient = new OkHttpClient();
            OkClient okClient = new OkClient(okHttpClient) {
                @Override
                protected HttpURLConnection openConnection(Request request) throws IOException {
                    HttpURLConnection connection = super.openConnection(request);
                    connection.setReadTimeout(90000);
                    connection.setConnectTimeout(45000);
                    
                    return connection;
                }
            };
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(apiEndpoint)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setConverter(new GsonConverter(gson))
                    .setRequestInterceptor(requestInterceptor)
                    
                    .setClient(okClient)
                    .build();
            apiService = restAdapter.create(ApiService.class);
            return apiService;
        }
    }
}
