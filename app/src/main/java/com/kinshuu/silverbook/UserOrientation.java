package com.kinshuu.silverbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class UserOrientation extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String College="null";
    String Branch="null";
    Integer Batch=0;
    Button BTNcontinue;

    String TAG="MyLOGS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_orientation);

        Spinner spinnerCollege= findViewById(R.id.spinnerCollege);
        Spinner spinnerBatch=findViewById(R.id.spinnerBatch);
        Spinner spinnerBranch=findViewById(R.id.spinnerBranch);
        BTNcontinue=findViewById(R.id.BTNcontinue);

        String[] spinnerBatchlist={"Others","2017","2018","2019"};
        ArrayAdapter<String> spinnerBatchAdapter= new ArrayAdapter<>(UserOrientation.this, android.R.layout.simple_list_item_1,spinnerBatchlist);
        spinnerBatchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBatch.setAdapter(spinnerBatchAdapter);
        spinnerBatch.setOnItemSelectedListener(this);

        String[] spinnerBranchlist={"Others","IT","ECE",};
        ArrayAdapter<String> spinnerBranchAdapter= new ArrayAdapter<>(UserOrientation.this, android.R.layout.simple_list_item_1,spinnerBranchlist);
        spinnerBranchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBranch.setAdapter(spinnerBranchAdapter);
        spinnerBranch.setOnItemSelectedListener(this);

        String[] spinnerCollegelist={"Others","IIIT-A" };
        ArrayAdapter<String> spinnerCollegeAdapter= new ArrayAdapter<>(UserOrientation.this, android.R.layout.simple_list_item_1,spinnerCollegelist);
        spinnerCollegeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCollege.setAdapter(spinnerCollegeAdapter);
        spinnerCollege.setOnItemSelectedListener(this);

        BTNcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent();
                if(College.equals("Others")){
                    Batch=1;
                    Branch="Others";
                    College="Others";
                }
                if(Branch.equals("Others")) {
                    Batch = 1;
                    Branch="Others";
                    College="Others";
                }
                if(Branch.equals("null")) {
                    Batch = 1;
                    Branch="Others";
                    College="Others";
                }
                intent.putExtra("College",College);
                intent.putExtra("Branch",Branch);
                intent.putExtra("Batch",Batch);
                setResult(RESULT_OK,intent);
                Log.d(TAG, "In User Orientation class onClick: College, Branch and Batch is "+College+","+Branch+","+Batch);
                UserOrientation.this.finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){

            case R.id.spinnerBatch:{
                if(parent.getItemAtPosition(position).toString().equals("Others"))
                    Batch=0;
                else
                    Batch=Integer.parseInt(parent.getItemAtPosition(position).toString());
                //Toast.makeText(this, Batch+"", Toast.LENGTH_SHORT).show();
                Log.d("UserOrientation", "onItemSelected: "+Batch);
                break;
            }
            case R.id.spinnerCollege:{
                if(parent.getItemAtPosition(position).toString().equals("Others"))
                    Batch=0;
                else
                    College=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, College, Toast.LENGTH_SHORT).show();
                Log.d("UserOrientation", "onItemSelected: "+College);
                break;
            }
            case R.id.spinnerBranch:{
                if(parent.getItemAtPosition(position).toString().equals("Others"))
                    Batch=0;
                else
                    Branch=parent.getItemAtPosition(position).toString();
                //Toast.makeText(this, Branch, Toast.LENGTH_SHORT).show();
                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
