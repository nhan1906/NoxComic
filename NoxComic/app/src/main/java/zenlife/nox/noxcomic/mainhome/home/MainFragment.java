package zenlife.nox.noxcomic.mainhome.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import zenlife.nox.noxcomic.ListComicsActivity;
import zenlife.nox.noxcomic.R;
import zenlife.nox.noxcomic.utils.ItemImageComicAdapter;
import zenlife.nox.noxcomic.utils.SliderImageAdapter;
import zenlife.nox.noxcomic.utils.WrapContentViewPager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recentRecyclerView, popularRecyclerView, mostRecyclerView, comingSoonRecyclerView;
    private static WrapContentViewPager sliderImageViewPager;
    private static int currentPager = 0;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        (view.findViewById(R.id.seeAllTextview)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveToListComics = new Intent(getActivity(), ListComicsActivity.class);
                startActivity(moveToListComics);
            }
        });

        initSliderImageViewPager(view);
        initRecentRecyclerView(view);
        initPopularRecyclerView(view);
        initMostRecyclerView(view);
        intitComingSoonRecyclerView(view);

        return view;
    }


    private void intitComingSoonRecyclerView(View view) {
        comingSoonRecyclerView = (RecyclerView) view.findViewById(R.id.comingSoonRecyclerView);
        comingSoonRecyclerView.setAdapter(new ItemImageComicAdapter(getContext()));
        comingSoonRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initMostRecyclerView(View view) {
        popularRecyclerView = (RecyclerView)  view.findViewById(R.id.popularRecyclerView);
        popularRecyclerView.setAdapter(new ItemImageComicAdapter(getContext()));
        popularRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initPopularRecyclerView(View view) {
        mostRecyclerView = (RecyclerView)  view.findViewById(R.id.mostRecyclerView);
        mostRecyclerView.setAdapter(new ItemImageComicAdapter(getContext()));
        mostRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initRecentRecyclerView(View view) {
        recentRecyclerView = (RecyclerView)  view.findViewById(R.id.recentRecyclerView);
        recentRecyclerView.setAdapter(new ItemImageComicAdapter(getContext()));
        recentRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
    }

    private void initSliderImageViewPager(View view) {
        sliderImageViewPager = (WrapContentViewPager)  view.findViewById(R.id.slideImageViewPager);
        sliderImageViewPager.setAdapter(new SliderImageAdapter(getContext()));
        CircleIndicator indicator = (CircleIndicator)  view.findViewById(R.id.indicator);
        indicator.setViewPager(sliderImageViewPager);

        //Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if (currentPager == 5){
                    currentPager = 0;
                }
                sliderImageViewPager.setCurrentItem(currentPager++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
