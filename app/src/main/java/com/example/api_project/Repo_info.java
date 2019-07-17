package com.example.api_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Repo_info extends AppCompatActivity {

    TextView Name,lang,cont,ownerdetails,ownername;
List_Adapter adapt;
String url;
    ArrayList<List_Products> pro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_info);


        pro =  new ArrayList<>();

        Name= findViewById(R.id.Name);
        lang= findViewById(R.id.lang);
        cont= findViewById(R.id.cont);
        ownerdetails=findViewById(R.id.ownerdetails);

        //ownerdetails =  findViewById(R.id.ownerdetails);

        Intent i = getIntent();

        List_Products p = i.getParcelableExtra("data");

        String name = p.getname();



        System.out.println(" "+p.getname());

    //    System.out.println(" RepO info page link :"+link);

//        Picasso.get().load(p.getPimg()).into(pimg);

        Name.setText(p.getname());
        cont.setText(p.getId());

  ownerdetails.setText(""+p.getOwnerdetails());

 url = p.getLink();

        adapt =  new List_Adapter(Repo_info.this,pro);



        ownerdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Repo_info.this,Desc_Owner.class);

              //  i.putExtra("link", link);

                Bundle bundle =  new Bundle();

                bundle.putString("url",url);

                 i.putExtras(bundle);

                startActivity(i);


            }
        });

        System.out.println("This is from products page: "+name);


        System.out.println("This is from products page: "+cont);

        System.out.println("This is from products page: "+lang);

        System.out.println("This is from products page: "+ownerdetails);


    }
}
