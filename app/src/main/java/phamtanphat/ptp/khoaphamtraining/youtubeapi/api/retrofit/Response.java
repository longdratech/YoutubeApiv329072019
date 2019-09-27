package phamtanphat.ptp.khoaphamtraining.youtubeapi.api.retrofit;

public class Response {
    private final static String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public static RequestApi getAPI(){
        return RetrofitInit.getInstance(BASE_URL).create(RequestApi.class);
    }
}
