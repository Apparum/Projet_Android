package projetandroid.fise3.tse.projetandroid;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEditName;
    RecyclerView recyclerView;
    NameListAdapter nameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameListAdapter.updateList(DataManager.getInstance().getNameList());
    }

    private void initViews()
    {
        recyclerView = findViewById(R.id.activity_main_recyclerView);
        buttonEditName = findViewById(R.id.activity_main_button_editName);
        buttonEditName.setOnClickListener(this);
    }

    private void initList(){
        nameListAdapter = new NameListAdapter();
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation((LinearLayoutManager.VERTICAL));

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nameListAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_button_editName:
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                break;
        }
    }
}
