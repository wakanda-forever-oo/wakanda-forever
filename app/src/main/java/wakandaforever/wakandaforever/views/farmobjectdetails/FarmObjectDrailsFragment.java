package wakandaforever.wakandaforever.views.farmobjectdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectAdapter;

public class FarmObjectDrailsFragment{
//        extends Fragment
//        implements FarmObjectDetailsContracts.View {
//
//    private FarmObjectDetailsContracts.Presenter mPresenter;
//
//    @BindView(R.id.tv_details_humidity)
//    TextView mHumidityTextView;
//
//    @BindView(R.id.tv_details_temperature)
//    TextView mTemperatureTextView;
//
//    @BindView(R.id.tv_details_waterLevel)
//    TextView mWaterLevelTextView;
//
//    @BindView(R.id.tv_details_soilMoisture)
//    TextView mSoilMoistureTextView;
//
//    @BindView(R.id.tv_details_fire)
//    TextView mFireTextView;
//
//    @BindView(R.id.tv_details_pressure)
//    TextView mPressureTextView;
//
//    @BindView(R.id.tv_details_createdAt)
//    TextView mCreatedAtTextView;
//
//    @BindView(R.id.lv_farmobjectdetails)
//    RecyclerView mFarmObjectDetailsView;
//
//    @Inject
//    FarmObjectDetailsAdapter mFarmObjectDetailsAdapter;
//
//    @Inject
//    public FarmObjectDrailsFragment() {
//        // Required empty public constructor
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_farm_object_details, container, false);
//
//        ButterKnife.bind(this, view);
//
//        mFarmObjectDetailsView.setAdapter(mFarmObjectDetailsAdapter);
//        mFarmObjectDetailViewLayoutManager = new GridLayoutManager(getContext(), 1);
//        mFarmObjectsView.setLayoutManager(mFarmObjectViewLayoutManager);
//
//        return view;
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mPresenter.subscribe(this);
//        mPresenter.loadFarmObject();
//    }
//
//    @Override
//    public FarmObject showFarmObject(FarmObject farmObject) {
////        mNameTextView.setText(farmObject.getName());
////        mSecretIdentityTextView.setText(farmObject.getSecretIdentity());
//        return new FarmObject();
//    }
//
//    @Override
//    public void setPresenter(FarmObjectDetailsContracts.Presenter presenter) {
//        mPresenter = presenter;
//    }
//
//    @Override
//    public void showError(Throwable e) {
//
//    }
//
//    @Override
//    public void showLoading() {
//
//    }
//
//    @Override
//    public void hideLoading() {
//
//    }
}

