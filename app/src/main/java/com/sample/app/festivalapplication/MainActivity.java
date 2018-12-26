package com.sample.app.festivalapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Spinner;
import android.widget.Toast;

import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    // butterknife를 사용하여 바인딩
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.spinner)
    MaterialSpinner spinner;

    private FestivalAdapter adapter;

    private List<FestivalData> festivalDataList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /**
         * 툴바 설정
         */
        setSupportActionBar(toolbar);
        setTitle("Festival");

        /**
         * 스피너 설정(지역에 맞추어 검색)
         */
        String[] location = getResources().getStringArray(R.array.location_list);
        spinner.setItems(location);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, Object item) {
                String search = item.toString();
                if (search.equals("전국")) {
                    search = "";
                }
                adapter.filter(search);
            }
        });

        /**
         * 샘플 데이터 생성
         * FestivalData(포스터, 제목, 상세설명, 일자, 위치, 전화번호) 입력
         */
        festivalDataList.add(new FestivalData(
                "https://post-phinf.pstatic.net/MjAxNzA0MDVfMjIz/MDAxNDkxMzc1MzgzMjE3.RGeoen3Z9-buHSs5npuuCex1Om4zog8t4l1ib3ECqDkg.mSonTZ9My6HJ4GaHAxBsHD3BFZBzj7apqNigEz5-N88g.JPEG/20148896.jpg?type=w1200",
                "창경궁 야간 특별관람 2018",
                "- 4월(궁중문화축전): 4. 28. ~ 5. 6. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 5월: 5. 20. ~ 6. 2. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 6월: 6. 17. ~ 6. 30. / 19:30 ~ 22:00(입장 마감 21:00) \n" +
                        "- 7월: 7. 22. ~ 8. 4. / 19:30 ~ 22:00(입장 마감 21:00) \n" +
                        "- 9월: 9. 16. ~ 9. 29. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 10월: 10. 21. ~ 11. 3. / 19:00 ~ 21:30(입장 마감 20:30)",
                "2018.04.28 ~ 2018.11.03",
                "03072  서울시 종로구 창경궁로 185 (와룡동, 창경궁)",
                "02-762-9515"));

        festivalDataList.add(new FestivalData(
                "http://cfile25.uf.tistory.com/image/99919B335990C26D0E30F7",
                "2018년 경복궁 야간 특별관람",
                "- 4월(궁중문화축전): 4. 29. ~ 5. 6. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 5월: 5. 20. ~ 6. 2. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 6월: 6. 17. ~ 6. 30. / 19:30 ~ 22:00(입장 마감 21:00) \n" +
                        "- 7월: 7. 22. ~ 8. 4. / 19:30 ~ 22:00(입장 마감 21:00) \n" +
                        "- 9월: 9. 16. ~ 9. 29. / 19:00 ~ 21:30(입장 마감 20:30) \n" +
                        "- 10월: 10. 21. ~ 11. 3. / 19:00 ~ 21:30(입장 마감 20:30)",
                "2018.04.29 ~ 2018.11.03",
                "03045  서울시 종로구 사직로 161 (세종로, 경복궁) ",
                "02-3700-3900"));

        festivalDataList.add(new FestivalData(
                "http://tong.visitkorea.or.kr/cms/resource/53/2376253_image2_1.jpg",
                "2018 서울밤도깨비야시장",
                "여의도한강공원: 서울시 영등포구 여의동로 330\n" +
                        "반포한강공원: 서울시 서초구 신반포로11길 40\n" +
                        "동대문디자인플라자(DDP): 서울시 중구 을지로 281\n" +
                        "청계천: 서울시 종로구 서린동 14 광통교 일대\n" +
                        "문화비축기지: 서울시 마포구 증산로 87\n" +
                        "청계광장: 서울시 종로구 서린동 14-1 청계광장",
                "2018.03.30 ~ 2018.10.28",
                "서울시",
                "02-120"));

        festivalDataList.add(new FestivalData(
                "http://www.mcst.go.kr/attachFiles/cultureInfoCourt/localFestival/notifyFestival/1494813366457.JPG",
                "안산 성호문화제 2018",
                "안산시에서 2018년 5월 26일 토요일부터 27일 일요일까지 2일간 <제22회 성호문화제>를 개최한다. 안산시 일동에서 살면서 성호 사상과 실학을 완성시킨 성호 이익 선생을 기리는 문화축제이다. 실학과 전통문화의 만남인 성호문화제는 다양한 행사 프로그램과 성호 이익 선생의 삼두 회릉 기리는 삼두회 체험마당 등 다양한 체험마당으로 구성될 예정이며 성호문화제 기간 동안에는 성호기념관 무료입장이 가능하다.",
                "2018.05.26 ~ 2018.05.27",
                "경기도 안산시",
                "안산문화원 관리자 031-481-2798 / 031-415-0041"));

        festivalDataList.add(new FestivalData(
                "http://www.mcst.go.kr/attachFiles/cultureInfoCourt/localFestival/notifyFestival/1494812152159.jpg",
                "생거진천 농다리축제 2018",
                "농다리축제는 소중한 문화유산을 널리 알리고 소중한 문화유산 보존의 중요성을 일깨움은 물론 조상의 슬기를 배워가고자 농다리를 테마로 한 이색적 축제이다. 농다리는 고려 초기에 놓여 1천 년의 신비를 지닌 국내 유일의 돌다리로 지방유형문화재 제28호로 지정되어 보호되고 있는 「생거진천」의 귀중한 문화유산으로 총 길이 94m 폭 3.6m 교각의 두께가 1.2m이며, 교각과 교각의 사이는 0.8m로 자줏빛 자연석을 그대로 쌓았음에도 견고하여 장마가 져도 다리 위로 물이 흐르도록 설계되어 1000년의 세월에도 유실되지 않는 축조기술이 매우 뛰어난 유산임을 알 수 있다.",
                "2018.05.25 ~ 2018.05.27 3일간",
                "충청북도 진천군",
                "진천문화원 관리자 진천군청 문화홍보체육과 043-539-3601~2"));

        festivalDataList.add(new FestivalData(
                "http://www.mcst.go.kr/attachFiles/cultureInfoCourt/localFestival/notifyFestival/1526861240804.jpg",
                "내고장 사랑 대축제 2018",
                "대구경북 지역민이 함께하는 축제의 한마당이다. 특히 미스코리아 대구경북대회로 발굴된 여성 인재들이 홍보 전시 판매활동에 나서 지역 경제 활성화에 기여할 것으로 보인다. 특설무대에서 진행되는 공연 및 풍성한 이벤트와 함께 대구경북지역 우수 농특산물 및 중소기업 우수상품 직거래 부스, 먹거리 부스가 운영된다.",
                "2018.05.25 ~ 2018.05.27",
                "대구시 달서구",
                "대구한국일보, 엠플러스한국, 대구광역시, 경상북도 관리자 053-755-5881"));

        festivalDataList.add(new FestivalData(
                "http://www.mcst.go.kr/attachFiles/cultureInfoCourt/localFestival/notifyFestival/1524097478106.jpg",
                "화도진축제 2018",
                "2018 제29회 화도진축제는 구한말 외세의 침략을 막기 위해 설치한 화도진이라는 역사적 배경을 근거로 한 대한민국 대표 군영 축제로 어영대장 축성행렬, 한미수호통상조약 조인식 재현, 화도진 성곽쌓기 체험 등 화도진의 역사성을 재조명하는 문화행사 등 다채로운 공연과 체험행사로 구성되어 있다.",
                "2018.05.18. ~ 2018.05.19 / 10:00~22:00",
                "인천시 동구",
                "인천광역시 동구, 화도진문화원 관리자 032-770-6922"));

        /**
         * 리사이클러뷰에 데이터 연결
         */
        adapter = new FestivalAdapter(this, festivalDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        /**
         * 리사이클러뷰의 아이템 클릭
         */
        adapter.setOnItemClickListener(new FestivalAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(FestivalData festivalData) {
                // 축제 상세보기
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data", festivalData);
                startActivity(intent);
            }
        });
    }
}
