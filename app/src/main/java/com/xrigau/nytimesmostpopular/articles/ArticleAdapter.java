package com.xrigau.nytimesmostpopular.articles;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.xrigau.nytimesmostpopular.R;
import com.xrigau.nytimesmostpopular.dummy.DummyContent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> items;
    private final NavigationStrategy navigationStrategy;

    ArticleAdapter(List<DummyContent.DummyItem> items, NavigationStrategy navigationStrategy) {
        this.items = items;
        this.navigationStrategy = navigationStrategy;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.idView.setText(items.get(position).id);
        holder.contentView.setText(items.get(position).content);

        holder.itemView.setTag(items.get(position));
        holder.itemView.setOnClickListener(onClickListener);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DummyContent.DummyItem item = (DummyContent.DummyItem) view.getTag();
            navigationStrategy.navigate(item.id);
        }
    };

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView idView;
        final TextView contentView;

        ViewHolder(View view) {
            super(view);
            idView = view.findViewById(R.id.id_text);
            contentView = view.findViewById(R.id.content);
        }
    }

    interface NavigationStrategy {
        void navigate(String item); // TODO: Use the correct type
    }
}
