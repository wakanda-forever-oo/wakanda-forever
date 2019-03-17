package wakandaforever.wakandaforever.views.farmobjectlist;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;

public class FarmObjectListFragment
        extends Fragment
        implements FarmObjectListContracts.View, FarmObjectAdapter.OnFarmObjectClickListener {
    private FarmObjectListContracts.Navigator mNavigator;

    @BindView(R.id.lv_farmobjects)
    RecyclerView mFarmObjectsView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

//    @BindView(R.id.et_filter)
//    EditText mFilterEditText;

    @Inject
    FarmObjectAdapter mFarmObjectAdapter;

    private FarmObjectListContracts.Presenter mPresenter;
    private GridLayoutManager mFarmObjectViewLayoutManager;

    @Inject
    public FarmObjectListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_farm_object_list, container, false);

        // ButterKnife is applied
        ButterKnife.bind(this, view);

        mFarmObjectAdapter.setOnFarmObjectClickListener(this);

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
    public void setPresenter(FarmObjectListContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showFarmObjects(List<FarmObject> farmObjects) {
        mFarmObjectAdapter.clear();
        mFarmObjectAdapter.addAll(farmObjects);
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

    @Override
    public void showFarmObjectDetails(FarmObject farmObject) {
        mNavigator.navigateWith(farmObject);
    }

    void setNavigator(FarmObjectListContracts.Navigator navigator) {
        mNavigator = navigator;
    }

//    @OnTextChanged(R.id.et_filter)
//    public void onTextChanged() {
////        String pattern = mFilterEditText.getText().toString();
////        mPresenter.filterFarmObjects(pattern);
//    }

    @Override
    public void onClick(FarmObject farmObject) {
        mPresenter.selectFarmObject(farmObject);
    }

//    public void alert(){
//        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
//        alert.setTitle("Android Studio");
//        alert.setMessage("DO you love Android?");
//        alert.create().show();
//    }
}
