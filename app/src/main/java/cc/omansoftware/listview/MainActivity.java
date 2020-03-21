package cc.omansoftware.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView myListView; //Initialize ListView and call it by myListView
    ListAdapter myListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize a list on random names
        final String[] names = {"Cierra Vega",
                "Alden Cantrell",
                "Kierra Gentry",
                "Pierre Cox",
                "Thomas Crane",
                "Miranda Shaffer",
                "Bradyn Kramer",
                "Alvaro Mcgee"};


        myListView = findViewById(R.id.myListView); //call myListView from XML by it's id

        myListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);//Initialize adapter for list view to link the list view with the names list by using simple_list_item_1 model
        myListView.setAdapter(myListAdapter);//link list view with adapter


        //add click action to list view
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //position_NO is represent the number of each item on the list view by order from the top (0, 1, 2.......)
            public void onItemClick(AdapterView<?> parent, View view, int position_NO, long id) {

                String nameAtPosition = String.valueOf(parent.getItemAtPosition(position_NO));//ask the parent of adapter to giv us the value of each position_NO which come from the name list

                Toast.makeText(getApplicationContext(), "Item "+ position_NO +" its name is: "+nameAtPosition,Toast.LENGTH_LONG).show();//display a message contains the position number and the position value

            }
        });
    }
}
