package com.example.thriv31;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.thriv31.ui.groups.GroupsFragment;
import com.example.thriv31.ui.updates.UpdatesFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.thriv31.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getSupportActionBar().hide();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (findViewById(R.id.Group_fragment) != null) {
            // If we're being restored from a previous state, don't do anything
            // or else we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new EventListFragment
            GroupsFragment groupsFragment = new GroupsFragment();

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.Group_fragment, groupsFragment)
                    .commit();
        }
        if (savedInstanceState == null) {
            UpdatesFragment updatesFragment = new UpdatesFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.nav_host_fragment_activity_main, updatesFragment);
            transaction.commit();
        }

        BottomNavigationView navView = findViewById(R.id.ottom_nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_updates, R.id.nav_groups, R.id.nav_stories)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.ottomNavView, navController);
    }

}