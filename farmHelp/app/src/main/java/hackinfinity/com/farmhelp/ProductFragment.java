package hackinfinity.com.farmhelp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import hackinfinity.com.farmhelp.databinding.FragmentProductBinding;


public class ProductFragment extends Fragment {

    private List<Object> productList;
    private RecyclerView recyclerView;
    private FragmentProductBinding fragmentProductBinding;
    private ProductAdapter productAdapter;
    private LinearLayoutManager linearLayoutManager;
    private HashSet<String> set;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProductBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false);
        Helper.startProgress(getContext(), "Please wait...");
        set = new HashSet<>();
        initrv();
        initdata();

        return fragmentProductBinding.getRoot();
    }

    private void initdata() {
        Database database = new Database();
        set.clear();
        if(Constant.currentCat.equals(Database.CATEGORY_FERTILIZER)){
            database.getAllFertilizer(new Database.OnFertilizerRecieved() {
                @Override
                public void onRecieved(List<Fertilizer> fertilizerList) {
                    productList = new ArrayList<>();
                    for(int i = 0; i < fertilizerList.size(); i++){
                        Helper.log(String.valueOf(fertilizerList));
                        if(!set.contains(fertilizerList.get(i).getName())) {
                            productList.add(fertilizerList.get(i));
                            set.add(fertilizerList.get(i).getName());
                        }
                    }
                    updateData(productList);
                }
            });
        }else  if(Constant.currentCat.equals(Database.CATEGORY_SEED)){
            database.getAllSeed(new Database.OnSeedRecieved() {
                @Override
                public void onRecieved(List<Seed> fertilizerList) {
                    productList = new ArrayList<>();
                    for(int i = 0; i < fertilizerList.size(); i++){
                        if(!set.contains(fertilizerList.get(i).getName())) {
                            productList.add(fertilizerList.get(i));
                            set.add(fertilizerList.get(i).getName());
                        }
                    }
                    updateData(productList);
                }
            });
        }else if(Constant.currentCat.equals(Database.CATEGORY_HARDWARE)){
            database.getAllHardware(new Database.OnHardwareRecieved() {
                @Override
                public void onRecieved(List<Hardware> fertilizerList) {
                    productList = new ArrayList<>();
                    for(int i = 0; i < fertilizerList.size(); i++){
                        if(!set.contains(fertilizerList.get(i).getName())) {
                            productList.add(fertilizerList.get(i));
                            set.add(fertilizerList.get(i).getName());
                        }
                    }
                    updateData(productList);
                }
            });
        }else if(Constant.currentCat.equals(Database.CATEGORY_MARKET_RATES)){
            database.getAllMarketRate(new Database.OnMarketRecieved() {
                @Override
                public void onRecieved(List<MarketRate> fertilizerList) {
                    productList = new ArrayList<>();
                    for(int i = 0; i < fertilizerList.size(); i++){
                        if(!set.contains(fertilizerList.get(i).getMandiName())) {
                            productList.add(fertilizerList.get(i));
                            set.add(fertilizerList.get(i).getMandiName());
                        }
                    }
                    updateData(productList);
                }
            });
        }else if(Constant.currentCat.equals(Database.CATEGORY_TRANSPORTATION)){
            database.getAllTransport(new Database.OnTransportationRecieved() {
                @Override
                public void onRecieved(List<Transportation> fertilizerList) {
                    productList = new ArrayList<>();
                    for(int i = 0; i < fertilizerList.size(); i++){
                        if(!set.contains(fertilizerList.get(i).getName())) {
                            productList.add(fertilizerList.get(i));
                            set.add(fertilizerList.get(i).getName());
                        }
                    }
                    updateData(productList);
                }
            });
        }
    }

    private void updateData(List<Object> productList) {
        productAdapter.setObjectList(productList);
        productAdapter.notifyDataSetChanged();
        Helper.dismissProgress();
    }

    private void initrv() {
        productAdapter = new ProductAdapter(getContext());
        linearLayoutManager = new LinearLayoutManager(getContext());
        fragmentProductBinding.rvProduct.setLayoutManager(linearLayoutManager);
        fragmentProductBinding.rvProduct.setAdapter(productAdapter);
        productAdapter.setProductClickListener(new ProductAdapter.OnProductClickListener() {
            @Override
            public void onProductClicked() {
                ((MainActivity)getActivity()).loadFragment(new ServiceProviderFragment());
            }
        });
    }



}
