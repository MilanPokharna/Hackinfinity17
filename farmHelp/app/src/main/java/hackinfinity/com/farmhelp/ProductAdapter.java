package hackinfinity.com.farmhelp;

import android.app.ProgressDialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import hackinfinity.com.farmhelp.databinding.CardProductBinding;

/**
 * Created by mohit on 12/11/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductCardHolder>{

    private List<Object> objectList;
    private LayoutInflater layoutInflater;
    private Context mContext;
    public OnProductClickListener productClickListener;

    ProductAdapter(Context context){
        mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ProductCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductCardHolder(layoutInflater.inflate(R.layout.card_product, null));
    }

    @Override
    public void onBindViewHolder(ProductCardHolder holder, int position) {
        if(Constant.currentCat.equals(Database.CATEGORY_FERTILIZER)){
            Fertilizer fertilizer = (Fertilizer) objectList.get(position);
            holder.cardProductBinding.ivImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.fertilizer, null));
            holder.cardProductBinding.tvTitle.setText(fertilizer.getName() + "(" + fertilizer.getComposition() + ")");
        }else if(Constant.currentCat.equals(Database.CATEGORY_SEED)){
            Seed fertilizer = (Seed) objectList.get(position);
            holder.cardProductBinding.ivImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.seed, null));
            holder.cardProductBinding.tvTitle.setText(fertilizer.getName());

        }else if(Constant.currentCat.equals(Database.CATEGORY_MARKET_RATES)){
            MarketRate fertilizer = (MarketRate) objectList.get(position);
            holder.cardProductBinding.ivImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.market_rate, null));
            holder.cardProductBinding.tvTitle.setText(fertilizer.getMandiName());

        }else if(Constant.currentCat.equals(Database.CATEGORY_TRANSPORTATION)){
            Transportation fertilizer = (Transportation) objectList.get(position);
            holder.cardProductBinding.ivImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.transportation, null));
            holder.cardProductBinding.tvTitle.setText(fertilizer.getName());

        }else  if(Constant.currentCat.equals(Database.CATEGORY_HARDWARE)){
            Hardware fertilizer = (Hardware) objectList.get(position);
            holder.cardProductBinding.ivImage.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hardware, null));
            holder.cardProductBinding.tvTitle.setText(fertilizer.getName());

        }

    }

    public void setProductClickListener(OnProductClickListener productClickListener) {
        this.productClickListener = productClickListener;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }

    @Override
    public int getItemCount() {
        if(objectList != null){
            return objectList.size();
        }
        return 0;
    }

    public class ProductCardHolder extends RecyclerView.ViewHolder{
        public CardProductBinding cardProductBinding;
        public ProductCardHolder(View itemView) {
            super(itemView);
            cardProductBinding = DataBindingUtil.bind(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<ServiceProvider> serviceProviders = new ArrayList<>();
                    List<Integer> integerList = new ArrayList<>();
                    HashMap<Integer, ServiceProvider> map = new HashMap<>();
                    for(int i = 0; i < Constant.serviceProviderList.size(); i++){
                        map.put(Constant.serviceProviderList.get(i).getId(), Constant.serviceProviderList.get(i));
                    }

                    if(Constant.currentCat.equals(Database.CATEGORY_FERTILIZER)){
                       Fertilizer object = (Fertilizer) objectList.get(getAdapterPosition());
                       for(int i = 0; i < objectList.size(); i++) {
                           Fertilizer obj = (Fertilizer) objectList.get(i);
                           if(obj.getName().equals(object.getName())){
                               serviceProviders.add(map.get(obj.getServiceProviderId()));
                               integerList.add((int) obj.getPrice());
                           }
                       }


                    }else if(Constant.currentCat.equals(Database.CATEGORY_SEED)){
                        Seed object = (Seed) objectList.get(getAdapterPosition());
                        for(int i = 0; i < objectList.size(); i++) {
                            Seed obj = (Seed) objectList.get(i);
                            if(obj.getName().equals(object.getName())){
                                serviceProviders.add(map.get(obj.getServiceProviderId()));
                                integerList.add((int) obj.getPrice());
                            }
                        }
                    }else if(Constant.currentCat.equals(Database.CATEGORY_MARKET_RATES)){
                        MarketRate object = (MarketRate) objectList.get(getAdapterPosition());

                    }else if(Constant.currentCat.equals(Database.CATEGORY_TRANSPORTATION)){
                        Transportation object = (Transportation) objectList.get(getAdapterPosition());
                        for(int i = 0; i < objectList.size(); i++) {
                            Transportation obj = (Transportation) objectList.get(i);
                            if(obj.getName().equals(object.getName())){
                                serviceProviders.add(map.get(obj.getServiceProviderId()));
                                integerList.add((int) obj.getPrice());
                            }
                        }
                    }else  if(Constant.currentCat.equals(Database.CATEGORY_HARDWARE)){
                        Hardware object = (Hardware) objectList.get(getAdapterPosition());
                        for(int i = 0; i < objectList.size(); i++) {
                            Hardware obj = (Hardware) objectList.get(i);
                            if(obj.getName().equals(object.getName())){
                                serviceProviders.add(map.get(obj.getServiceProviderId()));
                                integerList.add((int) obj.getRentPrice());
                            }
                        }
                    }

                    Constant.serviceProviderList = serviceProviders;
                    Constant.amountList = integerList;
                    productClickListener.onProductClicked();
                }
            });
        }
    }

    public interface OnProductClickListener{
        public void onProductClicked();
    }
}
