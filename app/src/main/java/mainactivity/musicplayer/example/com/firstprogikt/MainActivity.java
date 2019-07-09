package mainactivity.musicplayer.example.com.firstprogikt;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         bottomNavigationView = findViewById(R.id.bottomNavigation);
         viewPager = findViewById(R.id.viewPager);
        setupViewPager();
        setupNavigationView();
    }

    private void setupNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.viewPager:
                                viewPager.setCurrentItem(0);
                                return true;
                            case R.id.newPeg:
                                viewPager.setCurrentItem(1);
                                return true;
                            case R.id.feedPeg:
                                viewPager.setCurrentItem(2);
                                return true;
                        }
                        return false;
                    }
                });
    }

    private void setupViewPager(){
        ViewPegerAdaptor adaptor = new ViewPegerAdaptor(getSupportFragmentManager());
        adaptor.addFragment(new HomeFragment());
        adaptor.addFragment(new NewsFragment());
        adaptor.addFragment(new FeetFrahment());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.viewPager);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.newPeg);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.feedPeg);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
