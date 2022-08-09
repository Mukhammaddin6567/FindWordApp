package uz.gita.findwordappMBF.ui;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import uz.gita.findwordappMBF.R;

public class MainFragmentDirections {
  private MainFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionMainFragmentToGameFragment() {
    return new ActionOnlyNavDirections(R.id.action_mainFragment_to_gameFragment);
  }

  @NonNull
  public static NavDirections actionMainFragmentToSettingsFragment() {
    return new ActionOnlyNavDirections(R.id.action_mainFragment_to_settingsFragment);
  }
}
