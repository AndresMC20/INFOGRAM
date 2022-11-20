package com.aplicacion.infogram.view.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aplicacion.infogram.R;
import com.aplicacion.infogram.adapter.CardViewAdapter;
import com.aplicacion.infogram.model.Image;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //toolbar
        showToolBar(getString(R.string.title_home_fragment), false, view);

        //recyclerview
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

        //layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Adapter
        CardViewAdapter cardViewAdapter = new CardViewAdapter(buidImages(), R.layout.cardview_image, getActivity());
        recyclerView.setAdapter(cardViewAdapter);

        return view;
    }

    public void showToolBar(String titulo, boolean botonSubir, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titulo);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(botonSubir);
    }

    //Creamos lista de imagenes
    public ArrayList<Image> buidImages(){
        ArrayList<Image> images = new ArrayList<>();

        images.add(new Image("https://www.boliviaentusmanos.com/turismo/imagenes/cristo-de-la-concordia-1.jpg", "Andres Moral C", "1 dias", "20 me gusta"));
        images.add(new Image("https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0e/1b/f4/2a/fuerte-de-samaipata.jpg?w=500&h=400&s=1", "Caros Valdivia", "2 dias", "1 me gusta"));
        images.add(new Image("https://lh5.googleusercontent.com/-CINb2hHdBHc/VMfJjASBQDI/AAAAAAAAC0I/23gSET6uSaw/s640/blogger-image-979580039.jpg", "Limbert Sanchez", "3 dias", "8 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Monumento_a_la_Virgen_Candelaria.JPG/500px-Monumento_a_la_Virgen_Candelaria.JPG", "Daniel Mollinedo", "4 dias", "6 me gusta"));
        images.add(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/La_Glorieta_-_Sucre.jpg/1280px-La_Glorieta_-_Sucre.jpg", "Israel Zabala C", "1 dias", "6 me gusta"));
        images.add(new Image("https://cdn.bolivia.com/sdi/2019/07/29/mi-teleferico-reporta-muerte-obrero-accidente-trabajo-linea-amarilla-757091.jpg", "Joel Lester Soto", "6 dias", "5 me gusta"));
        images.add(new Image("https://mochilerosindinero.com/wp-content/uploads/2021/11/coroicoBolivia.jpg", "Noel Vallejos U", "5 dias", "7 me gusta"));
        images.add(new Image("https://www.wamanadventures.com/blog/wp-content/uploads/2019/06/La-Laguna-Colorada-Waman-Adventures-1-1.jpg", "Alejandro Flores", "9 dias", "3 me gusta"));
        images.add(new Image("https://boliviatravelsite.com/Images/Attractionphotos/incachaca-004.jpg", "Misael Nawel", "7 dias", "4 me gusta"));
        images.add(new Image("https://www.viajesylugares.com/imagenes/copacabana505101_960_720.jpg", "Carlos Antezana", "3 dias", "9 me gusta"));
        images.add(new Image("https://uyunisaltflat.com/Images/gallery/incahuasi-island-20.jpg", "Moto Moto", "8 dias", "8 me gusta"));

        return images;
    }

}