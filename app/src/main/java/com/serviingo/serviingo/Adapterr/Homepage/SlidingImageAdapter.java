package com.serviingo.serviingo.Adapterr.Homepage;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.serviingo.serviingo.Adapterr.FinancialAdapter.FinanceCaetegoryAdapter;
import com.serviingo.serviingo.R;
import com.serviingo.serviingo.modelrepo.Responsee.Finacial.FinacialCategoryRepo;
import com.serviingo.serviingo.modelrepo.Responsee.HomePageRepo;
import com.squareup.picasso.Picasso;


public class SlidingImageAdapter extends PagerAdapter {
    HomePageRepo homePageRepo;

    private LayoutInflater layoutInflater;
    private Context context;

    private SliderClick itemClickListenerr;


    public SlidingImageAdapter(HomePageRepo homePageRepo, Context context, SliderClick itemClickListenerr) {
        this.homePageRepo = homePageRepo;
        this.context = context;

        this.itemClickListenerr = itemClickListenerr;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return homePageRepo.getData().getSliders().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.image_slider_layout_item, container, false);

        assert view != null;
        final ImageView imageView = (ImageView) view.findViewById(R.id.iv_auto_image_slider);

        //  imageView.setImageResource(Images.get(position));
        Picasso.get().load(homePageRepo.getData().getSliders().get(position).getLink()).into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerr.SliderClickk(homePageRepo, position);
            }
        });
        container.addView(view, 0);
        return view;
    }

    @Override
    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }

    @Nullable
    @Override

    public Parcelable saveState() {
        return null;
    }

    public interface SliderClick {

        void SliderClickk(HomePageRepo repo, int pos);


    }
}
