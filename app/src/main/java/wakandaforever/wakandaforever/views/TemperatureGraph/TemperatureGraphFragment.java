package wakandaforever.wakandaforever.views.TemperatureGraph;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.views.farmobjectdetails.FarmObjectDetailsContracts;

public class TemperatureGraphFragment
        extends Fragment
        implements TemperatureGraphContracts.View {

    private TemperatureGraphContracts.Presenter mPresenter;

    @BindView(R.id.graph)
    GraphView graphView;

    @BindView(R.id.humidity_bar)
    GraphView barView;

    @BindView(R.id.soilMoisture_point)
    GraphView soilMoistureGraph;

    @Inject
    public TemperatureGraphFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temperature_graph, container, false);

        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        List<FarmObject> farmObjects = new OkHttpHttpRequester().getAllFarmObjects();
        DataPoint[] dataPoints = new DataPoint[farmObjects.size()];
        for (int i = 0; i < dataPoints.length; i++){
            dataPoints[i] = new DataPoint(i, farmObjects.get(i).getTemperature());
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dataPoints);
        graph.addSeries(series);

        GraphView bar = (GraphView) view.findViewById(R.id.humidity_bar);
        DataPoint[] barDataPoints = new DataPoint[farmObjects.size()];
        for (int i = 0; i < barDataPoints.length; i++){
            barDataPoints[i] = new DataPoint(i, farmObjects.get(i).getHumidity());
        }
        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<DataPoint>(barDataPoints
        );
        bar.addSeries(series2);
//
//        GraphView point = (GraphView) view.findViewById(R.id.soilMoisture_point);
//        DataPoint[] soilMoistureDataPoints = new DataPoint[farmObjects.size()];
//        for (int i = 0; i < soilMoistureDataPoints.length; i++){
//            soilMoistureDataPoints[i] = new DataPoint(i, farmObjects.get(i).getSoilMoisture());
//        }
//        PointsGraphSeries<DataPoint> series3 = new PointsGraphSeries<DataPoint>(soilMoistureDataPoints
//        );
//        point.addSeries(series3);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
    }

    @Override
    public void setPresenter(TemperatureGraphContracts.Presenter presenter) {
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



