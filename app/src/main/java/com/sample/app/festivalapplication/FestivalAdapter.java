package com.sample.app.festivalapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 리사이클러뷰를 사용하기 위한 어댑터 생성
 */
public class FestivalAdapter extends RecyclerView.Adapter<FestivalAdapter.ViewHolder> {
    private Context context;
    private List<FestivalData> items = null;
    private List<FestivalData> festivalDataList;
    private OnItemClickListener onItemClickListener;


    public FestivalAdapter(Context context, List<FestivalData> festivalDataList) {
        this.context = context;
        this.festivalDataList = festivalDataList;
        this.items = new ArrayList<>();
        items.addAll(festivalDataList);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_festival, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FestivalData festivalData = festivalDataList.get(position);
        Glide.with(context)
                .load(festivalData.getPoster())
                .into(holder.posterImage);
        holder.titleText.setText(festivalData.getTitle());
        holder.whenText.setText(festivalData.getWhen());
        holder.itemBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.OnItemClick(festivalData);
            }
        });
    }

    /**
     * 지역별로 검색을 위한 filter
     * @param search
     */
    public void filter(String search) {
        festivalDataList.clear();
        for (FestivalData festivalData : items) {
            String location = festivalData.getLocation();
            if (location.contains(search)) {
                festivalDataList.add(festivalData);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return festivalDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemBox)
        CardView itemBox;

        @BindView(R.id.posterImage)
        ImageView posterImage;

        @BindView(R.id.titleText)
        TextView titleText;

        @BindView(R.id.whenText)
        TextView whenText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        public void OnItemClick(FestivalData festivalData);
    }
}
