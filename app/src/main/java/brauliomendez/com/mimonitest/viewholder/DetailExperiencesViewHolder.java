package brauliomendez.com.mimonitest.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import brauliomendez.com.mimonitest.R;
import brauliomendez.com.mimonitest.model.CityExperience;
import butterknife.BindView;
import butterknife.ButterKnife;
import mx.leo.easyrecycler.viewholder.EasyItemViewHolder;

/**
 * Created by Braulio on 14/01/2017.
 */

public class DetailExperiencesViewHolder extends EasyItemViewHolder {

    @BindView(R.id.detail_experience_image_view) ImageView detailExperienceImageView;
    @BindView(R.id.detail_name_text_view) TextView detailNameTextView;

    public DetailExperiencesViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindItem(CityExperience experience) {
        detailNameTextView.setText(experience.getTitle());
    }
}
