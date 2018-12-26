package com.sample.app.festivalapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    // butterknife를 사용하여 바인딩
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.posterImage)
    ImageView posterImage;

    @BindView(R.id.whenText)
    TextView whenText;

    @BindView(R.id.locationText)
    TextView locationText;

    @BindView(R.id.phoneText)
    TextView phoneText;

    @BindView(R.id.descText)
    TextView bindText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        /**
         * 인텐트로 받은 데이터
         */
        FestivalData festivalData = (FestivalData) getIntent().getSerializableExtra("data");

        /**
         * 툴바 설정
         */
        setSupportActionBar(toolbar);
        // 축제 제목 출력
        setTitle(festivalData.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         * 인텐트로 받은 데이터 출력(포스터, 일자, 위치, 전화번호)
         */
        Glide.with(this)
                .load(festivalData.getPoster())
                .into(posterImage);
        whenText.setText(festivalData.getWhen());
        locationText.setText(festivalData.getLocation());
        phoneText.setText(festivalData.getPhone());
        bindText.setText(festivalData.getDesc());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 뒤로가기 버튼 클릭
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
