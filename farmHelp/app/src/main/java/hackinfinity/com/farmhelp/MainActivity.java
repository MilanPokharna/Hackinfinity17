package hackinfinity.com.farmhelp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnCategoryClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        loadFragment(new HomeFragment());
    }

    private void initData() {
        Database database = new Database();
        database.getAllFertilizer(new Database.OnFertilizerRecieved() {
            @Override
            public void onRecieved(List<Fertilizer> fertilizerList) {
                Constant.fertilizerList = fertilizerList;
            }
        });

        database.getAllServiceProvider(new Database.OnServiceProviderRecieved() {
            @Override
            public void onRecieved(List<ServiceProvider> serviceProviderList) {
                Constant.serviceProviderList = serviceProviderList;
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.main_activity,fragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onCategoryClick(String cat) {
        Constant.currentCat = cat;
        loadFragment(new ProductFragment());
    }
}
