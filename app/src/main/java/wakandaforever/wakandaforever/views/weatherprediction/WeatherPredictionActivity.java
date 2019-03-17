package wakandaforever.wakandaforever.views.weatherprediction;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.views.BaseDrawerActivity;

public class WeatherPredictionActivity extends BaseDrawerActivity
        implements WeatherPredictionContracts.Navigator {

    public static final long IDENTIFIER = 235;

    @Inject
    WeatherPredictionFragment mWeatherPredictionFragment;

    @Inject
    WeatherPredictionContracts.Presenter mWeatherPredictionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_prediction);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mWeatherPredictionFragment.setNavigator(this);
        mWeatherPredictionFragment.setPresenter(mWeatherPredictionPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mWeatherPredictionFragment);

        transaction.commit();
    }

    private boolean isPhone() {
        return true;
        //return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
