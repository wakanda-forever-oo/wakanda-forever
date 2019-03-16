package wakandaforever.wakandaforever.views.farmobjectlist;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.BaseDrawerActivity;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsActivity;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsFragment;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsPresenter;

public class FarmObjectListActivity
        extends BaseDrawerActivity
        implements FarmObjectListContracts.Navigator {
    public static final long IDENTIFIER = 49;

    @Inject
    FarmObjectListFragment mFarmObjectListFragment;

    @Inject
    FarmObjectListContracts.Presenter mFarmObjectListPresenter;

    @Inject
    FarmObjectDetailsFragment mFarmObjectDetailsFragment;

    @Inject
    FarmObjectDetailsPresenter mFarmObjectDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_object_list);

        ButterKnife.bind(this);

        setSupportActionBar(getToolbar());

        mFarmObjectListFragment.setNavigator(this);
        mFarmObjectListFragment.setPresenter(mFarmObjectListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFarmObjectListFragment);

        if (!isPhone()) {
            mFarmObjectDetailsFragment.setPresenter(mFarmObjectDetailsPresenter);
            transaction.replace(R.id.content_details, mFarmObjectDetailsFragment);
        }

        transaction.commit();
    }

    private boolean isPhone() {
        return findViewById(R.id.content_details) == null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void navigateWith(FarmObject farmObject) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    FarmObjectDetailsActivity.class
            );

            intent.putExtra(FarmObjectDetailsActivity.EXTRA_KEY, farmObject);

            startActivity(intent);
        } else {
            //mFarmObjectDetailsPresenter.setFarmObjectId(farmObject.getId());
            mFarmObjectDetailsPresenter.loadFarmObject();
        }
    }
}

