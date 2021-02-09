package com.pouillos.suiviseries.recycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.pouillos.suiviseries.R;
import com.pouillos.suiviseries.entities.Episode;
import com.pouillos.suiviseries.recycler.holder.RecyclerViewHolderEpisode;

import java.util.List;

public class RecyclerAdapterEpisode extends RecyclerView.Adapter<RecyclerViewHolderEpisode> {

        private List<Episode> listEpisode;

    public interface Listener {
        void onClickEpisodeButton(int position);
    }

    private final Listener callback;

    public RecyclerAdapterEpisode(List<Episode> listEpisode, Listener callback) {
        this.listEpisode = listEpisode;
        this.callback = callback;
    }

        @Override
        public RecyclerViewHolderEpisode onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.recycler_list_episode, parent, false);

            return new RecyclerViewHolderEpisode(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolderEpisode viewHolder, int position) {
            viewHolder.updateWithEpisode(this.listEpisode.get(position),this.callback);
        }

        @Override
        public int getItemCount() {
            return this.listEpisode.size();
        }

    public Episode getEpisode(int position){
        return this.listEpisode.get(position);
    }
}
