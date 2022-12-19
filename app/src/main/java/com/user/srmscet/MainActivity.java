package com.user.srmscet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.user.srmscet.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    Button btnLogOut;
    FirebaseAuth mAuth;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
//    TextView txtMarquee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // casting of textview
//        txtMarquee = (TextView) findViewById(R.id.marqueeText);
//
//        // Now we will call setSelected() method
//        // and pass boolean value as true
//        txtMarquee.setSelected(true);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);


        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_profile:
                startActivity(new Intent(this, profile.class));
                break;
            case R.id.navigation_video:
                gotoUrl("https://www.youtube.com/c/SRMSTrust");
                break;

            case R.id.navigation_ebook:
                startActivity(new Intent(this, EbookActivity.class));
                break;
            case R.id.navigation_event_register:
                startActivity(new Intent(this, event_registration.class));
                break;
            case R.id.navigation_website:
                gotoUrl("https://www.srms.ac.in/");
                break;
            case R.id.navigation_share:
               try{
                   Intent i = new Intent(Intent.ACTION_SEND);
                   i.setType("text/plain");
                   i.putExtra(Intent.EXTRA_SUBJECT,"SRMS CET");
                   i.putExtra(Intent.EXTRA_TEXT,""+getApplicationContext().getPackageName());
                   startActivity(Intent.createChooser(i,"Share with"));
               }catch (Exception e){
                   Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
               }
                break;

        }
        return true;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }

    public void Logout(MenuItem item) {
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();

            Toast.makeText(this, "User logged out successfully", Toast.LENGTH_SHORT).show();
        });
    }


    public void profileView(MenuItem item) {
        startActivity(new Intent(MainActivity.this, profile.class));
    }

    public void admindash(MenuItem item) {
        startActivity(new Intent(MainActivity.this, admin_dashboard.class));
    }


    //notice function
    public void registerevent(View view)  {
        startActivity(new Intent(MainActivity.this, event_registration.class));
    }
}