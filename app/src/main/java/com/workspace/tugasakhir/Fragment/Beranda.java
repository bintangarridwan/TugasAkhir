package com.workspace.tugasakhir.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import com.workspace.tugasakhir.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Beranda extends Fragment {

    private RecyclerView recyclerView;
    private int[] mImages = new int[] {
            R.drawable.header, R.drawable.image_hokben, R.drawable.image_yoshinoya, R.drawable.image_yoshinoya2
    };
    final String[] mImagesTittle = new String[]{
            "Cateringku", "Menu Hokben", "Promo Yoshinoya", "Menu Yoshinoya"
    };
    public Beranda() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        recyclerView = view.findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);

        ImageButton imageButton = view.findViewById(R.id.img_lainnya);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        getContext(), R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getContext()).inflate(R.layout.layout_btmsheet,
                        (LinearLayout)view.findViewById(R.id.btmSheetContainer));
                bottomSheetDialog.dismiss();
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });


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
                Toast.makeText(getContext(), mImagesTittle[position], Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
