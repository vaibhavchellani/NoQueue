package com.example.vaibhavchellani.noqueue;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by vaibhavchellani on 10/1/17.
 */

public class JoinQueue extends AppCompatActivity {

    @BindView(R.id.textView1) TextView mTextView1;
    @BindView(R.id.textView2) TextView mTextView2;
    @BindView(R.id.enrollButton) Button enrollButton;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinqueue);
        ButterKnife.bind(this);
        mdatabase= FirebaseDatabase.getInstance().getReference();
        final DatabaseReference queue_ref=mdatabase.child("queues").child("-KvO-b0Hs9IOb-LGwP66");
        //replace the child id with the one we get from recycler view
        queue_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(JoinQueue.this, String.valueOf(dataSnapshot), Toast.LENGTH_SHORT).show();
                mTextView1.setText(dataSnapshot.child("name_of_queue").getValue(String.class));
                int no_of_users=dataSnapshot.child("no_of_tokens").getValue(Integer.class);
                queue_ref.child("users").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //get all current tokens here and show the 3 of them
                        Toast.makeText(JoinQueue.this, "works", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
