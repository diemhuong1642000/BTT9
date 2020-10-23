package com.example.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem,btnCN;
    EditText edt;
    ListView lv;
    int vitri=-1;
    ArrayList <String> UserAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView);
        btnThem = (Button) findViewById(R.id.buttonThem);

        btnCN = (Button) findViewById(R.id.buttonCapnhat);
        edt = (EditText) findViewById(R.id.editText);
        UserAccount = new ArrayList<>();
        UserAccount.add("Tăng Thị Diễm Hương");
        UserAccount.add("Lê Thị Kim Thoa");
        UserAccount.add("Nguyễn Văn Trí");
        UserAccount.add("Nguyễn Kim An");
        UserAccount.add("Trần Quốc Nghĩa");
        UserAccount.add("Dương Xuân Dưỡng");
        UserAccount.add("Trịnh Quang Phúc");



        // android.R.layout.simple_list_item_1 is a constant predefined layout of Android.
        // used to create a ListView with simple ListItem (Only one TextView).


        final ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                UserAccount

        );
        lv.setAdapter(adapter);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = edt.getText().toString();
                UserAccount.add(item);
                adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                edt.setText(UserAccount.get(i));
                vitri=i;
            }
        });
        btnCN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserAccount.set(vitri,edt.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "Đã xóa " +UserAccount.get(position),
                        Toast.LENGTH_SHORT
                ).show();

                UserAccount.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }


}