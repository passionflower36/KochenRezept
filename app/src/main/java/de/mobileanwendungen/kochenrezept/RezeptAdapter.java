package de.mobileanwendungen.kochenrezept;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RezeptAdapter extends RecyclerView.Adapter<RezeptAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ModelFood> mList;
    private onItemClickListner mListener;

    public interface onItemClickListner{
        void onItemClick (int position);
    }

    RezeptAdapter(Context context, ArrayList<ModelFood> list){
        mContext=context;
        mList = list;
    }

    public void setOnItemClickListener(onItemClickListner listener){
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name;


        public ViewHolder (View itemView){
            super(itemView);

            item_image = itemView.findViewById(R.id.card_image);
            item_name = itemView.findViewById(R.id.card_text);



        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.rv_foot_items, viewGroup, false );

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ModelFood footItem = mList.get(position);

        ImageView image = holder.item_image;
        TextView text = holder.item_name;

        image.setImageResource(footItem.getImage());
        text.setText(footItem.getName());

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

}
