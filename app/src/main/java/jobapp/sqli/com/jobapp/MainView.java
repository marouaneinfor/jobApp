
package jobapp.sqli.com.jobapp;

import java.util.List;

public interface MainView {


  void setItems(List<Object> items);
  void setError(String message);
  void showProgress();

  void hideProgress();
}
