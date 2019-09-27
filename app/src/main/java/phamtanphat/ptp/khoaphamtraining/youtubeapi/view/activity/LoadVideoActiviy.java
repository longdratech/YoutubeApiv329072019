package phamtanphat.ptp.khoaphamtraining.youtubeapi.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import phamtanphat.ptp.khoaphamtraining.youtubeapiv329072019.R;

public class LoadVideoActiviy extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {


    YouTubePlayerView youTubePlayerView;
    String API_KEY = "AIzaSyAhKNr7hCcAkYiwSeWNmHePoxHjvV8H3Uc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   youTubePlayerView = findViewById(R.id.youtubePlayerview);

        youTubePlayerView.initialize(API_KEY, this);
//        https://www.googleapis.com/youtube/v3/search?part=snippet&q=android&maxResults=50&type=video&key=AIzaSyDw1xWgw-tzAEnKhPUpCPEpNXTwbs3e6hY
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("d9xm3kXffGo");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(LoadVideoActiviy.this, 123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {

            youTubePlayerView.initialize(API_KEY, this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

//https://developers.google.com/youtube/android/player/downloads/