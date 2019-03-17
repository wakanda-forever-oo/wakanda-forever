package wakandaforever.wakandaforever.views.TemperatureGraph;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.BaseDrawerActivity;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsContracts;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsFragment;

public class TemperatureGraphActivity extends BaseDrawerActivity {
    public static final String EXTRA_KEY = "SUPERHERO_EXTRA_KEY";

    public static final long IDENTIFIER = 50;

    @Inject
    TemperatureGraphFragment mTemperatureGraphFragment;

    @Inject
    TemperatureGraphContracts.Presenter mTemperatureGraphPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_graph);

        ButterKnife.bind(this);

//        mSuperheroDetailsPresenter.setSuperheroId(superhero.getId());
        mTemperatureGraphFragment.setPresenter(mTemperatureGraphPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mTemperatureGraphFragment)
                .commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}


