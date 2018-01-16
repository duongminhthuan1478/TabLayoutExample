package com.example.dell.tablayoutexample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private SimpleFragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        displayTabLayout();

        //Set icon for tablayout
        setUpIcon();

    }
    private void displayTabLayout() {
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

        // Create an adapter that knows which fragment should be shown on each page
        mAdapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager());
        createAdapter(mAdapter);

        // Set the adapter onto the view pager
        viewPager.setAdapter(mAdapter);

        // Find the tab layout that shows the tabs
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        // Connect the tab layout with the view pager. This will
        //   1. Update the tab layout when the view pager is swiped
        //   2. Update the view pager when a tab is selected
        //   3. Set the tab layout's tab names with the view pager's adapter's titles
        //      by calling onPageTitle()
        mTabLayout.setupWithViewPager(viewPager);


    }
    private void setUpIcon() {
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(R.drawable.icon_adr);
        }
    }

    /**
     * display Fragment with a String title
     *
     * @param adapter
     */
    private void createAdapter(SimpleFragmentPagerAdapter adapter) {
        adapter.addFragment(new FirstFragment(), "FIRST");
        adapter.addFragment(new SecondFragment(), "SECOND");
        adapter.addFragment(new ThirdFragment(), "THIRD");
    }


}
