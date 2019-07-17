package com.example.api_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class List_Repo extends AppCompatActivity {

    ListView lsp;
    List_Adapter adapt;
    ArrayList<List_Products> pro;
    String ownername;
String listlink;
String ownerlink;

    String ls = "https://api.github.com/repositories";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__repo);

            lsp = findViewById(R.id.listrepo);


          pro =  new ArrayList<>();


          Intent i= getIntent();
          String tag= i.getStringExtra("TAG");
            ownerlink = i.getStringExtra("publicrepo");


        System.out.println("tag name : " + tag);
        System.out.println("Owner Repos Link: " + ownerlink);


          if(tag.equals("splash"))
          {


              getdata(ls);


          }
          else
          {

              getdata(ownerlink);

          }


        }

    public void getdata(String flink)
    {
        try {
            String mysts = new Asyncdata().execute(flink).get();


            System.out.println("This is from MainActivity:" + mysts);

            JSONArray proarray = new JSONArray(mysts);


            for (int i = 0; i < proarray.length(); i++) {
                JSONObject childobj = proarray.getJSONObject(i);

                JSONObject owner = childobj.getJSONObject("owner");


                //JSONObject link1 = owner.getJSONObject("url");

                String name = childobj.getString("name");
                String id = childobj.getString("id");
                String ownerdetails = owner.getString("login");
                String link = owner.getString("url");


                String pimg = owner.getString("avatar_url");
                String followers = owner.getString("followers_url");
                String following = owner.getString("following_url");
                String cont = owner.getString("type");


//                    String jobj =  new Asyncdata().execute(link).get();

                // JSONObject url = new JSONObject(jobj);

                //   String value= url.getString("login");

                //    String value1= url.getString("followers");

                pro.add(new List_Products(name, id, ownerdetails, link, pimg, followers, following, cont));

                System.out.println("names : " + name);
                System.out.println("lang : " + id);
                System.out.println("Owner : " + ownerdetails);
                System.out.println("URL of Owner : " + link);
                System.out.println("Owner Reposlink: " + ownerlink);
                //    System.out.println("name of Owner : "+value);
                //  System.out.println("name of Owner : "+value1);
            }


            adapt = new List_Adapter(List_Repo.this, pro);

            lsp.setAdapter(adapt);

            lsp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(List_Repo.this, pro.get(position).getname(), Toast.LENGTH_LONG).show();

                    Bundle bundle = new Bundle();
                    bundle.putParcelable("data", pro.get(position));


                    Intent i = new Intent(List_Repo.this, Repo_info.class);
                    i.putExtra("data", pro.get(position));
                    startActivity(i);
                }
            });


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




}

