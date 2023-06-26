package com.example.parichaymahanrashtra;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.parichaymahanrashtra.databinding.ActivityNavHomeBinding;
import com.example.parichaymahanrashtra.ui.bucketlist.Bucketlist;
import com.example.parichaymahanrashtra.ui.hotels.home.HomeFragment;
import com.example.parichaymahanrashtra.ui.location.Location;
import com.example.parichaymahanrashtra.ui.logout.Logout;
import com.example.parichaymahanrashtra.ui.transport.Transport;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class nav_home extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavHomeBinding binding;
    private MenuItem logout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ImageButton fort,cave,temple,shopping,agrot,ruralt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNavHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        logout=(MenuItem) findViewById(R.id.action_logout);
        fort= (ImageButton)findViewById(R.id.imageButton8);
        cave=(ImageButton)findViewById(R.id.imageButton4);
        agrot=(ImageButton)findViewById(R.id.imageButton6);

        cave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Caves.class));
            }
        });

        fort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Forts.class));
            }
        });
        binding.appBarNavHome.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){

                case R.id.map:
                    startActivity(new Intent(getApplication(),
                            mapfin.class));

                    return true;


                case R.id.transport:
                    startActivity(new Intent(getApplication(),
                            transportfin.class));

                    return true;


                case R.id.home:
                    startActivity(new Intent(getApplication(),
                            nav_home.class));

                    return true;

                case R.id.buckets:
                    startActivity(new Intent(getApplicationContext(),
                            Retrievedata.class));
                    return true;


                case R.id.profile:
                    startActivity(new Intent(getApplication(),
                            profilefin.class));

                    return true;



            }
            return  false;
        });

        setSupportActionBar(binding.appBarNavHome.toolbar);
//        binding.appBarNavHome.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.Diary, R.id.Hotels,R.id.About,R.id.bucketList,R.id.Contact,R.id.location,R.id.logout,R.id.Favourites,R.id.Rating,R.id.Help,R.id.speedDials,R.id.Transport,R.id.Terms)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_home,fragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_nav_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_logout)
        {
            startActivity(new Intent(getApplicationContext(),pop.class));

        }
        else{
            return true;
        }
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }



}