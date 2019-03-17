package wakandaforever.wakandaforever.views.weatherprediction;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Illness;
import wakandaforever.wakandaforever.models.Prediction;

public class WeatherPredictionAdapter extends RecyclerView.Adapter<WeatherPredictionAdapter.FarmObjectViewHolder> {
    private List<Prediction> mFarmObjects;

    @Inject
    public WeatherPredictionAdapter() {
        mFarmObjects = new ArrayList<>();
    }

    @NonNull
    @Override
    public WeatherPredictionAdapter.FarmObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_prediction_item, parent, false);
        int height = parent.getMeasuredHeight() / 2 - 150;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new WeatherPredictionAdapter.FarmObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherPredictionAdapter.FarmObjectViewHolder holder, int position) {
        holder.bind(mFarmObjects.get(position));
    }

    @Override
    public int getItemCount() {
        return mFarmObjects.size();
    }

    public Prediction getItem(int position) {
        return mFarmObjects.get(position);
    }

    public void clear() {
        mFarmObjects.clear();
    }

    public void addAll(List<Prediction> predictions) {
        mFarmObjects.addAll(predictions);
    }

    public static class FarmObjectViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_wp_datetime)
        TextView mDatetimeView;

        @BindView(R.id.tv_wp_grnd_level)
        TextView mGrndLevelView;

        @BindView(R.id.tv_wp_humidity)
        TextView mHumidityView;

        @BindView(R.id.tv_wp_pressure)
        TextView mPressureView;

        @BindView(R.id.tv_wp_sea_level)
        TextView mSeaLevelView;

        @BindView(R.id.tv_wp_temperature)
        TextView mTemperatureView;

        @BindView(R.id.tv_wp_temperature_max)
        TextView mTemperatureMaxView;

        @BindView(R.id.tv_wp_temperature_min)
        TextView mTemperatureMinView;

        @BindView(R.id.tv_wp_wind_speed)
        TextView mWindSpeedView;

        private Prediction mFarmObject;

        public FarmObjectViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(Prediction prediction) {
            mDatetimeView.setText("Time: " + String.valueOf(prediction.getDatetime()));
            mGrndLevelView.setText("Grnd level: " + String.valueOf(prediction.getGrnd_level()));
            mHumidityView.setText("Humidity: " + String.valueOf(prediction.getHumidity()));
            mPressureView.setText("Pressure: " + String.valueOf(prediction.getPressure()));
            mSeaLevelView.setText("Sea level: " + String.valueOf(prediction.getSea_level()));
            mTemperatureView.setText("Temperature: " + String.valueOf(prediction.getTemperature()));
            mTemperatureMaxView.setText("Temeprature Max: " + String.valueOf(prediction.getTemperature_max()));
            mTemperatureMinView.setText("Temperature Min: " + String.valueOf(prediction.getTemperature_min()));
            mWindSpeedView.setText("Wind Speed: " + String.valueOf(prediction.getWind_speed()));
//            mSecretIdentityTextView.setText(farmObject.getSecretIdentity());
//            Picasso.get()
//                    .load(farmObject.getImageUrl())
//                    .into(mFarmObjectImageView);
            mFarmObject = prediction;
        }
    }

    interface OnFarmObjectClickListener {
        void onClick(FarmObject farmObject);
    }
}


