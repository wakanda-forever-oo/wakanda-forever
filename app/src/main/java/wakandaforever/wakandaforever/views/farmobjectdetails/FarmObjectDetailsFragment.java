package wakandaforever.wakandaforever.views.farmobjectdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;

public class FarmObjectDetailsFragment
        extends Fragment
        implements FarmObjectDetailsContracts.View {

    private FarmObjectDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_details_humidity)
    TextView mHumidityTextView;

    @BindView(R.id.tv_details_temperature)
    TextView mTemperatureTextView;

    @BindView(R.id.tv_details_waterLevel)
    TextView mWaterLevelTextView;

    @BindView(R.id.tv_details_soilMoisture)
    TextView mSoilMoistureTextView;

    @BindView(R.id.tv_details_fire)
    TextView mFireTextView;

    @BindView(R.id.tv_details_pressure)
    TextView mPressureTextView;


    private GridLayoutManager mFarmObjectDetailsViewLayoutManager;

    @Inject
    public FarmObjectDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_farm_object_details, container, false);

        ButterKnife.bind(this, view);

        List<FarmObject> farmObjects = new ArrayList<>();
        farmObjects.add(new FarmObject(1, 2, 3, 4, 5, 6, "dsadsa"));
        mFarmObjectDetailsViewLayoutManager = new GridLayoutManager(getContext(), 2);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadFarmObject();
    }

    @Override
    public FarmObject showFarmObject(FarmObject farmObject) {
        FarmObject farmObject1 = (FarmObject)getActivity().getIntent().getExtras().getSerializable("SUPERHERO_EXTRA_KEY");

        mHumidityTextView.setText(String.valueOf(farmObject1.getHumidity() + "%"));
        mTemperatureTextView.setText(String.valueOf(farmObject1.getTemperature()) + " C");
        mWaterLevelTextView.setText(String.valueOf(farmObject1.getWaterLevel())); //TODO to came with formula
        mSoilMoistureTextView.setText(String.valueOf(farmObject1.getSoilMoisture()) + "%");
        if(farmObject.getFire() > 100) {
            mFireTextView.setText("OFF");
        }else{
            mFireTextView.setText("ON");
        }
        mPressureTextView.setText(String.valueOf((int)farmObject1.getPressure()) + " kPa");
        return farmObject1;
    }

    @Override
    public void setPresenter(FarmObjectDetailsContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}


