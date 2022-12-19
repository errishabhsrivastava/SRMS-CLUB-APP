package com.user.srmscet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.user.srmscet.faculty.UpdateFaculty;
import com.user.srmscet.notice.DeleteNoticeActivity;
import com.user.srmscet.notice.UploadNotice;

public class admin_dashboard extends AppCompatActivity implements View.OnClickListener{

    CardView uploadNotice, addGalleryImage, addEbook, faculty, deleteNoitce,adduser;
    Button btnLogOut;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

//        btnLogOut = findViewById(R.id.logout);





        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNoitce = findViewById(R.id.deleteNotice);
        adduser = findViewById(R.id.adduser);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        adduser.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNoitce.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.admin_menu,menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){

            case R.id.addNotice:
                intent = new Intent(admin_dashboard.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.adduser:
                intent = new Intent(admin_dashboard.this, UpdateUser.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                intent = new Intent(admin_dashboard.this,UploadImage.class);
                startActivity(intent);
                break;

            case R.id.addEbook:
                intent = new Intent(admin_dashboard.this,UploadPdfActivity.class);
                startActivity(intent);
                break;

            case R.id.faculty:
                intent = new Intent(admin_dashboard.this, UpdateFaculty.class);
                startActivity(intent);
                break;

            case R.id.deleteNotice:
                intent = new Intent(admin_dashboard.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;


        }

    }


    public void Logout(MenuItem item) {
        mAuth = FirebaseAuth.getInstance();

        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(admin_dashboard.this, LoginActivity.class));
            Toast.makeText(this, "User logged out successfully", Toast.LENGTH_SHORT).show();
        });
    }


}
