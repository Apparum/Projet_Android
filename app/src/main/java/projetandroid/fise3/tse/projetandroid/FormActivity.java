package projetandroid.fise3.tse.projetandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private Button confirmButton;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initView();
    }

    private void initView() {
        confirmButton = findViewById(R.id.activity_form_button_confirm);
        editTextName = findViewById(R.id.activity_form_editText_name);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmName();
            }
        });
    }

    private void confirmName() {
        String name = editTextName.getText().toString();
        if (!name.isEmpty()){
            DataManager.getInstance().addItem(name);
        } else {
            Toast.makeText(this,
                    "Veuillez saisir votre nom",
                    Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
