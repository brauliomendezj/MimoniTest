package brauliomendez.com.mimonitest.viewholder;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import brauliomendez.com.mimonitest.R;
import brauliomendez.com.mimonitest.activity.DetailInformationActivity;
import brauliomendez.com.mimonitest.adapter.DetailPlaceAdapter;
import brauliomendez.com.mimonitest.model.CityPlace;
import brauliomendez.com.mimonitest.model.Place;
import butterknife.BindView;
import butterknife.ButterKnife;
import mx.leo.easyrecycler.util.RecyclerViewItemClickListener;
import mx.leo.easyrecycler.util.extensions.RecyclerViewExtensionsKt;
import mx.leo.easyrecycler.viewholder.EasyViewHolder;

/**
 * Created by Braulio on 15/01/2017.
 */

public class PlaceViewHolder extends EasyViewHolder {

    @BindView(R.id.information_experience_button) Button nameExperienceButton;
    @BindView(R.id.name_experience_text_view) TextView nameExperienceTextView;
    @BindView(R.id.main_item_recycler_view) RecyclerView recyclerView;

    public PlaceViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindItem(Place place) {
        nameExperienceTextView.setText(place.getCity());
    }

    public void setUpRecyclerView(List<CityPlace> places) {
        final DetailPlaceAdapter placeAdapter = new DetailPlaceAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(placeAdapter);
        placeAdapter.addItems((ArrayList<CityPlace>) places);
        RecyclerViewExtensionsKt.OnItemClickListener(recyclerView, new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, Integer integer) {
                CityPlace cityPlace = placeAdapter.getItems().get(integer);
                Intent intent = new Intent(recyclerView.getContext(), DetailInformationActivity.class);
                intent.putExtra("image", cityPlace.getImage());
                intent.putExtra("name", cityPlace.getAutor());
                recyclerView.getContext().startActivity(intent);
            }
        });
    }
}
