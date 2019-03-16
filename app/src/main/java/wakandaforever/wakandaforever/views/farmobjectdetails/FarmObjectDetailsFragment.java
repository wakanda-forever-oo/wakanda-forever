package wakandaforever.wakandaforever.views.farmobjectdetails;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;

public class FarmObjectDetailsFragment
        extends Fragment
        implements FarmObjectDetailsContracts.View {

    private FarmObjectDetailsContracts.Presenter mPresenter;

    @BindView(R.id.tv_name)
    TextView mNameTextView;

    @BindView(R.id.tv_secret_identity)
    TextView mSecretIdentityTextView;

    @Inject
    public FarmObjectDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_farm_object_details, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadFarmObject();
    }

    @Override
    public void showFarmObject(FarmObject farmObject) {
//        mNameTextView.setText(farmObject.getName());
//        mSecretIdentityTextView.setText(farmObject.getSecretIdentity());
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


