package ryebread761.darktube;

import android.graphics.Color;
import android.widget.FrameLayout;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_LayoutInflated;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

public class DarkTube implements IXposedHookInitPackageResources {
	
	@Override
	public void handleInitPackageResources(InitPackageResourcesParam resparam)
			throws Throwable {
		if (!resparam.packageName.equals("com.google.android.youtube"))
			return;
		resparam.res.hookLayout("com.google.android.youtube", "layout", "guide_activity", new XC_LayoutInflated() {
	        @Override
	        public void handleLayoutInflated(LayoutInflatedParam liparam) throws Throwable {
	            FrameLayout container = (FrameLayout) liparam.view.findViewById(
	            		liparam.res.getIdentifier("pane_fragment_container", "id", "com.google.android.youtube"));
	            container.setBackgroundColor(Color.BLACK);
	        }
	    });
	}

}
