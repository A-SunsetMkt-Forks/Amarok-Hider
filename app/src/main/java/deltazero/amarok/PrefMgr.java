package deltazero.amarok;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Collections;
import java.util.Set;

public class PrefMgr {

    public static final String TAG = "Hider";
    private final SharedPreferences mPrefs;
    private final SharedPreferences.Editor mPrefEditor;
    public AppHider appHider;
    public Context context;

    public PrefMgr(Context context) {
        this.context = context;

        mPrefs = context.getSharedPreferences("deltazero.amarok.prefs", MODE_PRIVATE);
        mPrefEditor = mPrefs.edit();
        appHider = new AppHider(new AppHider.RootMode());
    }


    public void setHideFilePath(Set<String> path) {
        mPrefEditor.putStringSet("hideFilePath", path);
        mPrefEditor.commit();
    }

    public Set<String> getHideFilePath() {
        return mPrefs.getStringSet("hideFilePath", Collections.emptySet());
    }

    public boolean getIsHidden() {
        return mPrefs.getBoolean("isHidden", true);
    }

    public void setIsHidden(boolean isHidden) {
        mPrefEditor.putBoolean("isHidden", isHidden);
        mPrefEditor.commit();
    }

    public Set<String> getHideApps() {
        return mPrefs.getStringSet("hidePkgNames", Collections.emptySet());
    }

    public void setHideApps(Set<String> pkgNames) {
        mPrefEditor.putStringSet("hidePkgNames", pkgNames);
        mPrefEditor.commit();
    }
}