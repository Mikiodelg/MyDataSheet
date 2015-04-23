package com.platygames.mydatasheet;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import android.util.Log;
import android.content.Intent;
import android.widget.Toast;

import com.platygames.mydatasheet.entities.*;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private Integer mInt;
    private int actual_sheet;
    private List<Sheet> Sheets = new ArrayList<Sheet>();
    private List<Module> Modules = new ArrayList<Module>();
    private List<Item> Items = new ArrayList<Item>();

    //Lists

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public List<Sheet> getSheets() {
        return Sheets;
    }

    public void setSheets(List<Sheet> sheets) {
        Sheets = sheets;
    }

    public List<Module> getModules() {
        return Modules;
    }

    public void setModules(List<Module> modules) {
        Modules = modules;
    }

    public List<Item> getItems() {
        return Items;
    }

    public void setItems(List<Item> items) {
        Items = items;
    }

    public void setActual_sheet(int actual){
        actual_sheet=actual;
    }
    public Integer getMInt(){return mInt;}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Init();


                super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        actual_sheet=0;
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        // Expandable List

        // get the listview


        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        // setting list data
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);


        // Expandable List
    }


    public void prepareListData() {
        Log.d("prepareList","prepareList: estoy cogiendo el sheet: "+actual_sheet);
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        List<String> data = new ArrayList<String>();

            for (int i = 0; i<Sheets.get(actual_sheet).getSheet_modules().size();i++){
                listDataHeader.add(Sheets.get(actual_sheet).getSheet_modules().get(i).getModule_name());
                for (int j = 0; j<Sheets.get(actual_sheet).getSheet_modules().get(i).getModule_items().size();j++){
                    data.add(Sheets.get(actual_sheet).getSheet_modules().get(i).getModule_items().get(j).getItem_label());
                    Log.d("prepareList","item: estoy cogiendo el item: "+data.get(j));
                }
                listDataChild.put(listDataHeader.get(0), data);
            }
        }
    public void notifyDataSetChanged() {
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        listAdapter.notifyDataSetChanged();
    }
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void Init(){
        //Initialize Forced Data

        Sheet sheet = new Sheet("1","Ficha 1","Ficha de prueba");
        Sheets.add(sheet);
        Module module = new Module("1","1","Atributos","Atributos del personaje");
        Sheets.get(0).addSheet_modules(module);
        Item item = new Item("0", "0", "Nominal", "FUE", "8");
        Sheets.get(0).getSheet_modules().get(0).addModule_items(item);
        item = new Item("1", "0", "Nominal", "AGI", "8");
        Sheets.get(0).getSheet_modules().get(0).addModule_items(item);
        item = new Item("2", "0", "Nominal", "INT", "8");
        Sheets.get(0).getSheet_modules().get(0).addModule_items(item);
        //
        sheet = new Sheet("2","Ficha 2","Ficha de prueba 2");
        Sheets.add(sheet);
        module = new Module("1","2","Atributos","Atributos del personaje 2");
        Sheets.get(1).addSheet_modules(module);
        //
        sheet = new Sheet("1","Ficha 3","Ficha de prueba 3");
        Sheets.add(sheet);
        module = new Module("1","3","Atributos","Atributos del personaje 3");
        Sheets.get(2).addSheet_modules(module);
        //

    }
    public void onSectionAttached(int number) {
        mInt = number-1;
        mTitle = Sheets.get(number-1).getSheet_name();
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent (this, MySheets.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
}
