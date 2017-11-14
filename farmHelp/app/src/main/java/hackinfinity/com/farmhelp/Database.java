package hackinfinity.com.farmhelp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiLaN on 12-11-2017.
 */

public class Database {
    private String DATABASE_URL = "https://farm-help.firebaseio.com/";
    private String DATABASE_SEED = "seed";
    private String DATABASE_FERTILIZER = "fertilizer";
    private String DATABASE_SERVICE_PROVIDER = "service_provider";
    private String DATABASE_TRANSPORTATION = "transportation";
    private String DATABASE_HARDWARE = "hardware";
    private String DATABASE_MARKET_RATES = "market_rates";
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    public static String CATEGORY_SEED = "seed";
    public static String CATEGORY_FERTILIZER = "fertilizer";
    public static String CATEGORY_TRANSPORTATION = "service_provider";
    public static String CATEGORY_HARDWARE = "hardware";
    public static String CATEGORY_MARKET_RATES = "market_rates";

    public Database(){
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public void saveToDatabase(ServiceProvider serviceProvider){
        initialise(DATABASE_SERVICE_PROVIDER);
        databaseReference.child(String.valueOf(serviceProvider.getId())).setValue(serviceProvider);
    }

    public void saveToDatabase(Fertilizer fertilizer){
        initialise(DATABASE_FERTILIZER);
        databaseReference.push().setValue(fertilizer);
    }

    public void saveToDatabase(Seed seed){
        initialise(DATABASE_SEED);
        databaseReference.push().setValue(seed);
    }

    public void saveToDatabase(MarketRate marketRate){
        initialise(DATABASE_MARKET_RATES);
        databaseReference.push().setValue(marketRate);
    }

    public void saveToDatabase(Hardware hardware){
        initialise(DATABASE_HARDWARE);
        databaseReference.push().setValue(hardware);
    }

    public void saveToDatabase(Transportation transportation){
        initialise(DATABASE_TRANSPORTATION);
        databaseReference.push().setValue(transportation);
    }

    public void getServiceProviderById(int id, final OnDataRecieved onDataRecieved){
        initialise(DATABASE_SERVICE_PROVIDER);
        databaseReference.child(String.valueOf(id)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {

                    onDataRecieved.onRecieved(dataSnapshot.getValue(ServiceProvider.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void getAllSeed(final OnSeedRecieved onSeedRecieved){
        initialise(DATABASE_SEED);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    //   Helper.log(dataSnapshot.toString());
                    List<Seed> seedList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        seedList.add(snapshot.getValue(Seed.class));
                    }
                    onSeedRecieved.onRecieved(seedList);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getAllFertilizer(final OnFertilizerRecieved onFertilizerRecieved){
        initialise(DATABASE_FERTILIZER);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                 //   Helper.log(dataSnapshot.toString());
                    List<Fertilizer> fertilizerList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        fertilizerList.add(snapshot.getValue(Fertilizer.class));
                    }
                  //  Helper.log(String.valueOf(fertilizerList.size()));
                    onFertilizerRecieved.onRecieved(fertilizerList);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getAllHardware(final OnHardwareRecieved onHardwareRecieved){
        initialise(DATABASE_HARDWARE);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    List<Hardware> hardwareList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        hardwareList.add(snapshot.getValue(Hardware.class));
                    }
                    onHardwareRecieved.onRecieved(hardwareList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



    public void getAllMarketRate(final OnMarketRecieved onMarketRecieved){
        initialise(DATABASE_MARKET_RATES);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    List<MarketRate> marketRateList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        marketRateList.add(snapshot.getValue(MarketRate.class));
                    }
                    onMarketRecieved.onRecieved(marketRateList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getAllTransport(final OnTransportationRecieved onMarketRecieved){
        initialise(DATABASE_TRANSPORTATION);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    List<Transportation> marketRateList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        marketRateList.add(snapshot.getValue(Transportation.class));
                    }
                    onMarketRecieved.onRecieved(marketRateList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    public void getAllServiceProvider(final OnServiceProviderRecieved onServiceProviderRecieved){
        initialise(DATABASE_SERVICE_PROVIDER);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot != null){
                    List<ServiceProvider> marketRateList = new ArrayList<>();
                    for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        marketRateList.add(snapshot.getValue(ServiceProvider.class));
                    }
                    onServiceProviderRecieved.onRecieved(marketRateList);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void initialise(String reference) {
        databaseReference = firebaseDatabase.getReference(reference);
    }

    public interface OnDataRecieved{
        public void onRecieved(Object object);
    }

    public interface OnFertilizerRecieved{
        public void onRecieved(List<Fertilizer> fertilizerList);
    }

    public interface OnHardwareRecieved{
        public void onRecieved(List<Hardware> hardwareList);
    }

    public interface OnMarketRecieved{
        public void onRecieved(List<MarketRate> marketRateList);
    }

    public interface OnSeedRecieved{
        public void onRecieved(List<Seed> seedList);
    }

    public interface OnTransportationRecieved{
        public void onRecieved(List<Transportation> transportationList);
    }

    public interface OnServiceProviderRecieved{
        public void onRecieved(List<ServiceProvider> serviceProviderList);
    }
}
