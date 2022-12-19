package com.user.srmscet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.user.srmscet.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.user.srmscet.faculty.TeacherAdapter;
import com.user.srmscet.faculty.TeacherData;

import java.util.ArrayList;
import java.util.List;

public class UpdateUser extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment, itDepartment, electricalDepartment, mechanicalDepartment;
    private RecyclerView tyroclub,litraryclub,robotraxclub,aeronauticsclub,synergyclub,mrc,pharmaqumicaclub,illuminaticlub,equinoxclub;
    private LinearLayout tyroclubNoData,litraryclubNoData,robotraxclubNoData,aeronauticsclubNoData,synergyclubNoData,mrcNoData,pharmaqumicaclubNoData,illuminaticlubNoData,equinoxclubNoData;
    private LinearLayout csNoData, itNoData, electricalNoData,mechanicalNoData;
    private List<TeacherData> list0 ,list1, list2, list3 , list4,list5,list6,list7,list8;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        tyroclub = findViewById(R.id.tyroclub);
        tyroclubNoData = findViewById(R.id.tyroclubNoData);

        litraryclub = findViewById(R.id.litraryclub);
        litraryclubNoData = findViewById(R.id.litraryclubNoData);

        illuminaticlub = findViewById(R.id.illuminaticlub);
        illuminaticlubNoData = findViewById(R.id.illuminaticlubNoData);

        synergyclub = findViewById(R.id.synergyclub);
        synergyclubNoData = findViewById(R.id.synergyclubNoData);

        robotraxclub = findViewById(R.id.Robotraxclub);
        robotraxclubNoData = findViewById(R.id.RobotraxclubNoData);

        aeronauticsclub = findViewById(R.id.aeronauticsclub);
        aeronauticsclubNoData = findViewById(R.id.aeronauticsclubNoData);

        equinoxclub = findViewById(R.id.equinoxclub);
        equinoxclubNoData = findViewById(R.id.equinoxclubNoData);

        mrc = findViewById(R.id.mediarelationalclub);
        mrcNoData = findViewById(R.id.mediarelationalclubNoData);

        pharmaqumicaclub = findViewById(R.id.pharmaquimicaclub);
        pharmaqumicaclubNoData = findViewById(R.id.pharmaquimicaclubNoData);

//        csDepartment = findViewById(R.id.csDepartment);
//        itDepartment = findViewById(R.id.itDepartment);
//        electricalDepartment = findViewById(R.id.electricalDepartment);
//        mechanicalDepartment = findViewById(R.id.mechanicalDepartment);
//
//        csNoData = findViewById(R.id.csNoData);
//        itNoData = findViewById(R.id.itNoData);
//        electricalNoData = findViewById(R.id.electricalNoData);
//        mechanicalNoData = findViewById(R.id.mechanicalNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

//        csDepartment();
//        itDepartment();
//        electricalDepartment();
//        mechanicalDepartment();

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


        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateUser.this, com.user.srmscet.faculty.AddTeacher.class));
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
                    aeronauticsclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list8, UpdateUser.this, "Aeronautics Club");
                    aeronauticsclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    mrc.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list7, UpdateUser.this, "Media Relational Club");
                    mrc.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    pharmaqumicaclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list6, UpdateUser.this, "Pharmaqumica Club");
                    pharmaqumicaclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    equinoxclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list5, UpdateUser.this, "Equinox Club");
                    equinoxclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    robotraxclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list4, UpdateUser.this, "Robotrax Club");
                    robotraxclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    synergyclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list3, UpdateUser.this, "Synergy Club");
                    synergyclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    illuminaticlub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list2, UpdateUser.this, "illuminati Club");
                    illuminaticlub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    litraryclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list1, UpdateUser.this, "Litrary Club");
                    litraryclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
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
                    tyroclub.setLayoutManager(new LinearLayoutManager(UpdateUser.this));
                    adapter = new TeacherAdapter(list0, UpdateUser.this, "Tyro Club");
                    tyroclub.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateUser.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}