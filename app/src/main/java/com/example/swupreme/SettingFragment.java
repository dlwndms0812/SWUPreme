package com.example.swupreme;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.BaseAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;

import static com.example.swupreme.LoginActivity.mOAuthLoginModule;
import static com.example.swupreme.LoginActivity.mcontext;



//설정 창 fragment
public class SettingFragment extends PreferenceFragmentCompat {
    SharedPreferences prefs;
    PreferenceScreen logout;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);

        logout=(PreferenceScreen)findPreference("logout");
        prefs= PreferenceManager.getDefaultSharedPreferences(getActivity());

        if(!prefs.getString("logout","").equals("")){
            mOAuthLoginModule.logout(mcontext);
        }

       // prefs.registerOnSharedPreferenceChangeListener(prefListener);

    }

    /*
    SharedPreferences.OnSharedPreferenceChangeListener prefListener=new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if(key.equals("logout")){
                mOAuthLoginModule.logout(mcontext);
                ((BaseAdapter)getPreferenceScreen().getRootAdapter()).notifyDataSetChanged();
            }
        }
    }*/
}
