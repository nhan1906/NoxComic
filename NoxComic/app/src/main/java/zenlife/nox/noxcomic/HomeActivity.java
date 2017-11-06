package zenlife.nox.noxcomic;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import zenlife.nox.noxcomic.mainhome.HomeFragment;
import zenlife.nox.noxcomic.mainhome.MyPageFragment;
import zenlife.nox.noxcomic.mainhome.home.CategoryFragment;
import zenlife.nox.noxcomic.mainhome.home.MainFragment;
import zenlife.nox.noxcomic.mainhome.home.NotificationFragment;
import zenlife.nox.noxcomic.signin.SignInActivity;
import zenlife.nox.noxcomic.utils.ItemImageComicAdapter;
import zenlife.nox.noxcomic.utils.SliderImageAdapter;
import zenlife.nox.noxcomic.utils.WrapContentViewPager;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        MyPageFragment.OnFragmentInteractionListener, HomeFragment.OnFragmentInteractionListener,
        CategoryFragment.OnFragmentInteractionListener, MainFragment.OnFragmentInteractionListener, NotificationFragment.OnFragmentInteractionListener{


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.inflateHeaderView(R.layout.nav_header_bar);
        Button btnSignIn = (Button)headerView.findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToSignIn = new Intent(HomeActivity.this, SignInActivity.class);
                startActivity(moveToSignIn);
            }
        });

        //setUpViewPager
        ViewPager mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));

    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);  // OPEN DRAWER
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public static class MainViewPagerAdapter extends FragmentPagerAdapter{

        private static final int NUM_PAGES = 2;

        public MainViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return HomeFragment.newInstance("Nothing", "Nothing");
                case 1:
                    return MyPageFragment.newInstance("Nothing", "Nothing");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
