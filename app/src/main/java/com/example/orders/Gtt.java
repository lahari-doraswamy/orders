package com.example.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Gtt extends Fragment {

RecyclerView recyclerView;
ArrayList<String> stockname = new ArrayList<>();
ArrayList<String> network = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gtt, container, false);
        recyclerView = view.findViewById(R.id.Recyclerview);


        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        try {
            JSONObject obj = new JSONObject(JSONfromAsserts());
            JSONArray userArray = obj.getJSONArray("data");
            for (int i=0 ; i<userArray.length();i++){
                JSONObject stockdetails =userArray.getJSONObject(i);
                stockname.add(stockdetails.getString("stockname"));
                network.add(stockdetails.getString("network"));

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        CustomAdapter customAdapter = new CustomAdapter(stockname, network,getContext()) {

            @Override
            public int getItemCount() {
                return 0;
            }
        };
        recyclerView.setAdapter(customAdapter);
        return view;
    }

    private String JSONfromAsserts() {
        String json=null;
        try {
            InputStream is = getActivity().getAssets().open("generated.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");


        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }



    }
