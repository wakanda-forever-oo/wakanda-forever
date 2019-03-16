package wakandaforever.wakandaforever.views.farmobjectdetails;

import android.content.Intent;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.BaseDrawerActivity;

public class FarmObjectDetailsActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "SUPERHERO_EXTRA_KEY";

    @Inject
    FarmObjectDetailsFragment mSuperheroDetailsFragment;

    @Inject
    FarmObjectDetailsContracts.Presenter mSuperheroDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_object_details);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        FarmObject superhero = (FarmObject) intent.getSerializableExtra(FarmObjectDetailsActivity.EXTRA_KEY);

//        mSuperheroDetailsPresenter.setSuperheroId(superhero.getId());
        mSuperheroDetailsFragment.setPresenter(mSuperheroDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mSuperheroDetailsFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return 0;
    }
}

