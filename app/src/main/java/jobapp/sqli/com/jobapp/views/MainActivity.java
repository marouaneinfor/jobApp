package jobapp.sqli.com.jobapp.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import jobapp.sqli.com.jobapp.R;
import jobapp.sqli.com.jobapp.dagger.presenters.DaggerPresenterComponent;
import jobapp.sqli.com.jobapp.dagger.presenters.PresenterModule;
import jobapp.sqli.com.jobapp.presenter.*;
import jobapp.sqli.com.jobapp.views.adapters.MultipleViewTypesAdapter;


public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView mRecyclerView;
    private MultipleViewTypesAdapter mAdapter;
    private ProgressBar mProgressBar;
    @Inject
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        DaggerPresenterComponent.builder().presenterModule(new PresenterModule(this)).build().inject(this);

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setItems(List<Object> items) {
        mAdapter = new MultipleViewTypesAdapter(items);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setError(String message) {
        Toast.makeText(this.getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


}
