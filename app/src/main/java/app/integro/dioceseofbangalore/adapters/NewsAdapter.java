package app.integro.dioceseofbangalore.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import app.integro.dioceseofbangalore.NewsDetailActivity;
import app.integro.dioceseofbangalore.R;
import app.integro.dioceseofbangalore.models.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<News> newsArrayList;

    public NewsAdapter(Context context, ArrayList<News> newsArrayList) {
        this.context = context;
        this.newsArrayList = newsArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_news, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final News newsItem = newsArrayList.get(position);
        holder.tvN_Title.setText(newsItem.getTitle());
        holder.tvN_date.setText(newsItem.getDate());

        Picasso.with(context)
                .load(newsItem.getL_img())
                .into(holder.ivNews);

        holder.llNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NewsDetailActivity.class);
                intent.putExtra("data", newsItem);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView tvN_Title;
        TextView tvN_date;
        LinearLayout llNews;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivNews = itemView.findViewById(R.id.ivNews);
            tvN_date = itemView.findViewById(R.id.tvDate);
            tvN_Title = itemView.findViewById(R.id.tvTitle);
            llNews = itemView.findViewById(R.id.rlNews);

        }
    }
}
