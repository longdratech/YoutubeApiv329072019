package phamtanphat.ptp.khoaphamtraining.youtubeapi.api.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    private static Retrofit mRetrofit = null;

    private RetrofitInit() {

    }

    public static Retrofit getInstance(String base_url) {
        if (mRetrofit == null) {
            Gson gson = new GsonBuilder().setLenient().create();
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .readTimeout(10,TimeUnit.SECONDS)
                                        .writeTimeout(10,TimeUnit.SECONDS)
                                        .connectTimeout(10,TimeUnit.SECONDS)
                                        .retryOnConnectionFailure(true)
                                        .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                        .build();

            mRetrofit = new Retrofit.Builder()
                                    .client(okHttpClient)
                                    .addConverterFactory(GsonConverterFactory.create(gson))
                                    .baseUrl(base_url)
                                    .build();
        }
        return mRetrofit;
    }
}
