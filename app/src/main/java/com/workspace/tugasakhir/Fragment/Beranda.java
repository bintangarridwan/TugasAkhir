package com.workspace.tugasakhir.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.workspace.tugasakhir.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Beranda extends Fragment {
    private int[] mImages = new int[] {
            R.drawable.header, R.drawable.image_hokben, R.drawable.image_yoshinoya, R.drawable.image_yoshinoya2
    };
    private String[] mImagesTittle = new String[]{
            "Cateringku", "Menu Hokben", "Promo Yoshinoya", "Menu Yoshinoya"
    };
    public Beranda() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        CarouselView carouselView = view.findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
            }
        });
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
            }
        });
        return view;
    }
}
