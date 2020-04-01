package com.workspace.tugasakhir;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.workspace.tugasakhir.Fragment.Akun;
import com.workspace.tugasakhir.Fragment.Beranda;
import com.workspace.tugasakhir.Fragment.Keranjang;
import com.workspace.tugasakhir.Fragment.Pesanan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] mImages = new int[] {
            R.drawable.header, R.drawable.image_hokben, R.drawable.image_yoshinoya, R.drawable.image_yoshinoya2
    };
    private String[] mImagesTittle = new String[]{
            "Cateringku", "Menu Hokben", "Promo Yoshinoya", "Menu Yoshinoya"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Beranda()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.navBeranda:
                    selectedFragment = new Beranda();
                    break;
                case R.id.navPesanan:
                    selectedFragment = new Pesanan();
                    break;
                case R.id.navCart:
                    selectedFragment = new Keranjang();
                    break;
                case R.id.navAccount:
                    selectedFragment = new Akun();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };
}
