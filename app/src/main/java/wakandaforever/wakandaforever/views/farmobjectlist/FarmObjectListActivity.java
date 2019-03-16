package wakandaforever.wakandaforever.views.farmobjectlist;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import wakandaforever.wakandaforever.R;

public class FarmObjectListActivity
        extends DaggerAppCompatActivity
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

        mSuperheroesListFragment.setNavigator(this);
        mSuperheroesListFragment.setPresenter(mSuperheroesListPresenter);

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFarmObjectsListFragment);

        if (!isPhone()) {
            mSuperheroDetailsFragment.setPresenter(mSuperheroDetailsPresenter);
            transaction.replace(R.id.content_details, mSuperheroDetailsFragment);
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
    public void navigateWith(Superhero superhero) {
        if (isPhone()) {
            Intent intent = new Intent(
                    this,
                    SuperheroDetailsActivity.class
            );

            intent.putExtra(SuperheroDetailsActivity.EXTRA_KEY, superhero);

            startActivity(intent);
        } else {
            mSuperheroDetailsPresenter.setSuperheroId(superhero.getId());
            mSuperheroDetailsPresenter.loadSuperhero();
        }
    }
}

