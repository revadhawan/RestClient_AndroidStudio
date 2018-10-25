package edu.upc.eetac.dsa.restclient;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Tracks> data;


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView singer;


        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title_TextView);
            singer = (TextView) v.findViewById(R.id.singer_TextView);
        }
    }

    public RecyclerViewAdapter(List<Tracks> data) {

        this.data = data;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_track, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Tracks track = ((Tracks) data.get(position));
        holder.title.setText(track.title);
        holder.singer.setText(track.singer);
        holder.itemView.setTag(track.tracksId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}