package wakandaforever.wakandaforever.views.farmobjectlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import wakandaforever.wakandaforever.models.FarmObject;

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
        int height = parent.getMeasuredHeight() / 10;
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
        TextView mNameTextView;

        private OnFarmObjectClickListener mOnClickListener;
        private FarmObject mFarmObject;

        FarmObjectViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        void bind(FarmObject farmObject) {
            mNameTextView.setText(String.valueOf(farmObject.getCreatedAt()));
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

