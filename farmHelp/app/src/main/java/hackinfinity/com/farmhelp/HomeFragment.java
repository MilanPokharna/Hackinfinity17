package hackinfinity.com.farmhelp;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackinfinity.com.farmhelp.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;
    private OnCategoryClickListener onCategoryClickListener;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        onCategoryClickListener = (OnCategoryClickListener) getActivity();
        onClick();
        return fragmentHomeBinding.getRoot();
    }

    private void onClick() {
        fragmentHomeBinding.cvFertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryClickListener.onCategoryClick(Database.CATEGORY_FERTILIZER);
            }
        });

        fragmentHomeBinding.cvSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryClickListener.onCategoryClick(Database.CATEGORY_SEED);
            }
        });
        fragmentHomeBinding.cvTransportation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryClickListener.onCategoryClick(Database.CATEGORY_TRANSPORTATION);
            }
        });
        fragmentHomeBinding.cvHardware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryClickListener.onCategoryClick(Database.CATEGORY_HARDWARE);
            }
        });
        fragmentHomeBinding.cvMarketRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCategoryClickListener.onCategoryClick(Database.CATEGORY_MARKET_RATES);
            }
        });
    }

    public interface OnCategoryClickListener{
        public void onCategoryClick(String cat);
    }

}
