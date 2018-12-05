package projetandroid.fise3.tse.projetandroid;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textViewName;
    Button buttonEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeFields();
    }

    private void initializeFields()
    {
        textViewName = findViewById(R.id.activity_main_textView_name);
        buttonEditName = findViewById(R.id.activity_main_button_editName);
        buttonEditName.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_button_editName:
                Intent intent = new Intent(this, FormActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
