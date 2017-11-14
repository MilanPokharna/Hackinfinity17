package hackinfinity.com.farmhelp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackinfinity.com.farmhelp.databinding.FragmentServiceBinding;


public class ServiceProviderFragment extends Fragment {

    private RecyclerView recyclerView;
    private ServiceProviderCard serviceProviderCard;
    private FragmentServiceBinding fragmentServiceBinding;
    public ServiceProviderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentServiceBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_service, container, false);
        serviceProviderCard = new ServiceProviderCard(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        fragmentServiceBinding.rvServiceProvider.setLayoutManager(linearLayoutManager);
        serviceProviderCard.setServiceProviders(Constant.serviceProviderList);
        serviceProviderCard.setIntegerList(Constant.amountList);
        fragmentServiceBinding.rvServiceProvider.setAdapter(serviceProviderCard);

        return fragmentServiceBinding.getRoot();
    }


}
