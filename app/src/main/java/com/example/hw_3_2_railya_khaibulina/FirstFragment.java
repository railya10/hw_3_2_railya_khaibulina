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
import android.widget.Toast;

import com.example.hw_3_2_railya_khaibulina.R;
import com.example.hw_3_2_railya_khaibulina.SecondFragment;

public class FirstFragment extends Fragment {

    public static final String KEY = "KEY";
    private Button btn_next;
    private EditText edit_text;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_next = view.findViewById(R.id.btn_next);
        edit_text = view.findViewById(R.id.edittext);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit_text.getText().toString().isEmpty()) {
                    Toast.makeText(requireActivity(), "ERROR! Enter your data", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString(KEY, edit_text.getText().toString());
                    SecondFragment fragment = new SecondFragment();
                    fragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).commit();
                }
            }
        });

    }
}