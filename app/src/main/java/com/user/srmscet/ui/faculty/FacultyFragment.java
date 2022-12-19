package com.user.srmscet.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.user.srmscet.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView csDepartment, itDepartment, electricalDepartment, mechanicalDepartment;
    private RecyclerView tyroclub,litraryclub,robotraxclub,aeronauticsclub,synergyclub,mrc,pharmaqumicaclub,illuminaticlub,equinoxclub;
    private LinearLayout tyroclubNoData,litraryclubNoData,robotraxclubNoData,aeronauticsclubNoData,synergyclubNoData,mrcNoData,pharmaqumicaclubNoData,illuminaticlubNoData,equinoxclubNoData;
    private LinearLayout csNoData, itNoData, electricalNoData,mechanicalNoData;
    private List<TeacherData> list0 ,list1, list2, list3 , list4,list5,list6,list7,list8;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);


        tyroclub = view.findViewById(R.id.tyroclub);
        tyroclubNoData = view.findViewById(R.id.tyroclubNoData);

        litraryclub = view.findViewById(R.id.litraryclub);
        litraryclubNoData = view.findViewById(R.id.litraryclubNoData);

        illuminaticlub = view.findViewById(R.id.illuminaticlub);
        illuminaticlubNoData = view.findViewById(R.id.illuminaticlubNoData);

        synergyclub = view.findViewById(R.id.synergyclub);
        synergyclubNoData = view.findViewById(R.id.synergyclubNoData);

        robotraxclub = view.findViewById(R.id.Robotraxclub);
        robotraxclubNoData = view.findViewById(R.id.RobotraxclubNoData);

        aeronauticsclub = view.findViewById(R.id.aeronauticsclub);
        aeronauticsclubNoData = view.findViewById(R.id.aeronauticsclubNoData);

        equinoxclub = view.findViewById(R.id.equinoxclub);
        equinoxclubNoData = view.findViewById(R.id.equinoxclubNoData);

        mrc = view.findViewById(R.id.mediarelationalclub);
        mrcNoData = view.findViewById(R.id.mediarelationalclubNoData);

        pharmaqumicaclub = view.findViewById(R.id.pharmaquimicaclub);
        pharmaqumicaclubNoData = view.findViewById(R.id.pharmaquimicaclubNoData);


//        csDepartment = view.findViewById(R.id.csDepartment);
//        itDepartment = view.findViewById(R.id.itDepartment);
//        electricalDepartment = view.findViewById(R.id.electricalDepartment);
//        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
//
//        csNoData = view.findViewById(R.id.csNoData);
//        itNoData = view.findViewById(R.id.itNoData);
//        electricalNoData = view.findViewById(R.id.electricalNoData);
//        mechanicalNoData = view.findViewById(R.id.mechanicalNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

//        clubs
        tyroclub();
        litraryclub();
        illuminaticlub();
        synergyclub();
        robotraxclub();
        equinoxclub();
        pharmaqumicaclub();
        mrc();
        aeronauticsclub();

        return view;
    }

    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {
                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void tyroclub() {
        dbRef = reference.child("Tyro Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list0 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    tyroclubNoData.setVisibility(View.VISIBLE);
                    tyroclub.setVisibility(View.GONE);
                }else {
                    tyroclubNoData.setVisibility(View.GONE);
                    tyroclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list0.add(data);
                    }
                    tyroclub.setHasFixedSize(true);
                    tyroclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list0, getContext());
                    tyroclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void aeronauticsclub() {
        dbRef = reference.child("Aeronautics Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    aeronauticsclubNoData.setVisibility(View.VISIBLE);
                    aeronauticsclub.setVisibility(View.GONE);
                }else {
                    aeronauticsclubNoData.setVisibility(View.GONE);
                    aeronauticsclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list8.add(data);
                    }
                    aeronauticsclub.setHasFixedSize(true);
                    aeronauticsclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list8, getContext());
                    aeronauticsclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mrc() {
        dbRef = reference.child("Media Relational Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mrcNoData.setVisibility(View.VISIBLE);
                    mrc.setVisibility(View.GONE);
                }else {
                    mrcNoData.setVisibility(View.GONE);
                    mrc.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list7.add(data);
                    }
                    mrc.setHasFixedSize(true);
                    mrc.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list7, getContext());
                    mrc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pharmaqumicaclub() {
        dbRef = reference.child("Pharmaqumica Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pharmaqumicaclubNoData.setVisibility(View.VISIBLE);
                    pharmaqumicaclub.setVisibility(View.GONE);
                }else {
                    pharmaqumicaclubNoData.setVisibility(View.GONE);
                    pharmaqumicaclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list6.add(data);
                    }
                    pharmaqumicaclub.setHasFixedSize(true);
                    pharmaqumicaclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    pharmaqumicaclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void equinoxclub() {
        dbRef = reference.child("Equinox Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    equinoxclubNoData.setVisibility(View.VISIBLE);
                    equinoxclub.setVisibility(View.GONE);
                }else {
                    equinoxclubNoData.setVisibility(View.GONE);
                    equinoxclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list5.add(data);
                    }
                    equinoxclub.setHasFixedSize(true);
                    equinoxclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    equinoxclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void robotraxclub() {
        dbRef = reference.child("Robotrax Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    robotraxclubNoData.setVisibility(View.VISIBLE);
                    robotraxclub.setVisibility(View.GONE);
                }else {
                    robotraxclubNoData.setVisibility(View.GONE);
                    robotraxclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    robotraxclub.setHasFixedSize(true);
                    robotraxclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    robotraxclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void synergyclub() {
        dbRef = reference.child("Synergy Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    synergyclubNoData.setVisibility(View.VISIBLE);
                    synergyclub.setVisibility(View.GONE);
                }else {
                    synergyclubNoData.setVisibility(View.GONE);
                    synergyclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    synergyclub.setHasFixedSize(true);
                    synergyclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    synergyclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void illuminaticlub() {
        dbRef = reference.child("illuminati Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    illuminaticlubNoData.setVisibility(View.VISIBLE);
                    illuminaticlub.setVisibility(View.GONE);
                }else {
                    illuminaticlubNoData.setVisibility(View.GONE);
                    illuminaticlub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    illuminaticlub.setHasFixedSize(true);
                    illuminaticlub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    illuminaticlub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void litraryclub() {
        dbRef = reference.child("Litrary Club");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    litraryclubNoData.setVisibility(View.VISIBLE);
                    litraryclub.setVisibility(View.GONE);
                }else {
                    litraryclubNoData.setVisibility(View.GONE);
                    litraryclub.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    litraryclub.setHasFixedSize(true);
                    litraryclub.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    litraryclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}