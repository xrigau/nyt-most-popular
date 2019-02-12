package com.xrigau.nytimesmostpopular.articles;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.xrigau.nytimesmostpopular.article.Article;
import com.xrigau.nytimesmostpopular.common.ImageLoader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private final List<Article> articles;
    private final ImageLoader imageLoader;
    private final ArticleDetailsDisplayStrategy articleDetailsDisplayStrategy;

    ArticleAdapter(List<Article> articles, ImageLoader imageLoader, ArticleDetailsDisplayStrategy articleDetailsDisplayStrategy) {
        this.articles = articles;
        this.imageLoader = imageLoader;
        this.articleDetailsDisplayStrategy = articleDetailsDisplayStrategy;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Article article = articles.get(position);
        imageLoader.loadThumbnail(article.getThumbnail().getUrl(), holder.image);
        holder.title.setText(article.getTitle());
        holder.author.setText(article.getAuthors());
        holder.date.setText(article.getPublishedDate());

        holder.itemView.setTag(article);
        holder.itemView.setOnClickListener(createOnClickListener(article));
    }

    private View.OnClickListener createOnClickListener(final Article article) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                articleDetailsDisplayStrategy.display(article);
            }
        };
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView title;
        final TextView author;
        final TextView date;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.article_image);
            title = view.findViewById(R.id.article_title);
            author = view.findViewById(R.id.article_author);
            date = view.findViewById(R.id.article_date);
        }
    }

}
