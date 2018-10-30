package app.ky.weatherapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {
    String TAG = "RCAdapter";
    Context ctx;
    String list[] = {"Taipei","hsinchu"};
    public RCAdapter(Context ctx) {

        this.ctx = ctx;
    }

    @NonNull
    @Override
    public RCAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,null);
        ViewHolder viewHolder =new ViewHolder(layout);
        Log.e(TAG,"onCreateViewHolder");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RCAdapter.ViewHolder holder, int position) {
        holder.textView.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return list.length;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public ViewHolder(View itemview){
            super(itemview);
            textView = (TextView)itemview.findViewById(R.id.textView);

            itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.e(TAG,"viewholder CLICK");

            Intent intent = new Intent();
            intent.setClass(ctx,WeatherDetail.class);
            intent.putExtra(MainActivity.LOCATION,textView.getText().toString());
            ctx.startActivity(intent);
        }
    }
}
