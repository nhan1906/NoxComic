package zenlife.nox.noxcomic.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zenlife.nox.noxcomic.DetailActivity;
import zenlife.nox.noxcomic.R;

/**
 * Created by Nhan on 11/5/2017.
 */

public class ItemNotificationRecyclerView extends RecyclerView.Adapter<ItemNotificationRecyclerView.ViewHolder> {

    private Context context;
    public ItemNotificationRecyclerView(Context context){
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            moveToDetailActivity();
        }

        private void moveToDetailActivity() {
            Intent intent = new Intent(context, DetailActivity.class);
            context.startActivity(intent);
        }
    }
}
