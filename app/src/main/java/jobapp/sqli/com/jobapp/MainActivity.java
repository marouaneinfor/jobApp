package jobapp.sqli.com.jobapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import jobapp.sqli.com.jobapp.adapters.MultipleViewTypesAdapter;
import jobapp.sqli.com.jobapp.model.FindItemsInteractorImpl;
import jobapp.sqli.com.jobapp.presenter.MainPresenter;
import jobapp.sqli.com.jobapp.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView {
  private RecyclerView mRecyclerView;
  private MultipleViewTypesAdapter mAdapter;
  private MainPresenter mPresenter;
  private ProgressBar mProgressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    mPresenter = new MainPresenterImpl(this, new FindItemsInteractorImpl(this));
    mProgressBar = (ProgressBar) findViewById(R.id.progress);

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
    mAdapter = new MultipleViewTypesAdapter(items, this);
    mRecyclerView.setAdapter(mAdapter);
    mAdapter.notifyDataSetChanged();

  }

  @Override
  public void setError(String message) {
   Toast.makeText(this.getApplicationContext(),message,Toast.LENGTH_LONG).show();
  }


}
