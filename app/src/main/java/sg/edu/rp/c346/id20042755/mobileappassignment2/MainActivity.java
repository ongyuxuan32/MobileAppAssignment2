package sg.edu.rp.c346.id20042755.mobileappassignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button Add,Clear,Update;
    ListView ViewList;
    ArrayList<String> List;
    ArrayAdapter<String>List2;
    String item;
    Integer index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Add = findViewById(R.id.AddButton);
        Clear = findViewById(R.id.ClearButton);
        Update = findViewById(R.id.UpdateButton);
        ViewList = findViewById(R.id.ViewList);
        input = findViewById(R.id.Userinput);

        List = new ArrayList<>();
        List.add("2021-08-09 Logitech Mouse");
        List.add("2021-08-10 Razer Mouse");
        List.add("2021-08-11 Corsair Mouse");
        List.add("2021-08-12 Msi Mouse");
        List.add("2021-08-13 Tecware Mouse");

        List2 = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,List);
        ViewList.setAdapter(List2);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String additem = input.getText().toString();
                List.add(additem);
                List2.notifyDataSetChanged();
                input.setText(null);
            }
        });

        ViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                item = adapterView.getItemAtPosition(i).toString() + "Has been Selected";
                index = i;
                Toast.makeText(MainActivity.this,item,Toast.LENGTH_SHORT).show();

            }
        });

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String update = input.getText().toString();
                List.set(index,update);
                List2.notifyDataSetChanged();
            }
        });
        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String update = "";
                List.set(index,update);
                List2.notifyDataSetChanged();
            }
        });


    }
}