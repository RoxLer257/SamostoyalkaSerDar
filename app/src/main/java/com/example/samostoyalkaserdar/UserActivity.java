package com.example.samostoyalkaserdar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {
    private EditText nameBox;
    private EditText quanBox;
    private Button delButton;
    private DatabaseAdapter adapter;
    private long userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        nameBox = findViewById(R.id.name);
        quanBox = findViewById(R.id.quan);
        delButton = findViewById(R.id.deleteButton);
        adapter = new DatabaseAdapter(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("ID");
        }
        if (userId > 0) {
            adapter.open();
            Fruits fruits = adapter.getUser(userId);
            nameBox.setText(fruits.getName());
            quanBox.setText(String.valueOf(fruits.getQuan()));

            adapter.close();
        } else {
            delButton.setVisibility(View.GONE);
        }
    }
    public void save(View view){
        String name = nameBox.getText().toString();
        int quan = Integer.parseInt(quanBox.getText().toString());
        Fruits fruits = new Fruits(userId, name, quan);

        adapter.open();
        if (userId > 0) {
            adapter.update(fruits);
        } else {
            adapter.insert(fruits);
        }
        adapter.close();
        goHome();
    }
    public void delete(View view){
        adapter.open();
        adapter.delete(userId);
        adapter.close();
        goHome();
    }
    private void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
}
