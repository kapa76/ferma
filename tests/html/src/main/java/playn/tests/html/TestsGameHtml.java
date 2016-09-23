package playn.tests.html;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;

import playn.html.HtmlPlatform;

import playn.tests.core.TestsGame;

public class TestsGameHtml implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HtmlPlatform.Config config = new HtmlPlatform.Config();
        try {
            config.scaleFactor = Float.parseFloat(Window.Location.getParameter("scale"));
        } catch (Exception e) {
        } // oh well
        try {
            config.frameBufferPixelRatio = Float.parseFloat(Window.Location.getParameter("fbpr"));
        } catch (Exception e) {
        } // oh well
        HtmlPlatform plat = new HtmlPlatform(config);
        plat.setTitle("Tests");
        plat.assets().setPathPrefix("testsgame/");
        plat.disableRightClickContextMenu();
        TestsGame game = new TestsGame(plat, new String[0]);
        plat.start();
    }
}
