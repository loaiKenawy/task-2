package com.example.Task2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter1 extends RecyclerView.Adapter<RVAdapter1.itemViewHolder> {

    private Context context;

    private List<itemViewModel> list_of_type_itemViewModel;

    private onItemClickListener listenerObj;

    private  onItemLongClickListener lListener;

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public interface onItemLongClickListener {
         void onLongClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener Listener) {
        listenerObj = Listener;
    }

    public void setOnItemLongClickListener(onItemLongClickListener Listener1) {
        lListener = Listener1;
    }



    public RVAdapter1(Context c, List<itemViewModel> modelList) {
        this.context = c;
        list_of_type_itemViewModel = modelList;
    }


//View holder class
    public class itemViewHolder extends RecyclerView.ViewHolder {

        TextView bookName ,authorName , pagesNumber;
        ImageView bookImage;

        public itemViewHolder(@NonNull View itemView, onItemClickListener listener) {
            super(itemView);

            bookName = itemView.findViewById(R.id.textView2);
            authorName = itemView.findViewById(R.id.textView3);
            bookImage = itemView.findViewById(R.id.actavitybutton);
            pagesNumber = itemView.findViewById(R.id.textView2h1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (lListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            lListener.onLongClick(position);
                        }
                    }
                    return false;
                }
            });
        }
    }

        @NonNull
        @Override
        public itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            itemViewHolder viewfinder = new itemViewHolder(v, listenerObj);
            return viewfinder;
        }

        @Override
        public void onBindViewHolder(@NonNull itemViewHolder holder, int position) {

            itemViewModel itemViewModelObj = list_of_type_itemViewModel.get(position);
            holder.bookName.setText(itemViewModelObj.getBookName());
            holder.authorName.setText(itemViewModelObj.getAuthorName());
            holder.bookImage.setImageResource(itemViewModelObj.getImResource());
            holder.pagesNumber.setText(itemViewModelObj.getPagesNumber());
        }

        @Override
        public int getItemCount() {
            return list_of_type_itemViewModel.size();
        }

    }
