package com.example.admin.apptest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{
    private Boolean isFabOpen = false;
    private FloatingActionButton floatingActionButton1,floatingActionButton2 ;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private PieChartActivity pieChartActivity;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        floatingActionButton1= (FloatingActionButton)findViewById(R.id.mainfab_button);
        Target viewTarget = new ViewTarget(R.id.mainfab_button, this);
        new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setContentTitle(R.string.title_single_shot)
                .setContentText(R.string.R_string_desc_single_shot).singleShot(42)
                .build();
        floatingActionButton1.setOnClickListener(this);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.piechart_fabbutton);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

        floatingActionButton2.setOnClickListener(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_item1) {

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_chart)
        {
            Intent  intent = new Intent(getApplication(),PieChartActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.nav_send)
        {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.mainfab_button:
                animateFAB();
                break;
            case R.id.piechart_fabbutton:
                startActivity(new Intent(getApplicationContext(),PieChartActivity.class));
                break;
            default :
                break;

        }
    }
    public void animateFAB() {
        if (isFabOpen) {
            floatingActionButton1.startAnimation(rotate_backward);
            floatingActionButton2.startAnimation(fab_close);
            floatingActionButton2.setClickable(false);
            isFabOpen= false;
            Log.d("Ramasamy", "close");
        } else {
            floatingActionButton1.startAnimation(rotate_forward);
            floatingActionButton2.startAnimation(fab_open);
            floatingActionButton2.setClickable(true);
            isFabOpen = true;
            Log.d("Ramasamy", "open");
        }
    }
}
