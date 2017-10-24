package com.example.vaibhavchellani.noqueue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Models.Queue;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {



    public LinearLayoutManager mlinearLayoutManager;
    public static class QueuesViewHolder extends RecyclerView.ViewHolder{

//     @BindView(R.id.queue_name)   public String queueName;
//     @BindView(R.id.queue_start_date)   public String queueStartDate;
//     @BindView(R.id.queue_start_time)   public String queueStartTime;
//     @BindView(R.id.queue_desc)   public String queueDescription;
        public TextView queueName;
        public TextView queueStartDate;
        public TextView queueStartTime;
        public TextView queueDescription;


        public QueuesViewHolder(View v) {
            super(v);
            queueName = (TextView) itemView.findViewById(R.id.queue_name) ;
            queueStartDate = (TextView) itemView.findViewById(R.id.queue_start_date);
            queueStartTime = (TextView) itemView.findViewById(R.id.queue_start_time);
            queueDescription = (TextView) itemView.findViewById(R.id.queue_desc);
        }
    }
    private TextView mTextMessage;
    private Button trial_createqueue;
    private DatabaseReference mDatabase;
    private FirebaseRecyclerAdapter<Queue,QueuesViewHolder> mFirebaseRecycleAdapter;
    @BindView(R.id.getToken) Button getTokenButton;
    @BindView(R.id.queue_list_view) public RecyclerView mQueueRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mQueueRecyclerView = findViewById(R.id.queue_list_view);
        mTextMessage =  findViewById(R.id.message);
        trial_createqueue=findViewById(R.id.create);
        mlinearLayoutManager = new LinearLayoutManager(this);
        mQueueRecyclerView.setLayoutManager(mlinearLayoutManager);
        mDatabase=FirebaseDatabase.getInstance().getReference();
        trial_createqueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),CreateQueue.class);
                startActivity(i);
            }
        });

        mFirebaseRecycleAdapter = new FirebaseRecyclerAdapter<Queue, QueuesViewHolder>(
                Queue.class,
                R.layout.queuelistview,
                QueuesViewHolder.class,
                mDatabase.child("queues")) {
            @Override
            protected void populateViewHolder(QueuesViewHolder viewHolder, Queue model, int position) {

                if(model.getName_of_queue()!=null
                        && model.getDescription()!=null
                        && model.getQueue_start_time()!=null
                        && model.getQueue_start_date()!=null){

                    viewHolder.queueName.setText(model.getName_of_queue());
                    Log.e("queue_name",model.getName_of_queue());
                    viewHolder.queueDescription.setText(model.getDescription());
                    viewHolder.queueStartDate.setText(model.getQueue_start_date());
                    viewHolder.queueStartTime.setText(model.getQueue_start_time());
                }
            }
        };

        mFirebaseRecycleAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(){
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                int queueCount = mFirebaseRecycleAdapter.getItemCount();
                int mLastVisiblePosition = mlinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (mLastVisiblePosition == -1 ||
                        (positionStart >= (queueCount - 1) &&
                                mLastVisiblePosition == (positionStart - 1))) {
                    mQueueRecyclerView.scrollToPosition(positionStart);
                }
            }
        });

        mQueueRecyclerView.setLayoutManager(mlinearLayoutManager);
        mQueueRecyclerView.setAdapter(mFirebaseRecycleAdapter);

        getTokenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),JoinQueue.class);
                startActivity(i);
            }
        });

    }

}
