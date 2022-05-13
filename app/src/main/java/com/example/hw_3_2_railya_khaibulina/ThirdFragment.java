package com.example.hw_3_2_railya_khaibulina;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdFragment extends Fragment {

    public static final String KEY = "KEY";
    private Button btn_next;
    private EditText edit_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_next = view.findViewById(R.id.btn_next);
        edit_text = view.findViewById(R.id.edittext);
        String data = getArguments().getString(KEY);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY, edit_text.getText().toString());
                FourthFragment fragment = new FourthFragment();
                fragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).commit();
            }
        });
    }
}