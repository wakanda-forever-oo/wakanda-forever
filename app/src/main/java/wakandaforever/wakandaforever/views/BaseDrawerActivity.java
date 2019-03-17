package wakandaforever.wakandaforever.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.views.TemperatureGraph.TemperatureGraphActivity;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectListActivity;
import wakandaforever.wakandaforever.views.weatherprediction.WeatherPredictionActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem listFarmObjectsItem = new PrimaryDrawerItem()
                .withIdentifier(FarmObjectListActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Farm Objects");

        PrimaryDrawerItem graph = new PrimaryDrawerItem()
                .withIdentifier(TemperatureGraphActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Temperature Graph");

        PrimaryDrawerItem prediction = new PrimaryDrawerItem()
                .withIdentifier(WeatherPredictionActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Weather Prediction");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        listFarmObjectsItem,
                        new DividerDrawerItem(),
                        graph,
                        new DividerDrawerItem(),
                        prediction
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == TemperatureGraphActivity.IDENTIFIER) {
            return new Intent(this, TemperatureGraphActivity.class);
        }
        else if (identifier == WeatherPredictionActivity.IDENTIFIER) {
            return new Intent(this, WeatherPredictionActivity.class);
        }

        else if (identifier == FarmObjectListActivity.IDENTIFIER){
            return new Intent(this, FarmObjectListActivity.class);
        }

        return null;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    protected abstract long getIdentifier();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}

