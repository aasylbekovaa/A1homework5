package com.example.a1homework5.fragments.first_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a1homework5.R;
import com.example.a1homework5.fragments.second_fragment.SecondFragment;


public class FirstFragment extends Fragment {
    Button btnOpen;
    TextView tvText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnOpen = view.findViewById(R.id.btn_open);
        tvText = view.findViewById(R.id.tv_text);
        listens();
        getData();
    }


    private void listens() {
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondFragment secondFragment = new SecondFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, secondFragment).commit();
            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            String s = getArguments().getString("Key");
            tvText.setText(s);

        }
        tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toString = tvText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("KeyA", toString);
                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, secondFragment).commit();
            }
        });
    }
}