package wakandaforever.wakandaforever.views.farmobjectlist;

import android.app.AlertDialog;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wakandaforever.wakandaforever.R;
import wakandaforever.wakandaforever.http.OkHttpHttpRequester;
import wakandaforever.wakandaforever.models.FarmObject;
import wakandaforever.wakandaforever.models.Illness;

public class FarmObjectAdapter extends RecyclerView.Adapter<FarmObjectAdapter.FarmObjectViewHolder> {
    private List<FarmObject> mFarmObjects;
    private OnFarmObjectClickListener mOnFarmObjectClickListener;

    @Inject
    public FarmObjectAdapter() {
        mFarmObjects = new ArrayList<>();
    }

    @NonNull
    @Override
    public FarmObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.farm_object_item, parent, false);
        int height = parent.getMeasuredHeight() / 5;
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        lp.height = height;
        view.setLayoutParams(lp);
        view.setMinimumHeight(height);
        return new FarmObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmObjectViewHolder holder, int position) {
        holder.setOnClickListener(mOnFarmObjectClickListener);
        holder.bind(mFarmObjects.get(position));
    }

    @Override
    public int getItemCount() {
        return mFarmObjects.size();
    }

    public FarmObject getItem(int position) {
        return mFarmObjects.get(position);
    }

    public void clear() {
        mFarmObjects.clear();
    }

    public void addAll(List<FarmObject> farmObjects) {
        mFarmObjects.addAll(farmObjects);
    }

    public void setOnFarmObjectClickListener(OnFarmObjectClickListener onFarmObjectClickListener) {
        this.mOnFarmObjectClickListener = onFarmObjectClickListener;
    }

    public static class FarmObjectViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_date)
        TextView mDateTextView;
        @BindView(R.id.tv_time)
        TextView mTimeTextView;
        @BindView(R.id.button_alert)
        Button alertButton;

        private OnFarmObjectClickListener mOnClickListener;
        private FarmObject mFarmObject;

        public FarmObjectViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            alertButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<Illness> illness = new OkHttpHttpRequester().getIllnessFarmObject(mFarmObject.getId());
                    AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                    alert.setTitle("Illnesses occur possibility");
                    alert.setMessage(illness.get(0).getName() + ": " + String.valueOf(illness.get(0).getProbability()) + " \n" +
                            illness.get(1).getName() + ": " + String.valueOf(illness.get(1).getProbability()) + " \n" +
                            illness.get(2).getName() + ": " + String.valueOf(illness.get(2).getProbability()) + " \n" +
                            illness.get(3).getName() + ": " + String.valueOf(illness.get(3).getProbability()));
//                    alert.setMessage(illness.get(1).getName() + ": " + String.valueOf(illness.get(1).getProbability()));
//                    alert.setMessage(illness.get(2).getName() + ": " + String.valueOf(illness.get(2).getProbability()));
//                    alert.setMessage(illness.get(3).getName() + ": " + String.valueOf(illness.get(3).getProbability()));
                    //alert.setMessage("DO you love Android?");
                    alert.create().show();
                }
            });
        }

        void bind(FarmObject farmObject) {
            mDateTextView.setText(String.valueOf(farmObject.getCreatedAt()).split(" ")[0]);
            mTimeTextView.setText(String.valueOf(farmObject.getCreatedAt()).split(" ")[1]);
//            mSecretIdentityTextView.setText(farmObject.getSecretIdentity());
//            Picasso.get()
//                    .load(farmObject.getImageUrl())
//                    .into(mFarmObjectImageView);
            mFarmObject = farmObject;
        }

        @OnClick
        public void onClick() {
            mOnClickListener.onClick(mFarmObject);
        }

        public void setOnClickListener(OnFarmObjectClickListener onClickListener) {
            mOnClickListener = onClickListener;
        }
    }

    interface OnFarmObjectClickListener {
        void onClick(FarmObject farmObject);
    }
}

