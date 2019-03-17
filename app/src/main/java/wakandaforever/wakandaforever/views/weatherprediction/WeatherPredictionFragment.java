package wakandaforever.wakandaforever.views.weatherprediction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Prediction;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectAdapter;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListContracts;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherPredictionFragment
        extends android.app.Fragment
        implements WeatherPredictionContracts.View, WeatherPredictionAdapter.OnFarmObjectClickListener {
    private WeatherPredictionContracts.Navigator mNavigator;

    @BindView(R.id.lv_weatherpredictions)
    RecyclerView mFarmObjectsView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

//    @BindView(R.id.et_filter)
//    EditText mFilterEditText;

    @Inject
    WeatherPredictionAdapter mFarmObjectAdapter;

    private WeatherPredictionContracts.Presenter mPresenter;
    private GridLayoutManager mFarmObjectViewLayoutManager;

    @Inject
    public WeatherPredictionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_prediction, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mFarmObjectsView.setAdapter(mFarmObjectAdapter);
        mFarmObjectViewLayoutManager = new GridLayoutManager(getContext(), 1);
        mFarmObjectsView.setLayoutManager(mFarmObjectViewLayoutManager);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadFarmObjects();
    }

    @Override
    public void setPresenter(WeatherPredictionContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showFarmObjects(List<Prediction> predictions) {
        mFarmObjectAdapter.clear();
        mFarmObjectAdapter.addAll(predictions);
        mFarmObjectAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyFarmObjectsList() {
        Toast.makeText(getContext(),
                "No farm objects",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mFarmObjectsView.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mFarmObjectsView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

    void setNavigator(WeatherPredictionContracts.Navigator navigator) {
        mNavigator = navigator;
    }

    @Override
    public void onClick(FarmObject farmObject) {

    }

//    @OnTextChanged(R.id.et_filter)
//    public void onTextChanged() {
////        String pattern = mFilterEditText.getText().toString();
////        mPresenter.filterFarmObjects(pattern);
//    }

//    public void alert(){
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        alert.setTitle("Android Studio");
//        alert.setMessage("DO you love Android?");
//        alert.create().show();
//    }
}
