package wakandaforever.wakandaforever.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import dagger.Module;
import dagger.Provides;
import wakandaforever.wakandaforever.views.farmobjectlist.FarmObjectAdapter;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<FarmObjectAdapter.FarmObjectViewHolder> farmObjectArrayAdapter(Context context) {
        return new FarmObjectAdapter();
    }
}

