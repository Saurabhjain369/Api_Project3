package com.example.api_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Desc_Owner extends AppCompatActivity {

    String url;
    String publicreposlink;
    List_Adapter adapt;
    ImageView pimg;
    TextView oname,followers,following,publicrepo,plink;
    ArrayList<List_Products> pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc__owner);

        pimg = findViewById(R.id.profilepic);
        oname = findViewById(R.id.oname);
        followers = findViewById(R.id.fol);
        following = findViewById(R.id.follow);
        publicrepo = findViewById(R.id.publicrepo);


        pro = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();

        Intent i = getIntent();

        List_Products p = i.getParcelableExtra("data");

        url = bundle.getString("url");



        System.out.println("Link of owner Details :- " + url);

        try {

            String urlvalue = new Asyncdata().execute(url).get();


            System.out.println("This is from Desc:" + urlvalue);


                JSONObject link1 = new JSONObject(urlvalue);

            String image = link1.getString("avatar_url");
                String login = link1.getString("login");
            String fol = link1.getString("followers");
            String follow = link1.getString("following");
            String publicRepos = link1.getString("public_repos");
             publicreposlink = link1.getString("repos_url");


                System.out.println("Owner Name" + login);

            System.out.println("image" + image);
            System.out.println("Followers " +fol );
            System.out.println("Following " + follow);
            System.out.println("publicrepos " + publicRepos);

            System.out.println("publicreposlink  : " + publicreposlink);

                //String followers = ownerdatas.getString("followers");

          //  System.out.println("ProductDesc "+p.getPimg());


              Picasso.get().load(image).into(pimg);

        oname.setText(login);
        followers.setText(fol);
        following.setText(follow);
            publicrepo.setText(publicRepos);


            publicrepo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(Desc_Owner.this, List_Repo.class);

                    i.putExtra("publicrepo",publicreposlink);
                    i.putExtra("TAG", "owner");

                    startActivity(i);
                }


            });





        } catch(InterruptedException e){
                e.printStackTrace();
            } catch(ExecutionException e){
                e.printStackTrace();
            } catch(JSONException e){
                e.printStackTrace();
            }

            }

    }






