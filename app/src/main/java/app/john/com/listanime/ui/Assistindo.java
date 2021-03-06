package app.john.com.listanime.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.john.com.listanime.R;
import app.john.com.listanime.adapters.AnimeRVAdapter;
import app.john.com.listanime.intermediario.Controle;
import app.john.com.listanime.modelos.Anime;

public class Assistindo extends Fragment {
    /* Atributos */
    View view;
    private RecyclerView rvAnimes;
    private Controle controle;

    /* Construtor */
    public Assistindo() {

    }

    /* Métodos */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_assistindo, container, false);

        rvAnimes = view.findViewById(R.id.rvAssistindo);

        carregarDados();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        controle = new Controle();
    }

    @Override
    public void onResume() {
        super.onResume();
        carregarDados();
    }

    private void carregarDados() {
        List<Anime> animes = new ArrayList<>();

        for (Anime anime: controle.getUsuarioLogado().getAnimes()) {
            if (anime.getStatus().equals("Assistindo")) {
                animes.add(anime);
            }
        }
        AnimeRVAdapter adapter = new AnimeRVAdapter(getContext(), animes);

        rvAnimes.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvAnimes.setAdapter(adapter);
    }
}
