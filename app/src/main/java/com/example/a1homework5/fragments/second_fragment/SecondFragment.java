package com.example.a1homework5.fragments.second_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a1homework5.R;
import com.example.a1homework5.fragments.first_fragment.FirstFragment;

public class SecondFragment extends Fragment {
    EditText etInput;
    Button btnData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etInput = view.findViewById(R.id.et_input);
        btnData = view.findViewById(R.id.btn_data);
        Listeners();
        getData();

    }


    private void Listeners() {
        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etInput.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Key", title);
                FirstFragment firstFragment = new FirstFragment();
                firstFragment.setArguments(bundle);
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.container_fragment, firstFragment).commit();

            }
        });
    }

    private void getData() {
        if (getArguments() != null) {
            String s = getArguments().getString("KeyA");
            etInput.setText(s);
        }


    }
}
