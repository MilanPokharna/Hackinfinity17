package hackinfinity.com.farmhelp;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hackinfinity.com.farmhelp.databinding.CardServiceproviderBinding;

/**
 * Created by mohit on 12/11/17.
 */

public class ServiceProviderCard extends RecyclerView.Adapter<ServiceProviderCard.MyViewHolder>{
    private Context context;
    private List<ServiceProvider> serviceProviders;
    private List<Integer> integerList;
    private LayoutInflater layoutInflater;

    public ServiceProviderCard(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public void setServiceProviders(List<ServiceProvider> serviceProviders) {
        this.serviceProviders = serviceProviders;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(layoutInflater.inflate(R.layout.card_serviceprovider, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.cardServiceproviderBinding.ivImage.setImageResource(context.getResources().getIdentifier("a" + String.valueOf(position%4) + ".png","drawable", context.getPackageName()));
        holder.cardServiceproviderBinding.tvTitle.setText(serviceProviders.get(position).getName());
        holder.cardServiceproviderBinding.tvPhoneNumber.setText(serviceProviders.get(position).getPhone());
        holder.cardServiceproviderBinding.tvRate.setText(String.valueOf(integerList.get(position)));
    }

    @Override
    public int getItemCount() {
        if(serviceProviders != null){
            return serviceProviders.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private CardServiceproviderBinding cardServiceproviderBinding;
        public MyViewHolder(View itemView) {
            super(itemView);
            cardServiceproviderBinding = DataBindingUtil.bind(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceProvider serviceProvider = serviceProviders.get(getAdapterPosition());
                String uri = "geo:" + serviceProvider.getLocation() + "?q=" + serviceProvider.getLocation()
                        + "(" + Uri.encode(serviceProvider.getName()) + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                ((MainActivity)context).startActivity(intent);
            }
        });
        }

    }
}
